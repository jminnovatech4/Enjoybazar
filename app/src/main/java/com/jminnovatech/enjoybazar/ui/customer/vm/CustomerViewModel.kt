package com.jminnovatech.enjoybazar.ui.customer.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jminnovatech.data.model.customer.CustomerCartItem
import com.jminnovatech.data.model.customer.CustomerOrder
import com.jminnovatech.data.model.customer.CustomerOrderItem
import com.jminnovatech.data.model.customer.CustomerOrderRequest
import com.jminnovatech.enjoybazar.data.model.customer.*
import com.jminnovatech.enjoybazar.data.repository.CustomerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CustomerViewModel : ViewModel() {

    private val repo = CustomerRepository()

    private val _products = MutableStateFlow<List<CustomerProduct>>(emptyList())
    val products = _products.asStateFlow()

    private val _orders = MutableStateFlow<List<CustomerOrder>>(emptyList())
    val orders = _orders.asStateFlow()

    private val _cart = MutableStateFlow<List<CustomerCartItem>>(emptyList())
    val cart = _cart.asStateFlow()

    fun loadProducts() {
        viewModelScope.launch {
            val res = repo.getProducts()
            if (res.success) _products.value = res.data ?: emptyList()
        }
    }

    fun loadOrders() {
        viewModelScope.launch {
            val res = repo.getOrders()
            if (res.success) _orders.value = res.data ?: emptyList()
        }
    }

    fun addToCart(p: CustomerProduct) {
        val list = _cart.value.toMutableList()
        list.add(CustomerCartItem(p, 1.0))
        _cart.value = list
    }

    fun placeOrder(name: String, phone: String, address: String) {
        viewModelScope.launch {
            val req = CustomerOrderRequest(
                buyer_name = name,
                buyer_phone = phone,
                buyer_address = address,
                items = _cart.value.map {
                    CustomerOrderItem(it.product.id, it.qty)
                }
            )
            repo.placeOrder(req)
            _cart.value = emptyList()
        }
    }
}
