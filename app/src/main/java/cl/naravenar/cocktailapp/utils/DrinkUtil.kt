package cl.naravenar.cocktailapp.utils

import cl.naravenar.cocktailapp.enums.SizePizza
import cl.naravenar.cocktailapp.model.DrinkModel
import cl.naravenar.cocktailapp.model.IngredientModel
import android.content.Context
import android.widget.TextView
import cl.naravenar.cocktailapp.R
import cl.naravenar.cocktailapp.model.PizzaModel
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class DrinkUtil {
    fun shareFormater(drinkModel:DrinkModel):String{

        var ingredient = ""
        for (ing in drinkModel.getIngredients()){
           ingredient+="${ing.getName()} ${ing.getAmount()} ${ing.getUnitMeasurement().getName()}\n"
        }

        return "${drinkModel.getName()}\n\n$ingredient\n${drinkModel.getPreparation()}"
    }

    fun detailsDrinks(drinks:List<DrinkModel>):String{
        var detail = ""
        for (aux in drinks){
            detail+= "${aux.getName()}\n"
        }
        return detail
    }

    fun ingredientDrink(ingredientsList:List<IngredientModel>):String{
        var ingredient = "Ingredientes:\n"
        for (value in ingredientsList) {
            ingredient += "${value.getName()} ${if(value.getAmount() == "0") "" else value.getAmount()} ${value.getUnitMeasurement().getName()} \n"
        }
        return ingredient
    }

    fun ingredientCantPizza(ingredientsList:List<IngredientModel>, number:Int):String{
        var ingredient = "Ingredientes:\n"
        for (value in ingredientsList) {
            ingredient += "${value.getName()} ${if(value.getAmount() == "0") "" else mostrarMontoFormateado((value.getAmount().toIntOrNull() ?: 1) * number)} ${value.getUnitMeasurement().getName()} \n"
        }
        return ingredient
    }

    fun maxLines(max:Int, currentLength:Int, value:String):Int{
        if (max == currentLength) {
            return value.length
        }
        return max
    }

    fun typeFont(value:Boolean):Int {
        if (value){
            return android.R.style.TextAppearance_Large
        }else{
            return  android.R.style.TextAppearance_Holo
        }
    }

    fun mostrarMontoFormateado(textView: TextView, monto: Int) {
        val symbols = DecimalFormatSymbols().apply {
            groupingSeparator = '.' // Puedes usar ',' si quieres estilo inglés
        }
        val formatter = DecimalFormat("#,###", symbols)
        val montoFormateado = formatter.format(monto)

        textView.text = "$montoFormateado" // O agrega moneda: "$ $montoFormateado"
    }

    fun mostrarMontoFormateado(monto: Int):String {
        val symbols = DecimalFormatSymbols().apply {
            groupingSeparator = '.' // Puedes usar ',' si quieres estilo inglés
        }
        val formatter = DecimalFormat("#,###", symbols)
        val montoFormateado = formatter.format(monto)

        return montoFormateado // O agrega moneda: "$ $montoFormateado"
    }
}