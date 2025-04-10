package cl.naravenar.cocktailapp.repository.impl

import android.content.Context
import cl.naravenar.cocktailapp.R
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
        return drinks
    }

    private fun createClassicMojito():DrinkModel{

        var categoryRum = CategoryModel(1, context.resources.getString(R.string.title_category_rum),true,"ic_while_run_category")

        var unitMeasSheet = UnitMeasurementModel(1,context.resources.getString(R.string.drink_unit_meas_leaves_mojito))
        var unitMeasOz = UnitMeasurementModel(2,context.resources.getString(R.string.drink_unit_meas_oz_mojito))
        var unitMeasFrappe = UnitMeasurementModel(3,context.resources.getString(R.string.drink_unit_meas_frappe_mojito))
        var unitMeasToCrown = UnitMeasurementModel(4,context.resources.getString(R.string.drink_unit_meas_to_crown_mojito))

        var ingredients = listOf(IngredientModel(1,context.resources.getString(R.string.drink_ingredients_mint_mojito), "5",unitMeasSheet),
            IngredientModel(2,context.resources.getString(R.string.drink_ingredients_eraser_mojito),"1",unitMeasOz),
            IngredientModel(3,context.resources.getString(R.string.drink_ingredients_lemon_juice_mojito),"1",unitMeasOz),
            IngredientModel(4,context.resources.getString(R.string.drink_ingredients_ice_frappe_mojito),"3/4",unitMeasFrappe),
            IngredientModel(5,context.resources.getString(R.string.drink_ingredients_rum_mojito),"2",unitMeasOz),
            IngredientModel(6,context.resources.getString(R.string.drink_ingredients_mineral_mojito),"0",unitMeasToCrown))

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

        var unitMeasSheet = UnitMeasurementModel(1,context.resources.getString(R.string.drink_unit_meas_leaves_mojito))
        var unitMeasOz = UnitMeasurementModel(2,context.resources.getString(R.string.drink_unit_meas_oz_mojito))
        var unitMeasFrappe = UnitMeasurementModel(3,context.resources.getString(R.string.drink_unit_meas_frappe_mojito))
        var unitMeasToCrown = UnitMeasurementModel(4,context.resources.getString(R.string.drink_unit_meas_to_crown_mojito))

        var ingredients = listOf(IngredientModel(1,context.resources.getString(R.string.drink_ingredients_maracuya_mint_mojito), "5",unitMeasSheet),
            IngredientModel(2,context.resources.getString(R.string.drink_ingredients_maracuya_eraser_mojito),"1",unitMeasOz),
            IngredientModel(3,context.resources.getString(R.string.drink_ingredients_maracuya_lemon_juice_mojito),"1",unitMeasOz),
            IngredientModel(4,context.resources.getString(R.string.drink_ingredients_maracuya_ice_frappe_mojito),"3/4",unitMeasFrappe),
            IngredientModel(5,context.resources.getString(R.string.drink_ingredients_maracuya_rum_mojito),"2",unitMeasOz),
            IngredientModel(6,context.resources.getString(R.string.drink_ingredients_maracuya_juice_mojito),"2",unitMeasOz),
            IngredientModel(7,context.resources.getString(R.string.drink_ingredients_maracuya_mineral_mojito),"0",unitMeasToCrown))

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

        var unitMeasOz = UnitMeasurementModel(2,context.resources.getString(R.string.drink_unit_meas_oz_daiquiri))
        var unitMeasCube = UnitMeasurementModel(4,context.resources.getString(R.string.drink_unit_meas_cube_daiquiri))
        var unitMeasToDash = UnitMeasurementModel(4,context.resources.getString(R.string.drink_unit_meas_dash_daiquiri))

        var ingredients = listOf(IngredientModel(1,context.resources.getString(R.string.drink_ingredients_eraser_daiquiri),"1",unitMeasOz),
            IngredientModel(2,context.resources.getString(R.string.drink_ingredients_lemon_juice_daiquiri),"1",unitMeasOz),
            IngredientModel(3,context.resources.getString(R.string.drink_ingredients_rum_daiquiri),"2",unitMeasOz),
            IngredientModel(4,context.resources.getString(R.string.drink_ingredients_ice_cube_daiquiri),"2",unitMeasCube),
            IngredientModel(5,context.resources.getString(R.string.drink_ingredients_triple_sex_daiquiri),"1",unitMeasToDash))

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

        var unitMeasOz = UnitMeasurementModel(1,context.resources.getString(R.string.drink_unit_meas_oz_strawberry_daiquiri))
        var unitMeasCube = UnitMeasurementModel(2,context.resources.getString(R.string.drink_unit_meas_cube_strawberry_daiquiri))
        var unitMeasToDash = UnitMeasurementModel(3,context.resources.getString(R.string.drink_unit_meas_dash_strawberry_daiquiri))
        var unitMeasLeaves = UnitMeasurementModel(4,context.resources.getString(R.string.drink_unit_meas_leaves_strawberry_daiquiri))


        //var ingedients = context.resources.getString(R.string.drink_ingredients_mojito).split("\n")
        var ingredients = listOf(IngredientModel(1,context.resources.getString(R.string.drink_ingredients_eraser_strawberry_daiquiri),"1",unitMeasOz),
            IngredientModel(2,context.resources.getString(R.string.drink_ingredients_lemon_strawberry_juice_daiquiri),"1",unitMeasOz),
            IngredientModel(3,context.resources.getString(R.string.drink_ingredients_rum_strawberry_daiquiri),"2",unitMeasOz),
            IngredientModel(4,context.resources.getString(R.string.drink_ingredients_triple_sex_strawberry_daiquiri),"1",unitMeasToDash),
            IngredientModel(5,context.resources.getString(R.string.drink_ingredients_ice_cube_strawberry_daiquiri),"2",unitMeasCube),
            IngredientModel(6,context.resources.getString(R.string.drink_ingredients_basil_leaf_strawberry_daiquiri),"2",unitMeasLeaves))

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

        var unitMeasOz = UnitMeasurementModel(1,context.resources.getString(R.string.drink_unit_meas_oz_pina_colada))
        var unitMeasFrappe = UnitMeasurementModel(2,context.resources.getString(R.string.drink_unit_meas_cube_pina_colada))
        var unitMeasLeaves = UnitMeasurementModel(3,context.resources.getString(R.string.drink_unit_meas_leaves_pina_colada))

        var ingredients = listOf(IngredientModel(1,context.resources.getString(R.string.drink_ingredients_pina_just_pina_colada),"2",unitMeasOz),
            IngredientModel(2,context.resources.getString(R.string.drink_ingredients_coconut_cream_pina_colada),"2",unitMeasOz),
            IngredientModel(3,context.resources.getString(R.string.drink_ingredients_rum_pina_colada),"2",unitMeasOz),
            IngredientModel(3,context.resources.getString(R.string.drink_ingredients_eraser_pina_colada),"1",unitMeasOz),
            IngredientModel(6,context.resources.getString(R.string.drink_ingredients_misamplas_pina_colada),"1",unitMeasLeaves),
            IngredientModel(5,context.resources.getString(R.string.drink_ingredients_ice_frappe_pina_colada),"2/4",unitMeasFrappe))

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

        var unitMeasGr = UnitMeasurementModel(1,context.resources.getString(R.string.drink_unit_meas_gr_cosmopolitan))
        var unitMeasOz = UnitMeasurementModel(2,context.resources.getString(R.string.drink_unit_meas_oz_cosmopolitan))
        var unitMeasCubo = UnitMeasurementModel(3,context.resources.getString(R.string.drink_unit_meas_cube_cosmopolitan))
        var unitMeasDash = UnitMeasurementModel(4,context.resources.getString(R.string.drink_unit_meas_dash_cosmopolitan))


        var ingredients = listOf(IngredientModel(1,context.resources.getString(R.string.drink_ingredients_blueberries_cosmopolitan), "40",unitMeasGr),
            IngredientModel(2,context.resources.getString(R.string.drink_ingredients_lemon_juice_cosmopolitan),"1",unitMeasDash),
            IngredientModel(3,context.resources.getString(R.string.drink_ingredients_triple_sex_cosmopolitan),"1",unitMeasDash),
            IngredientModel(2,context.resources.getString(R.string.drink_ingredients_vodka_cosmopolitan),"2",unitMeasOz),
            IngredientModel(4,context.resources.getString(R.string.drink_ingredients_cube_ice_cosmopolitan),"3",unitMeasCubo))

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

        var unitMeasWedges= UnitMeasurementModel(1,context.resources.getString(R.string.drink_unit_meas_wedges_moscow_mule_rusia))
        var unitMeasFrappe = UnitMeasurementModel(2,context.resources.getString(R.string.drink_unit_meas_frappe_moscow_mule_rusia))
        var unitMeasOz = UnitMeasurementModel(3,context.resources.getString(R.string.drink_unit_meas_oz_moscow_mule_rusia))
        var unitMeasToCrown = UnitMeasurementModel(4,context.resources.getString(R.string.drink_unit_meas_to_crown_moscow_mule_rusia))


        var ingredients = listOf(IngredientModel(1,context.resources.getString(R.string.drink_ingredients_lemon_moscow_mule_rusia), "2",unitMeasWedges),
            IngredientModel(2,context.resources.getString(R.string.drink_ingredients_frappe_moscow_mule_rusia),"3/4",unitMeasFrappe),
            IngredientModel(3,context.resources.getString(R.string.drink_ingredients_vodka_moscow_mule_rusia),"2",unitMeasOz),
            IngredientModel(4,context.resources.getString(R.string.drink_ingredients_ginger_beer_moscow_mule_rusia),"0",unitMeasToCrown))

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

        var unitMeasOz = UnitMeasurementModel(1,context.resources.getString(R.string.drink_unit_meas_oz_express_martini))
        var unitMeasCube = UnitMeasurementModel(2,context.resources.getString(R.string.drink_unit_meas_cube_express_martini))
        var unitMeasGrain = UnitMeasurementModel(3,context.resources.getString(R.string.drink_unit_meas_grain_express_martini))

        var ingredients = listOf(IngredientModel(1,context.resources.getString(R.string.drink_ingredients_coffee_liquor_express_martini), "1 1/2",unitMeasOz),
            IngredientModel(2,context.resources.getString(R.string.drink_ingredients_eraser_express_martini),"1 1/2",unitMeasOz),
            IngredientModel(3,context.resources.getString(R.string.drink_ingredients_coffee_express_martini),"1",unitMeasOz),
            IngredientModel(4,context.resources.getString(R.string.drink_ingredients_vodka_express_martini),"1 1/2",unitMeasOz),
            IngredientModel(5,context.resources.getString(R.string.drink_ingredients_cube_express_martini),"3-4",unitMeasCube),
            IngredientModel(6,context.resources.getString(R.string.drink_ingredients_grain_coffee_express_martini),"2-3",unitMeasGrain))

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

        var unitMeasOz = UnitMeasurementModel(1,context.resources.getString(R.string.drink_unit_meas_oz_tom_collins))
        var unitMeasCube = UnitMeasurementModel(2,context.resources.getString(R.string.drink_unit_meas_cube_tom_collins))
        var unitMeasToCrown= UnitMeasurementModel(3,context.resources.getString(R.string.drink_unit_meas_to_crown_mojito))

        var ingredients = listOf(IngredientModel(1,context.resources.getString(R.string.drink_ingredients_eraser_tom_collins), "1",unitMeasOz),
            IngredientModel(2,context.resources.getString(R.string.drink_ingredients_lemon_juice_tom_collins),"1",unitMeasOz),
            IngredientModel(3,context.resources.getString(R.string.drink_ingredients_gin_tom_collins),"2",unitMeasOz),
            IngredientModel(4,context.resources.getString(R.string.drink_ingredients_cube_tom_collins),"3/4",unitMeasCube),
            IngredientModel(6,context.resources.getString(R.string.drink_ingredients_water_tom_collins),"0",unitMeasToCrown))

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

        var unitMeasOz = UnitMeasurementModel(1,context.resources.getString(R.string.drink_unit_meas_oz_gin_tonic))
        var unitMeasCube = UnitMeasurementModel(2,context.resources.getString(R.string.drink_unit_meas_cube_gin_tonic))
        var unitMeasToCrown = UnitMeasurementModel(3,context.resources.getString(R.string.drink_unit_meas_to_crown_gin_tonic))
        var unitMeasSlice = UnitMeasurementModel(4,context.resources.getString(R.string.drink_unit_meas_slice_gin_tonic))

        var ingredients = listOf(IngredientModel(1,context.resources.getString(R.string.drink_ingredients_cube_gin_tonic), "3/4",unitMeasCube),
            IngredientModel(2,context.resources.getString(R.string.drink_ingredients_orange_gin_tonic),"1",unitMeasSlice),
            IngredientModel(3,context.resources.getString(R.string.drink_ingredients_clove_gin_tonic),"1",unitMeasSlice),
            IngredientModel(4,context.resources.getString(R.string.drink_ingredients_gin_gin_tonic),"2",unitMeasOz),
            IngredientModel(5,context.resources.getString(R.string.drink_ingredients_water_gin_tonic),"3/4",unitMeasToCrown),
            IngredientModel(6,context.resources.getString(R.string.drink_ingredients_anise_stars_gin_tonic),"0",unitMeasToCrown))

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
            IngredientModel(2,"Hielo Cristalino ", "1",unitMeasCristalino),
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
            IngredientModel(2,"Hielo Cristalino ", "1",unitMeasCubo),
            IngredientModel(3,"Jugo de Naranja","1",unitMeasOz),
            IngredientModel(4,"Tequila ","2",unitMeasOz),
            IngredientModel(5,"Triple Sex","1",unitMeasDash),
            IngredientModel(6,"Hielo","3",unitMeasCubo))

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

        var unitMeasSheet = UnitMeasurementModel(1,context.resources.getString(R.string.drink_unit_meas_leaves_old_fashioned))
        var unitMeasOz = UnitMeasurementModel(2,context.resources.getString(R.string.drink_unit_meas_oz_old_fashioned))
        var unitMeasFrappe = UnitMeasurementModel(3,context.resources.getString(R.string.drink_unit_meas_frappe_old_fashioned))
        var unitMeasToCrown = UnitMeasurementModel(4,context.resources.getString(R.string.drink_unit_meas_to_crown_old_fashioned))

        var ingredients = listOf(
            IngredientModel(1,context.resources.getString(R.string.drink_ingredients_eraser_old_fashioned), "5",unitMeasSheet),
            IngredientModel(2,context.resources.getString(R.string.drink_ingredients_angosturas_old_fashioned),"1",unitMeasOz),
            IngredientModel(3,context.resources.getString(R.string.drink_ingredients_mineral_old_fashioned),"1",unitMeasOz),
            IngredientModel(4,context.resources.getString(R.string.drink_ingredients_ice_cube_old_fashioned),"3/4",unitMeasFrappe),
            IngredientModel(5,context.resources.getString(R.string.drink_ingredients_whisky_old_fashioned),"2",unitMeasOz),
            IngredientModel(6,context.resources.getString(R.string.drink_ingredients_crystalline_ice_old_fashioned),"0",unitMeasToCrown),
            IngredientModel(7,context.resources.getString(R.string.drink_ingredients_maraschino_old_fashioned),"0",unitMeasToCrown))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(context.resources.getString(R.string.drink_name_old_fashioned))
        drinkModelMojito.setImage("ic_mojito_drink")
        drinkModelMojito.setPreparation(context.resources.getString(R.string.drink_preparation_old_fashioned))
        drinkModelMojito.setDescription(context.resources.getString(R.string.drink_description_old_fashioned))
        drinkModelMojito.setIngredients(ingredients)
        drinkModelMojito.setCategory(categoryRum)
        return drinkModelMojito
    }
}