package inf4067.solid.srp.after;

/** Responsabilité : persistance. */
public class BookSaver {
    public void saveToDatabase(BookSRP book) {
        System.out.println("Sauvegarde de '" + book.getTitle() + "' en base de données...");
    }

    public void saveToFile(BookSRP book, String filename) {
        System.out.println("Sauvegarde de '" + book.getTitle() + "' dans " + filename);
    }
}
