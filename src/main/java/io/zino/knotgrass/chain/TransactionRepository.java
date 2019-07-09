package io.zino.knotgrass.chain;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.zino.knotgrass.domain.TransactionDO;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepository {

    private final MongoCollection<Document> collection;

    public TransactionRepository(MongoDatabase mongoDatabase) {
        this.collection = mongoDatabase.getCollection(TransactionDO.COLLECTION);
    }

    public boolean insert(TransactionDO transactionDO) {
        this.collection.insertOne(TransactionDO.saveTo(transactionDO));
        return true;
    }

    public List<TransactionDO> findByUuid(String uuid) {
        Map<String, Object> params = new HashMap<>();
        params.put(TransactionDO.PRP_UUID, uuid);
        return findByArgs(params);
    }

    private List<TransactionDO> findByArgs(Map<String, Object> params) {
        List<TransactionDO> list = new ArrayList<>();
        final Document query = new Document();
        params.forEach((k, v) -> query.put(k, v));
        FindIterable<Document> docs = this.collection.find(query);
        for (Document doc : docs) {
            list.add(TransactionDO.loadFrom(doc));
        }
        return list;
    }
}
