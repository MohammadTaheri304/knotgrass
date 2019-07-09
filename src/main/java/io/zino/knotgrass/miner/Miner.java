package io.zino.knotgrass.miner;

import io.zino.knotgrass.chain.block.domain.BlockDO;

public class Miner {

    private final CurrentMiningBlock currentMiningBlock;

    public Miner(MinerHandler dana) {
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
        // TODO
    }
}
