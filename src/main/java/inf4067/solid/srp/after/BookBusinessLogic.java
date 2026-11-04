package inf4067.solid.srp.after;

/** Responsabilité : logique métier. */
public class BookBusinessLogic {
    public void emprunter(BookSRP book, String lecteur) {
        System.out.println("Emprunt du livre '" + book.getTitle() + "' par " + lecteur);
    }

    public void autreService(BookSRP book) {
        System.out.println("Autre logique métier sur le livre '" + book.getTitle() + "'");
    }
}
