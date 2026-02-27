package com.stephennnamani.productdisplay

import com.stephennnamani.productdisplay.domain.model.Product
import com.stephennnamani.productdisplay.domain.repository.ProductRepository
import com.stephennnamani.productdisplay.domain.result.AppResult

class FakeProductRepository : ProductRepository {

    val result: AppResult<List<Product>> =
        AppResult.Success(emptyList())

    override suspend fun getProducts(): AppResult<List<Product>> {
        return result
    }

}