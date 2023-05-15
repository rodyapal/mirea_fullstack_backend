package com.rodyapal.di

import com.rodyapal.config.Config
import com.rodyapal.model.repository.EventRepository
import com.rodyapal.model.dao.BarberDao
import com.rodyapal.model.dao.ClientDao
import com.rodyapal.model.dao.EventDao
import com.rodyapal.model.repository.BarberRepository
import com.rodyapal.model.repository.ServiceRepository
import com.rodyapal.model.repository.ClientRepository
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
		com.rodyapal.model.dao.ServiceDao(database = get())
	}
	single {
		EventRepository(
			eventDao = get(),
			barberDao = get(),
			clientDao = get(),
			serviceDao = get()
		)
	}
	single {
		ClientRepository(
			clientDao = get()
		)
	}
	single {
		ServiceRepository(
			serviceDao = get()
		)
	}
	single {
		BarberRepository(
			barberDao = get()
		)
	}
}