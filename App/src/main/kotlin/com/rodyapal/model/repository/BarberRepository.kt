package com.rodyapal.model.repository

import com.rodyapal.model.dao.BarberDao
import com.rodyapal.model.entity.BarberDto

class BarberRepository(
	private val barberDao: BarberDao
) {
	fun getAll() = barberDao.findAll().map { BarberDto.from(it) }
}