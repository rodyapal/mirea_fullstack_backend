package com.rodyapal

import com.rodyapal.config.Config
import com.rodyapal.di.databaseModule
import com.rodyapal.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>) {
	embeddedServer(Netty, port = Config.SERVER_PORT, host = Config.SERVER_HOST, module = Application::module).start(wait = true)
}

fun Application.module() {
	configureCORS()
	configureSecurity()
	configureSessions()
	configureMonitoring()
	configureSerialization()
	configureRouting()

	install(Koin) {
		modules(databaseModule)
	}
}
