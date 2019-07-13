package io.zino.knotgrass;

/**
 * Encapsulate a server properties
 *
 * @author Mohammad Taheri
 */
public class ServerConfig {

    /**
     * Server uuid
     */
    private String uuid;

    /**
     * Server url
     */
    private String url;

    /**
     * Server port
     */
    private Integer port;

    /**
     * Server sign
     */
    private String sign;

    /**
     * Class constructor
     *
     * @param uuid The uuid
     * @param url  The url
     * @param port The port
     * @param sign The signature
     */
    public ServerConfig(String uuid, String url, Integer port, String sign) {
        this.uuid = uuid;
        this.url = url;
        this.port = port;
        this.sign = sign;
    }

    /**
     * Get the server uuid
     *
     * @return The uuid
     */
    public String getUuid() {
        return this.uuid;
    }

    /**
     * Get the server url
     *
     * @return The url
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Get the server port
     *
     * @return The port
     */
    public Integer getPort() {
        return this.port;
    }

    /**
     * Get the server signature
     *
     * @return The signature
     */
    public String getSign() {
        return this.sign;
    }
}

