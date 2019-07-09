package io.zino.knotgrass.miner;

import com.google.common.eventbus.Subscribe;
import io.zino.knotgrass.Context;
import io.zino.knotgrass.miner.request.MineBlockRequest;

public class MinerHandler {
    private Miner miner;

    public MinerHandler(Context context) {
        this.miner = new Miner(this);
    }

    @Subscribe
    public void handle(MineBlockRequest request) {
        miner.mine(request.getBlockDO());
    }
}
