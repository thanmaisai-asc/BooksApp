package com.example.booksapp.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booksapp.databinding.ItemLayoutBinding
import com.example.booksapp.models.Data

class BookAdapter(private val bookList: List<Data>): RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = bookList[position]
        holder.binding.apply {
            tvId.text = "ID: ${currentItem.id}"
            tvTitle.text = "Title: ${currentItem.Title}"
            tvPublisher.text = "Publisher: ${currentItem.Publisher}"
            tvYear.text = "Year: ${currentItem.Year}"
            tvISBN.text = "ISBN: ${currentItem.ISBN}"
        }
    }


}