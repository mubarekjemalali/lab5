package com.example.recyclerlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recipe.*

class Recipe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        var intent = intent
        name.text = intent.getStringExtra("name")
        imageView.setImageResource(intent.getIntExtra("image", 0))
        details.text = intent.getStringExtra("recipe")

    }
}