package com.jminnovatech.enjoybazar.data.repository

import com.jminnovatech.data.model.customer.CustomerOrderRequest

import com.jminnovatech.enjoybazar.data.remote.api.RetrofitClient

class CustomerRepository {

    suspend fun getProducts() =
        RetrofitClient.customerApi.getProducts()

    suspend fun getOrders() =
        RetrofitClient.customerApi.getOrders()

    suspend fun placeOrder(req: CustomerOrderRequest) =
        RetrofitClient.customerApi.placeOrder(req)
}
