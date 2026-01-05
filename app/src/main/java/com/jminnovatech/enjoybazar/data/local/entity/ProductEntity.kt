package com.jminnovatech.enjoybazar.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val price: Double
)
