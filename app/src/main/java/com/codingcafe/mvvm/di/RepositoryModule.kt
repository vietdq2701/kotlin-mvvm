package com.codingcafe.mvvm.di

import com.codingcafe.mvvm.data.mapper.NetworkMapper
import com.codingcafe.mvvm.data.remote.BlogService
import com.codingcafe.mvvm.data.repository.MainRepository
import com.codingcafe.mvvm.room.dao.BlogDao
import com.codingcafe.mvvm.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        blogRetrofit: BlogService,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository{
        return MainRepository(blogDao, blogRetrofit, cacheMapper, networkMapper)
    }
}