package io.zino.knotgrass.network.request;

import io.zino.knotgrass.domain.TransactionDO;

public class PublishTransactionRequest {
    private final TransactionDO transactionDO;

    public PublishTransactionRequest(TransactionDO transactionDO) {
        this.transactionDO = transactionDO;
    }

    public TransactionDO getTransactionDO() {
        return transactionDO;
    }
}