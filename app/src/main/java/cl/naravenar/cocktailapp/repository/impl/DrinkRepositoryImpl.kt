package cl.naravenar.cocktailapp.repository.impl

import android.content.Context
import cl.naravenar.cocktailapp.R
import cl.naravenar.cocktailapp.enums.IngredientDrink
import cl.naravenar.cocktailapp.enums.UnitMeasDrink
import cl.naravenar.cocktailapp.model.CategoryModel
import cl.naravenar.cocktailapp.model.DrinkModel
import cl.naravenar.cocktailapp.model.IngredientModel
import cl.naravenar.cocktailapp.model.UnitMeasurementModel
import cl.naravenar.cocktailapp.repository.DrinkRepository

class DrinkRepositoryImpl(context: Context) : DrinkRepository {

    private val drinks: MutableList<DrinkModel> = ArrayList()
    private var context:Context = context

    override fun createDrink(drink: DrinkModel) {
        drinks.add(drink)
    }
    override fun findDrinkByIdCategoria(idCategoria:Long): List<DrinkModel> {
        listCocktails()
        return drinks.filter {
            it.getCategory().getId() == idCategoria
        }
    }
    override fun listCocktails(): MutableList<DrinkModel> {
        return listCocktailsDam()
    }

    fun listCocktailsDam(): MutableList<DrinkModel>{
        drinks.clear()
        createDrink(createClassicMojito())
        createDrink(createMaracuyaMojito())
        createDrink(createDaiquiri())
        createDrink(createStrawberryDaiquiri())
        createDrink(createPinaColada())
        createDrink(createCosmopolitan())
        createDrink(createMoscowMuleRussia())
        createDrink(createMartiniExpreso())
        createDrink(createClassicTomCollins())
        createDrink(createGinTonic())
        createDrink(createSunriseTequila())
        createDrink(createMargaritaTequila())
        createDrink(createOldFashioned())
        createDrink(rustyClove())
        createDrink(manhattan())
        createDrink(irishCoffee())
        return drinks
    }

    private fun createClassicMojito():DrinkModel{

        var categoryRum = CategoryModel(1, context.resources.getString(R.string.title_category_rum),true,"ic_while_run_category")

        var unitMeasSheet = UnitMeasurementModel(1,UnitMeasDrink.LEAVES.getMessage(context))
        var unitMeasOz = UnitMeasurementModel(2,UnitMeasDrink.OZ.getMessage(context))
        var unitMeasFrappe = UnitMeasurementModel(3,UnitMeasDrink.FRAPPE.getMessage(context))
        var unitMeasToCrown = UnitMeasurementModel(4,UnitMeasDrink.TO_CROWN.getMessage(context))

        var ingredients = listOf(IngredientModel(1, IngredientDrink.MINT.getMessage(context), "5",unitMeasSheet),
            IngredientModel(2,IngredientDrink.ERASER.getMessage(context),"1",unitMeasOz),
            IngredientModel(3,IngredientDrink.LEMON_JUICE.getMessage(context),"1",unitMeasOz),
            IngredientModel(4,IngredientDrink.FRAPPE_ICE.getMessage(context),"3/4",unitMeasFrappe),
            IngredientModel(5,IngredientDrink.WHITE_RUM.getMessage(context),"2",unitMeasOz),
            IngredientModel(6,IngredientDrink.MINERAL_WATER.getMessage(context),"0",unitMeasToCrown))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(context.resources.getString(R.string.drink_name_mojito))
        drinkModelMojito.setImage("ic_mojito_drink")
        drinkModelMojito.setPreparation(context.resources.getString(R.string.drink_preparation_mojito))
        drinkModelMojito.setDescription(context.resources.getString(R.string.drink_description_mojito))
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }

