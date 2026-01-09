package com.jminnovatech.enjoybazar.ui.customer.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jminnovatech.data.model.customer.CustomerCartItem
import com.jminnovatech.data.model.customer.CustomerOrder
import com.jminnovatech.enjoybazar.data.model.customer.CustomerOrderCreateRequest
import com.jminnovatech.enjoybazar.data.model.customer.CustomerOrderItem
import com.jminnovatech.enjoybazar.data.model.customer.CustomerOrderItemRequest

import com.jminnovatech.enjoybazar.data.model.customer.CustomerProduct
import com.jminnovatech.enjoybazar.data.repository.CustomerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class CustomerViewModel : ViewModel() {

    private val repo = CustomerRepository()

    // 🔹 Products
    private val _products = MutableStateFlow<List<CustomerProduct>>(emptyList())
    val products = _products.asStateFlow()

    // 🔹 Orders
    private val _orders = MutableStateFlow<List<CustomerOrder>>(emptyList())
    val orders = _orders.asStateFlow()

    // 🔹 Cart
    private val _cart = MutableStateFlow<List<CustomerCartItem>>(emptyList())
    val cart = _cart.asStateFlow()

    // ---------------- PRODUCTS ----------------

    fun loadProducts() {
        viewModelScope.launch {
            val res = repo.getProducts()
            if (res.success) {
                _products.value = res.data ?: emptyList()
            }
        }
    }

    // ---------------- ORDERS ----------------





    // ---------------- CART ----------------

    fun addToCart(product: CustomerProduct) {
        val list = _cart.value.toMutableList()
        list.add(CustomerCartItem(product = product, qty = 1.0))
        _cart.value = list
    }

    fun clearCart() {
        _cart.value = emptyList()
    }

    // ---------------- PLACE ORDER ----------------

    fun placeOrder(
        buyerName: String,
        buyerPhone: String,
        buyerAddress: String
    ) {
        viewModelScope.launch {

            if (_cart.value.isEmpty()) {
                Log.e("ORDER", "Cart is empty")
                return@launch
            }

            // ✅ THIS IS THE CORRECT PLACE
            val items = _cart.value.map {
                CustomerOrderItemRequest(
                    product_id = it.product.id,
                    qty = it.qty
                )
            }


            val request = CustomerOrderCreateRequest(
                buyer_name = buyerName,
                buyer_phone = buyerPhone,
                buyer_address = buyerAddress,
                items = items
            )

            try {
                val res = repo.placeOrder(request)
                if (res.success) {
                    _cart.value = emptyList()
                }
            } catch (e: HttpException) {
                Log.e("ORDER", "HTTP ${e.code()} ${e.response()?.errorBody()?.string()}")
            }
        }
    }

    fun removeFromCart(product: CustomerProduct) {
        val list = _cart.value.toMutableList()
        val index = list.indexOfFirst { it.product.id == product.id }

        if (index != -1) {
            val item = list[index]
            if (item.qty > 1) {
                list[index] = item.copy(qty = item.qty - 1)
            } else {
                list.removeAt(index)
            }
            _cart.value = list
        }
    }
    fun loadOrders() {
        viewModelScope.launch {
            try {
                val res = repo.getOrders()
                Log.d("ORDERS_API", "Response = $res")

                if (res.success) {
                    _orders.value = res.data ?: emptyList()
                } else {
                    Log.e("ORDERS_API", "API success=false")
                }
            } catch (e: Exception) {
                Log.e("ORDERS_API", "Error", e)
            }
        }
    }


}
