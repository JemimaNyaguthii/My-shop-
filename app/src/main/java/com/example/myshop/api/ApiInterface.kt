package com.example.myshop.api

import com.example.myshop.models.Product
import com.example.myshop.models.ProductsResponse
import com.example.myshop.models.Users
import com.example.myshop.models.UsersResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/products")
   suspend fun getProducts():Response<ProductsResponse>

    @GET("/products{id}")
   suspend fun getProducts(@Path("id")productId:Int):Response<Product>
    @GET("/users")
    suspend fun getUsers():Response<UsersResponse>

    @GET("/users{id}")
    suspend fun getUsers(@Path("id")usersId:Int):Response<Users>

}
