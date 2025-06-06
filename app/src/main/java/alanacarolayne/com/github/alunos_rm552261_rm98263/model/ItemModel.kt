package alanacarolayne.com.github.alunos_rm552261_rm98263.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val nome:String,
    val tipoEvento:String,
    val pessoasAfetadas:Int,
    val dataEvento: String,
    val grauImpacto:String
)