package com.example.treeplantingapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TreeViewModel @Inject constructor(
    database: TreeDatabase,
) : ViewModel() {
    private lateinit var readAllData: LiveData<List<Tree>>
    private var repository: TreeRepository

    init {
        val treeDao = database.treeDao
        repository = TreeRepository(database.treeDao)
    }

    fun addTree(tree: Tree) {
        viewModelScope.launch {
            repository.addTree(tree)
        }
    }
}
