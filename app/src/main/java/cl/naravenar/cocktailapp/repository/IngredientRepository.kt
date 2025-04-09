package cl.naravenar.cocktailapp.repository

import cl.naravenar.cocktailapp.model.IngredientModel

interface IngredientRepository {
    fun createIngredient(ingredient: IngredientModel): Long
    fun getAllIngredients():MutableList<IngredientModel>
    fun getIngredientByID(id: Long): IngredientModel
}