package inf4067.solid.dip.after;

public class MongoDBDatabase implements Database {
    @Override public void save(String data) { System.out.println("Saving to MongoDB: " + data); }
}