    private fun createMaracuyaMojito():DrinkModel{

        var categoryRum = CategoryModel(1, context.resources.getString(R.string.title_category_rum),true,"ic_while_run_category")

        var unitMeasSheet = UnitMeasurementModel(1,UnitMeasDrink.LEAVES.getMessage(context))
        var unitMeasOz = UnitMeasurementModel(2,UnitMeasDrink.OZ.getMessage(context))
        var unitMeasFrappe = UnitMeasurementModel(3,UnitMeasDrink.FRAPPE.getMessage(context))
        var unitMeasToCrown = UnitMeasurementModel(4,UnitMeasDrink.TO_CROWN.getMessage(context))

        var ingredients = listOf(IngredientModel(1,IngredientDrink.MINT.getMessage(context), "5",unitMeasSheet),
            IngredientModel(2,IngredientDrink.ERASER.getMessage(context),"1",unitMeasOz),
            IngredientModel(3,IngredientDrink.LEMON_JUICE.getMessage(context),"1",unitMeasOz),
            IngredientModel(4,IngredientDrink.FRAPPE_ICE.getMessage(context),"3/4",unitMeasFrappe),
            IngredientModel(5,IngredientDrink.WHITE_RUM.getMessage(context),"2",unitMeasOz),
            IngredientModel(6,IngredientDrink.MARACUYA_PULP.getMessage(context),"2",unitMeasOz),
            IngredientModel(7,IngredientDrink.MINERAL_WATER.getMessage(context),"0",unitMeasToCrown))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(context.resources.getString(R.string.drink_name_maracuya_mojito))
        drinkModelMojito.setImage("ic_mojito_drink")
        drinkModelMojito.setPreparation(context.resources.getString(R.string.drink_preparation_maracuya_mojito))
        drinkModelMojito.setDescription(context.resources.getString(R.string.drink_description_maracuya_mojito))
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }

    private fun createDaiquiri():DrinkModel{

        var categoryRum = CategoryModel(1, context.resources.getString(R.string.title_category_rum),true,"ic_while_run_category")

        var unitMeasOz = UnitMeasurementModel(2,UnitMeasDrink.OZ.getMessage(context))
        var unitMeasCube = UnitMeasurementModel(4,UnitMeasDrink.CUBE.getMessage(context))
        var unitMeasToDash = UnitMeasurementModel(4,UnitMeasDrink.TO_CROWN.getMessage(context))

        var ingredients = listOf(IngredientModel(1,IngredientDrink.ERASER.getMessage(context),"1",unitMeasOz),
            IngredientModel(2,IngredientDrink.LEMON_JUICE.getMessage(context),"1",unitMeasOz),
            IngredientModel(3,IngredientDrink.WHITE_RUM.getMessage(context),"2",unitMeasOz),
            IngredientModel(4,IngredientDrink.ICE_CUBE.getMessage(context),"2",unitMeasCube),
            IngredientModel(5,IngredientDrink.TRIPLE_SEX.getMessage(context),"1",unitMeasToDash))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(context.resources.getString(R.string.drink_name_daiquiri))
        drinkModelMojito.setImage("ic_daiquiri_drink")
        drinkModelMojito.setPreparation(context.resources.getString(R.string.drink_preparation_daiquiri))
        drinkModelMojito.setDescription(context.resources.getString(R.string.drink_description_daiquiri))
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }

