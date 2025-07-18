package cl.naravenar.cocktailapp.repository

import cl.naravenar.cocktailapp.model.PizzaModel

interface PizzaRepository {
    fun createPizza(pizza :PizzaModel)
    fun listPizzas() :MutableList<PizzaModel>
    fun findPizzaByName(name:String): MutableList<PizzaModel>
}