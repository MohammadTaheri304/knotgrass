package io.zino.knotgrass.chain.block.impl;

import io.zino.knotgrass.Dana;
import io.zino.knotgrass.chain.block.domain.BlockDO;
import io.zino.knotgrass.chain.block.ChainRepository;
import io.zino.knotgrass.chain.block.ChainService;
import io.zino.knotgrass.chain.transaction.TransactionRepository;
import io.zino.knotgrass.chain.transaction.domain.TransactionDO;

import java.util.ArrayList;
import java.util.List;

public class Chainsaw extends Dana.DanaService implements ChainService {
    private final ChainRepository blockRepository;
    private final TransactionRepository transactionRepository;
    private final List<TransactionDO> doPublishList;

    public Chainsaw(Dana dana) {
        super(dana);
        doPublishList = new ArrayList<>();
        this.blockRepository = dana.getBlockRepository();
        this.transactionRepository = dana.getTransactionRepository();
    }

    @Override
    public Boolean receiveTransaction(TransactionDO transactionDO) {
        // TODO
        List<TransactionDO> byUuid = transactionRepository.findByUuid(transactionDO.getUuid());
        if (byUuid.size()>0) return Boolean.FALSE;
        // TODO check for transaction validity

        doPublishList.add(transactionDO);
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
