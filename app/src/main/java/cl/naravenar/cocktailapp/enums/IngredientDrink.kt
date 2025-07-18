package cl.naravenar.cocktailapp.enums

import android.content.Context
import cl.naravenar.cocktailapp.R

enum class IngredientDrink (val resourceId: Int) {
    FRAPPE_ICE(R.string.drink_ingredient_ice_frappe),
    ICE_CUBE(R.string.drink_ingredient_ice_cube),
    CRYSTALLINE_ICE(R.string.drink_ingredient_crystalline_ice),
    MINT(R.string.drink_ingredient_mint),
    ORANGE(R.string.drink_ingredient_orange),
    LEMON(R.string.drink_ingredient_lemon),
    LEMON_JUICE(R.string.drink_ingredient_lemon_juice),
    PINEAPPLE_PULP(R.string.drink_ingredient_pina_just),
    MARACUYA_PULP(R.string.drink_ingredient_maracuya_juice),
    BLUEBERRY(R.string.drink_ingredient_blueberries),
    MARASCHINO_AND_ORANGE(R.string.drink_ingredient_maraschino),
    GINGER_BEER(R.string.drink_ingredient_ginger_beer),
    COFFEE_LIQUOR(R.string.drink_ingredient_coffee_liquor),
    COFFEE_EXPRESS(R.string.drink_ingredient_coffee_express),
    COFFEE_GRAIN(R.string.drink_ingredient_coffee_grain),
    MILK_FOAM(R.string.drink_ingredient_milk_foam),
    COCONUT_CREAM(R.string.drink_ingredient_coconut_cream),
    ERASER(R.string.drink_ingredient_eraser),
    CLOVE(R.string.drink_ingredient_clove),
    MINERAL_WATER(R.string.drink_ingredient_mineral_water),
    TONIC_WATER(R.string.drink_ingredient_tonic_water),
    BASIL_LEAF(R.string.drink_ingredient_basil_leaf_strawberry),
    ANISE_STARS(R.string.drink_ingredient_anise_stars),
    MISAMPLAS(R.string.drink_ingredient_misamplas),
    WHITE_OR_GOLDEN_RUM(R.string.drink_ingredient_wg_rum),
    TRIPLE_SEX(R.string.drink_ingredient_triple_sex),
    WHITE_RUM(R.string.drink_ingredient_w_rum),
    VODKA(R.string.drink_ingredient_vodka),
    GENEVA(R.string.drink_ingredient_gin),
    ANGOSTURAS_BITTERS(R.string.drink_ingredient_angosturas),
    WHISKY_BLEND(R.string.drink_ingredient_whisky),
    WHISKY_IRISH(R.string.drink_ingredient_irish),
    DRAMBUIE(R.string.drink_ingredient_drambuie),
    SUGAR(R.string.drink_ingredient_sugar),
    TEQUILA(R.string.drink_ingredient_tequila),
    SALT(R.string.drink_ingredient_salt),
    BEER(R.string.drink_ingredient_beer);

    fun getMessage(context: Context): String {
        return context.getString(resourceId)
    }
}