package io.zino.knotgrass.chain;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import io.zino.knotgrass.Context;
import io.zino.knotgrass.chain.request.RegisterBlock;
import io.zino.knotgrass.chain.request.RegisterTransaction;
import io.zino.knotgrass.domain.BlockDO;
import io.zino.knotgrass.miner.request.MineBlockRequest;

public class ChainHandler {

    private final EventBus eventBus;
    private final ChainService chainService;
    private final String databaseUrl;
    private final Integer databasePort;
    private final String databaseName;

    public ChainHandler(Context context) {
        this.eventBus = context.getEventBus();
        this.chainService = new ChainService(this);
        this.databaseUrl = context.getDatabaseUrl();
        this.databasePort = context.getDatabasePort();
        this.databaseName = context.getDatabaseName();
    }

    @Subscribe
    public void handle(RegisterBlock request) {
        this.chainService.registerBlock(request.getBlockDO());
    }

    @Subscribe
    public void handle(RegisterTransaction request) {
        this.chainService.registerTransaction(request.getTransactionDO());
    }

    void publishMineBlockRequest(BlockDO blockDO) {
        this.eventBus.post(new MineBlockRequest(blockDO));
    }

    String getDatabaseUrl() {
        return databaseUrl;
    }

    Integer getDatabasePort() {
        return databasePort;
    }

    String getDatabaseName() {
        return databaseName;
    }
}
