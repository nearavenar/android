package cl.naravenar.cocktailapp.ui.cocktail

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cl.naravenar.cocktailapp.adapter.CategoryRecyclerAdapter
import cl.naravenar.cocktailapp.databinding.FragmentCategoryCocktailBinding
import cl.naravenar.cocktailapp.model.CategoryModel
import cl.naravenar.cocktailapp.service.CocktailService

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryCocktailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val cocktailService = CocktailService(requireContext())
        _binding = FragmentCategoryCocktailBinding.inflate(inflater, container, false)
        val root: View = binding.root
/*
        val textView: TextView = binding.txtTitleCocktails
        cocktailViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
 */
        setCategoriesList(cocktailService)

        _binding!!.txEdtInputSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Este método se llama antes de que el texto cambie.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Este método se llama cuando el texto está cambiando.
                setFilterCategory(cocktailService, s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                // Este método se llama después de que el texto ha cambiado.
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setCategoriesList(cocktailService:CocktailService){
        val categories: MutableList<CategoryModel> = cocktailService.getAllCategories()
        updateAdapter(categories)
    }

    private fun setFilterCategory(cocktailService:CocktailService, text:String){
        val categories: MutableList<CategoryModel> = cocktailService.findCategoriaByName(text)
        updateAdapter(categories)
    }

    private fun updateAdapter(categories :MutableList<CategoryModel>){
        val adapterCocktail = CategoryRecyclerAdapter(categories, requireContext())
        val linearLayoutManager = LinearLayoutManager(_binding?.root!!.context, LinearLayoutManager.VERTICAL, false)
        _binding!!.recicleViewCocktail.layoutManager = linearLayoutManager
        _binding!!.recicleViewCocktail.adapter = adapterCocktail
    }
}