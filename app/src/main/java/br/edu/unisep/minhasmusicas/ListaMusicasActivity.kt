package br.edu.unisep.minhasmusicas

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import br.edu.unisep.minhasmusicas.adapter.ArtistaAdapter
import br.edu.unisep.minhasmusicas.adapter.MusicaAdapter
import br.edu.unisep.minhasmusicas.api.AppQueue
import br.edu.unisep.minhasmusicas.api.MinhasMusicasAPI
import br.edu.unisep.minhasmusicas.vo.ArtistaVO
import br.edu.unisep.minhasmusicas.vo.MusicaVO
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_lista_musicas.*

class ListaMusicasActivity : AppCompatActivity() {

    private var adapter : MusicaAdapter? = null

    private var artista : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_musicas)

        adapter = MusicaAdapter(this)
        listaMusicas.adapter = adapter

        artista = intent.getIntExtra("ARTISTA",-1)

        obterListaMusicas()
    }
    fun obterListaMusicas(){
        val api = MinhasMusicasAPI()
        api.listarMusicas(artista, this::exibirLista)
    }

    fun exibirLista(lista : List<MusicaVO>){
        //recebe a lista retornada do server e atualiza a tela
        adapter!!.clear()
        adapter!!.addAll(lista)
        adapter!!.notifyDataSetChanged()
    }
}