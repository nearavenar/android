package cl.naravenar.cocktailapp.shared

import android.content.Context
import cl.naravenar.cocktailapp.model.PizzaModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object PizzaStorage {
    private const val PREFS_NAME = "pizza_prefs"
    private const val KEY_PIZZA_LIST = "pizza_list"

    fun savePizzaList(context: Context, pizzas: List<PizzaModel>) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(pizzas)
        editor.putString(KEY_PIZZA_LIST, json)
        editor.apply()
    }

    fun loadPizzaList(context: Context): MutableList<PizzaModel> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(KEY_PIZZA_LIST, null) ?: return mutableListOf()

        val gson = Gson()
        val type = object : TypeToken<List<PizzaModel>>() {}.type
        return gson.fromJson(json, type)
    }

    fun toggleFavorite(context: Context, pizzaId: Long) {
        val pizzas = loadPizzaList(context).toMutableList()
        val index = pizzas.indexOfFirst { it.getId() == pizzaId }

        if (index != -1) {
            pizzas[index].setFavorite(!pizzas[index].getFavorite())
            savePizzaList(context, pizzas)
        }
    }
}