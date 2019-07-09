package io.zino.knotgrass;

import com.google.common.eventbus.EventBus;

/**
 * Running server context.
 * Use to access configs and modules.
 *
 * @author Mohammad Taheri
 */
public class Context {

    /**
     * Server event-bus.
     * Modules use this event bus for their communications.
     */
    private EventBus eventBus;

    /**
     * Context constructor
     *
     * @param eventBus Event bus instance
     */
    public Context(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    /**
     * Get the event-bus
     * @return Context's event-bus
     */
    public EventBus getEventBus() {
        return eventBus;
    }
}