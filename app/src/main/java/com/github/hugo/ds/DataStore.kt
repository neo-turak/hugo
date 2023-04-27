package com.github.hugo.ds

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.github.hugo.api.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

//main ds
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constants.DS)

//sub
val dsNewUser = booleanPreferencesKey(Constants.DS_NEW_USER)

//read function
suspend fun Context.newUser(): Boolean {

    val flow: Flow<Boolean> = this.dataStore.data
        .map { preferences ->
            preferences[dsNewUser] ?: false
        }
    return flow.first()
}

//write data.
suspend fun Context.setNewUser(boolean: Boolean) {
    this.dataStore.edit { settings ->
        settings[dsNewUser] = boolean
    }
}