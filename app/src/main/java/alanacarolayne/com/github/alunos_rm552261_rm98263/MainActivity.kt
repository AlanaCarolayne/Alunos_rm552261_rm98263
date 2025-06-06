package alanacarolayne.com.github.alunos_rm552261_rm98263

import alanacarolayne.com.github.alunos_rm552261_rm98263.model.ItemModel
import alanacarolayne.com.github.alunos_rm552261_rm98263.viewmodel.ItemsAdapter
import alanacarolayne.com.github.alunos_rm552261_rm98263.viewmodel.ItemsViewModel
import alanacarolayne.com.github.alunos_rm552261_rm98263.R
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ItemsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonIntegrantes = findViewById<Button>(R.id.buttonVerIntegrantes)
        buttonIntegrantes.setOnClickListener {
            val intent = Intent(this, IntegrantesActivity::class.java)
            startActivity(intent)
        }


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Clima Tracker"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val editTextNome = findViewById<EditText>(R.id.editTextNome)
        val editTextTipo = findViewById<EditText>(R.id.editTextTipo)
        val editTextGrau = findViewById<EditText>(R.id.editTextGrau)
        val editTextData = findViewById<EditText>(R.id.editTextData)
        val editTextNum = findViewById<EditText>(R.id.editTextNum)
        val button = findViewById<Button>(R.id.button)

        val itemsAdapter = ItemsAdapter { item ->
            viewModel.removeItem(item)
        }
        recyclerView.adapter = itemsAdapter

        // Inicializa o ViewModel
        viewModel = ViewModelProvider(this)[ItemsViewModel::class.java]

        // Observa mudanças nos dados
        viewModel.itemsLiveData.observe(this) { items ->
            itemsAdapter.updateItems(items)
        }

        button.setOnClickListener {
            val nome = editTextNome.text.toString()
            val tipo = editTextTipo.text.toString()
            val grau = editTextGrau.text.toString()
            val data = editTextData.text.toString()
            val num = editTextNum.text.toString()

            var hasError = false
            if (nome.isEmpty()) {
                editTextNome.error = "Preencha o nome"
                hasError = true
            }
            if (tipo.isEmpty()) {
                editTextTipo.error = "Preencha o tipo"
                hasError = true
            }
            if (grau.isEmpty()) {
                editTextGrau.error = "Preencha o grau"
                hasError = true
            }
            if (data.isEmpty()) {
                editTextData.error = "Preencha a data"
                hasError = true
            }
            if (num.isEmpty()  ) {
                editTextNum.error = "Preencha o número"
                hasError = true
            }
            if (num.toInt() <=0  ) {
                editTextNum.error = "O número deve ser maior que zero!"
                hasError = true
            }

            if (hasError) return@setOnClickListener




            val item = ItemModel(
                nome = nome,
                tipoEvento = tipo,
                pessoasAfetadas = num.toInt(),
                dataEvento = data,
                grauImpacto = grau
            )

            viewModel.addItem(item)
            editTextNome.text.clear()
            editTextTipo.text.clear()
            editTextGrau.text.clear()
            editTextData.text.clear()
            editTextNum.text.clear()
        }


        val textViewContagem = findViewById<TextView>(R.id.textViewContagem)

        viewModel.itemsLiveData.observe(this) { items ->
            itemsAdapter.updateItems(items)
            textViewContagem.text = "Total de eventos: ${viewModel.getTotalEventos()}"
        }






    }
}