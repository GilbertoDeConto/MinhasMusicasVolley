package br.edu.unisep.minhasmusicas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import br.edu.unisep.minhasmusicas.R
import br.edu.unisep.minhasmusicas.vo.MusicaVO
import kotlinx.android.synthetic.main.item_musica.view.*

class MusicaAdapter(context: Context)
    : ArrayAdapter<MusicaVO>(context, 0) {


    private val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val item = inflater.inflate(R.layout.item_musica, null)
        val m = getItem(position)

        item!!.lblNome.text = m.nome

        return item
    }

}