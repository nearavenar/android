package cl.naravenar.cocktailapp.repository

import cl.naravenar.cocktailapp.model.CategoryModel
import cl.naravenar.cocktailapp.model.DrinkModel

interface CategoryRepository {
    fun createCategory(category :CategoryModel)
    fun getAllCategories():MutableList<CategoryModel>
    fun findCategoryByName(name:String): MutableList<CategoryModel>
    fun findCategoryById(idCategory:Long): CategoryModel
}