package com.thindie.database.entities

import com.thindie.domain.entities.behavior.Assignable
import com.thindie.domain.entities.behavior.Descriptionable
import com.thindie.domain.entities.behavior.Groupable
import com.thindie.domain.entities.behavior.Nameable
import com.thindie.domain.entities.behavior.Planable
import com.thindie.domain.entities.behavior.Priorable
import com.thindie.domain.entities.behavior.Spendable
import com.thindie.domain.entities.behavior.Trackable
import com.thindie.domain.entities.behavior.Uniqable

interface LocalSourceEntity : Nameable, Descriptionable, Planable, Uniqable, Groupable, Assignable,
    Priorable, Trackable,
    Spendable