package io.zino.knotgrass.chain.block.impl;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import io.zino.knotgrass.Dana;
import io.zino.knotgrass.chain.block.domain.BlockDO;
import io.zino.knotgrass.chain.block.ChainRepository;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleBlockRepository extends Dana.DanaService implements ChainRepository {
    private final MongoCollection<Document> collection;

    public SimpleBlockRepository(Dana dana) {
        super(dana);
        this.collection = dana.getDbHandler().getKnotgrassDB().getCollection("blocks");
    }

    @Override
    public boolean insert(BlockDO blockDO) {
        this.collection.insertOne(BlockDO.saveTo(blockDO));
        return true;
    }

    @Override
    public List<BlockDO> findByUuid(String uuid) {
        Map<String, Object> params = new HashMap<>();
        params.put(BlockDO.PRP_UUID, uuid);
        return findByArgs(params);
    }

    @Override
    public List<BlockDO> findByIndex(Long index) {
        Map<String, Object> params = new HashMap<>();
        params.put(BlockDO.PRP_INDEX, index);
        return findByArgs(params);
    }

    @Override
    public List<BlockDO> getHighestBlock() {
        // TODO
        return null;
    }

    private List<BlockDO> findByArgs(Map<String, Object> params) {
        List<BlockDO> list = new ArrayList<BlockDO>();
        final Document query = new Document();
        params.forEach((k, v) -> query.put(k, v));
        FindIterable<Document> docs = this.collection.find(query);
        for (Document doc : docs) {
            list.add(BlockDO.loadFrom(doc));
        }
        return list;
    }
}