    private fun createStrawberryDaiquiri ():DrinkModel{

        var categoryRum = CategoryModel(1, context.resources.getString(R.string.title_category_rum),true,"ic_while_run_category")

        var unitMeasOz = UnitMeasurementModel(1,UnitMeasDrink.OZ.getMessage(context))
        var unitMeasCube = UnitMeasurementModel(2,UnitMeasDrink.CUBE.getMessage(context))
        var unitMeasToDash = UnitMeasurementModel(3,UnitMeasDrink.DASH.getMessage(context))
        var unitMeasLeaves = UnitMeasurementModel(4,UnitMeasDrink.LEAVES.getMessage(context))


        //var ingedients = context.resources.getString(R.string.drink_ingredients_mojito).split("\n")
        var ingredients = listOf(IngredientModel(1,IngredientDrink.ERASER.getMessage(context),"1",unitMeasOz),
            IngredientModel(2,IngredientDrink.LEMON.getMessage(context),"1",unitMeasOz),
            IngredientModel(3,IngredientDrink.WHITE_RUM.getMessage(context),"2",unitMeasOz),
            IngredientModel(4,IngredientDrink.TRIPLE_SEX.getMessage(context),"1",unitMeasToDash),
            IngredientModel(5,IngredientDrink.ICE_CUBE.getMessage(context),"2",unitMeasCube),
            IngredientModel(6,IngredientDrink.BASIL_LEAF.getMessage(context),"2",unitMeasLeaves))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(context.resources.getString(R.string.drink_name_strawberry_daiquiri))
        drinkModelMojito.setImage("ic_daiquiri_drink")
        drinkModelMojito.setPreparation(context.resources.getString(R.string.drink_preparation_strawberry_daiquiri))
        drinkModelMojito.setDescription(context.resources.getString(R.string.drink_description_strawberry_daiquiri))
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }

    private fun createPinaColada():DrinkModel{
        var categoryRum = CategoryModel(1, context.resources.getString(R.string.title_category_rum),true,"ic_while_run_category")

        var unitMeasOz = UnitMeasurementModel(1,UnitMeasDrink.OZ.getMessage(context))
        var unitMeasFrappe = UnitMeasurementModel(2,UnitMeasDrink.CUBE.getMessage(context))
        var unitMeasLeaves = UnitMeasurementModel(3,UnitMeasDrink.LEAVES.getMessage(context))

        var ingredients = listOf(IngredientModel(1,IngredientDrink.PINEAPPLE_PULP.getMessage(context),"2",unitMeasOz),
            IngredientModel(2,IngredientDrink.COCONUT_CREAM.getMessage(context),"2",unitMeasOz),
            IngredientModel(3,IngredientDrink.WHITE_OR_GOLDEN_RUM.getMessage(context),"2",unitMeasOz),
            IngredientModel(3,IngredientDrink.ERASER.getMessage(context),"1",unitMeasOz),
            IngredientModel(6,IngredientDrink.MISAMPLAS.getMessage(context),"1",unitMeasLeaves),
            IngredientModel(5,IngredientDrink.FRAPPE_ICE.getMessage(context),"2/4",unitMeasFrappe))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(context.resources.getString(R.string.drink_name_pina_colada))
        drinkModelMojito.setImage("ic_pina_colada_drink")
        drinkModelMojito.setPreparation(context.resources.getString(R.string.drink_preparation_pina_colada))
        drinkModelMojito.setDescription(context.resources.getString(R.string.drink_description_pina_colada))
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }

    private fun createCosmopolitan():DrinkModel{

        var categoryRum = CategoryModel(2, context.resources.getString(R.string.title_category_vodka),true,"ic_vodka_category")

        var unitMeasGr = UnitMeasurementModel(1,UnitMeasDrink.GR.getMessage(context))
        var unitMeasOz = UnitMeasurementModel(2,UnitMeasDrink.OZ.getMessage(context))
        var unitMeasCubo = UnitMeasurementModel(3,UnitMeasDrink.CUBE.getMessage(context))
        var unitMeasDash = UnitMeasurementModel(4,UnitMeasDrink.DASH.getMessage(context))


        var ingredients = listOf(IngredientModel(1,IngredientDrink.BLUEBERRY.getMessage(context), "40",unitMeasGr),
            IngredientModel(2,IngredientDrink.LEMON_JUICE.getMessage(context),"1",unitMeasDash),
            IngredientModel(3,IngredientDrink.TRIPLE_SEX.getMessage(context),"1",unitMeasDash),
            IngredientModel(2,IngredientDrink.VODKA.getMessage(context),"2",unitMeasOz),
            IngredientModel(4,IngredientDrink.ICE_CUBE.getMessage(context),"3",unitMeasCubo))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(context.resources.getString(R.string.drink_name_cosmopolitan))
        drinkModelMojito.setImage("ic_cosmopolitan_drink")
        drinkModelMojito.setPreparation(context.resources.getString(R.string.drink_preparation_cosmopolitan))
        drinkModelMojito.setDescription(context.resources.getString(R.string.drink_description_cosmopolitan))
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }

