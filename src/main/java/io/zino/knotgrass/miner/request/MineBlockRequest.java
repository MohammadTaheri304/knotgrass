package io.zino.knotgrass.miner.request;

import io.zino.knotgrass.domain.UnsignedBlockDO;

public class MineBlockRequest {
    private UnsignedBlockDO blockDO;

    public MineBlockRequest(UnsignedBlockDO blockDO) {
        this.blockDO = blockDO;
    }

    public UnsignedBlockDO getBlockDO() {
        return blockDO;
    }
}
