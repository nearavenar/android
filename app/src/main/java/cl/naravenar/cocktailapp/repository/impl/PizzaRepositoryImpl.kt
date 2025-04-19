package cl.naravenar.cocktailapp.repository.impl

import android.content.Context
import cl.naravenar.cocktailapp.R
import cl.naravenar.cocktailapp.enums.IngredientPizza
import cl.naravenar.cocktailapp.enums.SizePizza
import cl.naravenar.cocktailapp.enums.UnitMeasPizza
import cl.naravenar.cocktailapp.model.IngredientModel
import cl.naravenar.cocktailapp.model.PizzaModel
import cl.naravenar.cocktailapp.model.SizeModel
import cl.naravenar.cocktailapp.model.UnitMeasurementModel
import cl.naravenar.cocktailapp.repository.PizzaRepository

class PizzaRepositoryImpl(context: Context) :PizzaRepository {

    private var context : Context = context
    private var pizzas :MutableList<PizzaModel> = mutableListOf()

    override fun createPizza(pizza: PizzaModel) {
        pizzas.add(pizza)
    }

    override fun listPizzas(): MutableList<PizzaModel> {
        return getAllCategoriesDam()
    }

    override fun findPizzaByName(name: String): MutableList<PizzaModel> {
        return pizzas.filter {
            it.getName().uppercase().contains(name.uppercase())
        }.toMutableList()
    }

    fun getAllCategoriesDam(): MutableList<PizzaModel> {
        pizzas.add(createMargaritaPizza())
        pizzas.add(CreateNicoPizza())
        return pizzas
    }

    private fun createMargaritaPizza(): PizzaModel {

        var unitMeasMl = UnitMeasurementModel(1, UnitMeasPizza.ML.getMessage(context))
        var unitMeasGr = UnitMeasurementModel(2, UnitMeasPizza.GR.getMessage(context))

        var ingredients = listOf(
            IngredientModel(1, IngredientPizza.TOMATO_SAUCE.getMessage(context), "30",unitMeasMl),
            IngredientModel(2, IngredientPizza.MOZZARELLA_CHEESE.getMessage(context),"30",unitMeasGr),
            IngredientModel(3, IngredientPizza.BASIL.getMessage(context),"10",unitMeasGr),
            IngredientModel(4, IngredientPizza.OLIVE_OIL.getMessage(context),"20",unitMeasMl),
        )

        var sizeModel = SizeModel()
        sizeModel.setId(2)
        sizeModel = SizePizza.XL.getSize(context)

        var margaritaPizza = PizzaModel()
        margaritaPizza.setId(1)
        margaritaPizza.setName(context.resources.getString(R.string.pizza_name_margarita))
        margaritaPizza.setImage("ic_margarita_pizza")
        margaritaPizza.setPreparation(context.resources.getString(R.string.pizza_preparation_margarita))
        margaritaPizza.setDescription(context.resources.getString(R.string.pizza_description_margarita))
        margaritaPizza.setSize(sizeModel)
        margaritaPizza.setIngredients(ingredients)
        margaritaPizza.setQuantity(1)
        return margaritaPizza
    }

    private fun CreateNicoPizza(): PizzaModel {
        var unitMeasMl = UnitMeasurementModel(1, UnitMeasPizza.ML.getMessage(context))
        var unitMeasGr = UnitMeasurementModel(2, UnitMeasPizza.GR.getMessage(context))
        var unitMeasDust = UnitMeasurementModel(3, UnitMeasPizza.DUST.getMessage(context))

        var ingredients = listOf(
            IngredientModel(1, IngredientPizza.STRONG_FLOUR.getMessage(context), "320",unitMeasGr),
            IngredientModel(2, IngredientPizza.CORN_FLOUR.getMessage(context), "60",unitMeasGr),
            IngredientModel(3, IngredientPizza.BAKING_POWDER.getMessage(context), "3",unitMeasGr),
            IngredientModel(4, IngredientPizza.GARLIC_POWDER.getMessage(context),"3",unitMeasGr),
            IngredientModel(5, IngredientPizza.ONION_POWDER.getMessage(context),"3",unitMeasGr),
            IngredientModel(6, IngredientPizza.SUGAR.getMessage(context),"5",unitMeasGr),
            IngredientModel(7, IngredientPizza.SALT.getMessage(context),"5",unitMeasGr),
            IngredientModel(8, IngredientPizza.WATER.getMessage(context),"235",unitMeasMl),
            IngredientModel(9, IngredientPizza.YEAST.getMessage(context),"20",unitMeasGr),
            IngredientModel(10, IngredientPizza.OLIVE_OIL.getMessage(context),"30",unitMeasMl),
            IngredientModel(11, IngredientPizza.SEMOLINA.getMessage(context),"0",unitMeasDust),
        )

        var sizeModel = SizeModel()
        sizeModel.setId(1)
        sizeModel = SizePizza.FAMILIAR.getSize(context)

        var nicoPizza = PizzaModel()
        nicoPizza.setId(1)
        nicoPizza.setName(context.resources.getString(R.string.pizza_name_nico))
        nicoPizza.setImage("ic_nico_pizza")
        nicoPizza.setPreparation(context.resources.getString(R.string.pizza_preparation_nico))
        nicoPizza.setDescription(context.resources.getString(R.string.pizza_description_nico))
        nicoPizza.setSize(sizeModel)
        nicoPizza.setIngredients(ingredients)
        nicoPizza.setQuantity(2)

        return nicoPizza
    }
}