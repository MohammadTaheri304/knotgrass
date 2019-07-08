package io.zino.knotgrass;

import com.google.common.eventbus.EventBus;

public class Context {
    EventBus eventBus;

    public Context(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public EventBus getEventBus() {
        return eventBus;
    }
}