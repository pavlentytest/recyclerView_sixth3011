package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder

data class Book(val name: String, val price: Double, val image: String)
class MainActivity : AppCompatActivity() {

    private lateinit var list: List<Book>
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result = application
            .assets
            .open("books.json")
            .bufferedReader()
            .use{ it.readText() }

        val gson = GsonBuilder().create()
        list = gson.fromJson(result,Array<Book>::class.java).toList()

        rv = findViewById(R.id.recyclerView)
        rv.adapter = MyAdapter(list)
        rv.layoutManager = LinearLayoutManager(this)

    }
}