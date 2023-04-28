package com.rajit.hiltunittesting.api

import androidx.lifecycle.LiveData
import com.rajit.hiltunittesting.model.Product
import com.rajit.hiltunittesting.util.NetworkResult
import retrofit2.Response
import retrofit2.http.GET

interface ProductAPI {

    @GET("/products")
    suspend fun getProducts(): Response<List<Product>>

}