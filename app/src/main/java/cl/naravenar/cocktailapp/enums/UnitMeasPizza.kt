package cl.naravenar.cocktailapp.enums

import android.content.Context
import cl.naravenar.cocktailapp.R

enum class UnitMeasPizza (val resourceId: Int) {
    ML(R.string.pizza_unit_meas_ml),
    DUST(R.string.pizza_unit_meas_dust),
    GR(R.string.pizza_unit_meas_gr);

    fun getMessage(context: Context): String {
        return context.getString(resourceId)
    }
}