package inf4067.solid.ocp.before;

/** AVANT : chaque nouvelle forme oblige à modifier cette classe (viole OCP). */
public class AreaCalculator {
    public double calculateArea(Object shape) {
        if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return r.getWidth() * r.getHeight();
        } else if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return Math.PI * c.getRadius() * c.getRadius();
        }
        throw new IllegalArgumentException("Unknown shape");
    }
}
