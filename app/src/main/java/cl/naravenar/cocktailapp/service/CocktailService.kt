package cl.naravenar.cocktailapp.service

import android.content.Context
import cl.naravenar.cocktailapp.model.CategoryModel
import cl.naravenar.cocktailapp.model.DrinkModel
import cl.naravenar.cocktailapp.repository.impl.CategoryRepositoryImpl
import cl.naravenar.cocktailapp.repository.impl.DrinkRepositoryImpl

class CocktailService(context: Context) {
    private var drinkRepositoryImpl : DrinkRepositoryImpl = DrinkRepositoryImpl(context);
    private var categoryRepositoryImpl : CategoryRepositoryImpl = CategoryRepositoryImpl(context);

    fun findDrinkByIdCategoria(idCategoria:Long): List<DrinkModel> {
        return drinkRepositoryImpl.findDrinkByIdCategoria(idCategoria)
    }

    fun getAllCategories(): MutableList<CategoryModel> {
        return categoryRepositoryImpl.getAllCategories()
    }

    fun getAllDrinks(): MutableList<DrinkModel> {
        return drinkRepositoryImpl.listCocktails()
    }

    fun findCategoriaByName(name:String): MutableList<CategoryModel> {
        return categoryRepositoryImpl.findCategoriaByName(name)
    }
}