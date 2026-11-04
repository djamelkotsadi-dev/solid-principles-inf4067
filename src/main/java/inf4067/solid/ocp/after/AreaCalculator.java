package inf4067.solid.ocp.after;

/** APRÈS : fermée à la modification, ouverte à l'extension. */
public class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}
