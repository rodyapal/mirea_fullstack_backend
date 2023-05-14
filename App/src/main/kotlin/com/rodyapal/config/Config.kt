package com.rodyapal.config

object Config {
	var useRailway = false

	val DATABASE_NAME get() = if (useRailway) RailwayDatabase.DATABASE_NAME else DockerDatabase.DATABASE_NAME
	val DATABASE_USER_NAME get() = if (useRailway) RailwayDatabase.DATABASE_USER_NAME else DockerDatabase.DATABASE_USER_NAME
	val DATABASE_PASSWORD get() = if (useRailway) RailwayDatabase.DATABASE_PASSWORD else DockerDatabase.DATABASE_PASSWORD
	val DATABASE_PORT get() = if (useRailway) RailwayDatabase.DATABASE_PORT else DockerDatabase.DATABASE_PORT
	val DATABASE_HOST get() = if (useRailway) RailwayDatabase.DATABASE_HOST else DockerDatabase.DATABASE_HOST
	val DATABASE_DRIVER get() = if (useRailway) RailwayDatabase.DATABASE_DRIVER else DockerDatabase.DATABASE_DRIVER
	val DATABASE_URL get() = if (useRailway) RailwayDatabase.DATABASE_URL else DockerDatabase.DATABASE_URL

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

private object DockerDatabase {
	const val DATABASE_NAME = "appDb"
	const val DATABASE_USER_NAME = "appUser"
	const val DATABASE_PASSWORD = "appPassword"
	const val DATABASE_PORT = "5432"
	const val DATABASE_HOST = "postgres"
	const val DATABASE_DRIVER = "org.postgresql.Driver"
	const val DATABASE_URL = "jdbc:postgresql://$DATABASE_HOST:$DATABASE_PORT/$DATABASE_NAME"
}

private object RailwayDatabase {
	const val DATABASE_NAME = "railway"
	const val DATABASE_USER_NAME = "postgres"
	const val DATABASE_PASSWORD = "dPVnylIcnGd8EzMVS1k9"
	const val DATABASE_PORT = "6355"
	const val DATABASE_HOST = "containers-us-west-155.railway.app"
	const val DATABASE_DRIVER = "org.postgresql.Driver"
	const val DATABASE_URL = "jdbc:postgresql://$DATABASE_USER_NAME:$DATABASE_PASSWORD@$DATABASE_HOST:$DATABASE_PORT/$DATABASE_NAME"
}