package inf4067.solid.lsp.after;

public class Rectangle implements Shape {
    private final int width, height;
    public Rectangle(int width, int height) { this.width = width; this.height = height; }
    @Override public int getArea() { return width * height; }
}
