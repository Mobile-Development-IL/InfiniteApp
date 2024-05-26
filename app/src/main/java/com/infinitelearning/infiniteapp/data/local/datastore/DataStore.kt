package com.infinitelearning.infiniteapp.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.infinitelearning.infiniteapp.utils.PreferencesKey.STATUS_LOGIN_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("StatusLogin")
    }

    val getStatusLogin: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[STATUS_LOGIN_KEY] ?: false
    }

    suspend fun saveStatus(isLogin: Boolean) = context.dataStore.edit { preferences ->
        preferences[STATUS_LOGIN_KEY] = isLogin
    }

    suspend fun clearStatus() = context.dataStore.edit { preferences ->
        preferences.remove(STATUS_LOGIN_KEY)
    }
}