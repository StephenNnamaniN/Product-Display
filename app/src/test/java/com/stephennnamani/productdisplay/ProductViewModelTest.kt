package com.stephennnamani.productdisplay

import com.stephennnamani.productdisplay.domain.model.Product
import com.stephennnamani.productdisplay.domain.result.AppResult
import com.stephennnamani.productdisplay.domain.usecase.GetProductUseCase
import com.stephennnamani.productdisplay.presentation.state.ProductUiState
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ProductViewModelTest {
    private lateinit var fakeRepository: FakeProductRepository
    private lateinit var useCase: GetProductUseCase
    private lateinit var viewModel: ProductViewModel

    @Before
    fun setUp() {
        fakeRepository = FakeProductRepository()
        useCase = GetProductUseCase(fakeRepository)
        viewModel = ProductViewModel(useCase)
    }

    @Test
    fun `emits Loading then Success when use case succeeds`() = runTest {
        val products = listOf(Product("1", "Shoes", "£50", true))
        fakeRepository.result = AppResult.Success(products)

        viewModel.fetchProducts()

        assertEquals(ProductUiState.Success(products), viewModel.uiState.value)
    }
}