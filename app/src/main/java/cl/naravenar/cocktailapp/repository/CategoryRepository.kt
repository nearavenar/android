package cl.naravenar.cocktailapp.repository

import cl.naravenar.cocktailapp.model.CategoryModel

interface CategoryRepository {
    fun createCategory(category: CategoryModel): Long
    fun getAllCategories():MutableList<CategoryModel>
    fun getCategoryByID(id: Long): CategoryModel
    fun findCategoriaByNameXml(name:String): List<CategoryModel>
}