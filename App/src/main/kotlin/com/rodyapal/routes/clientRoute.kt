package com.rodyapal.routes

import com.rodyapal.config.Config
import com.rodyapal.model.dao.ClientDao
import com.rodyapal.model.entity.Client
import com.rodyapal.model.entity.ClientDto
import com.rodyapal.model.repository.ClientRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.ktor.ext.inject


fun Route.clientApi() {
	val clientRepository by inject<ClientRepository>()
	route(Config.API_PATH_CLIENTS) {
		post {
			try {
				val data = call.receive<String>().let {
					Json.decodeFromString(deserializer = ClientRepository.ClientDataHolder.serializer(), it)
				}
				clientRepository.add(data)
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
	}
}