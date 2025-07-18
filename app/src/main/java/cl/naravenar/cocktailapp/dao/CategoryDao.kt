package cl.naravenar.cocktailapp.dao

import cl.naravenar.cocktailapp.model.CategoryModel

interface CategoryDao {
    //@Query("SELECT * FROM category")
    fun getAllCategories() : MutableList<CategoryModel>

    //@Query("SELECT * FROM category where id = :id")
    fun getCategoryById(id: Long): CategoryModel

    //@Insert
    fun createCategory(category: CategoryModel): Long

    //@Update
    fun updateCategory(category: CategoryModel)

    //@Delete
    fun deleteCategory(category: CategoryModel)
}