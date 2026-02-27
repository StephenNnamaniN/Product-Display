package com.stephennnamani.productdisplay.presentation.state

sealed interface ProductUiState {
    data object Idle: ProductUiState
    data object Loading: ProductUiState
    data object Success: ProductUiState
    data class Error(val message: String): ProductUiState
}