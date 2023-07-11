package com.example.myshop.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshop.models.ProductsResponse
import com.example.myshop.api.ApiClient
import com.example.myshop.api.ApiInterface
import com.example.myshop.databinding.ActivityMainBinding
import com.example.myshop.viewmodel.ProductsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity() : AppCompatActivity(){
    val productsViewModel:ProductsViewModel by viewModels()
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnFloating.setOnClickListener {
            val intent = Intent(this,UsersActivity::class.java)
            startActivity(intent)
        }
        productsViewModel.fetchProducts()
        productsViewModel.productsLiveData.observe(this, Observer { productsList ->
            Toast.makeText(
                baseContext,
                "fetched ${productsList?.size} products",
                Toast.LENGTH_LONG
            ).show()
            binding.rvProducts.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvProducts.adapter = ProductsRvAdapter(productsList)
        })
        productsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(
                baseContext, error,
                Toast.LENGTH_LONG
            ).show()
        })

    }}







//Coroutines are routines when it makes request waiting a response it suspends itself and let another function
// can use the same thread.Block of memory multiple functions.Asynchronous execution which is simpler.
//The thread only send requests and receive response blocks meaning it cannot do another request.
//There are limits of threads you can execute at a go;
//Callbacks in kotlin
//fun onResponse  and fun onFailure
//override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
//Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
//}
//Retrofit makes a request to the server then a response received in the background thread
//Application not responding a different process on the same machine
//ui on the ui

