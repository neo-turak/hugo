package com.github.hugo.events

import kotlinx.coroutines.flow.SharedFlow

/**
 * @author 努尔江
 * Created on: 2023/5/18
 * @project hugo
 * Description: 事件总线
 **/

sealed class EventBus<T> {
    abstract val events: SharedFlow<T>
    abstract suspend fun emitEvent(event: T)

    companion object {
        fun <T> create(): EventBus<T> = EventBusImpl()
    }
}