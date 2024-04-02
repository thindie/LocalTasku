package com.thindie.database

import com.thindie.database.entities.LocalSourceEntity
import com.thindie.domain.entities.behavior.Uniqable
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
internal class LocalSourceProviderImpl @Inject constructor(): LocalSource {
    override suspend fun update(localSourceEntity: LocalSourceEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(uniqable: Uniqable) {
        TODO("Not yet implemented")
    }

    override fun observeLocalStoredEntities(): Flow<LocalSourceEntity> {
        TODO("Not yet implemented")
    }
}