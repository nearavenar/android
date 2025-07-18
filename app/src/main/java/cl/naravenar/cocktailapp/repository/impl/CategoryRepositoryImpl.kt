package cl.naravenar.cocktailapp.repository.impl

import android.content.Context
import cl.naravenar.cocktailapp.R
import cl.naravenar.cocktailapp.model.CategoryModel
import cl.naravenar.cocktailapp.repository.CategoryRepository

class CategoryRepositoryImpl(context: Context) : CategoryRepository {

    private var context :Context = context
    private var category :MutableList<CategoryModel> = mutableListOf()

    override fun createCategory(drink: CategoryModel) {
        category.add(drink)
    }

    override fun getAllCategories(): MutableList<CategoryModel> {
        return getAllCategoriesDam()
    }

    override fun findCategoryByName(name:String): MutableList<CategoryModel> {
        return category.filter {
            it.getName().uppercase().contains(name.uppercase())
        }.toMutableList()
    }

    override fun findCategoryById(idCategory:Long):CategoryModel {
        return category.first() {
            it.getId() == idCategory
        }
    }

    fun getAllCategoriesDam(): MutableList<CategoryModel> {
        createCategory(CategoryModel(1, context.resources.getString(R.string.title_category_rum),true,"ic_while_run_category"))
        createCategory(CategoryModel(2, context.resources.getString(R.string.title_category_vodka),true,"ic_vodka_category"))
        createCategory(CategoryModel(3,context.resources.getString(R.string.title_category_ginebra),true,"ic_gin_category"))
        createCategory(CategoryModel(4,context.resources.getString(R.string.title_category_pisco),true,"ic_pisco_category"))
        createCategory(CategoryModel(5,context.resources.getString(R.string.title_category_whisky),true,"ic_wisky_category"))
        createCategory(CategoryModel(6,context.resources.getString(R.string.title_category_tequila),true,"ic_tequila_category"))
        createCategory(CategoryModel(7,context.resources.getString(R.string.title_category_aperol),true,"ic_aperol_category"))
        createCategory(CategoryModel(8,context.resources.getString(R.string.title_category_ramazzotti),true,"ic_ramazzotti_category"))
        createCategory(CategoryModel(9,context.resources.getString(R.string.title_category_cachaza),true,"ic_cachaza_category"))
        createCategory(CategoryModel(10,context.resources.getString(R.string.title_category_Other),true,"ic_other_category"))
        return category
    }
}