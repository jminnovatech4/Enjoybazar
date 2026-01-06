package com.jminnovatech.data.model.customer

import com.jminnovatech.enjoybazar.data.model.customer.CustomerProduct

data class CustomerCartItem(
    val product: CustomerProduct,
    var qty: Double
)