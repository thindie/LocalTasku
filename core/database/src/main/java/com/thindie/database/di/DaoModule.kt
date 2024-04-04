package com.thindie.database.di

import com.thindie.database.entities.NotesAppDataBase
import com.thindie.database.NotesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DaoModule {


    @Provides
    @Singleton
    fun provideCostDao(dataBase: NotesAppDataBase): NotesDao {
        return dataBase.getInstance()
    }

}
