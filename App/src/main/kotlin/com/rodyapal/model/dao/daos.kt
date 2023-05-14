package com.rodyapal.model.dao

import com.rodyapal.model.entity.*
import org.ktorm.database.Database
import org.ktorm.dsl.and
import org.ktorm.dsl.eq

class BarberDao(database: Database) : AppDao<Barber, Barbers>(Barbers, database)

class ClientDao(database: Database) : AppDao<Client, Clients>(Clients, database) {
	fun validate(name: String, password: String) = anyMatch { (it.name eq name) and (it.password eq password) }
}

class EventDao(database: Database) : AppDao<Event, Events>(Events, database)

class ServiceDao(database: Database) : AppDao<Service, Services>(Services, database)