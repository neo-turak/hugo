package com.github.hugo.events

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import timber.log.Timber

/**
 * @author 努尔江
 * Created on: 2023/5/18
 * @project hugo
 * Description:
 **/

class EventBusImpl<T> : EventBus<T>() {
    private val _events = MutableSharedFlow<T>()
    override val events: SharedFlow<T>
        get() = _events.asSharedFlow()

    override suspend fun emitEvent(event: T) {
        Timber.e("Emitting event = $event")
        _events.emit(event)
    }
}
