package io.zino.knotgrass.chain.transaction.impl;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import io.zino.knotgrass.chain.ChainHandler;
import io.zino.knotgrass.chain.transaction.TransactionRepository;
import io.zino.knotgrass.chain.transaction.domain.TransactionDO;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleTransactionRepository implements TransactionRepository {

    private final MongoCollection<Document> collection;

    public SimpleTransactionRepository(ChainHandler dana) {
        this.collection = dana.getDbHandler().getKnotgrassDB().getCollection(TransactionDO.COLLECTION);
    }

    @Override
    public boolean insert(TransactionDO transactionDO) {
        this.collection.insertOne(TransactionDO.saveTo(transactionDO));
        return true;
    }

    @Override
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
