package cl.naravenar.cocktailapp.repository

import cl.naravenar.cocktailapp.model.DrinkModel
interface DrinkRepository {
    fun createDrink(drink : DrinkModel)
    fun listCocktails():MutableList<DrinkModel>
    fun findDrinkByIdCategoria(idCategoria:Long): List<DrinkModel>
}