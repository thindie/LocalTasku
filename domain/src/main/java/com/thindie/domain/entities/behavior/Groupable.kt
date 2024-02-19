package com.thindie.domain.entities.behavior

interface Groupable {
    fun getGrouping(): String
    fun isGrouped(): Boolean
}