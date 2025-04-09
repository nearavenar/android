package cl.naravenar.cocktailapp.ui.cocktail.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.naravenar.cocktailapp.model.DrinkModel

class CocktailDetailViewModel(private val cocktail: DrinkModel) : ViewModel() {

    private val _title = MutableLiveData<String>().apply {
        value = cocktail.getName()
    }
    val tvCocktailTitle: LiveData<String> = _title

    private val _ingredients = MutableLiveData<String>().apply {
        var aux: String = ""
        for (value in cocktail.getIngredients()) {
            aux += value.getName()+"\n"
        }
        value = aux
    }
    val tvCocktailIngredients: LiveData<String> = _ingredients

    private val _preparation = MutableLiveData<String>().apply {
        value = cocktail.getPreparation()
    }
    val tvCocktailPreparation: LiveData<String> = _preparation

    private val _image = MutableLiveData<String>().apply {
        value = cocktail.getImage()
    }
    val imgView: LiveData<String> = _image
}

class CocktailDetailViewModelFactory(private val cocktail: DrinkModel): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CocktailDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CocktailDetailViewModel(cocktail) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}