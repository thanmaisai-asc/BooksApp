package com.example.booksapp.models

data class Data(
    val ISBN: String,
    val Notes: List<String>,
    val Pages: Int,
    val Publisher: String,
    val Title: String,
    val Year: Int,
    val created_at: String,
    val handle: String,
    val id: Int,
    val villains: List<Villain>
)