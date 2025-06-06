package alanacarolayne.com.github.alunos_rm552261_rm98263.viewmodel

import alanacarolayne.com.github.alunos_rm552261_rm98263.data.ItemDao
import alanacarolayne.com.github.alunos_rm552261_rm98263.data.ItemDatabase
import alanacarolayne.com.github.alunos_rm552261_rm98263.model.ItemModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

class ItemsViewModel(application: Application) : AndroidViewModel(application) {

    private val itemDao: ItemDao

    val itemsLiveData: LiveData<List<ItemModel>>

    init {
        val database = Room.databaseBuilder(
            getApplication(),
            ItemDatabase::class.java,
            "items_database"
        ).build()
        itemDao = database.itemDao()

        itemsLiveData = itemDao.getAll()
    }


    fun addItem(item: ItemModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val newItem = ItemModel(nome = item.nome, tipoEvento = item.tipoEvento, grauImpacto = item.grauImpacto, dataEvento = item.dataEvento, pessoasAfetadas = item.pessoasAfetadas )
            itemDao.insert(newItem)
        }
    }


    fun removeItem(item: ItemModel) {
        viewModelScope.launch(Dispatchers.IO) {
            itemDao.delete(item)
        }
    }

    fun getTotalEventos(): Int {
        return itemsLiveData.value?.size ?: 0
    }

}