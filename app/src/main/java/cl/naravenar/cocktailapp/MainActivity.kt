package cl.naravenar.cocktailapp

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import cl.naravenar.cocktailapp.databinding.ActivityMainBinding
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


        //TODO -> Ocultar boton del menu por ahora ya que estas secciones no estan disponibles
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.menu.findItem(R.id.navigation_pizza).isVisible = false
        bottomNav.menu.findItem(R.id.navigation_coffee).isVisible = false

        // Passing each menu ID as a set of Ids because each menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_cocktail, R.id.navigation_pizza, R.id.navigation_coffee
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        //navView.visibility = View.GONE
    }

    fun hidenNavView(){
        val navView: BottomNavigationView = binding.bottomNavigation
        navView.visibility = View.GONE
    }

    fun showNavView(){
        val navView: BottomNavigationView = binding.bottomNavigation
        navView.visibility = View.VISIBLE
    }


}