import java.io.*;
import java.util.ArraytList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Book> books;
    private static final String FILENAME= "library.txt";


    public Library() {
        this.books = new ArrayList<>();
        loadBooks();
    }

    public void addBook(Book book) {
        books.add(book)
        saveBooks();
    }

    public void removeBook(String title) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equals(title)) {
                iterator.remove();
                System.out.println("Book removed:" + book.getTitle());
                saveBooks();
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }

    public void printBooks() {
        if (books.isEmpty()){
            System.out.println("The library is empty");
        }else{
            System.out.println("Books in the library");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void searchBooksByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No books found with title containing: " + title);
        }else{
            System.out.println("Books found by author containing: '" title "':");
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    public void searchBooksByAuthor() {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(book);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No book by author containing: " + author);
        }else{
            System.out.println("Books found by containing'" + author + "':");
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    public void sortBooksByTitle() {
        Collections.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
        System.out.println("Books sorted by title:");
        printBooks();
    }

    public void sortBooksByDatePublished() {
        Collections.sort(books, (b1, b2) -> b1.getDatepublished().compareTo(b2.getDatepublished()));
        System.out.println("Book sorted by date published:");
        printBooks();

    }
}