package io.zino.knotgrass.miner;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import io.zino.knotgrass.Context;
import io.zino.knotgrass.chain.block.domain.BlockDO;
import io.zino.knotgrass.miner.request.MineBlockRequest;
import io.zino.knotgrass.network.request.PublishBlockRequest;

public class MinerHandler {
    private Miner miner;
    private EventBus eventBus;

    public MinerHandler(Context context) {
        this.miner = new Miner(this);
        this.eventBus = context.getEventBus();
    }

    @Subscribe
    public void handle(MineBlockRequest request) {
        miner.mine(request.getBlockDO());
    }

    void sendPublishBlockResuest(BlockDO blockDO) {
        this.eventBus.post(new PublishBlockRequest(blockDO));
    }
}
