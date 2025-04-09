package cl.naravenar.cocktailapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import cl.naravenar.cocktailapp.model.IngredientModel

@Dao
interface IngredientDao {
    @Insert
    fun createIngredient(ingredient: IngredientModel): Long

    @Query("SELECT * FROM ingredient where id = :id")
    fun getIngredientById(id: Long): IngredientModel

    @Update
    fun updateIngredient(ingredient: IngredientModel)

    @Delete
    fun deleteIngredient(ingredient: IngredientModel)

    @Query("SELECT * FROM ingredient")
    fun getAll() : MutableList<IngredientModel>
}