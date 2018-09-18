package br.edu.unisep.minhasmusicas.api

import android.widget.Toast
import br.edu.unisep.minhasmusicas.vo.ArtistaVO
import br.edu.unisep.minhasmusicas.vo.MusicaVO
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MinhasMusicasAPI {

    private val SERVER = "http://172.16.133.53:8080/minhasMusicas/ws"

    fun listarArtistas( funRetorno : (List<ArtistaVO>) -> Unit ) { //recebe um list tipo void e nao retorna nada
        val ws = "${SERVER}/artistas/listar"
        val req = StringRequest(Request.Method.GET, ws,
                Response.Listener { retorno ->
                    val g = Gson()
                    val tipo = object : TypeToken<List<ArtistaVO>> () {}.type
                    val lista = g.fromJson<List<ArtistaVO>>(retorno,tipo)

                    funRetorno(lista)
                },
                Response.ErrorListener { erro ->
                    erro.printStackTrace()
                })
        AppQueue.addToQueue(req)
    }

    fun listarMusicas(artista : Int, funRetorno : (List<MusicaVO>) -> Unit){
        val ws = "${SERVER}/musicas/listar?artista=" + artista
        val req = StringRequest(Request.Method.GET, ws,
                Response.Listener { retorno ->
                    val g = Gson()
                    val tipo = object : TypeToken<List<MusicaVO>> () {}.type
                    val lista = g.fromJson<List<MusicaVO>>(retorno,tipo)

                    funRetorno(lista)
                },
                Response.ErrorListener { erro ->
                    erro.printStackTrace()
                })
        // val q = Volley.newRequestQueue(this) //cria um novo requestqueue para um contexto atual
        //  q.add(req)
        AppQueue.addToQueue(req)
    }
}