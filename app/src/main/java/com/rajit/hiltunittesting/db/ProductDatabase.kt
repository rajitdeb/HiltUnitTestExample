package com.rajit.hiltunittesting.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rajit.hiltunittesting.dao.ProductDAO
import com.rajit.hiltunittesting.model.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase: RoomDatabase() {

    abstract fun productDAO(): ProductDAO

}