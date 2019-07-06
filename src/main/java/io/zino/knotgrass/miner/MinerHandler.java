package io.zino.knotgrass.miner;

import com.google.common.eventbus.Subscribe;

public enum MinerHandler {
    INSTANCE;

    public static class PublishTransactionRequest {
    }

    @Subscribe
    public void handle(PublishTransactionRequest request) {
        System.out.println("ooooooooooooh");
    }
}
