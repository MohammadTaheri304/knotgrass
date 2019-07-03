package io.zino.knotgrass;

import io.zino.knotgrass.chain.*;
import io.zino.knotgrass.chain.block.ChainRepository;
import io.zino.knotgrass.chain.block.impl.Chainsaw;
import io.zino.knotgrass.chain.block.impl.SimpleBlockRepository;
import io.zino.knotgrass.chain.transaction.impl.SimpleTransactionRepository;
import io.zino.knotgrass.chain.transaction.TransactionRepository;

public class Dana {
    private final DBHandler dbHandler;
    private final ChainRepository blockRepository;
    private final Chainsaw blockService;
    private final TransactionRepository transactionRepository;

    public Dana() {
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

    abstract public static class DanaService {
        private final Dana dana;
        public DanaService(Dana dana) {
            this.dana = dana;
        }
    }

}
