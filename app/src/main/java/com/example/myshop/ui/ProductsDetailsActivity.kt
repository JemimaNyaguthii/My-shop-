package com.example.myshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myshop.R
import com.example.myshop.databinding.ActivityProductsDetailsBinding
import com.squareup.picasso.Picasso

class ProductsDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductsDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productId = intent.getStringExtra("PRODUCT_ID")
        val title = intent.getStringExtra("PRODUCT_TITLE")
        val thumbnail = intent.getStringExtra("PRODUCT_IMAGE")
        val description = intent.getStringExtra("PRODUCT_DESCRIPTION")
        val discount = intent.getIntExtra("PRODUCT_DISCOUNT", 0)
        val rating = intent.getDoubleExtra("PRODUCT_RATING", 0.0)
        val price = intent.getDoubleExtra("PRODUCT_PRICE", 0.0)
        val category = intent.getStringExtra("PRODUCT_CATEGORY")
        val stock = intent.getIntExtra("PRODUCT_STOCK", 0)

        populateProductDetails(
            productId, title, thumbnail, description, discount, rating, price, category, stock
        )
    }

    private fun populateProductDetails(
        productId: String?,
        title: String?,
        thumbnail: String?,
        description: String?,
        discount: Int,
        rating: Double,
        price: Double,
        category: String?,
        stock: Int
    ) {
        binding.tvId.text = productId
        binding.tvTitle.text = title.toString()
        binding.tvStock.text = stock.toString()
        binding.tvPrice.text = price.toString()
        binding.tvBrand.text = category
        binding.tvStock.text = stock.toString()
        binding.tvCategory.text =category
        binding.tvDescription.text = description

        Picasso.get()
            .load(thumbnail)
            .resize(250, 250)
            .centerCrop()
            .into(binding.ivImage)
    }
}
