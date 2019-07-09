package io.zino.knotgrass;

import com.google.common.eventbus.EventBus;
import io.zino.knotgrass.chain.ChainHandler;
import io.zino.knotgrass.miner.MinerHandler;
import io.zino.knotgrass.network.NetworkHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        new KnotgrassApplication().run(args);
    }

    /**
     * Run the server
     *
     * @param arg input arguments
     */
    public void run(String arg[]) {
        logger.info("Create eventbus");
        EventBus eventBus = new EventBus();
        Context context = new Context(eventBus);

        logger.info("Register components at event bus");
        logger.debug("Register ChainHandler at event bus");
        eventBus.register(new ChainHandler(context));
        logger.debug("Register MinerHandler at event bus");
        eventBus.register(new MinerHandler(context));
        logger.debug("Register NetworkHandler at event bus");
        eventBus.register(new NetworkHandler(context));
        logger.info("All components registered at event bus");
    }
}
