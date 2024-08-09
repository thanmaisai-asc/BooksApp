package com.example.booksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksapp.adapters.BookAdapter
import com.example.booksapp.databinding.ActivityMainBinding
import com.example.booksapp.models.Data
import com.example.booksapp.utils.ApiClient
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//import kotlinx.coroutines.DelicateCoroutinesApi
//import kotlinx.coroutines.GlobalScope
//import android.widget.Toast
//import retrofit2.HttpException
//import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bookAdapter: BookAdapter
    private lateinit var books: List<Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.IO) {
            binding.rvMain.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                Log.d("MainActivity", "RecyclerView layoutManager set")
            }

            val response = try {
                ApiClient.api.getAllBooks()
            } catch (e: Exception) {
                null
            }

            withContext(Dispatchers.Main){
                try{
                    if (response?.isSuccessful == true && response.body() != null) {
                        books = response.body()!! // This should be of type List<Data>

                        // Log the data
                        Log.d("MainActivity", "Books: $books")

                        binding.rvMain.apply {
                            bookAdapter = BookAdapter(books)
                            adapter = bookAdapter
                            Log.d("MainActivity", "Adapter set")
                        }
                    } else {
                        Snackbar.make(binding.root, "Failed to load books.", Snackbar.LENGTH_LONG).show()
                    }
                } catch (e: Exception) {
                    // Handle exception
                    Log.e("MainActivity", "Error: ${e.message}")
                }
            }



        }
        }
    }