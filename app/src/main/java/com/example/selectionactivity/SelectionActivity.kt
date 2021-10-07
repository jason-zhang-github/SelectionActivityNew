package com.example.selectionactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text


class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = generateTestData()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)

        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // View.OnClickListener is created in the activity
        // and then passed to adapter
        // This allows the onClick() callback
        // to have access to the activity's members
        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)
            imageView.setImageResource(items[itemPosition].resourceId)
            textView.text = items[itemPosition].description


        }

        recyclerView.adapter = ImageAdapter(items, onClickListener)
    }

    // Test data
    fun generateTestData(): Array<Item> {
        return arrayOf(Item(R.drawable.dunk_stussy, "Stussy Dunk")
            , Item(R.drawable.dunk_paris,"Paris Dunk")
            , Item(R.drawable.dunk_mondrian,"Piet Mondrian Dunk")
            , Item(R.drawable.dunk_pigeon,"Pigeon Dunk")
            , Item(R.drawable.dunk_strangelove,"Strangelove Dunk")
            , Item(R.drawable.dunk_lobster,"Purple Lobster Dunk")
            , Item(R.drawable.dunk_viotech,"Viotech Dunk")
            , Item(R.drawable.dunk_supreme,"Supreme Dunk")
            , Item(R.drawable.dunk_heineken, "Heineken Dunk"))
    }


    fun sendMessage(view: View)
    {
        val viewText = findViewById<TextView>(R.id.textView) // Find textView
        val message = viewText.text.toString() // convert
    }



}