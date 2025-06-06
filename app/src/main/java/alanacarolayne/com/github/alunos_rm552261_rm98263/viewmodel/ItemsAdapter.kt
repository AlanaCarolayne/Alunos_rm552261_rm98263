package alanacarolayne.com.github.alunos_rm552261_rm98263.viewmodel

import alanacarolayne.com.github.alunos_rm552261_rm98263.model.ItemModel
import alanacarolayne.com.github.alunos_rm552261_rm98263.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private val onItemRemoved: (ItemModel) -> Unit) :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private var items = listOf<ItemModel>()

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNome = view.findViewById<TextView>(R.id.textViewItemNome)
        val textViewTipo = view.findViewById<TextView>(R.id.textViewItemTipo)
        val textViewGrau = view.findViewById<TextView>(R.id.textViewGrau)
        val textViewData = view.findViewById<TextView>(R.id.textViewData)
        val textViewNum = view.findViewById<TextView>(R.id.textViewItemNum)
        val button = view.findViewById<ImageButton>(R.id.imageButton)

        fun bind(item: ItemModel) {
            textViewNome.text = item.nome
            textViewTipo.text = item.tipoEvento
            textViewGrau.text = item.grauImpacto
            textViewData.text = item.dataEvento.toString()
            textViewNum.text = item.pessoasAfetadas.toString()
            button.setOnClickListener {
                onItemRemoved(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<ItemModel>) {
        items = newItems
        notifyDataSetChanged()
    }
}