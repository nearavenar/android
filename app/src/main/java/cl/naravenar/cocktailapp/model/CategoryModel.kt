package cl.naravenar.cocktailapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryModel (private var id: Long = 0,
                     private var name: String,
                     private var status: Boolean,
                     private var image: String) : Parcelable {

    constructor() : this(0,"",false,"") {
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

    fun getStatus(): Boolean {
        return status
    }

    fun setStatus(status: Boolean) {
        this.status = status
    }

    fun getImage(): String {
        return image
    }

    fun setImage(image: String) {
        this.image = image
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CategoryModel

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "$id:$name:$status:$image"
    }
}