package inf4067.solid.lsp.before;

/** AVANT : Square change le comportement attendu de Rectangle (viole LSP). */
public class Square extends Rectangle {
    @Override public void setWidth(int width) { super.setWidth(width); super.setHeight(width); }
    @Override public void setHeight(int height) { super.setWidth(height); super.setHeight(height); }
}
