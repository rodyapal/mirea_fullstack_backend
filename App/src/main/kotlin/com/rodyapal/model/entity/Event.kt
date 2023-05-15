package com.rodyapal.model.entity

import kotlinx.serialization.Serializable
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.jdbcTimestamp
import java.sql.Timestamp

object Events : Table<Event>("events") {
	val idEvent = int("id_event").primaryKey().bindTo { it.id }
	val idService = int("id_service").primaryKey().references(Services) { it.service }
	val idBarber = int("id_barber").primaryKey().references(Barbers) { it.barber }
	val idClient = int("id_client").primaryKey().references(Clients) { it.client }
	val visitDateTime = jdbcTimestamp("visit_date_time").bindTo { it.visitDateTime }
}
interface Event : Entity<Event> {
	companion object : Entity.Factory<Event>()
	val id: Int
	var service: Service
	var barber: Barber
	var client: Client
	var visitDateTime: Timestamp
}

@Serializable
data class EventDto(
	val id: Int,
	val service: ServiceDto,
	val barber: BarberDto,
	val client: ClientDto,
	val visitDateTime: Long
) {
	companion object {
		fun from(event: Event): EventDto {
			return EventDto(
				id = event.id,
				service = ServiceDto.from(event.service),
				barber = BarberDto.from(event.barber),
				client = ClientDto.from(event.client),
				visitDateTime = event.visitDateTime.time
			)
		}
	}
}