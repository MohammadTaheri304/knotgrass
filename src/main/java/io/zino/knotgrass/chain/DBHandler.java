package io.zino.knotgrass.chain;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import io.zino.knotgrass.chain.ChainHandler;

public class DBHandler {

    private MongoDatabase knotgrassDB;

    public DBHandler(ChainHandler dana) {
        try {
            MongoClient mongo = new MongoClient("localhost", 27017);
            this.knotgrassDB = mongo.getDatabase("knotgrass");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MongoDatabase getKnotgrassDB() {
        return knotgrassDB;
    }
}
