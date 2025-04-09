package cl.naravenar.cocktailapp.ui.pizza

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cl.naravenar.cocktailapp.databinding.FragmentPizzaBinding

class PizzaFragment : Fragment() {

    private var _binding: FragmentPizzaBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val pizzaViewModel = ViewModelProvider(this).get(PizzaViewModel::class.java)

        _binding = FragmentPizzaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvPizza
        pizzaViewModel.text_vm_pizza.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}