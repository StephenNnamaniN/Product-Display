package com.stephennnamani.productdisplay.domain.repository

import com.stephennnamani.productdisplay.domain.model.Product
import com.stephennnamani.productdisplay.domain.result.AppResult

interface ProductRepository {
    suspend fun getProducts(): AppResult<List<Product>>
}