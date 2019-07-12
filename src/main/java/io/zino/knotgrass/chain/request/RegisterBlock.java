package io.zino.knotgrass.chain.request;

import io.zino.knotgrass.domain.SignedBlockDO;

/**
 * Encapsulate a register block request
 *
 * @author Mohammad Taheri
 */
public class RegisterBlock {
    /**
     * The block that asked to be register
     */
    private SignedBlockDO blockDO;

    /**
     * Class constructor
     *
     * @param blockDO The block wish to be register
     */
    public RegisterBlock(SignedBlockDO blockDO) {
        this.blockDO = blockDO;
    }

    /**
     * Get the block that asked to be register
     * @return The new block that should be register
     */
    public SignedBlockDO getBlockDO() {
        return blockDO;
    }
}