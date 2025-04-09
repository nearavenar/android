package cl.naravenar.cocktailapp.repository.impl

import android.content.Context
import androidx.room.Room
import cl.naravenar.cocktailapp.config.StoreDatabase
import cl.naravenar.cocktailapp.model.UnitMeasurementModel
import cl.naravenar.cocktailapp.repository.UnitMeasurementRepository

class UnitMeasurementRepositoryImpl(context: Context):UnitMeasurementRepository {
    private var database = Room.databaseBuilder(context, StoreDatabase::class.java, "StoreDatabase")

    override fun createUnitMeasurement(unitMeasurement: UnitMeasurementModel): Long {
        TODO("Not yet implemented")
    }

    override fun getAllUnitMeasurements(): MutableList<UnitMeasurementModel> {
        TODO("Not yet implemented")
    }

    override fun getUnitMeasurementByID(id: Long): UnitMeasurementModel {
        TODO("Not yet implemented")
    }
}