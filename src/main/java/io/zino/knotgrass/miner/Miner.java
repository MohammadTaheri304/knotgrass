package io.zino.knotgrass.miner;

import io.zino.knotgrass.domain.BlockDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * The simple miner implementation
 *
 * @author Mohammad Taheri
 */
public class Miner {
    private Logger logger = LoggerFactory.getLogger(Miner.class);

    /**
     * Current mining block instance
     */
    private final CurrentMiningBlock currentMiningBlock;

    /**
     * Random instance
     */
    private final Random random = new Random(System.currentTimeMillis());

    /**
     * Reference to the miner handler
     */
    private final MinerHandler minerHandler;

    /**
     * Miner constructor
     *
     * @param minerHandler The miner's handler
     */
    public Miner(MinerHandler minerHandler) {
        this.minerHandler = minerHandler;
        currentMiningBlock = new CurrentMiningBlock();

        new Thread(() -> {
            while (true) {
                synchronized (this) {
                    if (currentMiningBlock.getBlockDO() == null) {
                        try {
                            this.wait(1000l);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Miner.this.mine(currentMiningBlock.getBlockDO());
                    }
                }
            }

        }).run();
    }

    /**
     * Set the given block as the current mining block
     *
     * @param blockDO The requested block for mining
     */
    public void mine(BlockDO blockDO) {
        this.currentMiningBlock.setBlockDO(blockDO);
    }

    /**
     * Encapsulate the current block for minner
     */
    private class CurrentMiningBlock {
        private BlockDO blockDO;
        private Long timestaml;

        public BlockDO getBlockDO() {
            return blockDO;
        }

        public void setBlockDO(BlockDO blockDO) {
            this.timestaml = System.currentTimeMillis();
            this.blockDO = blockDO;
        }

        public Long getTimestaml() {
            return timestaml;
        }
    }

    /**
     * Try to mine the current block
     *
     * @param blockDO The requested block for mining
     */
    private void tryTheBlock(BlockDO blockDO) {
        // TODO get the miner uuid from config
        blockDO.setMinnerUuid("replace-with-miner-uuid>");
        blockDO.setNonce(random.nextLong());
        String sha256hex = blockDO.computeHash();
        // TODO compute hash-cash size
        Long hashCashSize = 3L;
        Boolean checkForHashCash = checkForHashCashMatch(sha256hex, hashCashSize);
        if (checkForHashCash) {
            this.minerHandler.sendPublishBlockResuest(blockDO);
        }
    }

    /**
     * Check for computed puzzle solution size
     *
     * @param hash The computed hash cash
     * @param size The solution size required
     * @return True in case that solution match the requirements
     */
    private Boolean checkForHashCashMatch(String hash, Long size) {
        // todo
        return false;
    }
}
