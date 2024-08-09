package com.example.booksapp.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booksapp.databinding.ItemLayoutBinding
import com.example.booksapp.models.UsersItem

class RvAdapter (private val userList: List<UsersItem>): RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.binding.apply{
            tvId.text = "Id: ${currentItem.id}"
            tvUserId.text = "User Id: ${currentItem.userId}"
            tvTitle.text = "Title: ${currentItem.title}"
            tvBody.text = "Body: ${currentItem.body}"
        }
    }
}