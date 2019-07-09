package io.zino.knotgrass.chain.request;

import io.zino.knotgrass.domain.BlockDO;

public class RegisterBlock {
    private BlockDO blockDO;

    public RegisterBlock(BlockDO blockDO) {
        this.blockDO = blockDO;
    }

    public BlockDO getBlockDO() {
        return blockDO;
    }
}