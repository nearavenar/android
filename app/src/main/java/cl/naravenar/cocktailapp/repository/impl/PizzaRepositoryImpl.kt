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
import cl.naravenar.cocktailapp.shared.PizzaStorage

class PizzaRepositoryImpl(context: Context) :PizzaRepository {

    private var context : Context = context
    private var pizzas :MutableList<PizzaModel> = mutableListOf()

    override fun createPizza(pizza: PizzaModel) {
        pizzas.add(pizza)
    }

    override fun listPizzas(): MutableList<PizzaModel> {
        return getAllPizzas()
    }

    override fun findPizzaByName(name: String): MutableList<PizzaModel> {
        return pizzas.filter {
            it.getName().uppercase().contains(name.uppercase())
        }.toMutableList()
    }

    fun getAllPizzas(): MutableList<PizzaModel> {
        if (PizzaStorage.loadPizzaList(context).size != 0){
            pizzas = PizzaStorage.loadPizzaList(context)
        }else {
            pizzas.add(createMargaritaPizza())
            pizzas.add(CreateNicoPizza())
            pizzas.add(CreateItalianPizza())
            pizzas.add(CreateNicoDough())
            pizzas.add(CreateBasicDough())
            pizzas.add(CreateNeapolitanDough())
            PizzaStorage.savePizzaList(context, pizzas)
        }
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

        var pizza = PizzaModel()
        pizza.setId(1)
        pizza.setName(context.resources.getString(R.string.pizza_name_margarita))
        pizza.setImage("ic_margarita_pizza")
        pizza.setPreparation(context.resources.getString(R.string.pizza_preparation_margarita))
        pizza.setDescription(context.resources.getString(R.string.pizza_description_margarita))
        pizza.setSize(sizeModel)
        pizza.setIngredients(ingredients)
        pizza.setQuantity(1)
        return pizza
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

        var pizza = PizzaModel()
        pizza.setId(2)
        pizza.setName(context.resources.getString(R.string.pizza_name_nico))
        pizza.setImage("ic_nico_pizza")
        pizza.setPreparation(context.resources.getString(R.string.pizza_preparation_nico))
        pizza.setDescription(context.resources.getString(R.string.pizza_description_nico))
        pizza.setSize(sizeModel)
        pizza.setIngredients(ingredients)
        pizza.setQuantity(2)
        return pizza
    }

    private fun CreateItalianPizza(): PizzaModel {

        var unitMeasMl = UnitMeasurementModel(1, UnitMeasPizza.ML.getMessage(context))
        var unitMeasGr = UnitMeasurementModel(2, UnitMeasPizza.GR.getMessage(context))
        var unitMeasCu = UnitMeasurementModel(3, UnitMeasPizza.CU.getMessage(context))

        var ingredients = listOf(
            IngredientModel(1, IngredientPizza.TOMATO_SAUCE.getMessage(context), "270",unitMeasGr),
            IngredientModel(3, IngredientPizza.OREGANO.getMessage(context),"10",unitMeasGr),
            IngredientModel(2, IngredientPizza.MOZZARELLA_CHEESE.getMessage(context),"250",unitMeasGr),
            IngredientModel(4, IngredientPizza.SERRANO_HAM.getMessage(context),"20",unitMeasMl),
            IngredientModel(5, IngredientPizza.ARUGULA.getMessage(context),"5",unitMeasCu),
            IngredientModel(6, IngredientPizza.PARMESAN_CHEESE.getMessage(context),"200",unitMeasGr),
        )

        var sizeModel = SizeModel()
        sizeModel.setId(3)
        sizeModel = SizePizza.XL.getSize(context)

        var pizza = PizzaModel()
        pizza.setId(3)
        pizza.setName(context.resources.getString(R.string.pizza_name_italian))
        pizza.setImage("ic_italian_pizza")
        pizza.setPreparation(context.resources.getString(R.string.pizza_preparation_italian))
        pizza.setDescription(context.resources.getString(R.string.pizza_description_italian))
        pizza.setSize(sizeModel)
        pizza.setIngredients(ingredients)
        pizza.setQuantity(1)
        return pizza
    }

