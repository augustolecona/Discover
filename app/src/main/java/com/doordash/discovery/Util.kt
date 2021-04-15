package com.doordash.discovery

import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketException
import java.net.UnknownHostException

object Util {

    fun showError(throwable: Throwable): String {
        if (throwable is HttpException) {

            val code = (throwable as HttpException).code().toString()
            when (code) {
                "403" -> {

                    return "You have reached the limit of intents.. please try again in a couple of minutes "

                }
                "404" -> {

                    return "We can't find that page "

                }
                "409" -> {

                }
                "400, 422" -> {
                    return "There's something wrong  with your search"

                }

                else -> {
                        return "unknown error"
                }
            }
        } else {
             if (throwable is ConnectException || throwable is SocketException || throwable is UnknownHostException) {
                return    "There's a problem with the network. Please verify your network "


            } else {
                return "Something went wrong =( "
            }
        }
        return ""
    }
}