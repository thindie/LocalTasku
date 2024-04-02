package com.thindie.database.entities

internal fun LocalSourceEntity.toNoteDbModel() = NoteDbModel(
    noteId = getId(),
    noteTitle = getName(),
    noteDescription = getDescription(),
    noteDeadline = getPlannedTimeStampMillis(),
    noteGroupTitle = getGrouping(),
    noteStatusAssign = getAssign(),
    notePriority = getPrior(),
    noteCost = getCost(),
    noteCreationTime = getTrackPoint()

)