    private fun CreateNicoDough(): PizzaModel {
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
        sizeModel.setId(4)
        sizeModel = SizePizza.MEDIAN.getSize(context)

        var pizza = PizzaModel()
        pizza.setId(4)
        pizza.setName(context.resources.getString(R.string.pizza_name_dough_pizza))
        pizza.setImage("ic_nicolas_pizza_dough")
        pizza.setPreparation(context.resources.getString(R.string.pizza_preparation_dough_pizza))
        pizza.setDescription(context.resources.getString(R.string.pizza_description_dough_pizza))
        pizza.setSize(sizeModel)
        pizza.setIngredients(ingredients)
        pizza.setQuantity(3)
        return pizza
    }

    private fun CreateBasicDough(): PizzaModel {
        var unitMeasMl = UnitMeasurementModel(1, UnitMeasPizza.ML.getMessage(context))
        var unitMeasGr = UnitMeasurementModel(2, UnitMeasPizza.GR.getMessage(context))
        var unitMeasDust = UnitMeasurementModel(3, UnitMeasPizza.DUST.getMessage(context))

        var ingredients = listOf(
            IngredientModel(1, IngredientPizza.STRONG_FLOUR.getMessage(context), "603",unitMeasGr),
            IngredientModel(2, IngredientPizza.SALT.getMessage(context),"12",unitMeasGr),
            IngredientModel(3, IngredientPizza.WATER.getMessage(context),"37",unitMeasMl),
            IngredientModel(4, IngredientPizza.YEAST.getMessage(context),"6",unitMeasGr),
            IngredientModel(5, IngredientPizza.OLIVE_OIL.getMessage(context),"6",unitMeasMl),
            IngredientModel(6, IngredientPizza.SEMOLINA.getMessage(context),"0",unitMeasDust),
        )

        var sizeModel = SizeModel()
        sizeModel.setId(4)
        sizeModel = SizePizza.MEDIAN.getSize(context)

        var pizza = PizzaModel()
        pizza.setId(5)
        pizza.setName(context.resources.getString(R.string.pizza_name_dough_basic_pizza))
        pizza.setImage("ic_dough_pizza")
        pizza.setPreparation(context.resources.getString(R.string.pizza_preparation_dough_basic_pizza))
        pizza.setDescription(context.resources.getString(R.string.pizza_description_dough_basic_pizza))
        pizza.setSize(sizeModel)
        pizza.setIngredients(ingredients)
        pizza.setQuantity(3)
        return pizza
    }

    private fun CreateNeapolitanDough(): PizzaModel {
        var unitMeasMl = UnitMeasurementModel(1, UnitMeasPizza.ML.getMessage(context))
        var unitMeasGr = UnitMeasurementModel(2, UnitMeasPizza.GR.getMessage(context))
        var unitMeasDust = UnitMeasurementModel(3, UnitMeasPizza.DUST.getMessage(context))
        var unitMeasGreaseDough = UnitMeasurementModel(3, UnitMeasPizza.GREASE_DOUGH.getMessage(context))

        var ingredients = listOf(
            IngredientModel(1, IngredientPizza.STRONG_FLOUR.getMessage(context), "571",unitMeasGr),
            IngredientModel(2, IngredientPizza.SALT.getMessage(context),"17.1",unitMeasGr),
            IngredientModel(3, IngredientPizza.WATER.getMessage(context),"400",unitMeasMl),
            IngredientModel(4, IngredientPizza.YEAST.getMessage(context),"11.4",unitMeasGr),
            IngredientModel(5, IngredientPizza.OLIVE_OIL.getMessage(context),"0",unitMeasGreaseDough),
            IngredientModel(6, IngredientPizza.SEMOLINA.getMessage(context),"0",unitMeasDust),
        )

        var sizeModel = SizeModel()
        sizeModel.setId(4)
        sizeModel = SizePizza.MEDIAN.getSize(context)

        var pizza = PizzaModel()
        pizza.setId(6)
        pizza.setName(context.resources.getString(R.string.pizza_name_dough_napolitan_pizza))
        pizza.setImage("ic_napolitan_pizza_dough")
        pizza.setPreparation(context.resources.getString(R.string.pizza_preparation_dough_napolitan_pizza))
        pizza.setDescription(context.resources.getString(R.string.pizza_description_dough_napolitan_pizza))
        pizza.setSize(sizeModel)
        pizza.setIngredients(ingredients)
        pizza.setQuantity(3)
        return pizza
    }
}