package com.example.myshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshop.models.Users
import com.example.myshop.repository.UsersRepository
import kotlinx.coroutines.launch

class UsersViewModel:ViewModel(){
        val usersRepo= UsersRepository()
    var usersLiveData= MutableLiveData<List<Users>>()
    var errorLiveData= MutableLiveData<String>()
    fun fetchUsers(){
        viewModelScope.launch {
            val response =usersRepo.getUsers()
            if(response.isSuccessful){
                usersLiveData.postValue(response.body()?.users)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}

