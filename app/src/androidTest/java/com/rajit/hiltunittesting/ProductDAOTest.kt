package com.rajit.hiltunittesting

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.rajit.hiltunittesting.dao.ProductDAO
import com.rajit.hiltunittesting.db.ProductDatabase
import com.rajit.hiltunittesting.model.Product
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class ProductDAOTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Inject
    lateinit var productDatabase: ProductDatabase

    lateinit var productDAO: ProductDAO

    @Before
    fun setup() {
//        productDatabase = Room.inMemoryDatabaseBuilder(
//            ApplicationProvider.getApplicationContext(),
//            ProductDatabase::class.java
//        ).allowMainThreadQueries().build()

        hiltAndroidRule.inject()

        productDAO = productDatabase.productDAO()

    }

    @Test
    fun test_insertProduct_returnSingleProduct() = runTest {
        val product = Product(
            1,
            "Test Product",
            "This is a Test Product Description",
            12.99,
            ""
        )

        productDAO.insertProduct(product)

        val result = productDAO.getProductsFromDB()
        assertEquals(1, result.size)
        assertEquals("Test Product", result.first().title)

    }

    @After
    fun tearDown() {
        productDatabase.close()
    }

}