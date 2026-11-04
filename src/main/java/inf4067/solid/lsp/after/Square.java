package inf4067.solid.lsp.after;

/** APRÈS : Square et Rectangle sont deux implémentations indépendantes de Shape. */
public class Square implements Shape {
    private final int side;
    public Square(int side) { this.side = side; }
    @Override public int getArea() { return side * side; }
}
