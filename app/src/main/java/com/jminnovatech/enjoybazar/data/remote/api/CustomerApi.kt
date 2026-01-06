package com.jminnovatech.enjoybazar.data.remote.api

import com.jminnovatech.data.model.customer.CustomerOrder
import com.jminnovatech.data.model.customer.CustomerOrderRequest
import com.jminnovatech.enjoybazar.data.model.common.ApiResponse
import com.jminnovatech.enjoybazar.data.model.customer.*
import retrofit2.http.*

interface CustomerApi {

    @GET("customer/products")
    suspend fun getProducts(): ApiResponse<List<CustomerProduct>>

    @GET("customer/orders")
    suspend fun getOrders(): ApiResponse<List<CustomerOrder>>

    @POST("customer/orders")
    suspend fun placeOrder(
        @Body req: CustomerOrderRequest
    ): ApiResponse<Any>
}
