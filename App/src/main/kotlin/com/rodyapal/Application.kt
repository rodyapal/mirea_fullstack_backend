package com.rodyapal

import com.rodyapal.di.databaseModule
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.rodyapal.plugins.*
import org.koin.ktor.plugin.Koin

fun main() {
	embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module).start(wait = true)
}

fun Application.module() {
	configureSecurity()
	configureHTTP()
	configureMonitoring()
	configureSerialization()

	install(Koin) {
		modules(databaseModule)
	}
}
