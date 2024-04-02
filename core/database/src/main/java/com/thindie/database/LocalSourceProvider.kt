package com.thindie.database

interface LocalSourceProvider {
    fun provideLocalSource(): LocalSource
}