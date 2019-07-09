package io.zino.knotgrass.miner;

import io.zino.knotgrass.chain.block.domain.BlockDO;

import java.util.Random;

public class Miner {

    private final CurrentMiningBlock currentMiningBlock;
    private final Random random = new Random(System.currentTimeMillis());
    private final MinerHandler minerHandler;

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

    public void mine(BlockDO blockDO) {
        this.currentMiningBlock.setBlockDO(blockDO);
    }

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

    private void tryTheBlock(BlockDO blockDO) {
        // TODO get the miner uuid from config
        blockDO.setMinnerUuid("replace-with-miner-uuid>");
        blockDO.setNonce(random.nextLong());
        String sha256hex = blockDO.computeHash();
        // TODO compute hash-cash size
        Long hashCashSize = 3L;
        Boolean checkForHashCash = checkForHashCash(sha256hex, hashCashSize);
        if (checkForHashCash) {
            this.minerHandler.sendPublishBlockResuest(blockDO);
        }
    }

    private Boolean checkForHashCash(String hash, Long size) {
        // todo
        return false;
    }
}
