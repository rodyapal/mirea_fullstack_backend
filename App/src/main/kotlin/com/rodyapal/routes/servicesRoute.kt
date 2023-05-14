package com.rodyapal.routes

import com.rodyapal.config.Config
import com.rodyapal.model.dao.ServiceDao
import com.rodyapal.model.entity.ServiceDto
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.servicesApi() {
	val serviceDao by inject<ServiceDao>()
	route(Config.API_PATH_SERVICES) {
		get {
			call.response.header("Access-Control-Allow-Origin", "*")
			call.respond(
				message = serviceDao.findAll().map { ServiceDto.from(it) },
				status = HttpStatusCode.OK
			)
		}
	}
}