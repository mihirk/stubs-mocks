package org.egov.bootcamp.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.egov.bootcamp.model.Entity;

public class EntityDao {

    private MongoCollection<Document> entities;

    public EntityDao() {
        MongoClientURI dbURI = new MongoClientURI("mongodb://stub:mock@ds159737.mlab.com:59737/stubs-mocks");
        MongoClient dbClient = new MongoClient(dbURI);
        MongoDatabase db = dbClient.getDatabase(dbURI.getDatabase());
        entities = db.getCollection("entities");
    }

    public Entity get(Integer entityId) {
        BasicDBObject id = new BasicDBObject("id", entityId);
        MongoCursor<Document> documents = entities.find(id).iterator();
        if (documents.hasNext()) {
            Document doc = documents.next();
            return new Entity(doc.get("id", Integer.class), doc.get("name", String.class));
        }
        return null;
    }
}
