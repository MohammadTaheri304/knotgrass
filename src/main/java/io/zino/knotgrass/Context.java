package io.zino.knotgrass;

import com.google.common.eventbus.EventBus;

import java.util.Properties;

/**
 * Running server context.
 * Use to access configs and modules.
 *
 * @author Mohammad Taheri
 */
public class Context {

    private Properties properties;
    /**
     * Server event-bus.
     * Modules use this event bus for their communications.
     */
    private EventBus eventBus;

    /**
     * Context constructor
     *
     * @param properties Config properties
     * @param eventBus Event bus instance
     */
    public Context(Properties properties, EventBus eventBus) {
        this.properties = properties;
        this.eventBus = eventBus;
    }

    /**
     * Get the event-bus
     * @return Context's event-bus
     */
    public EventBus getEventBus() {
        return eventBus;
    }

    public String getDatabaseUrl(){
        return this.properties.getProperty("database.url");
    }

    public Integer getDatabasePort(){
        return Integer.parseInt(this.properties.getProperty("database.port"));
    }

    public String getDatabaseName(){
        return this.properties.getProperty("database.name");
    }

}