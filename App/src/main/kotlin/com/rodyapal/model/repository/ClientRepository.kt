package com.rodyapal.model.repository

import com.rodyapal.model.dao.ClientDao
import com.rodyapal.model.entity.Client
import kotlinx.serialization.Serializable
import org.ktorm.dsl.and
import org.ktorm.dsl.eq

class ClientRepository(
	private val clientDao: ClientDao
) {
	fun validate(name: String, password: String) = clientDao.anyMatch { (it.name eq name) and (it.password eq password) }

	fun validateSession(sessionId: Int) = clientDao.anyMatch { sessionId eq it.id }

	fun getIdForName(name: String) = clientDao.findOne { it.name eq name }!!.id

	fun add(
		data: ClientDataHolder
	) = clientDao.add(
		Client {
			name = data.name
			phoneNumber = data.phone
			email = data.email
			password = data.password
		}
	)

	@Serializable
	data class ClientDataHolder(
		val name: String,
		val phone: String,
		val email: String,
		val password: String
	)

}