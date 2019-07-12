package io.zino.knotgrass.chain;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import io.zino.knotgrass.Context;
import io.zino.knotgrass.chain.request.RegisterBlock;
import io.zino.knotgrass.chain.request.RegisterTransaction;
import io.zino.knotgrass.domain.UnsignedBlockDO;
import io.zino.knotgrass.miner.request.MineBlockRequest;

/**
 * Handle chain events.
 * This class will be register at the server bus to subscribe chain related events.
 *
 * @author Mohammad Taheri
 */
public class ChainHandler {

    /**
     * The event bus instance
     */
    private final EventBus eventBus;

    /**
     * {@link ChainService} instance
     */
    private final ChainService chainService;

    /**
     * The database url
     */
    private final String databaseUrl;

    /**
     * The database port
     */
    private final Integer databasePort;

    /**
     * The database name
     */
    private final String databaseName;

    /**
     * The class constructor
     *
     * @param context The server context
     */
    public ChainHandler(Context context) {
        this.eventBus = context.getEventBus();
        this.chainService = new ChainService(this);
        this.databaseUrl = context.getDatabaseUrl();
        this.databasePort = context.getDatabasePort();
        this.databaseName = context.getDatabaseName();
    }

    /**
     * Handle new block registration events
     * @param request Block registration request
     */
    @Subscribe
    public void handle(RegisterBlock request) {
        this.chainService.registerBlock(request.getBlockDO());
    }

    /**
     * Handle new transaction registration events
     * @param request Transaction registration request
     */
    @Subscribe
    public void handle(RegisterTransaction request) {
        this.chainService.registerTransaction(request.getTransactionDO());
    }

    /**
     * Publish the mining request for the given block
     * @param blockDO The block that asked to be mine
     */
    void publishMineBlockRequest(UnsignedBlockDO blockDO) {
        this.eventBus.post(new MineBlockRequest(blockDO));
    }

    /**
     * Get the database url
     * @return The database url
     */
    String getDatabaseUrl() {
        return databaseUrl;
    }

    /**
     * Get the database port
     * @return The database port
     */
    Integer getDatabasePort() {
        return databasePort;
    }

    /**
     * Get the database name
     * @return The database name
     */
    String getDatabaseName() {
        return databaseName;
    }
}
