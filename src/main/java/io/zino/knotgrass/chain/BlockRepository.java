package io.zino.knotgrass.chain;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.zino.knotgrass.domain.BlockDO;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockRepository {
    private final MongoCollection<Document> collection;

    public BlockRepository(MongoDatabase mongoDatabase) {
        this.collection = mongoDatabase.getCollection(BlockDO.COLLECTION);
    }

    public boolean insert(BlockDO blockDO) {
        this.collection.insertOne(BlockDO.saveTo(blockDO));
        return true;
    }

    public List<BlockDO> findByUuid(String uuid) {
        Map<String, Object> params = new HashMap<>();
        params.put(BlockDO.PRP_UUID, uuid);
        return findByArgs(params);
    }

    public List<BlockDO> findByIndex(Long index) {
        Map<String, Object> params = new HashMap<>();
        params.put(BlockDO.PRP_INDEX, index);
        return findByArgs(params);
    }

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
