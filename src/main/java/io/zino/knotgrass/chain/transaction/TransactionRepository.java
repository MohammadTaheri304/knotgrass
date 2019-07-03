package io.zino.knotgrass.chain.transaction;

import io.zino.knotgrass.chain.transaction.domain.TransactionDO;

import java.util.List;

public interface TransactionRepository {
    public boolean insert(TransactionDO transactionDO);
    public List<TransactionDO> findByUuid(String uuid);
}
