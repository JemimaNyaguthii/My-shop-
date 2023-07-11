package com.example.myshop.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.models.Product
import com.example.myshop.databinding.ProductsListItemBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductsRvAdapter (var products:List<Product>): RecyclerView.Adapter<ProductsRvAdapter.ProductsViewHolder>() {


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
      val binding =
            ProductsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsRvAdapter.ProductsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val currentProduct = products.get(position)
        val binding = holder.binding
        binding.tvId.text = currentProduct.id.toString()
        binding.tvBrand.text = currentProduct.brand
        binding.tvCategory.text = currentProduct.category
        binding.tvRating.text = currentProduct.rating.toString()
        binding.tvStock.text = currentProduct.stock.toString()
        binding.tvTitle.text = currentProduct.title
        binding.tvPrice.text = currentProduct.price.toString()
        binding.ivImage.tag = currentProduct.thumbnail
        binding.tvDescription.text = currentProduct.description

        Picasso
            .get().load(currentProduct.thumbnail)
            .resize(80, 80)
            .centerInside()
            .transform(CropCircleTransformation())

            .into(binding.ivImage)
    }


    override fun getItemCount(): Int {
        return products.size
   }

    class ProductsViewHolder(var binding: ProductsListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
