package cl.naravenar.cocktailapp.config

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cl.naravenar.cocktailapp.dao.CategoryDao
import cl.naravenar.cocktailapp.dao.DrinkDao
import cl.naravenar.cocktailapp.dao.IngredientDao
import cl.naravenar.cocktailapp.dao.UnitMeasurementDao
import cl.naravenar.cocktailapp.entity.converter.CategoryConverter
import cl.naravenar.cocktailapp.entity.converter.IngredientConverter
import cl.naravenar.cocktailapp.entity.converter.UnitMeasurementConverter
import cl.naravenar.cocktailapp.model.CategoryModel
import cl.naravenar.cocktailapp.model.DrinkModel
import cl.naravenar.cocktailapp.model.IngredientModel
import cl.naravenar.cocktailapp.model.UnitMeasurementModel

@Database(entities = [DrinkModel::class, CategoryModel::class, IngredientModel::class, UnitMeasurementModel::class], version = 1)
@TypeConverters(IngredientConverter::class,CategoryConverter::class,UnitMeasurementConverter::class)
abstract class StoreDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun drinkDao(): DrinkDao
    abstract fun ingredientDao(): IngredientDao
    abstract fun unitMeasurementDao(): UnitMeasurementDao
}