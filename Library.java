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
            }
        }
    }
}