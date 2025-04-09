package cl.naravenar.cocktailapp.repository

import cl.naravenar.cocktailapp.model.DrinkModel

interface DrinkRepository {
    fun createDrink(drink: DrinkModel): Long
    fun listCocktails():ArrayList<DrinkModel>
    fun getDrinkByID(id: Long): DrinkModel
    fun listDrinks():MutableList<DrinkModel>
}