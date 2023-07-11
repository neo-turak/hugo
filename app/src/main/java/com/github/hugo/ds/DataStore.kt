package com.github.hugo.ds

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.github.hugo.api.Constants
import com.github.hugo.helper.JSONHelper
import com.github.hugo.helper.toJson
import com.github.hugo.model.ShopAdminModel
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
val dsUserInfo = stringPreferencesKey(Constants.DS_USER_INFO)

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

suspend fun Context.saveAdminInfo(shopAdminModel: String) {
    this.dataStore.edit { settings ->
        settings[dsUserInfo] = shopAdminModel.toJson()
    }
}

suspend fun Context.getAdminInfo(): ShopAdminModel? {
    val flow: Flow<String> = this.dataStore.data
        .map { value: Preferences ->
            value[dsUserInfo] ?: ""
        }
    val result = flow.first()
    if (result != "") {
        return JSONHelper.instance.fromGson(result, ShopAdminModel::class.java)
    }
    return null
}