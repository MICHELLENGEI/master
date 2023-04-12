package com.example.treeplantingapp.data

import androidx.lifecycle.LiveData

class TreeRepository(private val treeDao: TreeDao) {
    val readAllData: LiveData<List<Tree>> = treeDao.readAllData()
    suspend fun addTree(tree: Tree) {
        treeDao.addTree(tree)
    }


}
