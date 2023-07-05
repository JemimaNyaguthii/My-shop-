package com.example.myshop.models

import com.example.myshop.models.Product

data class ProductsResponse(
    var products:List<Product>,
    var total:Int,
    var skip:Int,
    var limit:Int
)
