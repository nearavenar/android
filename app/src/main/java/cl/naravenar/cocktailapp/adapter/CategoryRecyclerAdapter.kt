package cl.naravenar.cocktailapp.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import cl.naravenar.cocktailapp.R
import cl.naravenar.cocktailapp.model.CategoryModel
import cl.naravenar.cocktailapp.model.DrinkModel
import cl.naravenar.cocktailapp.service.CocktailService
import cl.naravenar.cocktailapp.ui.cocktail.detail.DrinkFragment
import cl.naravenar.cocktailapp.utils.DrinkUtil
import com.google.android.material.textfield.TextInputEditText

class CategoryRecyclerAdapter(cocktailsList: List<CategoryModel>, context: Context) : RecyclerView.Adapter<CategoryRecyclerAdapter.CocktailViewHolder>() {

    private var cocktailsList: List<CategoryModel> = cocktailsList
    private var context:Context = context
    lateinit var cocktailService : CocktailService

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        cocktailService = CocktailService(context)
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_view_cocktail, parent, false)
        val evh: CategoryRecyclerAdapter.CocktailViewHolder = CategoryRecyclerAdapter.CocktailViewHolder(view)
        return evh
    }

    override fun getItemCount(): Int {
        return cocktailsList.size
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        var category:CategoryModel = cocktailsList.get(position)

        //cocktailService.listCocktails()
        /*
        val cocktailsList: MutableList<DrinkModel> = cocktailService.getAllDrinks()
        var aux:String = ""
        for (drink in cocktailsList){
            if (category.getId() == drink.getCategory().getId()){
                aux+=drink.getName()
            }else{
                aux=drink.getName()
            }
            Log.i("NEAR_APP","dink:"+aux+", category:"+drink.getCategory().getId())
            //Log.i("NEAR_APP","Drink:"+drink.getName() + ", Category:"+drink.getCategory().getName())
        }
         */


        //var drink = cocktailService.findDrinkByIdCategoriaXml(category.getId())
        var drink = DrinkModel()

        val resourceId = context.resources.getIdentifier(category.getImage(), "mipmap", context.packageName)
        if (resourceId != 0) {
            holder.imgCategory.setImageResource(resourceId)
        } else {
            holder.imgCategory.setImageResource(R.mipmap.ic_pina_colada_cocktail_round)
        }


        var descripction= cocktailService.findDrinkByIdCategoria(category.getId())

        holder.cocktailTitle.text = category.getName()
        if (drink != null) {
            holder.cocktailDescription.text = DrinkUtil().detailsDrinks(descripction)
        }

        holder.layout.setOnClickListener {
            val fragmentManager = (context as AppCompatActivity).supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            val fragment = DrinkFragment()

            val bundle = Bundle().apply {
                putParcelable("cocktailModel", category)
            }

            fragment.arguments = bundle

            //fragmentTransaction.remove(CocktailFragment())
            fragmentTransaction.replace(R.id.activity_main_container, fragment)
            fragmentTransaction.addToBackStack(null)  // Opcional: para agregar a la pila de retroceso
            fragmentTransaction.commit()

            //Snackbar.make(holder.itemView, "ID: ${cocktailModel.getId()}", Snackbar.LENGTH_LONG).show()
        }

    }

    class CocktailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val cocktailTitle: TextView = itemView.findViewById(R.id.tv_cocktail_title)
        internal val cocktailDescription: TextView = itemView.findViewById(R.id.tv_cocktail_description)
        internal val layout: RelativeLayout = itemView.findViewById(R.id.cv_adapter_cocktail)
        internal val imgCategory: ImageView = itemView.findViewById(R.id.img_cocktail)

        /*fun bind(thread: CategoryModel) {
            cocktailTitle.text = thread.getName()
            cocktailDescription.text = thread.getName()
            //imgCategory
        }*/
    }
}