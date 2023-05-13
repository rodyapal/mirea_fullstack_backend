package com.rodyapal.routes

import com.rodyapal.config.Config
import com.rodyapal.model.EventService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.eventsApi() {
	val eventService by inject<EventService>()
	route(Config.API_PATH_EVENTS) {
		get("/user/{userId}") {
			call.parameters["userId"]?.let { userId ->
				call.respond(
					message = eventService.getEventsByUserId(
						userId = userId.toInt()
					),
					status = HttpStatusCode.OK
				)
			} ?: call.respond(
				message = "User id is not specified",
				status = HttpStatusCode.BadRequest
			)
		}
		post {
			try {
				val eventData = call.receive<EventService.EventDataHolder>()
				eventService.registerEvent(eventData)
				call.respondText(
					text = "Event registered",
					status = HttpStatusCode.OK
				)
			} catch (e: Exception) {
				call.respondText(
					text = "Event registration failed: ${e.message}",
					status = HttpStatusCode.BadRequest
				)
			}
		}
	}
}