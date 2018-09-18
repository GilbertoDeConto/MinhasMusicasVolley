package br.edu.unisep.minhasmusicas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import br.edu.unisep.minhasmusicas.R
import br.edu.unisep.minhasmusicas.vo.ArtistaVO
import kotlinx.android.synthetic.main.item_artista.view.*

class ArtistaAdapter(context: Context)
    : ArrayAdapter<ArtistaVO>(context, 0) {


    private val inflater = LayoutInflater.from(context)
//pra pegar o id do objeto , usa sempre que tiver selecao de item da lista
    override fun getItemId(position: Int): Long {
         var artista = getItem(position)
        return artista!!.id!!.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val item = inflater.inflate(R.layout.item_artista, null)
        val a = getItem(position)

        item!!.lblArtista.text = a.nome

        return item
    }

}