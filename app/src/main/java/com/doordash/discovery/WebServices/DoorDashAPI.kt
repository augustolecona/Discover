package com.doordash.discovery.WebServices

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import com.doordash.discovery.models.Stores


interface DoorDashAPI {


    @GET("v1/store_feed/")
    fun getRestaurants(
        @Query("lat") lat: String?,
        @Query("lng")  lng: String?,
         @Query("offset")  offset: String?,
        @Query("limit")  limit: String?
    ): Observable<Stores.ListofStores>
}



