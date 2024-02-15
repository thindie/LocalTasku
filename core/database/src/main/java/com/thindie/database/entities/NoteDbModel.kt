package com.thindie.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thindie.database.DataBaseContract.notesTable


@Entity(tableName = notesTable)
data class NoteDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val creationTimeInMillis: Long,
    val costId: Int? = null,
    val bindingsId: Int? = null,
)