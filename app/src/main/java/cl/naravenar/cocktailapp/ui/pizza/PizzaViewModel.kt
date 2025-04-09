package cl.naravenar.cocktailapp.ui.pizza

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PizzaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Pizza Fragment"
    }
    val text_vm_pizza: LiveData<String> = _text
}