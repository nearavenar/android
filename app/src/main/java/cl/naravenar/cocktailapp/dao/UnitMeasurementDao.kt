package cl.naravenar.cocktailapp.dao

import cl.naravenar.cocktailapp.model.UnitMeasurementModel

//@Dao
interface UnitMeasurementDao {
    //@Insert
    fun createUnitMeasurement(unitMeasurement: UnitMeasurementModel): Long

    //@Query("SELECT * FROM unit_measurement where id = :id")
    fun getUnitMeasurementById(id: Long): UnitMeasurementModel

    //@Update
    fun updateUnitMeasurement(unitMeasurement: UnitMeasurementModel)

    //@Delete
    fun deleteUnitMeasurement(unitMeasurement: UnitMeasurementModel)

    //@Query("SELECT * FROM unit_measurement")
    fun getAll() : MutableList<UnitMeasurementModel>
}