package io.zino.knotgrass.chain.block;

import io.zino.knotgrass.chain.block.domain.BlockDO;

import java.util.List;

public interface ChainRepository {

    public boolean insert(BlockDO blockDO);

    public List<BlockDO> findByUuid(String uuid);

    public List<BlockDO> findByIndex(Long index);

    public List<BlockDO> getHighestBlock();
}
