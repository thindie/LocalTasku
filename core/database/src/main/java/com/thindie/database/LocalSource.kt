package com.thindie.database

import com.thindie.database.entities.LocalSourceEntity
import com.thindie.domain.entities.behavior.Uniqable
import kotlinx.coroutines.flow.Flow

interface LocalSource {
    suspend fun update(localSourceEntity: LocalSourceEntity)
    suspend fun delete(uniqable: Uniqable)

    suspend fun get(uniqable: Uniqable): LocalSourceEntity
    suspend fun create()
    fun observeLocalStoredEntities(): Flow<List<LocalSourceEntity>>
}