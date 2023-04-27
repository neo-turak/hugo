package com.github.hugo.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.hugo.api.Constants
import com.github.hugo.application
import com.github.hugo.model.SoftwareModel

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

@Database(entities = [SoftwareModel.SoftwareEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun softwareDao(): SoftwareDao
}

val db = Room.databaseBuilder(
    application,
    AppDatabase::class.java,
    Constants.ROOM
).build()