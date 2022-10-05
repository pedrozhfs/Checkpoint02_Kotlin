package com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566

import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.model.ItemListaModel

interface IcrudItem {
    fun AddItem()
    fun EditItem(item: ItemListaModel, postition: Int)
    fun RemoveItem(item: ItemListaModel, postition: Int)
}