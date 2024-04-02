package com.thindie.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thindie.database.entities.BindingsDbModel
import com.thindie.database.entities.CostDbModel
import com.thindie.database.entities.NoteDbModel
import javax.inject.Singleton

@Singleton
//@Database(entities =  [], version = 1, exportSchema = false)
internal abstract class NotesAppDataBase : RoomDatabase() {

}
