package inf4067.solid.test;

import static inf4067.solid.test.Check.*;

public class OcpTest {
    public static void run() {
        section("OCP - AVANT : AreaCalculator avec instanceof");
        inf4067.solid.ocp.before.AreaCalculator old = new inf4067.solid.ocp.before.AreaCalculator();
        eq("Rectangle 4x3 = 12", 12.0, old.calculateArea(new inf4067.solid.ocp.before.Rectangle(4, 3)));
        eq("Cercle r=1 = PI", Math.PI, old.calculateArea(new inf4067.solid.ocp.before.Circle(1)));
        throwsEx("Triangle : forme inconnue => il faut MODIFIER AreaCalculator",
            IllegalArgumentException.class,
            () -> old.calculateArea(new inf4067.solid.ocp.before.Triangle(4, 3)));

        section("OCP - APRÈS : interface Shape + polymorphisme");
        inf4067.solid.ocp.after.AreaCalculator calc = new inf4067.solid.ocp.after.AreaCalculator();
        eq("Rectangle 4x3 = 12", 12.0, calc.calculateArea(new inf4067.solid.ocp.after.Rectangle(4, 3)));
        eq("Cercle r=1 = PI", Math.PI, calc.calculateArea(new inf4067.solid.ocp.after.Circle(1)));
        eq("Triangle 4x3 = 6 (extension, AreaCalculator inchangé)", 6.0,
            calc.calculateArea(new inf4067.solid.ocp.after.Triangle(4, 3)));
        inf4067.solid.ocp.after.Shape anonyme = () -> 42.0;
        eq("Nouvelle forme ajoutée à la volée", 42.0, calc.calculateArea(anonyme));
    }
}
