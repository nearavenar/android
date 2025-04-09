package cl.naravenar.cocktailapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import cl.naravenar.cocktailapp.R
import cl.naravenar.cocktailapp.model.DrinkPhotoPreparationModel
import cl.naravenar.cocktailapp.service.CocktailService

class DrinkPreparationImgRecyclerAdapter(cocktailsList: List<DrinkPhotoPreparationModel>, context: Context) : RecyclerView.Adapter<DrinkPreparationImgRecyclerAdapter.CocktailViewHolder>() {

    private var drinkPhotoPreparationsList: List<DrinkPhotoPreparationModel> = cocktailsList
    private var context:Context = context
    lateinit var cocktailService : CocktailService

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_view_img_preparation, parent, false)
        val evh: CocktailViewHolder = CocktailViewHolder(view)
        return evh
    }

    override fun getItemCount(): Int {
        return drinkPhotoPreparationsList.size
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        val resourceId = context.resources.getIdentifier("ic_mojito_drink", "mipmap", context.packageName)
        if (resourceId != 0) {
            holder.imgPreparation.setImageResource(resourceId)
        } else {
            holder.imgPreparation.setImageResource(R.mipmap.ic_pina_colada_cocktail_round)
        }
    }

    class CocktailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val imgPreparation: ImageView = itemView.findViewById(R.id.img_drink_preparaion)
    }
}