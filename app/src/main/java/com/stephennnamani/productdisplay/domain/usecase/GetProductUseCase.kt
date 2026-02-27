package com.stephennnamani.productdisplay.domain.usecase

import com.stephennnamani.productdisplay.domain.model.Product
import com.stephennnamani.productdisplay.domain.repository.ProductRepository
import com.stephennnamani.productdisplay.domain.result.AppResult

class GetProductUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): AppResult<List<Product>> {
        return repository.getProducts()
    }
}