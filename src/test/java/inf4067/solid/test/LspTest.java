package inf4067.solid.test;

import static inf4067.solid.test.Check.*;
import java.util.List;

public class LspTest {
    public static void run() {
        section("LSP - AVANT : Square extends Rectangle");
        inf4067.solid.lsp.before.Rectangle r = new inf4067.solid.lsp.before.Rectangle();
        r.setWidth(5); r.setHeight(4);
        eq("Rectangle 5x4 = 20", 20, r.getArea());

        inf4067.solid.lsp.before.Rectangle sub = new inf4067.solid.lsp.before.Square();
        sub.setWidth(5); sub.setHeight(4);
        eq("Violation LSP : le Square substitué donne 16 au lieu de 20", 16, sub.getArea());
        isTrue("Substitution cassée (20 attendu != 16 obtenu)", sub.getArea() != 20);

        section("LSP - APRÈS : Shape, Square et Rectangle indépendants");
        List<inf4067.solid.lsp.after.Shape> shapes = List.of(
            new inf4067.solid.lsp.after.Square(3),
            new inf4067.solid.lsp.after.Rectangle(3, 4));
        eq("Square(3) = 9", 9, shapes.get(0).getArea());
        eq("Rectangle(3,4) = 12", 12, shapes.get(1).getArea());
        eq("Somme polymorphe sans surprise", 21, shapes.stream().mapToInt(inf4067.solid.lsp.after.Shape::getArea).sum());
    }
}
