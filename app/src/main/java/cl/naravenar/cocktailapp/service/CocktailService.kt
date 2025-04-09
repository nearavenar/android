package cl.naravenar.cocktailapp.service

import android.content.Context
import cl.naravenar.cocktailapp.model.CategoryModel
import cl.naravenar.cocktailapp.model.DrinkModel
import cl.naravenar.cocktailapp.repository.impl.CategoryRepositoryImpl
import cl.naravenar.cocktailapp.repository.impl.DrinkRepositoryImpl

class CocktailService(context: Context) {
    private var drinkRepositoryImpl : DrinkRepositoryImpl = DrinkRepositoryImpl(context);
    private var categoryRepositoryImpl : CategoryRepositoryImpl = CategoryRepositoryImpl(context);

    fun findDrinkByIdCategoria(idCategoria:Long): List<DrinkModel>{
        return drinkRepositoryImpl.findDrinksByIdCategoria(idCategoria)
    }

    fun findDrinkByIdCategoriaXml(idCategoria:Long): List<DrinkModel> {
        return drinkRepositoryImpl.findDrinkByIdCategoriaXml(idCategoria)
    }

    fun getCocktailById(id: Int): DrinkModel {
        return drinkRepositoryImpl.listCocktails()[0]
    }

    fun getAllCategories(): MutableList<CategoryModel> {
        return categoryRepositoryImpl.getAllCategories()
    }

    fun findCategoriaByNameXml(name:String): List<CategoryModel> {
        return categoryRepositoryImpl.findCategoriaByNameXml(name)
    }

    fun getCategoryById(id: Long): CategoryModel {
        return categoryRepositoryImpl.getCategoryByID(id)
    }

    fun createCategory(category: CategoryModel): Long {
        var result:Long = 0
        if (categoryRepositoryImpl.getCategoryByID(category.getId()) == null){
            result = categoryRepositoryImpl.createCategory(category)
        }
        return result
    }

    fun createDrink(drink: DrinkModel): Long {
        var result:Long = 0
        if (drinkRepositoryImpl.getDrinkByID(drink.getId()) == null){
            result = drinkRepositoryImpl.createDrink(drink)
        }
        return result
    }

    fun getAllDrinks(): MutableList<DrinkModel> {
        return drinkRepositoryImpl.listDrinks()
    }

    fun getAllDrinksXml(): MutableList<DrinkModel> {
        return drinkRepositoryImpl.listCocktails()
    }
}