package io.zino.knotgrass.chain.block.impl;

import io.zino.knotgrass.chain.ChainHandler;
import io.zino.knotgrass.chain.block.ChainRepository;
import io.zino.knotgrass.chain.block.ChainService;
import io.zino.knotgrass.chain.block.domain.BlockDO;
import io.zino.knotgrass.chain.transaction.TransactionRepository;
import io.zino.knotgrass.chain.transaction.domain.TransactionDO;
import io.zino.knotgrass.miner.Miner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Chainsaw implements ChainService {
    private final ChainRepository blockRepository;
    private final TransactionRepository transactionRepository;
    private Set<TransactionDO> queuedTransactions;

    public Chainsaw(ChainHandler dana) {
        this.blockRepository = dana.getBlockRepository();
        this.transactionRepository = dana.getTransactionRepository();
        queuedTransactions = new HashSet<>();
    }

    @Override
    public Boolean receiveTransaction(TransactionDO transactionDO) {
        // TODO
        List<TransactionDO> byUuid = transactionRepository.findByUuid(transactionDO.getUuid());
        if (byUuid.size() > 0) return Boolean.FALSE;
        // TODO check for transaction validity
        return Boolean.TRUE;
    }

    @Override
    public void publishTransaction(TransactionDO transactionDO) {
        // TODO
    }

    @Override
    public void publishBlock(BlockDO blockDO) {
        // TODO
    }

    @Override
    public void receiveBlock(BlockDO blockDO) {
        // TODO check for block validity
        this.blockRepository.insert(blockDO);
    }
}
