package com.thindie.tasks_general.di

import javax.inject.Scope

@Retention(AnnotationRetention.RUNTIME)
@Scope
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class TasksGeneralScope()
