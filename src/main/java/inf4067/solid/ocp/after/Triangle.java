package inf4067.solid.ocp.after;

/** EXTENSION : ajout de code uniquement, AreaCalculator reste inchangé. */
public class Triangle implements Shape {
    private final double base, height;
    public Triangle(double base, double height) { this.base = base; this.height = height; }
    @Override public double calculateArea() { return base * height / 2; }
}
