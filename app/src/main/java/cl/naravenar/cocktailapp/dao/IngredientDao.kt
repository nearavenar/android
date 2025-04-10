package cl.naravenar.cocktailapp.dao

import cl.naravenar.cocktailapp.model.IngredientModel

//@Dao
interface IngredientDao {
    //@Insert
    fun createIngredient(ingredient: IngredientModel): Long

    //@Query("SELECT * FROM ingredient where id = :id")
    fun getIngredientById(id: Long): IngredientModel

    //@Update
    fun updateIngredient(ingredient: IngredientModel)

    //@Delete
    fun deleteIngredient(ingredient: IngredientModel)

    //@Query("SELECT * FROM ingredient")
    fun getAll() : MutableList<IngredientModel>
}