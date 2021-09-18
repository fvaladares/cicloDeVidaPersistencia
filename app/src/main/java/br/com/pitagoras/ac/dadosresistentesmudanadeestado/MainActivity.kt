package br.com.pitagoras.ac.dadosresistentesmudanadeestado

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.com.pitagoras.ac.dadosresistentesmudanadeestado.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /*
        TODO(IMPEDIR QUE SEJA POSSÍVEL INSERIR ITENS VAZIOS NA LISTA - Extra, exibir uma mensagem de erro no edit text (consultar a referencia do material design))
     */
    private lateinit var binding: ActivityMainBinding
    private var nomes = arrayListOf<String>()
    private var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (savedInstanceState != null) {
            nomes = savedInstanceState.run {
                getStringArrayList(NOMES) as ArrayList<String>
            }
        }

        Log.i(TAG, "onCreate()")
        iniciarComponentes()
    }

    private fun iniciarComponentes() {
        iniciarAdapter()
        iniciarListerners()
    }

    private fun iniciarListerners() {
        binding.btnEnviar.setOnClickListener {
            acaoBotaoEnviar()
        }
    }

    private fun acaoBotaoEnviar() {
        nomes.add(binding.tietNome.text.toString())
        adapter?.notifyDataSetChanged()
        binding.tietNome.text?.clear()
    }

    private fun iniciarAdapter() {
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nomes)
        binding.lvNomes.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putStringArrayList(NOMES, nomes)
        }
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        savedInstanceState?.run {
            nomes = getStringArrayList(NOMES) as ArrayList<String>
            iniciarAdapter()
        }
    }

    companion object {
        const val TAG = "[DDM]"
        const val NOMES = "lista_nomes"
    }
}