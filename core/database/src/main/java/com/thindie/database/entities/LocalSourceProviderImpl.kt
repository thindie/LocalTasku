package com.thindie.database.entities

import com.thindie.database.LocalSource
import com.thindie.database.NotesDao
import com.thindie.domain.entities.behavior.Uniqable
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
internal class LocalSourceProviderImpl @Inject constructor(private val dao: NotesDao) :
    LocalSource {
    override suspend fun update(localSourceEntity: LocalSourceEntity) {
        dao.upsertNote(localSourceEntity.toNoteDbModel())
    }

    override suspend fun delete(uniqable: Uniqable) {
        dao.deleteNote(uniqable.getId())
    }

    override suspend fun get(uniqable: Uniqable): LocalSourceEntity {
      return dao.getNote(uniqable.getId())
    }

    override suspend fun create() {
        dao.upsertNote(NoteDbModel.getInstance())
    }

    override fun observeLocalStoredEntities(): Flow<List<LocalSourceEntity>> {
        return dao.observeNotes()
    }
}