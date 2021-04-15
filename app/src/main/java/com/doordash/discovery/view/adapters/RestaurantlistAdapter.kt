package com.doordash.discovery.view.adapters

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doordash.discovery.database.DatabaseHelper
import com.doordash.discovery.R
import com.doordash.discovery.models.Stores
import kotlinx.android.synthetic.main.proyectoview.view.*


class RestaurantlistAdapter(
    val context: Context,
    val stores: Stores.ListofStores,
    val dataBaseHelper: DatabaseHelper
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClick: ((Stores.Store?) -> Unit)? = null

    override fun getItemCount(): Int {

        if  (stores.stores== null) return 0
        else return stores.stores!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.proyectoview, parent, false)
        )

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (stores.stores != null)
        (holder as ViewHolder).bind(stores!!.stores?.get(position), context)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(stores: Stores.Store?, context: Context) {
            itemView.restaurantName.text = stores!!.name!!
            Glide.with(context).load(stores.coverImgUrl!!).into(itemView.RestaurantImage)
            itemView.cucine.text = stores.description
            itemView.distance.text = Math.round(stores.distanceFromConsumer!!*4).toString() +" min"


            val getRestaurant: Cursor = dataBaseHelper.existsRestaurantsFav(stores.id)!!

            var restaurant_exists = false

            while (getRestaurant.moveToNext()) {
                restaurant_exists = getRestaurant.getInt(0) > 0
            }

            getRestaurant.close()
            if (restaurant_exists) itemView.favorite.setImageResource(R.drawable.favorite)
            else itemView.favorite.setImageResource(R.drawable.addfav)

            itemView.favorite.setOnClickListener {

                  val InsertUser: Boolean = dataBaseHelper.SaveRestaurant(stores)
                  if (InsertUser) {
                      itemView.favorite.setImageResource(R.drawable.favorite)
                  } else {
                      //toastMessage("Soemthing went wrong")
                  }

                  }


        }

        init {
            itemView.setOnClickListener {
                  onItemClick?.invoke(stores!!.stores?.get(position))
            }
        }
    }

}

