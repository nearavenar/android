package cl.naravenar.cocktailapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import cl.naravenar.cocktailapp.entity.converter.UnitMeasurementConverter
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "ingredient")
data class IngredientModel (@PrimaryKey private var id: Long = 0,
                            private var name: String,
                            private var amount: String,
                            @TypeConverters(UnitMeasurementConverter::class)
                            /*@ColumnInfo(name = "unit_measurement")*/
                            private var unitMeasurement: UnitMeasurementModel) : Parcelable {

    constructor() : this(0, "", "0", UnitMeasurementModel(1,"")) {

    }

    fun getId(): Long {
        return id
    }

    fun setId(id: Long) {
        this.id = id
    }

    fun getName(): String {
        return name
    }

    fun setName(drink: String) {
        this.name = name
    }

    fun getAmount(): String {
        return amount
    }

    fun setAmount(amount: String) {
        this.amount = amount
    }

    fun getUnitMeasurement(): UnitMeasurementModel {
        return unitMeasurement
    }

    fun setUnitMeasurement(unitMeasurement: UnitMeasurementModel) {
        this.unitMeasurement = unitMeasurement
    }

    override fun toString(): String {
        return "$id:$name:$amount:$unitMeasurement"
    }
}