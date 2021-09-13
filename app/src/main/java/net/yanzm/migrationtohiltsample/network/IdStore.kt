package net.yanzm.migrationtohiltsample.network

import android.app.Application
import android.content.Context
import java.util.UUID

interface IdStore {

    fun getId(): String
}

class DefaultIdStore(application: Application) : IdStore {

    private val pref = application.getSharedPreferences("id_store", Context.MODE_PRIVATE)

    override fun getId(): String {
        val id = pref.getString("id", null)
        if (id.isNullOrEmpty()) {
            val newId = UUID.randomUUID().toString()
            pref.edit().putString("id", newId).apply()
            return newId
        }
        return id
    }
}
