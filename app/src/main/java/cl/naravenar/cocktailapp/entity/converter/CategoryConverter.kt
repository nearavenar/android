package cl.naravenar.cocktailapp.entity.converter

import androidx.room.TypeConverter
import cl.naravenar.cocktailapp.model.CategoryModel

class CategoryConverter {

    @TypeConverter
    fun categoryToString(category: CategoryModel) = "$category"

    @TypeConverter
    fun stringToTeacher(value: String): CategoryModel {

        if (value == null) {
            return CategoryModel()
        }

        var data = value.split(":")
        val id = data[0].toLong()
        val name = data[1]
        val status = data[2].toBoolean()
        val image = data[3]

        return CategoryModel(id, name, status,image)
    }
}