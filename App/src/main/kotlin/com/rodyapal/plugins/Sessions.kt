package com.rodyapal.plugins

import com.rodyapal.config.Config
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.sessions.*

data class UserSession(
	val name: String,
	val id: Int
) : Principal
fun Application.configureSessions() {
	install(Sessions) {
		cookie<UserSession>(
			name = Config.AUTH_SESSION_NAME
		) {
			cookie.path = "/"
//			cookie.extensions["SameSite"] = "lax"
		}
	}
}