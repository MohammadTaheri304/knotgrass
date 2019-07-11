package io.zino.knotgrass;

import com.google.common.eventbus.EventBus;

import java util.*;

/**
 * Running server context.
 * Use to access configs and modules.
 *
 * @author Mohammad Taheri
 */
public class Context {

    /**
     * Set of all servers config
     */
    private Set<ServerConfig> serverConfigs;

    /**
     * All the application properties
    */
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
    public Context(Properties properties, EventBus eventBus, Set<ServerConfig> serverConfig) {
        this.properties = properties;
        this.eventBus = eventBus;
	this.serverConfig = serverConfig;
    }

    /**
     * Get the event-bus
     * @return Context's event-bus
     */
    public EventBus getEventBus() {
        return eventBus;
    }

    /**
     * Get the database url
     * @return The database url
     */
    public String getDatabaseUrl(){
        return this.properties.getProperty("database.url");
    }

    /**
     * Get the database port
     * @return The database port
     */
    public Integer getDatabasePort(){
        return Integer.parseInt(this.properties.getProperty("database.port"));
    }

    /**
     * Get the database name
     * @return The database name
     */
    public String getDatabaseName(){
        return this.properties.getProperty("database.name");
    }

    /**
     * Get the rpc server port
     * @return The rpc server port
     */
    public Integer getServerPort(){
        return Integer.parseInt(this.properties.getProperty("server.port"));
    }

    /**
     * Get all the servers config
     * @return The servers config
     */
    public Set<ServerConfig> getServerConfig(){return this.serverConfig;}
}
