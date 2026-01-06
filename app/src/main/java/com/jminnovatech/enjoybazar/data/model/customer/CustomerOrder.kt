package com.jminnovatech.data.model.customer

data class CustomerOrder(
    val id: Int,
    val order_no: String,
    val total_amount: Double,
    val status: String,
    val created_at: String,
    val image: String?   // ✅ ADD THIS
)