    private fun createMoscowMuleRussia():DrinkModel{

        var categoryRum = CategoryModel(2, context.resources.getString(R.string.title_category_vodka),true,"ic_vodka_category")

        var unitMeasWedges= UnitMeasurementModel(1,UnitMeasDrink.WEDGES.getMessage(context))
        var unitMeasFrappe = UnitMeasurementModel(2,UnitMeasDrink.FRAPPE.getMessage(context))
        var unitMeasOz = UnitMeasurementModel(3,UnitMeasDrink.OZ.getMessage(context))
        var unitMeasToCrown = UnitMeasurementModel(4,UnitMeasDrink.TO_CROWN.getMessage(context))


        var ingredients = listOf(IngredientModel(1,IngredientDrink.LEMON.getMessage(context), "2",unitMeasWedges),
            IngredientModel(2,IngredientDrink.FRAPPE_ICE.getMessage(context),"3/4",unitMeasFrappe),
            IngredientModel(3,IngredientDrink.VODKA.getMessage(context),"2",unitMeasOz),
            IngredientModel(4,IngredientDrink.GINGER_BEER.getMessage(context),"0",unitMeasToCrown))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(context.resources.getString(R.string.drink_name_moscow_mule_rusia))
        drinkModelMojito.setImage("ic_mojito_drink")
        drinkModelMojito.setPreparation(context.resources.getString(R.string.drink_preparation_moscow_mule_rusia))
        drinkModelMojito.setDescription(context.resources.getString(R.string.drink_description_moscow_mule_rusia))
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }

    private fun createMartiniExpreso():DrinkModel{

        var categoryRum = CategoryModel(2, context.resources.getString(R.string.title_category_vodka),true,"ic_vodka_category")

        var unitMeasOz = UnitMeasurementModel(1,UnitMeasDrink.OZ.getMessage(context))
        var unitMeasCube = UnitMeasurementModel(2,UnitMeasDrink.CUBE.getMessage(context))
        var unitMeasGrain = UnitMeasurementModel(3,UnitMeasDrink.GRAIN.getMessage(context))

        var ingredients = listOf(IngredientModel(1,IngredientDrink.COFFEE_LIQUOR.getMessage(context), "1 1/2",unitMeasOz),
            IngredientModel(2,IngredientDrink.ERASER.getMessage(context),"1 1/2",unitMeasOz),
            IngredientModel(3,IngredientDrink.COFFEE_EXPRESS.getMessage(context),"1",unitMeasOz),
            IngredientModel(4,IngredientDrink.VODKA.getMessage(context),"1 1/2",unitMeasOz),
            IngredientModel(5,IngredientDrink.ICE_CUBE.getMessage(context),"3-4",unitMeasCube),
            IngredientModel(6,IngredientDrink.COFFEE_GRAIN.getMessage(context),"2-3",unitMeasGrain))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(context.resources.getString(R.string.drink_name_express_martini))
        drinkModelMojito.setImage("ic_expresso_martini_drink")
        drinkModelMojito.setPreparation(context.resources.getString(R.string.drink_preparation_express_martini))
        drinkModelMojito.setDescription(context.resources.getString(R.string.drink_description_express_martini))
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }

