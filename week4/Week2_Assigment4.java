class Book {

    private String title;
    private String author;
    private int currentPage;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.currentPage = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void turnPage() {
        currentPage++;
    }

    public String getCurrentPageContent() {
        return "Content of page " + currentPage;
    }

    public String getLocation() {
        return "Shelf 42, Room 3";
    }
}

interface Printer {

    void printPage(String page);
}

class PlainTextPrinter implements Printer {

    @Override
    public void printPage(String page) {
        System.out.println(page);
    }
}

class BookSaver {

    public void save(Book book) {
        String filename = book.getTitle() + " - " + book.getAuthor() + ".txt";
        String content = "Title: " + book.getTitle() + "\n" +
                         "Author: " + book.getAuthor() + "\n" +
                         "Content: " + book.getCurrentPageContent() + "\n";
        System.out.println("Saving book to file: " + filename);
        System.out.println("File content:\n" + content);
    }
}

public class Main {
    public static void main(String[] args) {
        Book book = new Book("The Magic of Thinking Big", "John Doe");
        book.turnPage();

        Printer printer = new PlainTextPrinter();
        printer.printPage(book.getCurrentPageContent());

        BookSaver saver = new BookSaver();
        saver.save(book);
    }
}
