package cl.naravenar.cocktailapp.utils

import cl.naravenar.cocktailapp.enums.SizePizza
import cl.naravenar.cocktailapp.model.DrinkModel
import cl.naravenar.cocktailapp.model.IngredientModel
import android.content.Context
import cl.naravenar.cocktailapp.R

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
}