package net.yanzm.migrationtohiltsample.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.yanzm.migrationtohiltsample.network.IdStore
import javax.inject.Inject

class MainViewModel(
    private val idStore: IdStore
) : ViewModel() {

    fun getId(): String {
        return idStore.getId()
    }

    class Factory @Inject constructor(
        private val idStore: IdStore
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(idStore) as T
        }
    }
}
