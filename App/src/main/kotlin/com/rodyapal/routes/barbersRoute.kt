package com.rodyapal.routes

import com.rodyapal.config.Config
import com.rodyapal.model.dao.BarberDao
import com.rodyapal.model.entity.BarberDto
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.barbersApi() {
	val barberDao by inject<BarberDao>()
	route(Config.API_PATH_BARBERS) {
		get {
			call.response.header("Access-Control-Allow-Origin", "*")
			call.respond(
				message = barberDao.findAll().map { BarberDto.from(it) },
				status = HttpStatusCode.OK
			)
		}
	}
}