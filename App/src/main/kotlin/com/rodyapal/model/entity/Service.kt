package com.rodyapal.model.entity

import kotlinx.serialization.Serializable
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.text
import org.ktorm.schema.varchar

object Services : Table<Service>("services") {
	val id = int("id_service").primaryKey().bindTo { it.id }
	val name = varchar("name").bindTo { it.name }
	val description = text("description").bindTo { it.description }
	val duration = int("duration").bindTo { it.duration }
	val price = int("price").bindTo { it.price }
}

interface Service : Entity<Service> {
	companion object : Entity.Factory<Service>()
	val id: Int
	var name: String
	var description: String
	var duration: Int
	var price: Int
}

@Serializable
data class ServiceDto(
	val id: Int,
	val name: String,
	val description: String,
	val duration: Int,
	val price: Int
) {
	companion object {
		fun from(service: Service): ServiceDto {
			return ServiceDto(
				id = service.id,
				name = service.name,
				description = service.description,
				duration = service.duration,
				price = service.price
			)
		}
	}
}