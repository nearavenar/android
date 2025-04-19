package cl.naravenar.cocktailapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import cl.naravenar.cocktailapp.R
import cl.naravenar.cocktailapp.model.PizzaModel
import cl.naravenar.cocktailapp.utils.DrinkUtil
import cl.naravenar.cocktailapp.utils.PizzaUtil

class PizzaRecyclerAdapter (private var pizzasList: List<PizzaModel>, private var context: Context) : RecyclerView.Adapter<PizzaRecyclerAdapter.PizzaViewHolderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolderViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_view_pizza, parent, false)
        val evh = PizzaViewHolderViewHolder(view)
        return evh
    }

    override fun getItemCount(): Int {
        return pizzasList.size
    }

    override fun onBindViewHolder(holder: PizzaViewHolderViewHolder, position: Int) {
        val pizzaModel: PizzaModel = pizzasList[position]
        holder.title.text = pizzaModel.getName()
        holder.title.setTextAppearance(android.R.style.TextAppearance_Holo)

        holder.ingredients.text = DrinkUtil().ingredientDrink(pizzaModel.getIngredients())
        holder.preparation.text = pizzaModel.getPreparation()
        holder.size.text = PizzaUtil().textSizePizza(context, pizzaModel)

        var defaultValue = true
        holder.cardViewDetail.setOnClickListener{

            holder.title.setTextAppearance(DrinkUtil().typeFont(defaultValue))
            holder.preparation.maxLines = DrinkUtil().maxLines(3, holder.preparation.maxLines, pizzaModel.getPreparation())
            holder.drinkDescription.maxLines = DrinkUtil().maxLines(2, holder.drinkDescription.maxLines, pizzaModel.getDescription())
            holder.ingredients.maxLines = DrinkUtil().maxLines(4, holder.ingredients.maxLines, pizzaModel.getIngredients().toString())
            defaultValue=!defaultValue
        }

       holder.imgShare.setOnClickListener{
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
            //sharingIntent.putExtra(Intent.EXTRA_TEXT,  DrinkUtil().shareFormater(drinkModel))
            //context.startActivity(Intent.createChooser(sharingIntent,context.getString(R.string.app_name)))
        }

        holder.btnFavorite.setOnClickListener{
            Toast.makeText(context, "Favorite: "+ holder.btnFavorite.isChecked, Toast.LENGTH_LONG).show()
        }

        val resourceId = context.resources.getIdentifier(pizzaModel.getImage(), "mipmap", context.packageName)
        if (resourceId != 0) {
            holder.imgDrink.setImageResource(resourceId)
        } else {
            holder.imgDrink.setImageResource(R.mipmap.ic_pina_colada_cocktail_round)
        }

        holder.drinkDescription.text = pizzaModel.getDescription()
    }

    class PizzaViewHolderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tv_pizza_title)
        var ingredients: TextView = itemView.findViewById(R.id.tv_pizza_ingredients)
        var preparation: TextView = itemView.findViewById(R.id.tv_pizza_preparation)
        var cardViewDetail: ConstraintLayout = itemView.findViewById(R.id.card_view_pizza)
        var imgShare: ImageView = itemView.findViewById(R.id.img_share_view_pizza)
        var imgDrink: ImageView = itemView.findViewById(R.id.img_drink_card_view_pizza)
        var drinkDescription: TextView = itemView.findViewById(R.id.tv_pizza_description)
        var btnFavorite: CheckBox = itemView.findViewById(R.id.chb_favorite_item_card_pizza)
        var size: TextView = itemView.findViewById(R.id.tv_pizza_size)
    }
}