package com.rodyapal.model.entity

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