package com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.databinding.ItemListaBinding
import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.model.ItemListaModel


class ItemLinhaAdapter(val itemListener: IcrudItem) :
    RecyclerView.Adapter<ItemLinhaAdapter.ItemLinhaHolder>() {

    private val lista: MutableList<ItemListaModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemLinhaHolder {
        return ItemLinhaHolder(
            ItemListaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
    override fun onBindViewHolder(holder: ItemLinhaHolder, position: Int) {
        holder.bind(lista[position])
        holder.itemListaView.itemAddBtm.setOnClickListener {
            itemListener.RemoveItem(lista[position], position)
        }
        holder.itemListaView.itemEditBtm.setOnClickListener {
            itemListener.EditItem(lista[position], position)
        }
    }

    override fun getItemCount(): Int = lista.size

    fun setLista(listaItem: MutableList<ItemListaModel>){
        lista.clear()
        lista.addAll(listaItem)
        notifyDataSetChanged()
    }

    fun addLista(newItem: ItemListaModel){
        lista.add(newItem)
        notifyItemInserted(lista.size)
    }

    fun editLista(editItem: ItemListaModel, position: Int){
        lista[position] = editItem
        notifyItemChanged(position)
    }


    class ItemLinhaHolder(val itemListaView: ItemListaBinding) :
        RecyclerView.ViewHolder(itemListaView.root) {
        fun bind(item: ItemListaModel) {
            itemListaView.itemTexto.text = item.nome
            itemListaView.detalheItemText.text = item.item
            itemListaView.detalheItemText.text = item.tamanho
            itemListaView.detalheItemText.text = item.cor
        }

}


}
