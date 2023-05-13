package com.rodyapal.model.entity

import kotlinx.serialization.Serializable
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Barbers : Table<Barber>("barbers") {
	val id = int("id_barber").primaryKey().bindTo { it.id }
	val name = varchar("name").bindTo { it.name }
}
interface Barber : Entity<Barber> {
	companion object : Entity.Factory<Barber>()
	val id: Int
	var name: String
}

@Serializable
class BarberDto(
	val id: Int,
	val name: String
) {
	companion object {
		fun from(barber: Barber): BarberDto {
			return BarberDto(
				id = barber.id,
				name = barber.name
			)
		}
	}
}