package com.stephennnamani.productdisplay.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stephennnamani.productdisplay.domain.result.AppResult
import com.stephennnamani.productdisplay.domain.usecase.GetProductUseCase
import com.stephennnamani.productdisplay.presentation.state.ProductUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(
    private val getProductUseCase: GetProductUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<ProductUiState>(ProductUiState.Idle)
    val uiState: StateFlow<ProductUiState> = _uiState

    fun fetchProducts() {
        viewModelScope.launch {
            _uiState.value = ProductUiState.Loading

            when (val result = getProductUseCase()) {
                is AppResult.Success ->
                    _uiState.value = ProductUiState.Success(result.data)

                is AppResult.Failure ->
                    _uiState.value = ProductUiState.Error("Something wen wrong")
            }
        }
    }
}