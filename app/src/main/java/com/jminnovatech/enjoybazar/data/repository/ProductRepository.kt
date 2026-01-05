package com.jminnovatech.enjoybazar.data.repository

import com.jminnovatech.enjoybazar.data.local.ProductDao
import com.jminnovatech.enjoybazar.data.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.emitAll

class ProductRepository(
    private val dao: ProductDao
) {
    fun getProducts(): Flow<List<ProductEntity>> = flow {

        // dummy offline data (replace with API later)
        dao.insertAll(
            listOf(
                ProductEntity(1, "Rice", 45.0),
                ProductEntity(2, "Oil", 120.0)
            )
        )

        emitAll(dao.getProducts())
    }
}
