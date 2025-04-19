package cl.naravenar.cocktailapp.utils

import android.content.Context
import cl.naravenar.cocktailapp.R
import cl.naravenar.cocktailapp.enums.SizePizza
import cl.naravenar.cocktailapp.model.PizzaModel

class PizzaUtil {

    fun textSizePizza(context: Context, pizza: PizzaModel): String {
        val sb = StringBuilder()
        var result = pizza.getSize().getName()

        if(pizza.getSize().getSize() > 1){
            when (pizza.getSize().getName()) {
                context.getString(SizePizza.PERSONNEL.messageRes) -> result = context.getString(R.string.pizza_size_personal)
                context.getString(SizePizza.MEDIAN.messageRes) -> result = context.getString(R.string.pizza_size_medium)
                context.getString(SizePizza.FAMILIAR.messageRes) -> result = context.getString(R.string.pizza_size_family)
                context.getString(SizePizza.XL.messageRes) -> result = context.getString(R.string.pizza_size_xl)
            }
        }

        sb.append(context.getString(R.string.pizza_size_ration))
        sb.append(" ")
        sb.append(pizza.getQuantity())
        sb.append(" ")
        sb.append(result)
        sb.append(" ")
        sb.append(context.getString(R.string.pizza_size_ration_of))
        sb.append(" ")
        sb.append(pizza.getSize().getSize())
        sb.append(" ")
        sb.append(context.getString(R.string.pizza_unit_meas_cm))
        sb.append("\n")
        sb.append(context.getString(R.string.pizza_size_portion))
        sb.append(" ")
        sb.append(pizza.getSize().getPortion())
        return sb.toString()
    }
}