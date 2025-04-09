package cl.naravenar.cocktailapp.ui.coffee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoffeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is coffee Fragment"
    }
    val text: LiveData<String> = _text
}