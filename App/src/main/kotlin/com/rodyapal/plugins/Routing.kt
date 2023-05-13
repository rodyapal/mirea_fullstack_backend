package com.rodyapal.plugins

import com.rodyapal.routes.barbersApi
import com.rodyapal.routes.eventsApi
import com.rodyapal.routes.servicesApi
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
	routing {
		servicesApi()
		barbersApi()
		eventsApi()
	}
}