    private fun createClassicTomCollins():DrinkModel{

        var categoryRum = CategoryModel(3, context.resources.getString(R.string.title_category_vodka),true,"ic_gin_category")

        var unitMeasOz = UnitMeasurementModel(1,UnitMeasDrink.OZ.getMessage(context))
        var unitMeasCube = UnitMeasurementModel(2,UnitMeasDrink.CUBE.getMessage(context))
        var unitMeasToCrown= UnitMeasurementModel(3,UnitMeasDrink.TO_CROWN.getMessage(context))

        var ingredients = listOf(IngredientModel(1,IngredientDrink.ERASER.getMessage(context), "1",unitMeasOz),
            IngredientModel(2,IngredientDrink.LEMON_JUICE.getMessage(context),"1",unitMeasOz),
            IngredientModel(3,IngredientDrink.GENEVA.getMessage(context),"2",unitMeasOz),
            IngredientModel(4,IngredientDrink.ICE_CUBE.getMessage(context),"3/4",unitMeasCube),
            IngredientModel(6,IngredientDrink.TONIC_WATER.getMessage(context),"0",unitMeasToCrown))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(context.resources.getString(R.string.drink_name_tom_collins))
        drinkModelMojito.setImage("ic_tom_collins_drink")
        drinkModelMojito.setPreparation(context.resources.getString(R.string.drink_preparation_tom_collins))
        drinkModelMojito.setDescription(context.resources.getString(R.string.drink_description_tom_collins))
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }

    private fun createGinTonic():DrinkModel{

        var categoryRum = CategoryModel(3, context.resources.getString(R.string.title_category_vodka),true,"ic_cachaza_category")

        var unitMeasOz = UnitMeasurementModel(1,UnitMeasDrink.OZ.getMessage(context))
        var unitMeasCube = UnitMeasurementModel(2,UnitMeasDrink.CUBE.getMessage(context))
        var unitMeasToCrown = UnitMeasurementModel(3,UnitMeasDrink.TO_CROWN.getMessage(context))
        var unitMeasSlice = UnitMeasurementModel(4,UnitMeasDrink.SLICE.getMessage(context))

        var ingredients = listOf(IngredientModel(1,IngredientDrink.ICE_CUBE.getMessage(context), "3/4",unitMeasCube),
            IngredientModel(2,IngredientDrink.ORANGE.getMessage(context),"1",unitMeasSlice),
            IngredientModel(3,IngredientDrink.CLOVE.getMessage(context),"1",unitMeasSlice),
            IngredientModel(4,IngredientDrink.GINGER_BEER.getMessage(context),"2",unitMeasOz),
            IngredientModel(5,IngredientDrink.TONIC_WATER.getMessage(context),"3/4",unitMeasToCrown),
            IngredientModel(6,IngredientDrink.ANISE_STARS.getMessage(context),"0",unitMeasToCrown))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(context.resources.getString(R.string.drink_name_gin_tonic))
        drinkModelMojito.setImage("ic_gin_tonic_drink")
        drinkModelMojito.setPreparation(context.resources.getString(R.string.drink_preparation_gin_tonic))
        drinkModelMojito.setDescription(context.resources.getString(R.string.drink_description_gin_tonic))
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }

    private fun createSunriseTequila():DrinkModel{

        var categoryRum = CategoryModel(6, context.resources.getString(R.string.title_category_vodka),true,"ic_vodka_category")

        var unitMeasMl = UnitMeasurementModel(1,"ml")
        var unitMeasOz = UnitMeasurementModel(2,"oz")
        var unitMeasCristalino = UnitMeasurementModel(3,"Cristalino")
        var unitMeasCoronar= UnitMeasurementModel(4,"Coronar")

        //var ingedients = context.resources.getString(R.string.drink_ingredients_mojito).split("\n")
        var ingredients = listOf(
            IngredientModel(2,IngredientDrink.CRYSTALLINE_ICE.getMessage(context), "1",unitMeasCristalino),
            IngredientModel(4,"Tequila ","2",unitMeasOz),
            IngredientModel(3,"Jugo de Naranja","150",unitMeasMl),
            IngredientModel(6,"Granadina","1",unitMeasCoronar))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName("Tequila Sunrise")
        //drinkModelMojito.setImage(resources.getString(R.mipmap.ic_mojito_drink))
        drinkModelMojito.setImage("ic_margarita_tequila_drink")
        drinkModelMojito.setPreparation("Preparación:\nAgregar directo al vaso 1 hielo cristalino, 2 oz de tequila, rellenar con jugo de naranja dejando 1 o 2 dedos para luego llenar con granadina, Luego agregar la decoración, en este caso con se agregó una rodaja de naranja.")
        drinkModelMojito.setDescription("DESCRIPCION DEL TRAGO")
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }

