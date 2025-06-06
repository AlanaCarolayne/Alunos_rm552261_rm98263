package alanacarolayne.com.github.alunos_rm552261_rm98263.data
import  alanacarolayne.com.github.alunos_rm552261_rm98263.model.ItemModel
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ItemModel::class], version = 1)
abstract class ItemDatabase: RoomDatabase() {
    abstract fun itemDao(): ItemDao
}