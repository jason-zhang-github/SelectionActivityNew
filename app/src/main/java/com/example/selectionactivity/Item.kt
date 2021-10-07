package com.example.selectionactivity

import java.io.Serializable

// Implement Serializable to stop from crashing

data class Dunk (val resourceId: Int, val description: String) : Serializable{
}