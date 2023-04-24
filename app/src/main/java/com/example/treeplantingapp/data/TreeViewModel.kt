package com.example.treeplantingapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class TreeViewModel(
    application: Application
) : AndroidViewModel(application) {
    var readAllData: LiveData<List<Tree>>
    private var repository: TreeRepository

    init {

        val treeDao = TreeDatabase.getDatabase(application).treeDao()
        repository = TreeRepository(treeDao)
        readAllData = repository.readAllData
    }

    fun addTree(tree: Tree) {
        viewModelScope.launch {
            repository.addTree(tree)
        }
    }
}
