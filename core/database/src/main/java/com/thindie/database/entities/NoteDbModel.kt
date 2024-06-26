package com.thindie.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thindie.database.DataBaseContract.notesTable


@Entity(tableName = notesTable)
internal data class NoteDbModel(
    @PrimaryKey (autoGenerate = true)
    val noteId: Long = 0,
    val noteTitle: String,
    val noteDescription: String,
    val noteDeadline: Long,
    val noteGroupTitle: String,
    val noteStatusAssign: Int,
    val notePriority: Int,
    val noteCost: Int? = null,
    val noteCreationTime: Long,
): LocalSourceEntity {
    override fun getDescription() = noteDescription

    override fun getGrouping() = noteGroupTitle

    override fun isGrouped() = noteGroupTitle.isNotBlank()

    override fun getName() = noteTitle

    override fun getPlannedTimeStampMillis() = noteDeadline

    override fun getId() = noteId
    override fun getAssign() = noteStatusAssign
    override fun getPrior() = notePriority

    override fun getCost() = noteCost

    override fun getTrackPoint() = noteCreationTime

    companion object {
        fun getInstance() = NoteDbModel (
            noteId = 0,
            noteTitle = "",
            noteDescription = "",
            noteDeadline = 0,
            noteGroupTitle = "",
            noteStatusAssign = 0,
            notePriority = 0,
            noteCost = null,
            noteCreationTime = System.currentTimeMillis()
        )
    }
}