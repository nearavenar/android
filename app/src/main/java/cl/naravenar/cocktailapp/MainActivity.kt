package cl.naravenar.cocktailapp

import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import cl.naravenar.cocktailapp.config.StoreDatabase
import cl.naravenar.cocktailapp.dao.CategoryDao
import cl.naravenar.cocktailapp.databinding.ActivityMainBinding
import cl.naravenar.cocktailapp.model.CategoryModel
import cl.naravenar.cocktailapp.model.DrinkModel
import cl.naravenar.cocktailapp.model.IngredientModel
import cl.naravenar.cocktailapp.model.UnitMeasurementModel
import cl.naravenar.cocktailapp.service.CocktailService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val cocktailService : CocktailService = CocktailService(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNavigation

        val navController = findNavController(R.id.activity_main_container)
        // Passing each menu ID as a set of Ids because each menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_cocktail, R.id.navigation_pizza, R.id.navigation_coffee
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //navView.visibility = View.GONE

        //replaceFragment(IndexFragment())

        //createCategory()
        //createDrinks()
    }

    fun hidenNavView(){
        val navView: BottomNavigationView = binding.bottomNavigation
        navView.visibility = View.GONE
    }

    fun showNavView(){
        val navView: BottomNavigationView = binding.bottomNavigation
        navView.visibility = View.VISIBLE
    }

    fun createCategory(){
        Thread {
            cocktailService.createCategory(CategoryModel(1, resources.getString(R.string.title_category_rum),true,"ic_while_run_category"))
            cocktailService.createCategory(CategoryModel(2, resources.getString(R.string.title_category_vodka),true,"ic_vodka_category"))
            cocktailService.createCategory(CategoryModel(3, resources.getString(R.string.title_category_ginebra),true,"ic_gin_category"))
            cocktailService.createCategory(CategoryModel(4, resources.getString(R.string.title_category_pisco),true,"ic_pisco_category"))
            cocktailService.createCategory(CategoryModel(5, resources.getString(R.string.title_category_whisky),true,"ic_wisky_category"))
            cocktailService.createCategory(CategoryModel(6, resources.getString(R.string.title_category_tequila),true,"ic_tequila_category"))
            cocktailService.createCategory(CategoryModel(7, resources.getString(R.string.title_category_aperol),true,"ic_aperol_category"))
            cocktailService.createCategory(CategoryModel(8, resources.getString(R.string.title_category_ramazzotti),true,"ic_ramazzotti_category"))
        }.start()
    }

    fun createUnitMeasurement(){
        Thread{
            UnitMeasurementModel(1,"ml")
            UnitMeasurementModel(2,"oz")
            UnitMeasurementModel(3,"dash")
            UnitMeasurementModel(4,"cube")
            UnitMeasurementModel(5,"frappe")
        }.start()
    }

    fun createDrinks(){
        Thread{
            createMojito()
            createMaracuyaMojito()
            createDaiquiri()
        }.start()
    }

    fun createMojito(){
        var categoryRum = cocktailService.getCategoryById(1)

        var unitMeasSheet = UnitMeasurementModel(3,"hojas")
        var unitMeasOz = UnitMeasurementModel(2,"oz")
        var unitMeasFrappe = UnitMeasurementModel(4,"Frappe")
        var unitMeasToCrown = UnitMeasurementModel(4,"Coronar")


        /*
        var ingedients = resources.getString(R.string.drink_ingredients_mojito)

        var aux = ingedients.split("\n")
        var a = 1
         */


        var ingrdients = listOf(IngredientModel(1,"Menta ", "5",unitMeasSheet),
            IngredientModel(2,"Goma","1",unitMeasOz),
            IngredientModel(3,"Lemon Juice","1",unitMeasOz),
            IngredientModel(4,"Hielo Frappe","2",unitMeasFrappe),
            IngredientModel(5,"Ron Blanco o Dorado","2",unitMeasOz),
            IngredientModel(6,"Agua mineral","0",unitMeasToCrown))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName(resources.getString(R.string.drink_name_mojito))
        //drinkModelMojito.setImage(resources.getString(R.mipmap.ic_mojito_drink))
        drinkModelMojito.setImage("ic_mojito_drink")
        drinkModelMojito.setPreparation(resources.getString(R.string.drink_preparation_mojito))
        drinkModelMojito.setDescription("DESCRIPCION DEL TRAGO")
        drinkModelMojito.setIngredients(ingrdients)
        drinkModelMojito.setCategory(categoryRum)

        cocktailService.createDrink(drinkModelMojito)
    }

    fun createMaracuyaMojito(){
        var categoryRum = cocktailService.getCategoryById(1)

        var unitMeasSheet = UnitMeasurementModel(3,"hojas")
        var unitMeasOz = UnitMeasurementModel(2,"oz")
        var unitMeasFrappe = UnitMeasurementModel(4,"Frappe")
        var unitMeasToCrown = UnitMeasurementModel(4,"Coronar")

        var ingrdients = listOf(IngredientModel(1,"Menta ", "5",unitMeasSheet),
            IngredientModel(2,"Goma","1",unitMeasOz),
            IngredientModel(3,"Lemon Juice","1",unitMeasOz),
            IngredientModel(4,"Hielo Frappe","2",unitMeasFrappe),
            IngredientModel(5,"Ron Blanco o Dorado","2",unitMeasOz),
            IngredientModel(6,"Pulpa de maracuyá","0",unitMeasOz),
            IngredientModel(7,"Agua mineral","0",unitMeasToCrown))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(3)
        drinkModelMojito.setName("Mojito Maracuya")
        drinkModelMojito.setImage("ic_mojito_drink")
        drinkModelMojito.setPreparation("Preparación:\nEn un vaso tumbler, primero agregar menta (golpear la menta), 1 oz de Goma, 1 oz jugo de limón natural, amanerar suavemente para no romper las hojas, llenar el vaso con hielo frappe, 2 oz de ron, agregar 4 cucharadas de pulpa de maracuyá y revolver tratando de subir la menta y llenar con agua mineral con gas.")
        drinkModelMojito.setDescription("DESCRIPCION DEL TRAGO")
        drinkModelMojito.setIngredients(ingrdients)
        drinkModelMojito.setCategory(categoryRum)

        cocktailService.createDrink(drinkModelMojito)
    }

    fun createDaiquiri(){

        var categoryRum = cocktailService.getCategoryById(1)

        var unitMeasOz = UnitMeasurementModel(2,"oz")
        var unitMeasCube = UnitMeasurementModel(4,"Cubo")
        var unitMeasToDash = UnitMeasurementModel(4,"Dash")

        var ingrdients = listOf(IngredientModel(1,"Goma","1",unitMeasOz),
            IngredientModel(2,"Lemon Juice","1",unitMeasOz),
            IngredientModel(3,"Ron Blanco o Dorado","2",unitMeasOz),
            IngredientModel(4,"Hielo Cubo","2",unitMeasCube),
            IngredientModel(5,"Triple SEx","1",unitMeasToDash))

        var drinkModelMojito = DrinkModel()
        drinkModelMojito.setId(1)
        drinkModelMojito.setName("Daiquiri")
        drinkModelMojito.setImage("ic_daiquiri_drink")
        drinkModelMojito.setPreparation("Preparación:\nEn una coctelera agregar 1 oz jugo de limón natural, 1 oz de Goma, 2 oz de ron, 1 Dash de Triple Sec. (un toque). Agregar 2 o 3 hielos, luego mesclar (Cuando la coctelera esta empavonada [fría]).")
        drinkModelMojito.setDescription("DESCRIPCION DEL TRAGO")
        drinkModelMojito.setIngredients(ingrdients)
        drinkModelMojito.setCategory(categoryRum)
        cocktailService.createDrink(drinkModelMojito)
    }

    fun deleteFragment(fragment: Fragment){

        val fragmentManagerM = supportFragmentManager
        val fragmentTransaction = fragmentManagerM.beginTransaction()
        fragmentTransaction.remove(fragment)
        //fragmentTransaction.addToBackStack(null)  // Opcional: para agregar a la pila de retroceso
        fragmentTransaction.commit()
    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_main_container, fragment)
            .commit()
    }
}