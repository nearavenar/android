package cl.naravenar.cocktailapp.repository.impl

import android.content.Context
import androidx.room.Room
import cl.naravenar.cocktailapp.R
import cl.naravenar.cocktailapp.config.StoreDatabase
import cl.naravenar.cocktailapp.model.CategoryModel
import cl.naravenar.cocktailapp.repository.CategoryRepository

class CategoryRepositoryImpl(context: Context) : CategoryRepository {

    private var context:Context = context
    private var database = Room.databaseBuilder(context, StoreDatabase::class.java, "StoreDatabase")

    override fun getAllCategories(): MutableList<CategoryModel> {
        //return this.database.build().categoryDao().getAllCategories()
        return getAllCategoriesXML()
    }

    fun getAllCategoriesXML(): MutableList<CategoryModel> {
        var categoriesList:MutableList<CategoryModel> = mutableListOf()
        categoriesList.add(CategoryModel(1, context.resources.getString(R.string.title_category_rum),true,"ic_while_run_category"))
        categoriesList.add(CategoryModel(2, context.resources.getString(R.string.title_category_vodka),true,"ic_vodka_category"))
        categoriesList.add(CategoryModel(3,context.resources.getString(R.string.title_category_ginebra),true,"ic_gin_category"))
        categoriesList.add(CategoryModel(4,context.resources.getString(R.string.title_category_pisco),true,"ic_pisco_category"))
        categoriesList.add(CategoryModel(5,context.resources.getString(R.string.title_category_whisky),true,"ic_wisky_category"))
        categoriesList.add(CategoryModel(6,context.resources.getString(R.string.title_category_tequila),true,"ic_tequila_category"))
        categoriesList.add(CategoryModel(7,context.resources.getString(R.string.title_category_aperol),true,"ic_aperol_category"))
        categoriesList.add(CategoryModel(8,context.resources.getString(R.string.title_category_ramazzotti),true,"ic_ramazzotti_category"))
        categoriesList.add(CategoryModel(9,context.resources.getString(R.string.title_category_cachaza),true,"ic_cachaza_category"))
        return categoriesList
    }

    override fun findCategoriaByNameXml(name:String): List<CategoryModel> {
        return getAllCategoriesXML().filter {
            it.getName().uppercase().contains(name.uppercase())
        }
    }

    override fun createCategory(category: CategoryModel): Long {
        return this.database.build().categoryDao().createCategory(category)
    }

    override fun getCategoryByID(id: Long): CategoryModel {
        return this.database.build().categoryDao().getCategoryById(id)
    }
}