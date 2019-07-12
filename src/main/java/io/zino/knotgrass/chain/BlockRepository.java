package io.zino.knotgrass.chain;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.zino.knotgrass.domain.SignedBlockDO;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides data access logic for signed blocks
 *
 * @author Mohammad Taheri
 */
public class BlockRepository {
    /**
     * Mongo collection
     */
    private final MongoCollection<Document> collection;

    /**
     * Class constructor
     *
     * @param mongoDatabase Database connection object
     */
    public BlockRepository(MongoDatabase mongoDatabase) {
        this.collection = mongoDatabase.getCollection(SignedBlockDO.COLLECTION);
    }

    /**
     * Add new signed block to the database
     *
     * @param blockDO The new block
     * @return The insertion result.
     */
    public boolean insert(SignedBlockDO blockDO) {
        this.collection.insertOne(SignedBlockDO.saveTo(blockDO));
        return true;
    }

    /**
     * Get list of blocks by the given uuid
     *
     * @param uuid The queried uuid
     * @return List of the matching blocks
     */
    public List<SignedBlockDO> findByUuid(String uuid) {
        Map<String, Object> params = new HashMap<>();
        params.put(SignedBlockDO.PRP_UUID, uuid);
        return findByArgs(params);
    }

    /**
     * Get all blocks at the given depth(index)
     *
     * @param index The queried index
     * @return List of all blocks at the asked index
     */
    public List<SignedBlockDO> findByIndex(Long index) {
        Map<String, Object> params = new HashMap<>();
        params.put(SignedBlockDO.PRP_INDEX, index);
        return findByArgs(params);
    }

    /**
     * Get list of blocks with highest index
     *
     * @return The list of blocks with highest index
     */
    public List<SignedBlockDO> getHighestBlock() {
        // TODO
        return null;
    }

    /**
     * Get all the blocks that match with the given params.
     *
     * @param params The query params
     * @return The list of blocks that matched the input arguments.
     */
    private List<SignedBlockDO> findByArgs(Map<String, Object> params) {
        // create db query
        final Document query = new Document();
        params.forEach((k, v) -> query.put(k, v));

        // query the db
        FindIterable<Document> docs = this.collection.find(query);

        // Convert db results to SignedBlockDO
        List<SignedBlockDO> list = new ArrayList<SignedBlockDO>();
        for (Document doc : docs) {
            list.add(SignedBlockDO.loadFrom(doc));
        }

        // return the result
        return list;
    }
}