    private fun createMargaritaTequila():DrinkModel{

        var categoryRum = CategoryModel(6, context.resources.getString(R.string.title_category_vodka),true,"ic_vodka_category")

        var unitMeasGr = UnitMeasurementModel(1,"gr")
        var unitMeasOz = UnitMeasurementModel(2,"oz")
        var unitMeasCubo = UnitMeasurementModel(3,"Cubo")
        var unitMeasDash = UnitMeasurementModel(4,"Dash")

        //var ingedients = context.resources.getString(R.string.drink_ingredients_mojito).split("\n")
        var ingredients = listOf(
            IngredientModel(1,"Tajín para enllantar la copa","10",unitMeasGr),
            IngredientModel(2,IngredientDrink.CRYSTALLINE_ICE.getMessage(context), "1",unitMeasCubo),
            IngredientModel(3,"Jugo de Naranja","1",unitMeasOz),
            IngredientModel(4,"Tequila ","2",unitMeasOz),
            IngredientModel(5,IngredientDrink.TRIPLE_SEX.getMessage(context),"1",unitMeasDash),
            IngredientModel(6,IngredientDrink.ICE_CUBE.getMessage(context),"3",unitMeasCubo))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName("Tequila Margarita")
        //drinkModelMojito.setImage(resources.getString(R.mipmap.ic_mojito_drink))
        drinkModelMojito.setImage("ic_sunrise_tequila_drink")
        drinkModelMojito.setPreparation("Preparación:\nPrimero hay que enllantar la copa con tajín, pasar un pedazo de limón por el borde de la copa, pasar el borde de la copa en el tajín. Agregar directo en la coctelera 1 oz de goma, 1 oz de jugo de limón, 2 oz de tequila, 1 dash de triple sec, agregar 3 o 4 cubos de hielos, coctelera para juntar todos los sabores. Servir con colador oruga en la copa, luego decoramos con una rodaja de limón de pica.")
        drinkModelMojito.setDescription("DESCRIPCION DEL TRAGO")
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }

    private fun createOldFashioned():DrinkModel{
        var categoryRum = CategoryModel(5, context.resources.getString(R.string.title_category_whisky),true,"ic_while_run_category")

        var unitMeasSheet = UnitMeasurementModel(1,UnitMeasDrink.LEAVES.getMessage(context))
        var unitMeasOz = UnitMeasurementModel(2,UnitMeasDrink.OZ.getMessage(context))
        var unitMeasFrappe = UnitMeasurementModel(3,UnitMeasDrink.FRAPPE.getMessage(context))
        var unitMeasToCrown = UnitMeasurementModel(4,UnitMeasDrink.TO_CROWN.getMessage(context))

        var ingredients = listOf(
            IngredientModel(1,IngredientDrink.ERASER.getMessage(context), "5",unitMeasSheet),
            IngredientModel(2,IngredientDrink.ANGOSTURAS_BITTERS.getMessage(context),"1",unitMeasOz),
            IngredientModel(3,IngredientDrink.MINERAL_WATER.getMessage(context),"1",unitMeasOz),
            IngredientModel(4,IngredientDrink.ICE_CUBE.getMessage(context),"3/4",unitMeasFrappe),
            IngredientModel(5,IngredientDrink.WHISKY_BLEND.getMessage(context),"2",unitMeasOz),
            IngredientModel(6,IngredientDrink.CRYSTALLINE_ICE.getMessage(context),"0",unitMeasToCrown),
            IngredientModel(7,IngredientDrink.MARASCHINO_AND_ORANGE.getMessage(context),"0",unitMeasToCrown))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(context.resources.getString(R.string.drink_name_old_fashioned))
        drinkModelMojito.setImage("ic_rusty_nail_drink")
        drinkModelMojito.setPreparation(context.resources.getString(R.string.drink_preparation_old_fashioned))
        drinkModelMojito.setDescription(context.resources.getString(R.string.drink_description_old_fashioned))
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }

