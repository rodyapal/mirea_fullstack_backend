package com.rodyapal.model

import com.rodyapal.barbershop.model.table.*
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf

val Database.barbers get() = sequenceOf(Barbers)
val Database.services get() = sequenceOf(Services)
val Database.BSConnections get() = sequenceOf(BarberServiceConnections)
val Database.clients get() = sequenceOf(Clients)
val Database.events get() = sequenceOf(Events)