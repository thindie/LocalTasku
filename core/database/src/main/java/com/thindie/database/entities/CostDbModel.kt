package com.thindie.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thindie.database.DataBaseContract.costsTable


@Entity(tableName = costsTable)
data class CostDbModel(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val price: Double,
    val isBought: Boolean
)