package cl.naravenar.cocktailapp.repository

import cl.naravenar.cocktailapp.model.UnitMeasurementModel

interface UnitMeasurementRepository {
    fun createUnitMeasurement(unitMeasurement: UnitMeasurementModel): Long
    fun getAllUnitMeasurements():MutableList<UnitMeasurementModel>
    fun getUnitMeasurementByID(id: Long): UnitMeasurementModel
}