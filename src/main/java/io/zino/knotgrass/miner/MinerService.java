package io.zino.knotgrass.miner;

import io.zino.knotgrass.domain.SignedBlockDO;
import io.zino.knotgrass.domain.UnsignedBlockDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Encapsulate all mining logic
 *
 * @author Mohammad Taheri
 */
public class MinerService {
    /**
     * Class logger
     */
    private Logger logger = LoggerFactory.getLogger(MinerService.class);

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
     * MinerService constructor
     *
     * @param minerHandler The miner's handler
     */
    public MinerService(MinerHandler minerHandler) {
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
                        MinerService.this.mine(currentMiningBlock.getBlockDO());
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
    public void mine(UnsignedBlockDO blockDO) {
        this.currentMiningBlock.setBlockDO(blockDO);
    }

    /**
     * Encapsulate the current block for minner
     */
    private class CurrentMiningBlock {
        private UnsignedBlockDO blockDO;
        private Long timestaml;

        public UnsignedBlockDO getBlockDO() {
            return blockDO;
        }

        public void setBlockDO(UnsignedBlockDO blockDO) {
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
    private void tryTheBlock(UnsignedBlockDO blockDO) {
        // TODO get the miner uuid from config
        blockDO.setMinerUuid("replace-with-miner-uuid>");
        blockDO.setNonce(random.nextLong());
        String sha256hex = blockDO.computeHash();
        // TODO compute hash-cash size
        Long hashCashSize = 3L;
        Boolean checkForHashCash = checkForHashCashMatch(sha256hex, hashCashSize);
        if (checkForHashCash) {
            SignedBlockDO signedBlockDO = signTheBlock(blockDO);
            this.minerHandler.sendPublishBlockRequest(signedBlockDO);
        }
    }

    /**
     * Sign the given unsigned block
     *
     * @param blockDO The unsigned block
     * @return The signed block
     */
    private SignedBlockDO signTheBlock(UnsignedBlockDO blockDO) {
        // TODO generate a signed block from the given block
        return null;
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
