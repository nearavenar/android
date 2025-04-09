package cl.naravenar.cocktailapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import cl.naravenar.cocktailapp.entity.converter.CategoryConverter
import cl.naravenar.cocktailapp.entity.converter.IngredientConverter
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "drink")
data class DrinkModel constructor(@PrimaryKey private var id: Long = 0,
                                  private var name: String,
                                  private var image: String,
                                  private var preparation: String,
                                  private var description: String,
                                  //@TypeConverters(IngredientConverter::class)
                                  private var ingredients: List<IngredientModel>,
                                  @TypeConverters(CategoryConverter::class)
                                  private var category: CategoryModel) : Parcelable {

    constructor() : this(0, "","", "","", emptyList(), CategoryModel()) {
    }

    fun getId(): Long {
        return id
    }

    fun setId(id: Long) {
        this.id = id
    }

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getImage(): String {
        return image
    }

    fun setImage(image: String) {
        this.image = image
    }

    fun getPreparation(): String {
        return preparation
    }

    fun setPreparation(preparation: String) {
        this.preparation = preparation
    }

    fun getDescription(): String {
        return description
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getIngredients(): List<IngredientModel> {
        return ingredients
    }

    fun setIngredients(ingredients: List<IngredientModel>) {
        this.ingredients = ingredients
    }

    fun getCategory(): CategoryModel {
        return category
    }

    fun setCategory(category: CategoryModel) {
        this.category = category
    }
}