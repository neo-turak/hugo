package com.github.hugo.room

import android.content.Context
import androidx.room.Room
import com.github.hugo.api.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description: this is still works, but some how it locks the thread.
 **/


@Module
@InstallIn(SingletonComponent::class)
object DBModule {
    @Provides
    @Singleton
    fun provideDB(@ApplicationContext appContext: Context):AppDatabase{
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            Constants.ROOM
        ).build()
    }

}
