package com.jminnovatech.enjoybazar.data.repository

import com.jminnovatech.enjoybazar.data.model.customer.CustomerOrderCreateRequest
import com.jminnovatech.enjoybazar.data.remote.api.RetrofitClient

class CustomerRepository {

    suspend fun getProducts() =
        RetrofitClient.customerApi.getProducts()

    suspend fun getOrders() =
        RetrofitClient.customerApi.getOrders()


    suspend fun placeOrder(req: CustomerOrderCreateRequest) =
        RetrofitClient.customerApi.placeOrder(req)


    suspend fun saveCustomerAddress(
        name: String,
        phone: String,
        address: String
    ) =
        RetrofitClient.customerApi.saveAddress(
            mapOf(
                "name" to name,
                "phone" to phone,
                "address" to address
            )
        )
}
