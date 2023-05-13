package com.rodyapal.config

object Config {
	const val DATABASE_NAME = "appDb"
	const val DATABASE_USER_NAME = "appUser"
	const val DATABASE_PASSWORD = "appPassword"
	const val DATABASE_PORT = "5432"
	const val DATABASE_HOST = "localhost"
	const val DATABASE_DRIVER = "org.postgresql.Driver"

	const val DATABASE_URL = "jdbc:postgres://$DATABASE_HOST:$DATABASE_PORT/$DATABASE_NAME"
}