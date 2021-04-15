package com.doordash.discovery.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.doordash.discovery.R
import com.doordash.discovery.Util
import com.doordash.discovery.database.DatabaseHelper
import com.doordash.discovery.models.Stores
import com.doordash.discovery.view.adapters.RestaurantlistAdapter
import com.google.gson.Gson
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins
import java.lang.Exception
import java.lang.NumberFormatException


class MainActivity : AppCompatActivity() {

    private val Disposable= ArrayList<Disposable>()
    private var counter= 0
    lateinit var recycleView: RecyclerView
    var restaurants =Stores.ListofStores()
    lateinit var adapter: RestaurantlistAdapter
    lateinit var textView: TextView
    lateinit var progressbarlayout: View
    lateinit var searchView: SearchView
    lateinit var modelView: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        castViews()
        modelView = ViewModelProviders.of(this).get(ViewModel::class.java)

        modelView.getData(10)
        progressbarlayout.visibility = View.VISIBLE


        val nameObserver = Observer<Stores.ListofStores> { CLICKED ->

            restaurants.copyfrom(CLICKED)
            adapter.notifyDataSetChanged()
            progressbarlayout.visibility = View.INVISIBLE
        }

        modelView.getObservable().observe(this, nameObserver)



        var dataBaseHelper =
            DatabaseHelper(this)

        adapter = RestaurantlistAdapter(
            this,
            restaurants,
            dataBaseHelper
        )
        recycleView.adapter = adapter


        adapter.onItemClick = { store ->
            val intent = Intent(this, Restaurant::class.java)
            val gson = Gson()
            val storejson = gson.toJson(store)
            intent.putExtra("storejson", storejson)
            startActivity(intent)

        }


        RxJavaPlugins.setErrorHandler { throwable ->
            throwable.printStackTrace()
            progressbarlayout.visibility = View.INVISIBLE
            Toast.makeText(this,Util.showError(throwable), Toast.LENGTH_LONG).show()
            Log.e (this@MainActivity.javaClass.name, throwable.message)

        }


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                    makeRequest(query!!)
                    return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                makeRequest(newText!!)
                return false
            }

        })



    }

    private fun makeRequest(query:String) {
        progressbarlayout.visibility = View.VISIBLE
        try {
            modelView.getData(query!!.toInt())
        }catch(e: Exception){
            if (e is NumberFormatException)
                Toast.makeText(this@MainActivity, "Please input numbers only", Toast.LENGTH_LONG).show()
            //if something else goes wrong with the request  it will be handled by RxJavaPlugins.setErrorHandler
            Log.e (this@MainActivity.javaClass.name, e.message)
            progressbarlayout.visibility = View.INVISIBLE
        }
    }

    private fun castViews() {
        textView = findViewById(R.id.textView)
        recycleView = findViewById<RecyclerView>(R.id.recyclerView)
        recycleView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycleView.setLayoutManager(linearLayoutManager)

        progressbarlayout = findViewById(R.id.llProgressBar)
        searchView = findViewById(R.id.searchView)
    }






    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.info -> {
                AlertDialog.Builder(this)
                    .setTitle("Dicover")
                    .setMessage("Discover nearby restaurants, please enter the number of results you want, next to the loop")
                    .setPositiveButton(
                        android.R.string.yes,
                        DialogInterface.OnClickListener { dialog, which ->

                        })
                    .setIcon(R.drawable.discover)
                    .show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}