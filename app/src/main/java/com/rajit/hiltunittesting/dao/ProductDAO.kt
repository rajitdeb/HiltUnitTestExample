package com.rajit.hiltunittesting.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rajit.hiltunittesting.model.Product

@Dao
interface ProductDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(product: Product)

    @Query("SELECT * FROM Product")
    suspend fun getProductsFromDB(): List<Product>

}