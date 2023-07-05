package com.example.myshop.repository

import com.example.myshop.api.ApiClient
import com.example.myshop.api.ApiInterface
import com.example.myshop.models.ProductsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductsRepository {
val apiClient =ApiClient.buildClient(ApiInterface::class.java)
    suspend fun getProducts():Response<ProductsResponse>{
        return withContext(Dispatchers.IO){
            apiClient.getProducts()
        }

    }

}


//get products invoking the api client
//withcontext is a network call responsible for switching from the main thread to io.

//response is a wrapper  class