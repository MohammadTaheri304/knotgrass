package io.zino.knotgrass.miner;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import io.zino.knotgrass.Context;
import io.zino.knotgrass.domain.BlockDO;
import io.zino.knotgrass.miner.request.MineBlockRequest;
import io.zino.knotgrass.network.request.PublishBlockRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handle miner events.
 * This class will be register at the server bus to subscribe miner related events.
 *
 * @author Mohammad Taheri
 */
public class MinerHandler {
    private Logger logger = LoggerFactory.getLogger(MinerHandler.class);

    /**
     * Miner instance
     */
    private Miner miner;

    /**
     * Event-bus instance
     */
    private EventBus eventBus;

    /**
     * Class constructor
     *
     * @param context The server context
     */
    public MinerHandler(Context context) {
        this.miner = new Miner(this);
        this.eventBus = context.getEventBus();
    }

    /**
     * Handle mine block requests
     *
     * @param request The request of mining a block
     */
    @Subscribe
    public void handle(MineBlockRequest request) {
        logger.debug("Recive {}", request);
        miner.mine(request.getBlockDO());
    }

    /**
     * Send publish block request to the event-bus
     *
     * @param blockDO The block that should publish
     */
    void sendPublishBlockResuest(BlockDO blockDO) {
        logger.debug("Called by {}", blockDO);
        this.eventBus.post(new PublishBlockRequest(blockDO));
    }
}
