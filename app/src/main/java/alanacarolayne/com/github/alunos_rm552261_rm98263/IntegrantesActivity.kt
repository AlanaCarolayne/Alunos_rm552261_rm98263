package alanacarolayne.com.github.alunos_rm552261_rm98263

import alanacarolayne.com.github.alunos_rm552261_rm98263.R
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IntegrantesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.integrantes_activity)

        val textViewAlana = findViewById<TextView>(R.id.textViewAlana)
        val alana = textViewAlana.text

        val textViewAna = findViewById<TextView>(R.id.textViewAna)
        val ana = textViewAlana.text


    }
}