package cl.naravenar.cocktailapp.adapter

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import cl.naravenar.cocktailapp.R
import cl.naravenar.cocktailapp.model.PizzaModel
import cl.naravenar.cocktailapp.shared.PizzaStorage
import cl.naravenar.cocktailapp.utils.DrinkUtil
import cl.naravenar.cocktailapp.utils.PizzaUtil
import com.bumptech.glide.Glide

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
        setViewInit(holder, pizzaModel)
        cardViewDetail(holder, pizzaModel)
        clickFavorite(holder, pizzaModel)
        btnImgShare(holder, pizzaModel)
        createImage(pizzaModel, holder)
        rationButton(holder, pizzaModel)
        showFullImage(holder, pizzaModel)

        /*holder.btnOrderByFavorite.setOnClickListener {
            val favorite = !pizzaModel.getFavorite()
            pizzasList.sortedByDescending { favorite }
        }*/
    }

    private fun setViewInit(
        holder: PizzaViewHolderViewHolder,
        pizzaModel: PizzaModel
    ) {
        holder.title.text = pizzaModel.getName()
        holder.title.setTextAppearance(android.R.style.TextAppearance_Holo)
        holder.ingredients.text = DrinkUtil().ingredientDrink(pizzaModel.getIngredients())
        holder.preparation.text = pizzaModel.getPreparation()
        holder.pizza_size.text = PizzaUtil().textSizePizza(context, pizzaModel, 1)
        holder.btnFavorite.isChecked = pizzaModel.getFavorite()
        holder.drinkDescription.text = pizzaModel.getDescription()
    }

    private fun cardViewDetail(
        holder: PizzaViewHolderViewHolder,
        pizzaModel: PizzaModel
    ) {
        var defaultValue = true
        holder.cardViewDetail.setOnClickListener {

            holder.title.setTextAppearance(DrinkUtil().typeFont(defaultValue))
            holder.preparation.maxLines =
                DrinkUtil().maxLines(3, holder.preparation.maxLines, pizzaModel.getPreparation())
            holder.drinkDescription.maxLines = DrinkUtil().maxLines(
                2,
                holder.drinkDescription.maxLines,
                pizzaModel.getDescription()
            )
            holder.ingredients.maxLines = DrinkUtil().maxLines(
                4,
                holder.ingredients.maxLines,
                pizzaModel.getIngredients().toString()
            )
            defaultValue = !defaultValue
        }
    }

    private fun clickFavorite(
        holder: PizzaViewHolderViewHolder,
        pizzaModel: PizzaModel
    ) {
        holder.btnFavorite.setOnClickListener {
            //Toast.makeText(context, "Favorite: "+ holder.btnFavorite.isChecked, Toast.LENGTH_LONG).show()
            pizzaModel.setFavorite(!pizzaModel.getFavorite())
            PizzaStorage.toggleFavorite(context, pizzaModel.getId())
        }
    }

    private fun btnImgShare(
        holder: PizzaViewHolderViewHolder,
        pizzaModel: PizzaModel
    ) {
        holder.imgShare.setOnClickListener {
            var value: Int = holder.tv_count_button.text.toString().toIntOrNull() ?: 1
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain" // Set MIME type as per the data you are sharing
            sharingIntent.putExtra(
                Intent.EXTRA_SUBJECT,
                "Subject Here"
            ) // Optional subject if sharing as email
            sharingIntent.putExtra(
                Intent.EXTRA_TEXT,
                PizzaUtil().shareFormater(pizzaModel, value)
            )// Actual data to share
            context.startActivity(
                Intent.createChooser(
                    sharingIntent,
                    context.getString(R.string.app_name)
                )
            )
        }
    }

    private fun createImage(
        pizzaModel: PizzaModel,
        holder: PizzaViewHolderViewHolder
    ) {
        val resourceId =
            context.resources.getIdentifier(pizzaModel.getImage(), "mipmap", context.packageName)
        if (resourceId != 0) {
            holder.imgPizza.setImageResource(resourceId)
        } else {
            holder.imgPizza.setImageResource(R.mipmap.ic_pizza)
        }
    }

    private fun showFullImage(holder: PizzaViewHolderViewHolder, pizzaModel: PizzaModel) {
        holder.imgPizza.setOnLongClickListener {
            val dialog = Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
            dialog.setContentView(R.layout.dialog_fullscreen_image)

            val fullscreenImageView = dialog.findViewById<ImageView>(R.id.fullscreenImageView)

            // Obtener el ID del recurso desde el nombre
            val imageResId = context.resources.getIdentifier(
                pizzaModel.getImage(), "drawable", context.packageName
            )

            // Usar Glide para cargar la imagen
            Glide.with(context)
                .load(imageResId)
                .into(fullscreenImageView)

            // Cerrar el diálogo al hacer click
            fullscreenImageView.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
            true
        }
    }

    private fun rationButton(holder: PizzaViewHolderViewHolder, pizzaModel: PizzaModel) {
        var value: Int = holder.tv_count_button.text.toString().toIntOrNull() ?: 1

        validateCount(value, holder)
        holder.add_button.setOnClickListener {
            value++
            setValues(holder, value, pizzaModel)
        }

        holder.subtract_button.setOnClickListener {
            value--
            setValues(holder, value, pizzaModel)
            validateCount(value, holder)
        }

        holder.subtract_button.setOnLongClickListener {
            value = 1
            setValues(holder, value, pizzaModel)
            validateCount(value, holder)
            true
        }
    }

    private fun setValues(holder: PizzaViewHolderViewHolder, value: Int, pizzaModel: PizzaModel) {
        holder.subtract_button.isEnabled = true
        holder.tv_count_button.text = value.toString();
        holder.ingredients.text = DrinkUtil().ingredientCantPizza(pizzaModel.getIngredients(), value)
        holder.pizza_size.text = PizzaUtil().textSizePizza(context, pizzaModel, value)
    }


    private fun validateCount(value: Int, holder: PizzaViewHolderViewHolder) {
        if (value <= 1) {
            holder.subtract_button.isEnabled = false
        }
    }

    class PizzaViewHolderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tv_pizza_title)
        var ingredients: TextView = itemView.findViewById(R.id.tv_pizza_ingredients)
        var preparation: TextView = itemView.findViewById(R.id.tv_pizza_preparation)
        var cardViewDetail: ConstraintLayout = itemView.findViewById(R.id.card_view_pizza)
        var imgShare: ImageView = itemView.findViewById(R.id.img_share_view_pizza)
        var imgPizza: ImageView = itemView.findViewById(R.id.img_drink_card_view_pizza)
        var drinkDescription: TextView = itemView.findViewById(R.id.tv_pizza_description)
        var btnFavorite: CheckBox = itemView.findViewById(R.id.chb_favorite_item_card_pizza)
        var pizza_size: TextView = itemView.findViewById(R.id.tv_pizza_size)

        var subtract_button: Button = itemView.findViewById(R.id.subtract_button)
        var add_button: Button = itemView.findViewById(R.id.add_button)
        var tv_count_button: TextView = itemView.findViewById(R.id.tv_count_button)
        //var btnOrderByFavorite: ImageView = itemView.findViewById(R.id.btn_order_by_favorite_pizza)
    }
}