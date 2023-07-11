package com.example.myshop.models

data class UsersResponse(
    var users:List<Users>,
    var total:Int,
    var skip:Int,
    var limit:Int
)
