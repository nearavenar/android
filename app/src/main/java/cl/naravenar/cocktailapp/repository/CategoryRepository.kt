package cl.naravenar.cocktailapp.repository

import cl.naravenar.cocktailapp.model.CategoryModel
import cl.naravenar.cocktailapp.model.DrinkModel

interface CategoryRepository {
    fun createCategory(category :CategoryModel)
    fun getAllCategories():MutableList<CategoryModel>
    fun findCategoriaByName(name:String): MutableList<CategoryModel>
}