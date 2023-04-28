package com.rajit.hiltunittesting.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajit.hiltunittesting.model.Product
import com.rajit.hiltunittesting.repository.ProductRepository
import com.rajit.hiltunittesting.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val productRepository: ProductRepository
): ViewModel(){

    private val _products: MutableLiveData<NetworkResult<List<Product>>> = MutableLiveData()
    val products: LiveData<NetworkResult<List<Product>>> get() = _products

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = productRepository.getProducts()
            _products.postValue(result)
        }
    }

}