package com.rodyapal.routes

import com.rodyapal.config.Config
import com.rodyapal.model.EventService
import com.rodyapal.plugins.UserSession
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import kotlinx.serialization.json.Json
import org.koin.ktor.ext.inject

fun Route.eventsApi() {
	val eventService by inject<EventService>()
	authenticate(Config.AUTH_TYPE_SESSION) {
		route(Config.API_PATH_EVENTS) {
			post {
				println("LOOK HERE: ${call.sessions}")
				call.principal<UserSession>()?.let {
					val eventData = call.receive<String>().let { data ->
						Json.decodeFromString(deserializer = EventService.EventDataHolder.serializer(), data)
					}
					eventService.registerEvent(eventData, it.id)
					call.respondText(
						text = "Event registered",
						status = HttpStatusCode.Created
					)
				} ?: call.respondText(
					text = "Event registration failed: user not found",
					status = HttpStatusCode.BadRequest
				)
			}
		}
	}
}