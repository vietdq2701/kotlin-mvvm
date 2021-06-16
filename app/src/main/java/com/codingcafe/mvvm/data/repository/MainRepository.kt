package com.codingcafe.mvvm.data.repository

import com.codingcafe.mvvm.data.mapper.NetworkMapper
import com.codingcafe.mvvm.data.model.Blog
import com.codingcafe.mvvm.data.remote.BlogService
import com.codingcafe.mvvm.room.dao.BlogDao
import com.codingcafe.mvvm.room.CacheMapper
import com.codingcafe.mvvm.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
    private val blogDao: BlogDao,
    private val blogService: BlogService,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getBlog(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val response = blogService.getBlogs()
            if (response.isSuccessful) {
                response.body()?.let {
                    val blogs = networkMapper.mapFromEntityList(it)
                    for (blog in blogs) {
                        blogDao.insert(cacheMapper.mapToEntity(blog))
                    }
                    val cachedBlogs = blogDao.get()
                    emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
                }
            } else {
//                emit(DataState.Error("Request failure"))
            }
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}