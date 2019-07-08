package io.zino.knotgrass.miner;

import com.google.common.eventbus.Subscribe;
import io.zino.knotgrass.Context;

public class MinerHandler {
    public MinerHandler(Context context) {

    }


    public static class PublishTransactionRequest {
    }

    @Subscribe
    public void handle(PublishTransactionRequest request) {
        System.out.println("ooooooooooooh");
    }
}
