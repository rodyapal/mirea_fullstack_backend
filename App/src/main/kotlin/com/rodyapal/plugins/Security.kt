package com.rodyapal.plugins

import com.rodyapal.config.Config
import com.rodyapal.model.dao.ClientDao
import com.rodyapal.model.repository.ClientRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import org.koin.ktor.ext.inject
import org.ktorm.dsl.eq

fun Application.configureSecurity() {

	val clientRepository by inject<ClientRepository>()
	authentication {
		session<UserSession>(Config.AUTH_TYPE_SESSION) {
			validate { session ->
				if (clientRepository.validateSession(session.id)) {
					session
				} else null
			}
		}
		form(Config.AUTH_TYPE_FORM) {
			userParamName = "username"
			passwordParamName = "password"
			validate { credentials ->
				if (clientRepository.validate(credentials.name, credentials.password)) {
					UserIdPrincipal(credentials.name)
				} else {
					null
				}
			}
			challenge {
				call.respond(HttpStatusCode.Unauthorized, "Credentials are not valid")
			}
		}
	}
	routing {
		authenticate(Config.AUTH_TYPE_FORM) {
			post(Config.AUTH_PATH) {
				val principal = call.principal<UserIdPrincipal>()!!
				call.sessions.set(UserSession(
					name = principal.name,
					id = clientRepository.getIdForName(principal.name)
				))
				call.respond(HttpStatusCode.OK, "OK")
				println("LOOK HERE: ${call.sessions}")
			}
		}
	}
}
