package br.edu.unisep.minhasmusicas.vo

data class MusicaVO(var id : Int? = null,
                    var nome : String? = null,
                    var artista : ArtistaVO? = null,
                    var duracao : Int? = null) {
}