    private fun rustyClove():DrinkModel{
        var categoryRum = CategoryModel(5, context.resources.getString(R.string.title_category_whisky),true,"ic_while_run_category")

        var unitMeasOz = UnitMeasurementModel(1,UnitMeasDrink.OZ.getMessage(context))
        var unitMeasSlice = UnitMeasurementModel(2,UnitMeasDrink.SLICE.getMessage(context))
        var unitMeasCu = UnitMeasurementModel(3,UnitMeasDrink.QUANTITY.getMessage(context))

        var ingredients = listOf(
            IngredientModel(1,IngredientDrink.CRYSTALLINE_ICE.getMessage(context), "1",unitMeasCu),
            IngredientModel(2,IngredientDrink.WHISKY_BLEND.getMessage(context),"2",unitMeasOz),
            IngredientModel(3,IngredientDrink.DRAMBUIE.getMessage(context),"1",unitMeasOz),
            IngredientModel(4,IngredientDrink.ORANGE.getMessage(context),"1",unitMeasSlice),
            IngredientModel(5,IngredientDrink.CLOVE.getMessage(context),"2",unitMeasCu))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(context.resources.getString(R.string.drink_name_rusty_clove))
        drinkModelMojito.setImage("ic_rusty_nail_drink")
        drinkModelMojito.setPreparation(context.resources.getString(R.string.drink_preparation_rusty_clove))
        drinkModelMojito.setDescription(context.resources.getString(R.string.drink_description_rusty_clove))
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }

    private fun manhattan():DrinkModel{
        var drinkModelMojito = DrinkModel()
        return drinkModelMojito
    }

    private fun irishCoffee():DrinkModel{
        var categoryRum = CategoryModel(5, context.resources.getString(R.string.title_category_whisky),true,"ic_while_run_category")

        var unitMeasOz = UnitMeasurementModel(1,UnitMeasDrink.OZ.getMessage(context))
        var unitMeasCu = UnitMeasurementModel(2,UnitMeasDrink.QUANTITY.getMessage(context))
        var unitToCrown = UnitMeasurementModel(3,UnitMeasDrink.TO_CROWN.getMessage(context))

        var ingredients = listOf(
            IngredientModel(1,IngredientDrink.COFFEE_EXPRESS.getMessage(context), "2",unitMeasOz),
            IngredientModel(2,IngredientDrink.WHISKY_BLEND.getMessage(context),"2",unitMeasOz),
            IngredientModel(3,IngredientDrink.MILK_FOAM.getMessage(context),"1",unitToCrown),
            IngredientModel(5,IngredientDrink.COFFEE_GRAIN.getMessage(context),"3",unitMeasCu))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(context.resources.getString(R.string.drink_name_irish_coffee))
        drinkModelMojito.setImage("ic_irish_coffee_drink")
        drinkModelMojito.setPreparation(context.resources.getString(R.string.drink_preparation_irish_coffee))
        drinkModelMojito.setDescription(context.resources.getString(R.string.drink_description_irish_coffee))
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }
}