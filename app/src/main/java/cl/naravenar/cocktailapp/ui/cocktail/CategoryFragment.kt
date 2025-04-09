package cl.naravenar.cocktailapp.ui.cocktail

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.naravenar.cocktailapp.adapter.CategoryRecyclerAdapter
import cl.naravenar.cocktailapp.databinding.FragmentCocktailBinding
import cl.naravenar.cocktailapp.model.CategoryModel
import cl.naravenar.cocktailapp.service.CocktailService

class CategoryFragment : Fragment() {

    private var _binding: FragmentCocktailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val cocktailService = CocktailService(requireContext())

        //val cocktailViewModel = ViewModelProvider(this)[CocktailViewModel::class.java]

        _binding = FragmentCocktailBinding.inflate(inflater, container, false)
        val root: View = binding.root
/*
        val textView: TextView = binding.txtTitleCocktails
        cocktailViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
 */
        setCategorysList(cocktailService)

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

        /*
        _binding!!.recicleViewCocktail.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                if (firstVisibleItemPosition + visibleItemCount >= totalItemCount) {
                    println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA, totalItemCount:$totalItemCount,sum:$firstVisibleItemPosition$visibleItemCount")
                }else{
                    println("CHAAAAAAAAAAAOOOOOOOOOOOOOOOOOOOOOOOOOO, totalItemCount:$totalItemCount,sum:$firstVisibleItemPosition$visibleItemCount")
                }
            }
        })
         */

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setCategorysList(cocktailService:CocktailService){
        //Thread{
            val categories: MutableList<CategoryModel> = cocktailService.getAllCategories()
            val adapterCocktail = CategoryRecyclerAdapter(categories, requireContext())
            val linearLayoutManager = LinearLayoutManager(_binding?.root!!.context, LinearLayoutManager.VERTICAL, false)

            _binding!!.recicleViewCocktail.layoutManager = linearLayoutManager
            _binding!!.recicleViewCocktail.adapter = adapterCocktail
        //}.start()
    }

    private fun setFilterCategory(cocktailService:CocktailService, text:String){
        val categories: List<CategoryModel> = cocktailService.findCategoriaByNameXml(text)
        val adapterCocktail = CategoryRecyclerAdapter(categories, requireContext())
        val linearLayoutManager = LinearLayoutManager(_binding?.root!!.context, LinearLayoutManager.VERTICAL, false)

        _binding!!.recicleViewCocktail.layoutManager = linearLayoutManager
        _binding!!.recicleViewCocktail.adapter = adapterCocktail
    }
}