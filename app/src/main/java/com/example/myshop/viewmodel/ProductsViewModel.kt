package com.example.myshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshop.models.Product
import com.example.myshop.repository.ProductsRepository
import kotlinx.coroutines.launch

class ProductsViewModel:ViewModel() {
    val productsRepo=ProductsRepository()
    var productsLiveData=MutableLiveData<List<Product>>()
    var errorLiveData=MutableLiveData<String>()
    fun fetchProducts(){
        viewModelScope.launch {
            val response =productsRepo.getProducts()
            if(response.isSuccessful){
                productsLiveData.postValue(response.body()?.products)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}

//live data holds data
//launch is responsible for launching/creating the coroutine
//viewmodel by default has its own view model scope we launch it because to cancel.
