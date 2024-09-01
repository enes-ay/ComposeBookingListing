package com.example.odev6.model

data class Place(
    val name :String,
    val price :Int,
    val rate: Float,
    val time_person_info :String,
    val warning : String = "",
    val isFav : Boolean,
    val bath_count: Int,
    val picture : String,
    val bedroom_count : Int,
    val totalReview : Int

)
