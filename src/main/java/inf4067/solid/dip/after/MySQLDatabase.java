package inf4067.solid.dip.after;

public class MySQLDatabase implements Database {
    @Override public void save(String data) { System.out.println("Saving to MySQL: " + data); }
}
