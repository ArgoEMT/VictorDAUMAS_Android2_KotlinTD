package com.providence.rickandmorty_api_kotlin.ui.activity


import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.providence.rickandmorty_api_kotlin.R
import com.providence.rickandmorty_api_kotlin.Webservice
import com.providence.rickandmorty_api_kotlin.model.ListCocktail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DrawerActivity : AppCompatActivity(){

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var webservice: Webservice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.logout_button
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        fetchCharacters()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.drawer, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun fetchCharacters() {


        //*onCreate API
        webservice = Webservice()
        val list: Call<ListCocktail?>? = webservice.getService()?.getCocktail()

        list?.enqueue(object : Callback<ListCocktail?> {
            override fun onResponse(call: Call<ListCocktail?>, response: Response<ListCocktail?>) {
                Log.i("code", Integer.toString(response.code()))
                if (response.body() != null) {
                    for (i in response.body()!!.getCocktails()!!) {
                        println(i?.getName())
                    }
                }
            }

            override fun onFailure(call: Call<ListCocktail?>, t: Throwable) {
                Log.i("List", t.message!!)
            }
        })
    }
}