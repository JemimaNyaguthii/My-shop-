package com.example.myshop.repository

import com.example.myshop.api.ApiClient
import com.example.myshop.api.ApiInterface
import com.example.myshop.models.ProductsResponse
import com.example.myshop.models.UsersResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UsersRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)
    suspend fun getUsers(): Response<UsersResponse> {
        return withContext(Dispatchers.IO){
            apiClient.getUsers()
        }

    }
}