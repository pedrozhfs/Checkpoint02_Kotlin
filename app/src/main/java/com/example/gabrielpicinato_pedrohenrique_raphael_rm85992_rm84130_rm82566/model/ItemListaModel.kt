package com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemListaModel(
        var nome: String,
        var item: String,
        var tamanho: String,
        var cor: String
) : Parcelable