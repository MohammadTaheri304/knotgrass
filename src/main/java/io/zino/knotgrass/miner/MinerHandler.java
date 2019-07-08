package io.zino.knotgrass.miner;

import com.google.common.eventbus.Subscribe;
import io.zino.knotgrass.Context;
import io.zino.knotgrass.miner.request.MineBlockRequest;

public class MinerHandler {
    public MinerHandler(Context context) {

    }

    @Subscribe
    public void handle(MineBlockRequest request) {
        System.out.println("ooooooooooooh");
    }
}
