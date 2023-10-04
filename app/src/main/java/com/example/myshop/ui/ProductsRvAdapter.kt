package com.example.myshop.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.R
import com.example.myshop.models.Product
import com.example.myshop.databinding.ProductsListItemBinding
import com.squareup.picasso.Picasso

import kotlinx.coroutines.withContext

class ProductsRvAdapter (var products:List<Product>,private val context:Context):RecyclerView.Adapter<ProductsRvAdapter.ProductsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding =
            ProductsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsRvAdapter.ProductsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val currentProduct = products[position]
        val binding = holder.binding

        binding.tvId.text = currentProduct.id.toString()
        binding.tvBrand.text = currentProduct.brand
        binding.tvCategory.text = currentProduct.category
        binding.tvStock.text = currentProduct.stock.toString()
        binding.tvTitle.text = currentProduct.title
        binding.tvPrice.text = currentProduct.price.toString()
        binding.ivImage.tag = currentProduct.thumbnail
        binding.tvDescription.text = currentProduct.description

        Picasso.get()
            .load(currentProduct.thumbnail)
            .resize(80, 80)
            .centerInside()
            .into(binding.ivImage)
 (R.layout.activity_main)
       holder.binding.ivImage.setOnClickListener{
            val intent = Intent(context,ProductsDetailsActivity::class.java)
            intent.putExtra("PRODUCT_ID", currentProduct.id)
            intent.putExtra("PRODUCT_TITLE", currentProduct.title)
            intent.putExtra("PRODUCT_IMAGE", currentProduct.thumbnail)
            intent.putExtra("PRODUCT_DESCRIPTION", currentProduct.description)
            intent.putExtra("PRODUCT_PRICE", currentProduct.price)
            intent.putExtra("PRODUCT_CATEGORY", currentProduct.category)
            intent.putExtra("PRODUCT_STOCK", currentProduct.stock)
            context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return products.size
   }

    class ProductsViewHolder(var binding: ProductsListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
