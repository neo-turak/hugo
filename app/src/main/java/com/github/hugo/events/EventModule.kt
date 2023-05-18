package com.github.hugo.events

import com.github.hugo.model.AppInfoModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author 努尔江
 * Created on: 2023/5/18
 * @project hugo
 * Description:
 **/

@Module
@InstallIn(SingletonComponent::class)
object EventModule {

    @Provides
    fun provideEventBus():EventBus<AppInfoModel>{
        return EventBus.create()
    }
}