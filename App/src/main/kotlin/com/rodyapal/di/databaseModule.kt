package com.rodyapal.di

import com.rodyapal.config.Config
import com.rodyapal.model.EventService
import com.rodyapal.model.dao.BarberDao
import com.rodyapal.model.dao.ClientDao
import com.rodyapal.model.dao.EventDao
import com.rodyapal.model.dao.ServiceDao
import org.koin.dsl.module
import org.ktorm.database.Database

val databaseModule = module {
	single<Database> { Database.connect(
		url = Config.DATABASE_URL,
		driver = Config.DATABASE_DRIVER,
		user = Config.DATABASE_USER_NAME,
		password = Config.DATABASE_PASSWORD
	) }

	single {
		BarberDao(database = get())
	}
	single {
		ClientDao(database = get())
	}
	single {
		EventDao(database = get())
	}
	single {
		ServiceDao(database = get())
	}
	single {
		EventService(
			eventDao = get(),
			barberDao = get(),
			clientDao = get(),
			serviceDao = get()
		)
	}
}