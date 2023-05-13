package com.rodyapal.di

import com.rodyapal.config.Config
import org.koin.dsl.module
import org.ktorm.database.Database

val databaseModule = module {
	single { Database.connect(
		url = Config.DATABASE_URL,
		driver = Config.DATABASE_DRIVER,
		user = Config.DATABASE_USER_NAME,
		password = Config.DATABASE_PASSWORD
	) }
}