package cl.naravenar.cocktailapp.entity.converter

import cl.naravenar.cocktailapp.model.UnitMeasurementModel
import com.google.gson.Gson

class UnitMeasurementConverter {

    //@TypeConverter
    fun unitMeasurementoString(unitMeasurement: UnitMeasurementModel) = "$unitMeasurement"

    //@TypeConverter
    fun stringToUnitMeasurement(value: String): UnitMeasurementModel {

        if (value == null) {
            return UnitMeasurementModel(0, "")
        }

        var data = value.split(":")
        val id = data[0].toLong()
        val name = data[1]

        return UnitMeasurementModel(id, name)
    }
}
