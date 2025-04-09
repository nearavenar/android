package cl.naravenar.cocktailapp.repository.impl

import android.content.Context
import androidx.room.Room
import cl.naravenar.cocktailapp.config.StoreDatabase
import cl.naravenar.cocktailapp.model.IngredientModel
import cl.naravenar.cocktailapp.repository.IngredientRepository

class IngredientRepositoryImpl(context: Context):IngredientRepository {
    private var database = Room.databaseBuilder(context, StoreDatabase::class.java, "StoreDatabase")

    override fun createIngredient(ingredient: IngredientModel): Long {
        TODO("Not yet implemented")
    }

    override fun getAllIngredients(): MutableList<IngredientModel> {
        TODO("Not yet implemented")
    }

    override fun getIngredientByID(id: Long): IngredientModel {
        TODO("Not yet implemented")
    }


}