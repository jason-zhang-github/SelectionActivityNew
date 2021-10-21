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
import android.content.Context
import androidx.activity.viewModels
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.fragment.app.activityViewModels


class MainActivity : AppCompatActivity() {

    // declare fragments
    lateinit var displayfrag: DisplayFragment
    lateinit var firstfrag: SelectionFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Gets the description array from Array XML
        val myArray : Array<String> = resources.getStringArray(R.array.dunk_names)
        val dunks = generateTestData(myArray)

        // initialize FragmentContainerViews
        val listFragment = findViewById<FragmentContainerView>(R.id.fragmentContainerView)
        val detailFragment = findViewById<FragmentContainerView>(R.id.fragmentContainerView2)

        // initialize ViewModel and pass dunk array
        val viewModel : DunkModel by viewModels()
        viewModel.setDunk(dunks)

        // initialize fragments
        firstfrag = SelectionFragment.getInstance(1)
        displayfrag = DisplayFragment()


        //val bundle = Bundle()
        //bundle.putParcelableArray("dunks", list as Array<Dunk>)
        //firstfrag.arguments

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, firstfrag)
            .add(R.id.fragmentContainerView2, displayfrag)
            .commit()


        // val fragmentManager = getFragmentManager()
        // Transaction Code
        /* if (savedInstanceState == null)
        {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<SelectionFragment>(R.id.fragmentContainerView)
            }
        } */


        // View.OnClickListener is created in the activity
        // and then passed to adapter
        // This allows the onClick() callback
        // to have access to the activity's members
        val onClickListener = View.OnClickListener {
            //imageView.setImageResource(dunks[itemPosition].resourceId)
            //textView.text = dunks[itemPosition].description

        }


    }

    // Assign each dunk with proper description
    fun generateTestData(dunkdesc : Array<String>): Array<Dunk> {
        return arrayOf(Dunk(R.drawable.dunk_stussy, dunkdesc[0])
            , Dunk(R.drawable.dunk_paris, dunkdesc[1])
            , Dunk(R.drawable.dunk_mondrian, dunkdesc[2])
            , Dunk(R.drawable.dunk_pigeon, dunkdesc[3])
            , Dunk(R.drawable.dunk_strangelove,dunkdesc[4])
            , Dunk(R.drawable.dunk_lobster, dunkdesc[5])
            , Dunk(R.drawable.dunk_viotech, dunkdesc[6])
            , Dunk(R.drawable.dunk_supreme, dunkdesc[7])
            , Dunk(R.drawable.dunk_heineken, dunkdesc[8]))
    }



}