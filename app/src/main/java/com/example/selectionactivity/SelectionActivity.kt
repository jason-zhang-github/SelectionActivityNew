package com.example.selectionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.io.Serializable


class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dunks = generateTestData()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        // val imageView = findViewById<ImageView>(R.id.imageView)
        // val textView = findViewById<TextView>(R.id.textView)

        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // View.OnClickListener is created in the activity
        // and then passed to adapter
        // This allows the onClick() callback
        // to have access to the activity's members
        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)
            //imageView.setImageResource(dunks[itemPosition].resourceId)
            //textView.text = dunks[itemPosition].description

            sendMessage(dunks[itemPosition])

        }

        recyclerView.adapter = ImageAdapter(dunks, onClickListener)
    }

    // Test data
    fun generateTestData(): Array<Dunk> {
        return arrayOf(Dunk(R.drawable.dunk_stussy, "Stussy Dunk")
            , Dunk(R.drawable.dunk_paris,"Paris Dunk")
            , Dunk(R.drawable.dunk_mondrian,"Piet Mondrian Dunk")
            , Dunk(R.drawable.dunk_pigeon,"Pigeon Dunk")
            , Dunk(R.drawable.dunk_strangelove,"Strangelove Dunk")
            , Dunk(R.drawable.dunk_lobster,"Purple Lobster Dunk")
            , Dunk(R.drawable.dunk_viotech,"Viotech Dunk")
            , Dunk(R.drawable.dunk_supreme,"Supreme Dunk")
            , Dunk(R.drawable.dunk_heineken, "Heineken Dunk"))
    }


    fun sendMessage(dunk: Dunk)
    {

        // val viewText = findViewById<TextView>(R.id.textView) // Find textView
        // val message = viewText.text.toString() // convert text to string
        val intent = Intent(this, DisplayActivity::class.java)
        intent.putExtra("custom_image", dunk as Serializable)
        // intent.putExtra("descriptor", dunk.description)
        startActivity(intent)

    }



}