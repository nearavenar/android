package cl.naravenar.cocktailapp.model

class DrinkPhotoPreparationModel(private var id: Long,
                                 private var name: String,
                                 private var image: String,
                                 private var drink:DrinkModel) {

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
    fun getDrink(): DrinkModel {
        return drink
    }

    fun setDrink(drink: DrinkModel) {
        this.drink = drink
    }
}