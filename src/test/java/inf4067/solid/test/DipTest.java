package inf4067.solid.test;

import static inf4067.solid.test.Check.*;
import java.util.ArrayList;
import java.util.List;

public class DipTest {
    /** Faux Database pour tester sans vraie base : possible grâce au DIP. */
    static class FakeDatabase implements inf4067.solid.dip.after.Database {
        final List<String> saved = new ArrayList<>();
        @Override public void save(String data) { saved.add(data); }
    }

    public static void run() {
        section("DIP - AVANT : OrderProcessor crée MySQLDatabase");
        inf4067.solid.dip.before.OrderProcessor old = new inf4067.solid.dip.before.OrderProcessor();
        String out = capture(() -> old.processOrder("cmd-1"));
        eq("Toujours MySQL, impossible de changer", "Saving to MySQL: cmd-1\n", out);

        section("DIP - APRÈS : OrderProcessor dépend de l'interface Database");
        eq("Injection MySQL", "Saving to MySQL: cmd-2\n",
            capture(() -> new inf4067.solid.dip.after.OrderProcessor(
                new inf4067.solid.dip.after.MySQLDatabase()).processOrder("cmd-2")));
        eq("Injection MongoDB (sans modifier OrderProcessor)", "Saving to MongoDB: cmd-3\n",
            capture(() -> new inf4067.solid.dip.after.OrderProcessor(
                new inf4067.solid.dip.after.MongoDBDatabase()).processOrder("cmd-3")));

        FakeDatabase fake = new FakeDatabase();
        new inf4067.solid.dip.after.OrderProcessor(fake).processOrder("cmd-4");
        eq("Test unitaire isolé avec un faux Database", List.of("cmd-4"), fake.saved);
    }
}
