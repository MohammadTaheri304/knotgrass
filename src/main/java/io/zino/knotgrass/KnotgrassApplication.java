package io.zino.knotgrass;

import com.google.common.eventbus.EventBus;
import io.zino.knotgrass.chain.ChainHandler;
import io.zino.knotgrass.miner.MinerHandler;
import io.zino.knotgrass.network.NetworkHandler;

public class KnotgrassApplication {

    public static void main(String[] args) {
        new KnotgrassApplication().run(args);
    }

    public void run(String arg[]) {
        EventBus eventBus = new EventBus();
        eventBus.register(ChainHandler.INSTANCE);
        eventBus.register(MinerHandler.INSTANCE);
        eventBus.register(NetworkHandler.INSTANCE);
        System.out.println("sss");
    }
}
