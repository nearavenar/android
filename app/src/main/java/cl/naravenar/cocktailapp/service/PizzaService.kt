package cl.naravenar.cocktailapp.service

import android.content.Context
import cl.naravenar.cocktailapp.model.PizzaModel
import cl.naravenar.cocktailapp.repository.impl.PizzaRepositoryImpl

class PizzaService (context: Context) {
    private var pizzaRepository : PizzaRepositoryImpl = PizzaRepositoryImpl(context);

    fun getAllPizzas(): MutableList<PizzaModel> {
        return pizzaRepository.getAllPizzas()
    }

    fun findCategoriaByName(name:String): MutableList<PizzaModel> {
        return pizzaRepository.findPizzaByName(name)
    }
}