package com.doordash.discovery.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.doordash.discovery.R
import com.doordash.discovery.models.Stores
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_restaurant_view.*


class Restaurant : AppCompatActivity() {




    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_view)
        var store: Stores.Store? = null
        try{
            val gson = Gson()
             store = gson.fromJson<Stores.Store>(
                intent.getStringExtra("storejson"), Stores.Store::class.java
            )
        }
        catch (e:Exception){
            Log.e("#ERROR", e.message)
        }

        if (store!= null) {
            if (store.coverImgUrl!=null)Glide.with(this).load(store.coverImgUrl).into(RestauranTImage)
            if (store.name!=null)            RestaurnatName.text = "${store.name}"
            if (store.distanceFromConsumer!=null)      distance.text = "Distance: ${Math.round(store.distanceFromConsumer!!*4).toString() +" min"}"
            if (store.averageRating!=null) rating.text = "Rating: ${store.averageRating.toString()}"
            if (store.description!=null)     description.text = "About: ${store.description}"
            if (store.url!= null)             url.text = "website: ${store.url}"
        }




    }
}