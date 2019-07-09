package io.zino.knotgrass.chain;

import io.zino.knotgrass.domain.BlockDO;
import io.zino.knotgrass.domain.TransactionDO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChainService {
    private final BlockRepository blockRepository;
    private final TransactionRepository transactionRepository;
    private Set<TransactionDO> queuedTransactions;

    public ChainService(ChainHandler ch) {
        DBHandler dbHandler = new DBHandler(ch.getDatabaseUrl(), ch.getDatabasePort(), ch.getDatabaseName());
        this.blockRepository = new BlockRepository(dbHandler.getKnotgrassDB());
        this.transactionRepository = new TransactionRepository(dbHandler.getKnotgrassDB());
        queuedTransactions = new HashSet<>();
    }

    public Boolean registerTransaction(TransactionDO transactionDO) {
        // TODO
        List<TransactionDO> byUuid = transactionRepository.findByUuid(transactionDO.getUuid());
        if (byUuid.size() > 0) return Boolean.FALSE;
        // TODO check for transaction validity
        return Boolean.TRUE;
    }

    public void registerBlock(BlockDO blockDO) {
        // TODO check for block validity
        this.blockRepository.insert(blockDO);
    }
}
