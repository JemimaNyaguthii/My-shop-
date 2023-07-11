package com.example.myshop.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.databinding.ProductsListItemBinding
import com.example.myshop.databinding.UsersListItemBinding
import com.example.myshop.models.Product
import com.example.myshop.models.Users
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class UsersRvAdapter (var users:List<Users>): RecyclerView.Adapter<UsersRvAdapter.UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding =
            UsersListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersRvAdapter.UsersViewHolder(binding)

    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val currentUsers = users.get(position)
        val binding = holder.binding
        binding.tvId.text = currentUsers.id.toString()
        binding.tvFirstName.text = currentUsers.firstName
        binding.tvLastName.text = currentUsers.lastName
        binding.tvAge.text = currentUsers.age.toString()
        binding.tvGender.text = currentUsers.gender.toString()
        binding.tvEmail.text = currentUsers.email
        binding.tvUniversity.text = currentUsers.university
        binding.ivImage.tag = currentUsers.image
        binding.tvPhone.text = currentUsers.phone
        Picasso
            .get().load(currentUsers.image)
            .resize(80, 80)
            .centerInside()
            .transform(CropCircleTransformation())
            .into(binding.ivImage)

    }

    override fun getItemCount(): Int {
        return users.size
    }

    class UsersViewHolder(var binding: UsersListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}