package com.stephennnamani.productdisplay

import com.stephennnamani.productdisplay.domain.model.Product
import com.stephennnamani.productdisplay.domain.result.AppResult
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

class GetProductUseCaseTest {
    private lateinit var useCase: GetProductUseCase
    private lateinit var fakeRepository: FakeProductRepository

    @Before
    fun setUp() {
        fakeRepository = FakeProductRepository()
        useCase = GetProductUseCase(fakeRepository)
    }

    @Test
    fun `return success when repository returns success`() = runTest {
        val products = listOf(
            Product("1", "shoes", "£50", true)
        )

        fakeRepository.result = AppResult.Success(products)

        val result = useCase()

        assertEquals(AppResult.Success(products), result)
    }
}