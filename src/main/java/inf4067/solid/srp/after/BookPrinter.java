package inf4067.solid.srp.after;

/** Responsabilité : présentation. */
public class BookPrinter {
    public void printToScreen(BookSRP book) {
        System.out.println("===Print to Screen=== ");
        System.out.println("Titre: " + book.getTitle());
        System.out.println("Auteur: " + book.getAuthor());
        System.out.println("Contenu: " + book.getContent());
    }

    // Nouveau format d'affichage sans toucher à BookSRP
    public void printToHTML(BookSRP book) {
        System.out.println("===Print to HTML=== ");
        System.out.println("<h1>" + book.getTitle() + "</h1>");
        System.out.println("<h2>Par " + book.getAuthor() + "</h2>");
        System.out.println("<p>" + book.getContent() + "</p>");
    }
}
