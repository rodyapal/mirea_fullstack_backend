package com.rodyapal.model.dao

import com.rodyapal.model.entity.*
import org.ktorm.database.Database

class BarberDao(database: Database) : AppDao<Barber, Barbers>(Barbers, database)

class ClientDao(database: Database) : AppDao<Client, Clients>(Clients, database)

class EventDao(database: Database) : AppDao<Event, Events>(Events, database)

class ServiceDao(database: Database) : AppDao<Service, Services>(Services, database)