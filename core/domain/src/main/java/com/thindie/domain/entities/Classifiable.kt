package com.thindie.domain.entities

import com.thindie.domain.entities.behavior.Assignable
import com.thindie.domain.entities.behavior.Descriptionable
import com.thindie.domain.entities.behavior.Nameable

interface Classifiable<T> : Nameable, Descriptionable, Assignable<T>