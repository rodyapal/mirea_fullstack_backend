package com.rodyapal.model.repository

import com.rodyapal.model.dao.BarberDao
import com.rodyapal.model.dao.ClientDao
import com.rodyapal.model.dao.EventDao
import com.rodyapal.model.dao.ServiceDao
import com.rodyapal.model.entity.Event
import com.rodyapal.model.entity.EventDto
import kotlinx.serialization.Serializable
import org.ktorm.dsl.eq
import java.sql.Timestamp

class EventRepository(
	private val eventDao: EventDao,
	private val serviceDao: ServiceDao,
	private val barberDao: BarberDao,
	private val clientDao: ClientDao
) {
	fun getEventsByUserId(userId: Int) = eventDao.findAll().filter { it.id == userId }.map { EventDto.from(it) }

	fun registerEvent(
		data: EventDataHolder,
		idClient: Int
	): Boolean {
		val storedService = serviceDao.findOne { it.id eq data.idService }
		val storedBarber = barberDao.findOne { it.id eq data.idBarber }
		val storedClient = clientDao.findOne { it.id eq idClient }

		if (storedService == null || storedBarber == null || storedClient == null) return false

		val event = Event {
			service = storedService
			barber = storedBarber
			client = storedClient
			visitDateTime = Timestamp(data.dateTime)
		}
		eventDao.add(event)
		return true
	}

	@Serializable
	data class EventDataHolder(
		val idBarber: Int,
		val idService: Int,
		val dateTime: Long
	)
}