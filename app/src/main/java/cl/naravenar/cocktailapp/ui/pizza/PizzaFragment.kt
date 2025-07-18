package cl.naravenar.cocktailapp.ui.pizza

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cl.naravenar.cocktailapp.R
import cl.naravenar.cocktailapp.adapter.CategoryRecyclerAdapter
import cl.naravenar.cocktailapp.adapter.PizzaRecyclerAdapter
import cl.naravenar.cocktailapp.databinding.FragmentPizzaMenuBinding
import cl.naravenar.cocktailapp.model.CategoryModel
import cl.naravenar.cocktailapp.model.PizzaModel
import cl.naravenar.cocktailapp.service.CocktailService
import cl.naravenar.cocktailapp.service.PizzaService

class PizzaFragment : Fragment() {

    private var _binding: FragmentPizzaMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val pizzaViewModel = ViewModelProvider(this).get(PizzaViewModel::class.java)
        val pizzaService = PizzaService(requireContext())

        _binding = FragmentPizzaMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setAllPizzas(root.context, pizzaService)


        _binding!!.txEdtInputSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Este método se llama antes de que el texto cambie.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Este método se llama cuando el texto está cambiando.
                setFilterPizza(pizzaService, s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                // Este método se llama después de que el texto ha cambiado.
            }
        })

        var favorite = true
        _binding!!.btnOrderByFavoritePizza.setOnClickListener{
            var pizzasList: List<PizzaModel> = pizzaService.getAllPizzas()
            _binding!!.btnOrderByFavoritePizza.setBackgroundColor(ContextCompat.getColor(_binding?.root!!.context, R.color.green_app))
            if(favorite){
                pizzasList = pizzasList.sortedByDescending { it.getFavorite() }
                _binding!!.btnOrderByFavoritePizza.setBackgroundColor(Color.RED)
            }

            if(pizzasList.isNotEmpty()){
                val adapterCocktailDetail = PizzaRecyclerAdapter(pizzasList, requireContext())
                val linearLayoutManager = LinearLayoutManager(_binding?.root!!.context, LinearLayoutManager.VERTICAL, false)
                _binding!!.recicleViewPizzas.layoutManager = linearLayoutManager
                _binding!!.recicleViewPizzas.adapter = adapterCocktailDetail
                favorite = !favorite
            }else{
                Toast.makeText(context, "Sin Tragos para esta categoria", Toast.LENGTH_LONG).show()
            }

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setAllPizzas(context: Context, pizzaService: PizzaService){

        val cocktailsList: List<PizzaModel> = pizzaService.getAllPizzas()
        if(cocktailsList.isNotEmpty()){
            val adapterCocktailDetail: PizzaRecyclerAdapter = PizzaRecyclerAdapter(cocktailsList, requireContext())
            val linearLayoutManager = LinearLayoutManager(_binding?.root!!.context, LinearLayoutManager.VERTICAL, false)
            _binding!!.recicleViewPizzas.layoutManager = linearLayoutManager
            _binding!!.recicleViewPizzas.adapter = adapterCocktailDetail
        }else{
            Toast.makeText(context, "Sin Tragos para esta categoria", Toast.LENGTH_LONG).show()
        }
    }


    private fun setFilterPizza(pizzaService: PizzaService, text:String){
        val pizzas: MutableList<PizzaModel> = pizzaService.findCategoriaByName(text)
        updateAdapter(pizzas)
    }

    private fun updateAdapter(pizza :MutableList<PizzaModel>){
        val adapterCocktail = PizzaRecyclerAdapter(pizza, requireContext())
        val linearLayoutManager = LinearLayoutManager(_binding?.root!!.context, LinearLayoutManager.VERTICAL, false)
        _binding!!.recicleViewPizzas.layoutManager = linearLayoutManager
        _binding!!.recicleViewPizzas.adapter = adapterCocktail
    }
}