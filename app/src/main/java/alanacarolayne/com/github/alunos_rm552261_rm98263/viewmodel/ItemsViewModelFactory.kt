package alanacarolayne.com.github.alunos_rm552261_rm98263.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ItemsViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun<T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ItemsViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ItemsViewModel(application) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel class")

    }


}