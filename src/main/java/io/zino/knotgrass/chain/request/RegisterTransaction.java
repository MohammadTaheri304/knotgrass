package io.zino.knotgrass.chain.request;

import io.zino.knotgrass.domain.TransactionDO;

public class RegisterTransaction {
    private TransactionDO transactionDO;

    public RegisterTransaction(TransactionDO transactionDO) {
        this.transactionDO = transactionDO;
    }

    public TransactionDO getTransactionDO() {
        return transactionDO;
    }
}