package cl.naravenar.cocktailapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class SizeModel( private var id: Long = 0,
                 private var name: String,
                 private var size: Int,
                 private var portion: Int) : Parcelable {

    constructor() : this(0, "",0, 0) {
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

    fun getPortion(): Int {
        return portion
    }

    fun setPortion(portion: Int) {
        this.portion = portion
    }

    fun getSize(): Int {
        return size
    }

    fun setSize(size: Int) {
        this.size = size
    }
}