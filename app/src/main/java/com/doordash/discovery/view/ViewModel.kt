package com.doordash.discovery.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.doordash.discovery.WebServices.NetworkHelper
import com.doordash.discovery.models.Stores
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ViewModel (context: Application) : AndroidViewModel(context) {

    private var listaProyectos= MutableLiveData<Stores.ListofStores>()
   // private val Disposable= ArrayList<Disposable>()
   private val Disposable: CompositeDisposable? = CompositeDisposable()

    fun getData(limit:Int) {

        var obs = NetworkHelper.createGitHubAPI().getRestaurants("37.422740","-122.139956","0",limit.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{
                Disposable!!.add(it)
            }
            .doOnError {
                var t = 0
            }
            .doOnNext { data ->

                        listaProyectos.value= data

            }
            .subscribe()
    }


     fun getObservable(): MutableLiveData<Stores.ListofStores> {
        return listaProyectos
    }


    override fun onCleared() {
        Disposable!!.clear()
    }

}