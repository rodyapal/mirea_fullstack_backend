package com.rodyapal

import com.rodyapal.config.Config
import com.rodyapal.di.databaseModule
import com.rodyapal.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>) {
	if (args.any { it.contains("railway") }) Config.useRailway = true
	embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module).start(wait = true)
}

fun Application.module() {
	configureSecurity()
	configureSessions()
	configureMonitoring()
	configureSerialization()
	configureRouting()

	install(Koin) {
		modules(databaseModule)
	}
}
