import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Book> books;
    private static final String FILENAME = "library.txt";

    public Library() {
        this.books = new ArrayList<>();
        loadBooks(); // Load books from file when Library is instantiated
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks(); // Save books to file after adding a book
    }

    public void removeBook(String title) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equals(title)) {
                iterator.remove();
                System.out.println("Book removed: " + book.getTitle());
                saveBooks(); // Save books to file after removing a book
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }

    public void printBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Books in the library:");
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
        } else {
            System.out.println("Books found with title containing '" + title + "':");
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    public void searchBooksByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(book);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No books found by author containing: " + author);
        } else {
            System.out.println("Books found by author containing '" + author + "':");
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
        Collections.sort(books, (b1, b2) -> b1.getDatePublished().compareTo(b2.getDatePublished()));
        System.out.println("Books sorted by date published:");
        printBooks();
    }

    private void loadBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String title = data[0].trim();
                    String author = data[1].trim();
                    String datePublished = data[2].trim();
                    books.add(new Book(title, author, datePublished));
                }
            }
            System.out.println("Books loaded from file.");
        } catch (FileNotFoundException e) {
            System.out.println("No existing library file found. Starting with an empty library.");
        } catch (IOException e) {
            System.out.println("Error loading books from file: " + e.getMessage());
        }
    }

    private void saveBooks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Book book : books) {
                writer.write(book.getTitle() + ", " + book.getAuthor() + ", " + book.getDatePublished() + "\n");
            }
            System.out.println("Books saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving books to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        library.addBook(new Book("Java Programming", "John Doe", "2020"));
        library.addBook(new Book("Python for Beginners", "Jane Smith", "2018"));
        library.addBook(new Book("Data Structures and Algorithms", "Alan Turing", "1959"));

        // Printing all books
        library.printBooks();

        // Searching books by title
        library.searchBooksByTitle("Java");

        // Searching books by author
        library.searchBooksByAuthor("Smith");

        // Sorting books by title
        library.sortBooksByTitle();

        // Removing a book
        library.removeBook("Java Programming");

        // Printing books after removal
        library.printBooks();
    }
}
