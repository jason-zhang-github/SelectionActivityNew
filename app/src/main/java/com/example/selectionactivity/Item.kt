package com.example.selectionactivity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

// Implement Serializable to stop from crashing
@Parcelize
data class Dunk (val resourceId: Int, val description: String) : Parcelable{
}

/*
* data class Dunk (val resourceId: Int, val description: String) : Parcelable
* {
*       @JvmField
        val CREATOR = object : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel) = Item(parcel)
        override fun newArray(size: Int) = arrayOfNulls<Item>(size)
* }
*
*
*
* */