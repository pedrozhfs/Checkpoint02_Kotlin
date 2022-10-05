package com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.databinding.ActivityMainBinding
import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.model.ItemListaModel
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.Constants.INDEX_INTENT
import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.Constants.INDEX_RESULT
import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.Constants.ITEM_INTENT
import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.Constants.ITEM_RESULT

class MainActivity : AppCompatActivity(), IcrudItem {
    lateinit var binding: ActivityMainBinding
    val lAdapter = ItemLinhaAdapter(this)
    var cont = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyCler()
        binding.addItemBtn.setOnClickListener {
            AddItem()
        }
    }

    private fun setupRecyCler(){
        binding.listaReciclavelRv.layoutManager = LinearLayoutManager(this)

        val l = mutableListOf<ItemListaModel>()
        l.add(ItemListaModel( "mizuno", "tênis", "39", "preto"))
        l.add(ItemListaModel( "nike", "chinelo", "41", "branco"))
        l.add(ItemListaModel( "mizuno", "tênis", "39", "preto"))
        l.add(ItemListaModel( "mizuno", "tênis", "39", "preto"))
        lAdapter.setLista(l)
        binding.listaReciclavelRv.adapter = lAdapter
    }

    override fun AddItem(){
        val intent = Intent(this, DetalheItemActivity::class.java)
        register.launch(intent)
    }



    override fun EditItem(item: ItemListaModel, position: Int){
        val intent = Intent(this, DetalheItemActivity::class.java)
        intent.putExtra(ITEM_INTENT, item)
        intent.putExtra(INDEX_INTENT, position)
        register.launch(intent)
    }

    private val register = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult())
    {result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK){
            result.data?.let {data ->
                if (data.hasExtra(ITEM_RESULT)){
                    val item = data.getParcelableExtra<ItemListaModel>(ITEM_RESULT)
                }
            }
        }
    }

    override fun RemoveItem (item: ItemListaModel, position: Int){

    }

}