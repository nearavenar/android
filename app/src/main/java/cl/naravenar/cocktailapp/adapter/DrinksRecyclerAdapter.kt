package cl.naravenar.cocktailapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import cl.naravenar.cocktailapp.MainActivity
import cl.naravenar.cocktailapp.R
import cl.naravenar.cocktailapp.model.DrinkModel
import cl.naravenar.cocktailapp.utils.DrinkUtil

class DrinksRecyclerAdapter (private var cocktailsList: List<DrinkModel>, private var context: Context) : RecyclerView.Adapter<DrinksRecyclerAdapter.CocktailDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailDetailViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_view_cocktail_detail, parent, false)
        val evh = CocktailDetailViewHolder(view)
        return evh
    }

    override fun getItemCount(): Int {
        return cocktailsList.size
    }

    override fun onBindViewHolder(holder: CocktailDetailViewHolder, position: Int) {
        val drinkModel: DrinkModel = cocktailsList[position]
        holder.title.text = drinkModel.getName()
        holder.title.setTextAppearance(android.R.style.TextAppearance_Holo)

        holder.ingredients.text = DrinkUtil().ingredientDrink(drinkModel.getIngredients())
        holder.preparation.text = drinkModel.getPreparation()

        var defaultValue = true
        holder.cardViewDetail.setOnClickListener{

            holder.title.setTextAppearance(DrinkUtil().typeFont(defaultValue))
            holder.preparation.maxLines = DrinkUtil().maxLines(3, holder.preparation.maxLines, drinkModel.getPreparation())
            holder.drinkDescription.maxLines = DrinkUtil().maxLines(2, holder.drinkDescription.maxLines, drinkModel.getDescription())
            holder.ingredients.maxLines = DrinkUtil().maxLines(4, holder.ingredients.maxLines, drinkModel.getIngredients().toString())
            defaultValue=!defaultValue
        }

        holder.imgShare.setOnClickListener{
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain" // Set MIME type as per the data you are sharing
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here") // Optional subject if sharing as email
            sharingIntent.putExtra(Intent.EXTRA_TEXT,  DrinkUtil().shareFormater(drinkModel))// Actual data to share
            context.startActivity(Intent.createChooser(sharingIntent,context.getString(R.string.app_name)))
        }

        val resourceId = context.resources.getIdentifier(drinkModel.getImage(), "mipmap", context.packageName)
        if (resourceId != 0) {
            holder.imgDrink.setImageResource(resourceId)
        } else {
            holder.imgDrink.setImageResource(R.mipmap.ic_pina_colada_cocktail_round)
        }

        holder.drinkDescription.text = drinkModel.getDescription()

        //holder.ratingBarDrink.rating = 4.5f
        holder.tvRatingBarDrink.visibility = View.GONE
        holder.ratingBarDrink.visibility = View.GONE
    }

    class CocktailDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tv_cocktail_detail_title)
        var ingredients: TextView = itemView.findViewById(R.id.tv_cocktail_detail_ingredients)
        var preparation: TextView = itemView.findViewById(R.id.tv_cocktail_detail_preparation)
        var cardViewDetail: ConstraintLayout = itemView.findViewById(R.id.card_view_detail)
        var imgShare: ImageView = itemView.findViewById(R.id.img_share_view)
        var imgDrink: ImageView = itemView.findViewById(R.id.img_drink_card_view)
        var drinkDescription: TextView = itemView.findViewById(R.id.tv_drink_description)
        var ratingBarDrink: RatingBar = itemView.findViewById(R.id.rating_bar_rink)
        var tvRatingBarDrink: TextView = itemView.findViewById(R.id.tv_rating_bar_rink)
        //var description: TextView = itemView.findViewById(R.id.tv_cocktail_detail_description)
        //var layout: LinearLayout = itemView.findViewById(R.id.cv_adapter_cocktail_detail)
    }
}