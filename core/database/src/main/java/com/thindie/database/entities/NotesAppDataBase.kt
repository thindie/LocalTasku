package com.thindie.database.entities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thindie.database.NotesDao
import javax.inject.Singleton

@Singleton
@Database(entities =  [NoteDbModel::class], version = 1, exportSchema = false)
internal abstract class NotesAppDataBase : RoomDatabase() {
        abstract fun getInstance(): NotesDao
}
