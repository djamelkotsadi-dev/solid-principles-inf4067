package inf4067.solid.ocp.after;

public class Rectangle implements Shape {
    private final double width, height;
    public Rectangle(double width, double height) { this.width = width; this.height = height; }
    @Override public double calculateArea() { return width * height; }
}
