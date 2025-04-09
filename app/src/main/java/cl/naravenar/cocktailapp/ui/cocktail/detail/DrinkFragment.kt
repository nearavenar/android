package cl.naravenar.cocktailapp.ui.cocktail.detail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import cl.naravenar.cocktailapp.adapter.CategoryRecyclerAdapter
import cl.naravenar.cocktailapp.adapter.DrinkPreparationImgRecyclerAdapter
import cl.naravenar.cocktailapp.adapter.DrinksRecyclerAdapter
import cl.naravenar.cocktailapp.databinding.FragmentCocktailDetailBinding
import cl.naravenar.cocktailapp.model.CategoryModel
import cl.naravenar.cocktailapp.model.DrinkModel
import cl.naravenar.cocktailapp.model.DrinkPhotoPreparationModel
import cl.naravenar.cocktailapp.model.IngredientModel
import cl.naravenar.cocktailapp.service.CocktailService

class DrinkFragment : Fragment() {

    private var _binding: FragmentCocktailDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val cocktailService = CocktailService(requireContext())
        var categoryodel: CategoryModel

        arguments.let {
            categoryodel = if (it != null) {
                arguments?.getParcelable("cocktailModel")!!
            } else {
                CategoryModel()
            }
        }



        //Buscar los tragos por ID de category

        /*val cocktailDetailViewModel: CocktailDetailViewModel by viewModels {
            CocktailDetailViewModelFactory(drinkModel)
        }*/

        _binding = FragmentCocktailDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val tvPreparation: TextView = binding.tvCocktailDetailPreparation
        //val tvIngredients: TextView = binding.tvCocktailDetailIngredients

        /*
        cocktailDetailViewModel.tvCocktailIngredients.observe(viewLifecycleOwner) {
            tvIngredients.text = it
        }

        cocktailDetailViewModel.tvCocktailPreparation.observe(viewLifecycleOwner) {
            tvPreparation.text = it
        }
         */



        //val cocktailService : CocktailService = CocktailService(requireContext())
        //val cocktailsList: List<DrinkModel> = cocktailService.getAllDrinks()
        //val adapterCocktailDetail: CocktailDetailsRecyclerAdapter = CocktailDetailsRecyclerAdapter(cocktailsList, requireContext())

        setDrinkList(root.context, cocktailService, categoryodel.getId())

/*
        val cocktailService : CocktailService = CocktailService(requireContext())
        val cocktailsList: List<DrinkModel> = cocktailService.findDrinkByIdCategoriaXml(categoryodel.getId())
        if(cocktailsList.isNotEmpty()){
            val adapterCocktailDetail: CocktailDetailsRecyclerAdapter = CocktailDetailsRecyclerAdapter(cocktailsList, requireContext())
            val linearLayoutManager = LinearLayoutManager(_binding?.root!!.context, LinearLayoutManager.VERTICAL, false)
            _binding!!.recicleViewCocktailDetail.layoutManager = linearLayoutManager
            _binding!!.recicleViewCocktailDetail.adapter = adapterCocktailDetail
        }else{
            Toast.makeText(root.context, "Sin Tragos para esta categoria", Toast.LENGTH_LONG).show()
        }*/

        return root
    }

    private fun setDrinkList(context:Context, cocktailService:CocktailService, id:Long){

            val cocktailsList: List<DrinkModel> = cocktailService.findDrinkByIdCategoriaXml(id)
            if(cocktailsList.isNotEmpty()){
                val adapterCocktailDetail: DrinksRecyclerAdapter = DrinksRecyclerAdapter(cocktailsList, requireContext())
                val linearLayoutManager = LinearLayoutManager(_binding?.root!!.context, LinearLayoutManager.VERTICAL, false)
                _binding!!.recicleViewCocktailDetail.layoutManager = linearLayoutManager
                _binding!!.recicleViewCocktailDetail.adapter = adapterCocktailDetail


                /*
                val categories: MutableList<CategoryModel> = cocktailService.getAllCategories()

                var drinkImg:DrinkPhotoPreparationModel = DrinkPhotoPreparationModel(1,"img1","ic_mojito_drink",cocktailsList[0])
                var ingredients = listOf(drinkImg)

                val adapterCocktail = DrinkPreparationImgRecyclerAdapter(ingredients, requireContext())
                val linearLayoutManager2 = LinearLayoutManager(_binding?.root!!.context, LinearLayoutManager.VERTICAL, false)

                _binding!!.recicleViewCocktail.linearLayoutManager2 = linearLayoutManager
                _binding!!.recicleViewCocktail.adapter = adapterCocktail

                 */

            }else{
                Toast.makeText(context, "Sin Tragos para esta categoria", Toast.LENGTH_LONG).show()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*
    fun getAllCategories(cocktailService : CocktailService):MutableList<CategoryModel> {
        var categoriesList:MutableList<CategoryModel> = mutableListOf()
        Thread {
            categoriesList = cocktailService.getAllCategories()
            for (vat in categoriesList){
                Log.i("NEAR_APP", "id:"+vat.getId()+",name"+vat.getName())
            }
        }.start()
        return categoriesList
    }*/

    /*
    fun getAllDrinksBD(cocktailService : CocktailService):MutableList<DrinkModel> {
        var drinksList:MutableList<DrinkModel> = mutableListOf()
        Thread {
            drinksList = cocktailService.getAllDrinks()
            for (vat in drinksList){
                Log.i("NEAR_APP", "DRINK:"+vat)
                val adapterCocktailDetail: CocktailDetailsRecyclerAdapter = CocktailDetailsRecyclerAdapter(drinksList, requireContext())
                _binding!!.recicleViewCocktailDetail.adapter = adapterCocktailDetail
            }
        }.start()
        return drinksList
    }
     */
}