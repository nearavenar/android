package cl.naravenar.cocktailapp.ui.pizza

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cl.naravenar.cocktailapp.adapter.PizzaRecyclerAdapter
import cl.naravenar.cocktailapp.databinding.FragmentPizzaMenuBinding
import cl.naravenar.cocktailapp.model.PizzaModel
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

        /*val textView: TextView = binding.tvPizza
        pizzaViewModel.text_vm_pizza.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setAllPizzas(context: Context, pizzaService: PizzaService){

        val cocktailsList: List<PizzaModel> = pizzaService.getAllCategories()
        if(cocktailsList.isNotEmpty()){
            val adapterCocktailDetail: PizzaRecyclerAdapter = PizzaRecyclerAdapter(cocktailsList, requireContext())
            val linearLayoutManager = LinearLayoutManager(_binding?.root!!.context, LinearLayoutManager.VERTICAL, false)
            _binding!!.recicleViewPizzas.layoutManager = linearLayoutManager
            _binding!!.recicleViewPizzas.adapter = adapterCocktailDetail
        }else{
            Toast.makeText(context, "Sin Tragos para esta categoria", Toast.LENGTH_LONG).show()
        }
    }
}