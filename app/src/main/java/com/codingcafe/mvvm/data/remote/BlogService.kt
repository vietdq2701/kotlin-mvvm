package com.codingcafe.mvvm.data.remote

import com.codingcafe.mvvm.data.response.BlogNetworkResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.GET

interface BlogService {

    @GET("blogs")
    suspend fun getBlogs(): Response<List<BlogNetworkResponse>>

    @GET(".")
    fun getBlogsWithRx(): Observable<List<BlogNetworkResponse>>
}