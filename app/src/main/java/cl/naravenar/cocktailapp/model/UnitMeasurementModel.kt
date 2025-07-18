package cl.naravenar.cocktailapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
//@Entity(tableName = "unit_measurement")
data class UnitMeasurementModel(/*@PrimaryKey*/ private var id: Long = 0,
                           private var name: String) : Parcelable {

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

    override fun toString(): String {
        return "$id:$name"
    }
}