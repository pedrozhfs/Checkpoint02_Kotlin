package com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.Constants.INDEX_INTENT
import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.Constants.INDEX_RESULT
import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.Constants.ITEM_INTENT
import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.Constants.ITEM_RESULT
import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.databinding.ActivityDetalheItemBinding
import com.example.gabrielpicinato_pedrohenrique_raphael_rm85992_rm84130_rm82566.model.ItemListaModel


class DetalheItemActivity : AppCompatActivity() {
    lateinit var dataBind: ActivityDetalheItemBinding
    var item : ItemListaModel? = null
    var index : Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBind = ActivityDetalheItemBinding.inflate(layoutInflater)
        setContentView(dataBind.root)
        item = intent.getParcelableExtra(ITEM_INTENT)
        index = intent.getIntExtra(INDEX_INTENT, -1)
        if(item != null){
            dataBind.lblTamanho.setText(item?.tamanho)
            dataBind.lblCor.setText(item?.cor)
            dataBind.lblNome.setText(item?.nome)
        }
        dataBind.btnConfirmar.setOnClickListener {
            Intent().apply{
                putExtra(
                    ITEM_RESULT,
                    ItemListaModel(
                        dataBind.lblNome.text.toString(),
                        dataBind.lblTenis.text.toString(),
                        dataBind.lblTamanho.text.toString(),
                        dataBind.lblCor.text.toString()
                    )
                )
                putExtra(INDEX_RESULT, index)
                setResult(Activity.RESULT_OK, this)
            }
            this.finish()
        }
    }
}
