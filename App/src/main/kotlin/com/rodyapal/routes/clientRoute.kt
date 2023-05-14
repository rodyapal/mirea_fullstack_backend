package com.rodyapal.routes

import com.rodyapal.config.Config
import com.rodyapal.model.dao.ClientDao
import com.rodyapal.model.entity.Client
import com.rodyapal.model.entity.ClientDto
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.ktor.ext.inject

@Serializable
private data class ClientDataHolder(
	val name: String,
	val phone: String,
	val email: String,
	val password: String
)

fun Route.clientApi() {
	val clientDao by inject<ClientDao>()
	route(Config.API_PATH_CLIENTS) {
		post {
			try {
				val data = call.receive<String>().let {
					Json.decodeFromString(deserializer = ClientDataHolder.serializer(), it)
				}
				clientDao.add(
					Client {
						name = data.name
						phoneNumber = data.phone
						email = data.email
						password = data.password
					}
				)
				call.respondText(
					text = Json.encodeToString("Client registered"),
					status = HttpStatusCode.Created
				)
			} catch (e: Exception) {
				call.respondText(
					text =  Json.encodeToString("Client registration failed: ${e.message}"),
					status = HttpStatusCode.BadRequest
				)
			}
		}
		get {
			call.respond(
				message = clientDao.findAll().map { ClientDto.from(it) },
				status = HttpStatusCode.OK
			)
		}
	}
}