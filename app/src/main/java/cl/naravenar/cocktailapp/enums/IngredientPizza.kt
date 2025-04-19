package cl.naravenar.cocktailapp.enums

import android.content.Context
import cl.naravenar.cocktailapp.R

enum class IngredientPizza (val resourceId: Int) {

    MOZZARELLA_CHEESE(R.string.pizza_ingredient_mozzarella_cheese),
    ONION(R.string.pizza_ingredient_onion),
    RED_ONION(R.string.pizza_ingredient_red_onion),
    ONION_POWDER(R.string.pizza_ingredient_onion_powder),
    ONION_JULIENNE(R.string.pizza_ingredient_onion_julienne),
    CARAMEL_ONION(R.string.pizza_ingredient_caramel_onion),
    OLIVE_OIL(R.string.pizza_ingredient_olive_oil),
    PEPPERONI(R.string.pizza_ingredient_pepperoni),
    SALAMI(R.string.pizza_ingredient_salami),
    OLIVE(R.string.pizza_ingredient_olive),
    CORN(R.string.pizza_ingredient_corn),
    TOMATO_SAUCE(R.string.pizza_ingredient_tomato_sauce),
    TOMATO(R.string.pizza_ingredient_tomato),
    BARBECUE_SAUCE(R.string.pizza_ingredient_barbecue_sauce),
    BASIL(R.string.pizza_ingredient_basil),
    SAUSAGE(R.string.pizza_ingredient_sausage),
    MINCED_MEAT(R.string.pizza_ingredient_minced_meat),
    SHREDDED_CHICKEN(R.string.pizza_ingredient_shredded_chicken),
    PINEAPPLE(R.string.pizza_ingredient_pineapple),
    BACON(R.string.pizza_ingredient_bacon),
    HAM(R.string.pizza_ingredient_ham),
    OREGANO(R.string.pizza_ingredient_oregano),
    GARLIC(R.string.pizza_ingredient_garlic),
    GARLIC_POWDER(R.string.pizza_ingredient_garlic_powder),
    FLOUR(R.string.pizza_ingredient_flour),
    STRONG_FLOUR(R.string.pizza_ingredient_strong_flour),
    WATER(R.string.pizza_ingredient_water),
    SUGAR(R.string.pizza_ingredient_sugar),
    SALT(R.string.pizza_ingredient_salt),
    YEAST(R.string.pizza_ingredient_yeast),
    BAKING_POWDER(R.string.pizza_ingredient_baking_powder),
    SEMOLINA(R.string.pizza_ingredient_semolina),
    CORN_FLOUR(R.string.pizza_ingredient_corn_flour);

    fun getMessage(context: Context): String {
        return context.getString(resourceId)
    }
}