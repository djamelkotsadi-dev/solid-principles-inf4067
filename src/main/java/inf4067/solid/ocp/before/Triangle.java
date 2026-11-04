package inf4067.solid.ocp.before;

/** Nouvelle forme : AreaCalculator ne la gère pas => il faudra le modifier. */
public class Triangle {
    private final double base, height;
    public Triangle(double base, double height) { this.base = base; this.height = height; }
    public double getBase() { return base; }
    public double getHeight() { return height; }
}
