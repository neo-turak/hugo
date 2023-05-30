package com.github.hugo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.github.hugo.api.Constants
import com.github.hugo.room.dao.SoftwareDao
import com.github.hugo.room.entity.SoftwareEntity


/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

@Database(entities = [SoftwareEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun softwareDao(): SoftwareDao

    companion object {

      @Volatile
      private var instance: AppDatabase? = null

        //the name of the database
        fun getInstance(context: Context): AppDatabase  =
           instance ?: synchronized(this){
               instance ?:  databaseBuilder(
                   context.applicationContext,
                   AppDatabase::class.java,
                   Constants.ROOM)
                   .build().also {
                       instance = it
                   }
           }

    }
}
