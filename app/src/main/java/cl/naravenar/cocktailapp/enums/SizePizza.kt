package cl.naravenar.cocktailapp.enums

import android.content.Context
import androidx.annotation.StringRes
import cl.naravenar.cocktailapp.R
import cl.naravenar.cocktailapp.model.SizeModel

enum class SizePizza (@StringRes val messageRes: Int, val size: Int, val portion: Int) {
    PERSONNEL(R.string.pizza_size_personnel, 25, 6),
    MEDIAN(R.string.pizza_size_median, 33, 8),
    FAMILIAR(R.string.pizza_size_familiar, 40, 12),
    XL(R.string.pizza_size_xl, 45, 16);

    fun getSize(context: Context): SizeModel {
        val side = SizeModel()
        side.setName(context.getString(messageRes))
        side.setSize(size)
        side.setPortion(portion)
        return side
    }

    /*
    fun getSize(context: Context): String {
        return context.getString(messageRes)
    }
    */
}