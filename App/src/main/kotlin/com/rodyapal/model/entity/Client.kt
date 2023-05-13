package com.rodyapal.model.entity

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Clients : Table<Client>("clients") {
	val id = int("id_client").primaryKey().bindTo { it.id }
	val name = varchar("name").bindTo { it.name }
	val email = varchar("email").bindTo { it.email }
	val password = varchar("password").bindTo { it.password }
	val phoneNumber = varchar("phone_number").bindTo { it.phoneNumber }
}
interface Client : Entity<Client> {
	companion object : Entity.Factory<Client>()
	val id: Int
	var name: String
	var email: String
	var password: String
	var phoneNumber: String
}