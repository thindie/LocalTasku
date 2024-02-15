package com.thindie.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.thindie.database.DataBaseContract.costsTable
import com.thindie.database.entities.CostDbModel
import kotlinx.coroutines.flow.Flow

 interface CostsDao {

    @Query("SELECT * FROM $costsTable  WHERE id =:id")
    suspend fun getCost(id: Int): CostDbModel

    @Upsert
    suspend fun addCost(costDbModel: CostDbModel): Long

    @Query("DELETE FROM $costsTable WHERE id =:id")
    suspend fun deleteCost(id: Int)

    @Query("SELECT * FROM $costsTable ORDER  BY price ASC  ")
    fun getTopCosts(): Flow<List<CostDbModel>>
}