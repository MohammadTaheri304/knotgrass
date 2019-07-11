package io.zino.knotgrass;

import com.google.common.eventbus.EventBus;
import io.zino.knotgrass.chain.ChainHandler;
import io.zino.knotgrass.miner.MinerHandler;
import io.zino.knotgrass.network.NetworkHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * KnotgrassApplication starter class
 *
 * @author Mohammad Taheri
 */
public class KnotgrassApplication {

    private Logger logger = LoggerFactory.getLogger(KnotgrassApplication.class);

    /**
     * Server starter main method
     *
     * @param args input arguments
     */
    public static void main(String[] args) {
	System.out.println("Whats up?");
        try {
            new KnotgrassApplication().run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Run the server
     *
     * @param arg input arguments
     */
    public void run(String arg[]) throws Exception {
        logger.info("Load properties");
        Properties properties = loadProperties("application-dev.properties");

        logger.info("Create eventbus");
        EventBus eventBus = new EventBus();
        Context context = new Context(properties, eventBus, new HashSet<>());

        logger.info("Register components at event bus");
        logger.debug("Register ChainHandler at event bus");
        eventBus.register(new ChainHandler(context));
        logger.debug("Register MinerHandler at event bus");
        eventBus.register(new MinerHandler(context));
        logger.debug("Register NetworkHandler at event bus");
        eventBus.register(new NetworkHandler(context));
        logger.info("All components registered at event bus");
    }

    public Properties loadProperties(String path) throws Exception {
        logger.debug("Load embedded config");
        try (InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("application.properties")) {
            Objects.requireNonNull(inputStream, "initialized input stream is null");
            Properties properties = new Properties();
            properties.load(inputStream);

            logger.debug("Load external config");
            File externalPropertiesFile = new File(path);
            if (externalPropertiesFile.exists()) {
                try (InputStream fileInputStream = new FileInputStream(externalPropertiesFile)) {
                    Properties externalProperties = new Properties();
                    externalProperties.load(fileInputStream);
                    properties.putAll(externalProperties);
                }
            }
            return properties;
        }
    }
}
