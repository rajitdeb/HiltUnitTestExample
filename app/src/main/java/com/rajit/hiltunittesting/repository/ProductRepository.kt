package com.rajit.hiltunittesting.repository

import com.rajit.hiltunittesting.api.ProductAPI
import com.rajit.hiltunittesting.model.Product
import com.rajit.hiltunittesting.util.NetworkResult
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productAPI: ProductAPI
) {

    suspend fun getProducts(): NetworkResult<List<Product>> {
        val response = productAPI.getProducts()

        return if(response.isSuccessful) {
           val responseBody = response.body()
            if(responseBody != null) {
                NetworkResult.Success(responseBody)
            } else {
                NetworkResult.Failure("Something went Wrong!!")
            }
        } else {
            NetworkResult.Failure("Something went Wrong!!")
        }
    }

}