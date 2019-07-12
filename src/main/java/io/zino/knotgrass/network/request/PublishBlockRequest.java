package io.zino.knotgrass.network.request;

import io.zino.knotgrass.domain.SignedBlockDO;

public class PublishBlockRequest {
    private SignedBlockDO blockDO;

    public PublishBlockRequest(SignedBlockDO blockDO) {
        this.blockDO = blockDO;
    }

    public SignedBlockDO getBlockDO() {
        return blockDO;
    }
}
