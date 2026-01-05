package com.jminnovatech.enjoybazar.data.local

import androidx.room.*
import com.jminnovatech.enjoybazar.data.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM ProductEntity")
    fun getProducts(): Flow<List<ProductEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<ProductEntity>)
}
