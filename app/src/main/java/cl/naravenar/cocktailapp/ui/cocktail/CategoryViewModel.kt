package cl.naravenar.cocktailapp.ui.cocktail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoryViewModel/*(val cocktails: List<CocktailModel>)*/ : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment CocktailViewModel"
    }
    val text: LiveData<String> = _text
}

/*
class MainViewModelFactory(val cocktails: List<CocktailModel>) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModelFactory(cocktails) as T
    }
}
 */