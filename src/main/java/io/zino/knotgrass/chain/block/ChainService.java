package io.zino.knotgrass.chain.block;

import io.zino.knotgrass.chain.block.domain.BlockDO;
import io.zino.knotgrass.chain.transaction.domain.TransactionDO;

public interface ChainService {
    public Boolean receiveTransaction(TransactionDO transactionDO);
    public void publishTransaction(TransactionDO transactionDO);
    //public void buildBlock(BlockDO blockDO);
    public void publishBlock(BlockDO blockDO);
    public void receiveBlock(BlockDO blockDO);
}
