package io.zino.knotgrass.chain;

import io.zino.knotgrass.domain.SignedBlockDO;
import io.zino.knotgrass.domain.UnsignedBlockDO;
import io.zino.knotgrass.domain.TransactionDO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Encapsulate all chain logic
 *
 * @author Mohammad Taheri
 */
public class ChainService {
    /**
     * {@link ChainHandler} instance
     */
    private final ChainHandler chainHandler;
    /**
     * {@link BlockRepository} instance
     */
    private final BlockRepository blockRepository;
    /**
     * {@link TransactionRepository} instance
     */
    private final TransactionRepository transactionRepository;
    /**
     * Set of {@link TransactionDO} waiting to be add to a block
     */
    private Set<TransactionDO> queuedTransactions;

    /**
     * Class constructor
     * @param ch The ChainHandler instance
     */
    public ChainService(ChainHandler ch) {
        this.chainHandler = ch;
        DBHandler dbHandler = new DBHandler(ch.getDatabaseUrl(), ch.getDatabasePort(), ch.getDatabaseName());
        this.blockRepository = new BlockRepository(dbHandler.getKnotgrassDB());
        this.transactionRepository = new TransactionRepository(dbHandler.getKnotgrassDB());
        queuedTransactions = new HashSet<>();
    }

    /**
     * Check and register the given transaction
     * @param transactionDO The new transaction
     * @return The transaction registration result
     */
    public Boolean registerTransaction(TransactionDO transactionDO) {
        // TODO
        List<TransactionDO> byUuid = transactionRepository.findByUuid(transactionDO.getUuid());
        if (byUuid.size() > 0) return Boolean.FALSE;
        // TODO check for transaction validity
        this.queuedTransactions.add(transactionDO);

        this.chainHandler.publishMineBlockRequest(createBlock(this.queuedTransactions));
        return Boolean.TRUE;
    }

    /**
     * Create a block from the given transactions
     * @param transactions Set of the transaction for creating a new block
     * @return The new block created with the given transactions
     */
    private UnsignedBlockDO createBlock(Set<TransactionDO> transactions){
        //TODO
        return null;
    }

    /**
     * Check and register a given block
     * @param blockDO The signed block
     * @return The block registration result
     */
    public Boolean registerBlock(SignedBlockDO blockDO) {
        // TODO check for block validity
        this.blockRepository.insert(blockDO);

        // TODO remove block transaction from queued transactions and publish a new MineBlockRequest.
        return Boolean.FALSE;
    }
}
