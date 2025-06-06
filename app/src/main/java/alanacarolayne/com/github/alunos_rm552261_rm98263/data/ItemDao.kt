package alanacarolayne.com.github.alunos_rm552261_rm98263.data

import alanacarolayne.com.github.alunos_rm552261_rm98263.model.ItemModel
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Query("SELECT * FROM ItemModel")
    fun getAll():LiveData<List<ItemModel>>
    @Insert
    fun insert(item: ItemModel)
    @Delete
    fun delete(item: ItemModel)

}