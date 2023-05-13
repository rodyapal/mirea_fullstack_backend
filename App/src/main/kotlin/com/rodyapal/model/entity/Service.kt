package com.rodyapal.model.entity

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