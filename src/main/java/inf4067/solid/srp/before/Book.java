package inf4067.solid.srp.before;

/** AVANT : la classe Book cumule 4 responsabilités (viole SRP). */
public class Book {
    private String title;
    private String author;
    private String content;

    public Book(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    // Responsabilité 1 : données (entité)
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getContent() { return content; }

    // Responsabilité 2 : présentation
    public void printToScreen() {
        System.out.println("Titre: " + title);
        System.out.println("Auteur: " + author);
        System.out.println("Contenu: " + content);
    }

    // Responsabilité 3 : persistance
    public void saveToDatabase() {
        System.out.println("Sauvegarde du livre '" + title + "' en base de données...");
    }

    // Responsabilité 4 : logique métier
    public void emprunter(String lecteur) {
        System.out.println("Emprunt du livre '" + title + "' par " + lecteur);
    }
}
