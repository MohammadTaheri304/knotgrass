package io.zino.knotgrass.chain;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import io.zino.knotgrass.Dana;

public class DBHandler extends Dana.DanaService {

    private MongoDatabase knotgrassDB;

    public DBHandler(Dana dana) {
        super(dana);
        MongoClient mongo = new MongoClient("localhost", 27017);
        this.knotgrassDB = mongo.getDatabase("knotgrass");
    }

    public MongoDatabase getKnotgrassDB() {
        return knotgrassDB;
    }
}
