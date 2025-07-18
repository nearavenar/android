package cl.naravenar.cocktailapp.enums

import android.content.Context
import cl.naravenar.cocktailapp.R

enum class UnitMeasDrink (val resourceId: Int) {
    CUBE(R.string.drink_unit_meas_cube),
    OZ(R.string.drink_unit_meas_oz),
    DASH(R.string.drink_unit_meas_dash),
    LEAVES(R.string.drink_unit_meas_leaves),
    FRAPPE(R.string.drink_unit_meas_frappe),
    TO_CROWN(R.string.drink_unit_meas_to_crown),
    SLICE(R.string.drink_unit_meas_slice),
    GRAIN(R.string.drink_unit_meas_grain),
    WEDGES(R.string.drink_unit_meas_wedges),
    GR(R.string.drink_unit_meas_gr),
    FROST(R.string.drink_unit_meas_frost),
    QUANTITY(R.string.drink_unit_meas_quantity);

    fun getMessage(context: Context): String {
        return context.getString(resourceId)
    }
}