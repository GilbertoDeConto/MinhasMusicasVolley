package br.edu.unisep.minhasmusicas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.edu.unisep.minhasmusicas.adapter.ArtistaAdapter
import br.edu.unisep.minhasmusicas.api.AppQueue
import br.edu.unisep.minhasmusicas.api.MinhasMusicasAPI
import br.edu.unisep.minhasmusicas.vo.ArtistaVO
import br.edu.unisep.minhasmusicas.vo.MusicaVO
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_lista_musicas.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter : ArtistaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArtistaAdapter(this)
        listaArtistas.adapter = adapter

        listaArtistas.setOnItemClickListener{parent, view, position, id ->
            val i = Intent(this,ListaMusicasActivity::class.java)
            i.putExtra("ARTISTA", id.toInt())
            startActivityForResult(i,2)
        }

        AppQueue.startQueue(applicationContext)//appcontext vai valer pra todas as activitys
        obterListaArtistas()
    }
    fun obterListaArtistas(){
        val api = MinhasMusicasAPI()
      /*  api.listarArtistas({ retorno ->
            exibirLista(retorno)
        })*/

        api.listarArtistas (this::exibirLista)
    }

    fun exibirLista(lista : List<ArtistaVO>){
        //recebe a lista retornada do server e atualiza a tela
        adapter!!.clear()
        adapter!!.addAll(lista)
        adapter!!.notifyDataSetChanged()
    }
}
