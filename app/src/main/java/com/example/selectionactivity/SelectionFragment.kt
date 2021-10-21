package com.example.selectionactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager


/**
 * A simple [Fragment] subclass.
 * Use the [SelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectionFragment : Fragment() {

    lateinit var recycler : RecyclerView
    lateinit var layout : View

    lateinit var importdunks : Array<Dunk>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            importdunks = it.getParcelableArray("dunkarray") as Array<Dunk>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_selection, container, false)

        // Get the recyclerview from xml to the fragment
        recycler = layout.findViewById<RecyclerView>(R.id.recyclerview)

        recycler.layoutManager = GridLayoutManager(getActivity(), 3)

        // set onclicklistener
        val ocl = View.OnClickListener {
            val item_position = recycler.getChildAdapterPosition(it)

            ViewModelProvider(requireActivity()).get(DunkModel::class.java).setDunk(importdunks[item_position])
        }
        // set recycleview.adapter to an ImageAdapter
        recycler.adapter = ImageAdapter(importdunks, ocl)
        return layout
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SelectionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(dunkarray : Array<Dunk>) =
            SelectionFragment().apply {
                arguments = Bundle().apply {

                    putParcelableArray("dunkarray", dunkarray)
                }

            /* val fragment = SelectionFragment()
            val bundle: Bundle = Bundle()
            bundle.putSerializable("dunkarray", dunkarray)
            fragment.arguments = bundle
            return fragment
            */
        }
    }
}