package io.zino.knotgrass.chain;

import com.google.common.eventbus.Subscribe;
import io.zino.knotgrass.Context;
import io.zino.knotgrass.chain.block.ChainRepository;
import io.zino.knotgrass.chain.block.impl.Chainsaw;
import io.zino.knotgrass.chain.block.impl.SimpleBlockRepository;
import io.zino.knotgrass.chain.request.ReviewBlockrequest;
import io.zino.knotgrass.chain.request.ReviewTransactionrequest;
import io.zino.knotgrass.chain.transaction.TransactionRepository;
import io.zino.knotgrass.chain.transaction.impl.SimpleTransactionRepository;

public class ChainHandler {

    private final DBHandler dbHandler;
    private final ChainRepository blockRepository;
    private final Chainsaw blockService;
    private final TransactionRepository transactionRepository;

    public ChainHandler(Context context) {
        this.dbHandler = new DBHandler(this);
        this.blockRepository = new SimpleBlockRepository(this);
        this.blockService = new Chainsaw(this);
        this.transactionRepository = new SimpleTransactionRepository(this);
    }

    public DBHandler getDbHandler() {
        return dbHandler;
    }

    public ChainRepository getBlockRepository() {
        return blockRepository;
    }

    public Chainsaw getBlockService() {
        return this.blockService;
    }

    public TransactionRepository getTransactionRepository() {
        return transactionRepository;
    }

    @Subscribe
    public void handle(ReviewBlockrequest request) {
        System.out.println("ooooooooooooh");
    }

    @Subscribe
    public void handle(ReviewTransactionrequest request) {
        System.out.println("ooooooooooooh");
    }
}
