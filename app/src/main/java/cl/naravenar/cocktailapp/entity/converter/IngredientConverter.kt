package cl.naravenar.cocktailapp.entity.converter

import cl.naravenar.cocktailapp.model.IngredientModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Collections

class IngredientConverter {
    private val gson = Gson()

    //@TypeConverter
    fun stringToListIngredient(data: String?): List<IngredientModel> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<IngredientModel>>() {

        }.type

        return gson.fromJson<List<IngredientModel>>(data, listType)
    }

    //@TypeConverter
    fun listIngredientToString(someObjects: List<IngredientModel>): String {
        return gson.toJson(someObjects)
    }

    /*
    @TypeConverter
    fun stringToIngredient(value: String): IngredientMoldel {
        val id = value.substringBefore(':').toLong()
        val name = value.substringAfter(':')
        val amount = value.substringBefore(':').toInt()

        return IngredientMoldel(id, name, amount, UnitMeasurementModel(0, ""))
    }
    */
}