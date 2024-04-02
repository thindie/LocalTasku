package com.thindie.database

import com.thindie.database.entities.LocalSourceEntity
import com.thindie.domain.entities.behavior.Uniqable
import kotlinx.coroutines.flow.Flow

interface LocalSource {
    suspend fun update(localSourceEntity: LocalSourceEntity)
    suspend fun delete(uniqable: Uniqable)

    fun observeLocalStoredEntities(): Flow<List<LocalSourceEntity>>
}