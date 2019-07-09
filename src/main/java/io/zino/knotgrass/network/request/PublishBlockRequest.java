package io.zino.knotgrass.network.request;

import io.zino.knotgrass.chain.block.domain.BlockDO;

public class PublishBlockRequest {
    private BlockDO blockDO;

    public PublishBlockRequest(BlockDO blockDO) {
        this.blockDO = blockDO;
    }

    public BlockDO getBlockDO() {
        return blockDO;
    }
}
