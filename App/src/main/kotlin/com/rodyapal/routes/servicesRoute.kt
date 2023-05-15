package com.rodyapal.routes

import com.rodyapal.config.Config
import com.rodyapal.model.repository.ServiceRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.servicesApi() {
	val serviceRepository by inject<ServiceRepository>()
	route(Config.API_PATH_SERVICES) {
		get {
			call.response.header("Access-Control-Allow-Origin", "*")
			call.respond(
				message = serviceRepository.getAll(),
				status = HttpStatusCode.OK
			)
		}
	}
}