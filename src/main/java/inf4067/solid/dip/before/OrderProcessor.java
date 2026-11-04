package inf4067.solid.dip.before;

/** AVANT : le module haut niveau instancie un détail bas niveau (viole DIP). */
public class OrderProcessor {
    private final MySQLDatabase database;

    public OrderProcessor() { this.database = new MySQLDatabase(); }

    public void processOrder(String order) { database.save(order); }
}
