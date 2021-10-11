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

    val pigeon : String = getString(R.string.pigeon)
    val paris : String = getString(R.string.paris)
    val stussy : String = getString(R.string.stussy)
    val strangelove : String = getString(R.string.strangelove)
    val mondrian : String = getString(R.string.mondrian)
    val lobster : String = getString(R.string.lobster)
    val supreme : String = getString(R.string.supreme)
    val heineken : String = getString(R.string.heineken)
    val viotech : String = getString(R.string.viotech)

    // Test data
    fun generateTestData(): Array<Dunk> {
        return arrayOf(Dunk(R.drawable.dunk_stussy, stussy)
            , Dunk(R.drawable.dunk_paris,paris)
            , Dunk(R.drawable.dunk_mondrian,mondrian)
            , Dunk(R.drawable.dunk_pigeon,pigeon)
            , Dunk(R.drawable.dunk_strangelove,strangelove)
            , Dunk(R.drawable.dunk_lobster,lobster)
            , Dunk(R.drawable.dunk_viotech,viotech)
            , Dunk(R.drawable.dunk_supreme,supreme)
            , Dunk(R.drawable.dunk_heineken, heineken))
    }


    fun sendMessage(dunk: Dunk)
    {

        // val viewText = findViewById<TextView>(R.id.textView) // Find textView
        // val message = viewText.text.toString() // convert text to string
        val intent = Intent(this, DisplayActivity::class.java) // Create intent
        intent.putExtra("custom_image", dunk as Serializable) // Add Dunk to the intent
        // intent.putExtra("descriptor", dunk.description)
        startActivity(intent)

    }



}