package com.example.booksapp.models
data class Data(
    val id: Int,
    val Year: Int,
    val Title: String,
    val handle: String,
    val Publisher: String,
    val ISBN: String,
    val Pages: Int,
    val Notes: List<String>,
    val created_at: String,
    val villains: List<Villain>
)