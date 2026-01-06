package com.jminnovatech.enjoybazar.data.model.common

data class ApiResponse<T>(
    val success: Boolean,
    val data: T?,
    val message: String?
)
