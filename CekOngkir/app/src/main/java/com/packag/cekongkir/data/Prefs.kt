package com.packag.cekongkir.data

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {

    val prefsName   = "app.cekongkir.prefs"
    val oriId       = "origin_id"
    val oriName     = "origin_name"
    val destId      = "dest_id"
    val destName    = "origin_name"

    val sharedPreferences: SharedPreferences = context.getSharedPreferences(prefsName,0)

    var originId : String
        get()   = sharedPreferences.getString(oriId,"")
        set(value) = sharedPreferences.edit().putString(oriId, value).apply()

    var originName : String
        get()   = sharedPreferences.getString(oriName,"")
        set(value) = sharedPreferences.edit().putString(oriName, value).apply()

    var destinationId : String
        get()   = sharedPreferences.getString(destId,"")
        set(value) = sharedPreferences.edit().putString(destId, value).apply()

    var destinationName : String
        get()   = sharedPreferences.getString(destName,"")
        set(value) = sharedPreferences.edit().putString(destName, value).apply()


}