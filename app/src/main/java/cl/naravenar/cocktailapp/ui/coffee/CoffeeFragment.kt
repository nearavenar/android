package cl.naravenar.cocktailapp.ui.coffee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cl.naravenar.cocktailapp.databinding.FragmentCoffeeMenuBinding

class CoffeeFragment : Fragment() {

    private var _binding: FragmentCoffeeMenuBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val coffeViewModel =
            ViewModelProvider(this).get(CoffeViewModel::class.java)

        _binding = FragmentCoffeeMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvCoffee
        coffeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}