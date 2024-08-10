package com.example.booksapp

import com.example.booksapp.models.Books
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("books")
    suspend fun getAllBooks(): Response<Books>
}