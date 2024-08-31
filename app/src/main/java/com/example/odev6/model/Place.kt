package com.example.odev6.model

data class Place(
    val name :String,
    val price :Int,
    val rate: Float,
    val time_person_info :String,
    val warning : String,
    val isFav : Boolean,
    val bedroom_count :Int,
    val bath_count: Int,
    val picture : String,
    val totalReview : Int

)
