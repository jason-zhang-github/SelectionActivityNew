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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


lateinit var recycler : RecyclerView
lateinit var layout : View
lateinit var viewModelProvider : ViewModelProvider

/**
 * A simple [Fragment] subclass.
 * Use the [SelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_selection, container, false)

        // Get the recyclerview from xml to the fragment
        //val recyclerview = requireView().findViewById<RecyclerView>(R.id.recyclerview)
        recycler = layout.findViewById<RecyclerView>(R.id.recyclerview)

        // recycler.adapter = ArrayAdapter(requireContext(), android.R.layout.frag)
        recycler.adapter = ImageAdapter
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
        fun newInstance(dunkarray : Array<Dunk>) : SelectionFragment
        {
            val fragment = SelectionFragment()
            val bundle: Bundle = Bundle()
            bundle.putSerializable("dunkarray", dunkarray)
            fragment.arguments = bundle
            return fragment
        }
    }
}