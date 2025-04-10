package cl.naravenar.cocktailapp.repository.impl

import android.content.Context
import cl.naravenar.cocktailapp.model.IngredientModel
import cl.naravenar.cocktailapp.repository.IngredientRepository

class IngredientRepositoryImpl(context: Context):IngredientRepository {

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