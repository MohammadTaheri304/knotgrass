package io.zino.knotgrass.miner.request;

import io.zino.knotgrass.domain.BlockDO;

public class MineBlockRequest {
    private BlockDO blockDO;

    public MineBlockRequest(BlockDO blockDO) {
        this.blockDO = blockDO;
    }

    public BlockDO getBlockDO() {
        return blockDO;
    }
}
