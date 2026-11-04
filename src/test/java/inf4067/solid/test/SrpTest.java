package inf4067.solid.test;

import static inf4067.solid.test.Check.*;

public class SrpTest {
    public static void run() {
        section("SRP - AVANT : Book (4 responsabilités dans une classe)");
        inf4067.solid.srp.before.Book b =
            new inf4067.solid.srp.before.Book("SOLID", "M1-GL", "Révision");
        String out = capture(() -> { b.printToScreen(); b.saveToDatabase(); b.emprunter("Marcial"); });
        isTrue("Book affiche, sauvegarde et emprunte à la fois",
            out.contains("Titre: SOLID") && out.contains("en base de données") && out.contains("par Marcial"));

        section("SRP - APRÈS : 4 classes, 1 responsabilité chacune");
        inf4067.solid.srp.after.BookSRP book =
            new inf4067.solid.srp.after.BookSRP("SOLID", "M1-GL", "Révision");
        eq("BookSRP : getTitle", "SOLID", book.getTitle());
        eq("BookSRP : getAuthor", "M1-GL", book.getAuthor());

        String screen = capture(() -> new inf4067.solid.srp.after.BookPrinter().printToScreen(book));
        isTrue("BookPrinter : affichage écran", screen.contains("Titre: SOLID") && screen.contains("Auteur: M1-GL"));

        String html = capture(() -> new inf4067.solid.srp.after.BookPrinter().printToHTML(book));
        isTrue("BookPrinter : nouveau format HTML sans toucher BookSRP", html.contains("<h1>SOLID</h1>"));

        String db = capture(() -> new inf4067.solid.srp.after.BookSaver().saveToDatabase(book));
        isTrue("BookSaver : persistance BD", db.contains("Sauvegarde de 'SOLID' en base de données"));

        String file = capture(() -> new inf4067.solid.srp.after.BookSaver().saveToFile(book, "livre.txt"));
        isTrue("BookSaver : persistance fichier", file.contains("dans livre.txt"));

        String loan = capture(() -> new inf4067.solid.srp.after.BookBusinessLogic().emprunter(book, "Marcial"));
        isTrue("BookBusinessLogic : emprunt", loan.contains("Emprunt du livre 'SOLID' par Marcial"));
    }
}
