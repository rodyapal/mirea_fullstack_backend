package com.rodyapal.model.repository

import com.rodyapal.model.dao.ServiceDao
import com.rodyapal.model.entity.ServiceDto

class ServiceRepository(
	private val serviceDao: ServiceDao
) {
	fun getAll() = serviceDao.findAll().map { ServiceDto.from(it) }
}