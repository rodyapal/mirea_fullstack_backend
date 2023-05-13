package com.rodyapal.plugins

import com.rodyapal.routes.servicesApi
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
	routing {
		servicesApi()
	}
}