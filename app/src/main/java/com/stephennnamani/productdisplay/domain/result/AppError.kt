package com.stephennnamani.productdisplay.domain.result

sealed interface AppError {
    data object NetworkError : AppError
    data object ServerError: AppError
    data object UnknownError : AppError
}