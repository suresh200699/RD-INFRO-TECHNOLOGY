package com.suresh.task4recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.suresh.task4recyclerview.adapter.ItemAdapter
import com.suresh.task4recyclerview.model.ItemModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val itemList = listOf(
            ItemModel("Android", "Learn Android Development"),
            ItemModel("Kotlin", "Programming Language"),
            ItemModel("RecyclerView", "Display Lists"),
            ItemModel("Firebase", "Backend Service"),
            ItemModel("API", "Network Requests"),
            ItemModel("MVVM", "Architecture Pattern"),
            ItemModel("Room DB", "Local Database"),
            ItemModel("Jetpack", "Android Libraries")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(itemList)
    }
}