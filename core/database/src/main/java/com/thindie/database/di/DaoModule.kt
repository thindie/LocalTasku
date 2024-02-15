package com.thindie.database.di

import com.thindie.database.BindingsDao
import com.thindie.database.CostsDao
import com.thindie.database.NotesAppDataBase
import com.thindie.database.NotesDao
import dagger.Module
import dagger.Provides

@Module
class DaoModule {
/*    @Provides
    fun bindDao(dataBase: NotesAppDataBase): NotesDao {
        return dataBase.getInstance()
    }

    @Provides
    fun provideCostDao(dataBase: NotesAppDataBase): CostsDao {
        return dataBase.getCostsInstance()
    }

    @Provides
    fun provideBindingsDao(dataBase: NotesAppDataBase): BindingsDao {
        return dataBase.getBindingsInstance()
    }*/
}
