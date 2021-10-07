package com.example.selectionactivity

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

/* THIS CODE IS FROM ASSIGNMENT THREE PROFESSOR REQUESTED. SINCE MY IMPLEMENTATION
* WAS FAULTY I THOUGHT IT WOULD BE OK TO START FROM THE SOLUTION*/

class ImageAdapter (_items : Array<Dunk>, _ocl : View.OnClickListener) : RecyclerView.Adapter<ImageAdapter.ViewHolder>()
{

    private val items = _items
    val ocl = _ocl

    /**
     * ViewHolder Constructor accepts onClickListener
     * and assigns it to the included view
     */
    class ViewHolder(_view: ImageView, ocl: View.OnClickListener) : RecyclerView.ViewHolder(_view) {
        val imageView = _view.apply { setOnClickListener(ocl) }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // View is dynamically generated instead of inflated
        // A ViewGroup.LayoutParams object is used
        // to provide _width_ and _height_
        return ViewHolder(ImageView(parent.context).apply { layoutParams = ViewGroup.LayoutParams(300, 300) }, ocl)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(items[position].resourceId)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}