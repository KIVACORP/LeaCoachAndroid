package kiva.com.pe.tutorapp

import com.androidnetworking.AndroidNetworking
import com.orm.SugarApp

class LeacoachApp :SugarApp(){

    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(getApplicationContext())

    }
}