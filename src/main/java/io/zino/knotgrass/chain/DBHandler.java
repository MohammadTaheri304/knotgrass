package io.zino.knotgrass.chain;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DBHandler {
    private MongoDatabase knotgrassDB;

    public DBHandler(String url, int port, String db) {
        try {
            MongoClient mongo = new MongoClient(url, port);
            this.knotgrassDB = mongo.getDatabase(db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MongoDatabase getKnotgrassDB() {
        return knotgrassDB;
    }
}
