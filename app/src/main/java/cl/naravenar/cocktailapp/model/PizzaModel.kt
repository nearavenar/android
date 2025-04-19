package cl.naravenar.cocktailapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PizzaModel(private var id: Long = 0,
                      private var name: String,
                      private var image: String,
                      private var preparation: String,
                      private var description: String,
                      private var favorite: Boolean,
                      private var quantity: Int,
                      private var size: SizeModel,
                      private var ingredients: List<IngredientModel>) : Parcelable {

    constructor() : this(0, "","", "","", false, 0, SizeModel(), emptyList()) {
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

    fun getFavorite(): Boolean {
        return favorite
    }

    fun setFavorite(favorite: Boolean) {
        this.favorite = favorite
    }

    fun getIngredients(): List<IngredientModel> {
        return ingredients
    }

    fun setIngredients(ingredients: List<IngredientModel>) {
        this.ingredients = ingredients
    }

    fun getQuantity(): Int {
        return quantity
    }

    fun setQuantity(quantity: Int) {
        this.quantity = quantity
    }

    fun getSize(): SizeModel {
        return size
    }

    fun setSize(size: SizeModel) {
        this.size = size
    }
}