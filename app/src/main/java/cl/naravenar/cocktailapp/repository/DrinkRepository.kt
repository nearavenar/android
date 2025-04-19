package cl.naravenar.cocktailapp.repository

import cl.naravenar.cocktailapp.model.DrinkModel
interface DrinkRepository {
    fun createDrink(drink : DrinkModel)
    fun listCocktails():MutableList<DrinkModel>
    fun findDrinkByIdCategoria(idCategoria:Long): MutableList<DrinkModel>
    fun findDrinkByName(name:String): MutableList<DrinkModel>
}