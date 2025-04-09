package cl.naravenar.cocktailapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import cl.naravenar.cocktailapp.model.DrinkModel

@Dao
interface DrinkDao {
    @Insert
    fun createDrink(drink: DrinkModel): Long

    @Query("SELECT * FROM drink where id = :id")
    fun getDrinkById(id: Long): DrinkModel

    @Query("SELECT * FROM drink where category = :id")
    fun getDrinkByIdCategory(id: Long): List<DrinkModel>

    @Update
    fun updateDrink(drink: DrinkModel)

    @Delete
    fun deleteDrink(drink: DrinkModel)

    @Query("SELECT * FROM drink")
    fun getAll() : MutableList<DrinkModel>
}