package com.rajit.hiltunittesting.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
   @PrimaryKey
   val id: Int,
   val title: String,
   val description: String,
   val price: Double,
   val image: String
)
