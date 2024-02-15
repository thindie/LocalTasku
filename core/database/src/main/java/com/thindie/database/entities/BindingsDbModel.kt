package com.thindie.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thindie.database.DataBaseContract.bindingsTable


@Entity(tableName = bindingsTable)
data class BindingsDbModel(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val properties: String
)