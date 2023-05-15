package com.rodyapal.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cors.routing.*

fun Application.configureCORS() {
	install(CORS) {
		anyHost()
		allowHeader(HttpHeaders.ContentType)
		allowSameOrigin = true
		allowCredentials = true
		allowNonSimpleContentTypes = true
		allowMethod(HttpMethod.Post)
		allowMethod(HttpMethod.Get)
		allowHeader(HttpHeaders.AccessControlAllowOrigin)
	}
}