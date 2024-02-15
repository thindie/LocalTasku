package com.thindie.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.thindie.database.DataBaseContract.notesTable
import com.thindie.database.entities.NoteDbModel
import kotlinx.coroutines.flow.Flow

 interface NotesDao {
    @Query("SELECT * FROM $notesTable")
    fun observeNotes(): Flow<List<NoteDbModel>>

    @Upsert
    suspend fun upsertNote(noteDbModel: NoteDbModel): Long

    @Query("SELECT * FROM $notesTable WHERE id = :id LIMIT 1")
    suspend fun getNote(id: Int): NoteDbModel

    @Query("DELETE FROM $notesTable WHERE id = :id")
    suspend fun deleteNote(id: Int)

}
