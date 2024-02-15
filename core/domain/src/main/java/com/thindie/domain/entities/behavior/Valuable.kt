package com.thindie.domain.entities.behavior

interface Valuable<T> {
    fun getValue(): T
}