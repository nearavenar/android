package cl.naravenar.cocktailapp.shared

import android.content.Context
import cl.naravenar.cocktailapp.model.DrinkModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DrinkStorage {
    private const val PREFS_NAME = "drink_prefs"
    private const val KEY_DRINKS_LIST = "drink_list"

    fun saveDrinkList(context: Context, pizzas: List<DrinkModel>) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(pizzas)
        editor.putString(KEY_DRINKS_LIST, json)
        editor.apply()
    }

    fun loadDrinksList(context: Context): MutableList<DrinkModel> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(KEY_DRINKS_LIST, null) ?: return mutableListOf()

        val gson = Gson()
        val type = object : TypeToken<List<DrinkModel>>() {}.type
        return gson.fromJson(json, type)
    }

    fun toggleFavorite(context: Context, drinkId: Long) {
        val drinks = loadDrinksList(context).toMutableList()
        val index = drinks.indexOfFirst { it.getId() == drinkId }

        if (index != -1) {
            drinks[index].setFavorite(!drinks[index].getFavorite())
            saveDrinkList(context, drinks)
        }
    }
}