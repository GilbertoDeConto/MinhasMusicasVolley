package br.edu.unisep.minhasmusicas.api

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

open class AppQueue {
    companion object { //permite que apenas 1 objeto seja instanciado (como se fosse estatico)
        private var q : RequestQueue? = null

        fun startQueue(context : Context){
            if(q == null){
                q = Volley.newRequestQueue(context)
            }
        }

        fun <T> addToQueue(req : Request<T>){// t é o tipo generico ( qualquer coisa)
            q!!.add(req)
        }
    }
}