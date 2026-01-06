package com.jminnovatech.data.model.customer

data class CustomerOrderRequest(
    val buyer_name: String,
    val buyer_phone: String,
    val buyer_address: String,
    val items: List<CustomerOrderItem>
)
