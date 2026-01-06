package com.jminnovatech.enjoybazar.data.model.customer

data class CustomerProduct(
    val id: Int,
    val title: String,
    val sell_price: Double,
    val unit: String,
    val stock_qty: Double,
    val image: String?
)
