package com.example.selectionactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val importDunk = intent.extras!!.get("custom_image") as Dunk

        val newText = findViewById<TextView>(R.id.textView2)
        val newImage = findViewById<ImageView>(R.id.imageView2)

        newImage.setImageResource(importDunk.resourceId)
        newText.text = importDunk.description

    }
}