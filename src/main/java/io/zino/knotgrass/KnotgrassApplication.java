package io.zino.knotgrass;

import com.google.common.eventbus.EventBus;
import io.zino.knotgrass.chain.ChainHandler;
import io.zino.knotgrass.miner.MinerHandler;
import io.zino.knotgrass.network.NetworkHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KnotgrassApplication {

    private Logger logger = LoggerFactory.getLogger(KnotgrassApplication.class);

    public static void main(String[] args) {
        new KnotgrassApplication().run(args);
    }

    public void run(String arg[]) {
        logger.info("Create eventbus");
        EventBus eventBus = new EventBus();
        Context context = new Context(eventBus);

        logger.info("register components at event bus");
        eventBus.register(new ChainHandler(context));
        eventBus.register(new MinerHandler(context));
        eventBus.register(new NetworkHandler(context));
    }
}
