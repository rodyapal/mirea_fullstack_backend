package com.rodyapal.model.entity

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int

object BarberServiceConnections : Table<BarberServiceConnection>(
	"barber_service"
) {
	val idBarber = int("id_barber").primaryKey().references(Barbers) { it.barber }
	val idService = int("id_service").primaryKey().references(Services) { it.service }
}
interface BarberServiceConnection : Entity<BarberServiceConnection> {
	companion object : Entity.Factory<BarberServiceConnection>()
	var barber: Barber
	var service: Service
}