package com.rodyapal.config

object Config {
	const val DATABASE_NAME = "appDb"
	const val DATABASE_USER_NAME = "appUser"
	const val DATABASE_PASSWORD = "appPassword"
	const val DATABASE_PORT = "5432"
	const val DATABASE_HOST = "localhost"
	const val DATABASE_DRIVER = "org.postgresql.Driver"
	const val DATABASE_URL = "jdbc:postgresql://$DATABASE_HOST:$DATABASE_PORT/$DATABASE_NAME"

	const val API_VERSION = "v1"
	const val API_PATH_SERVICES = "/api/$API_VERSION/services"
	const val API_PATH_EVENTS = "/api/$API_VERSION/events"
	const val API_PATH_BARBERS = "/api/$API_VERSION/barbers"
	const val API_PATH_CLIENTS = "/api/$API_VERSION/clients"

	const val AUTH_SESSION_NAME = "auth-session"
	const val AUTH_TYPE_SESSION = "auth-type-session"
	const val AUTH_TYPE_FORM = "auth-type-form"
	const val AUTH_PATH = "auth/login"
}