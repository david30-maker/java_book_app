public class Book {
    private String title;
    private String author;
    private String datePublished;

    public Book(String title, String author, String datePublished) {
        this.title = title;
        this.author = author;
        this.datePublished = datePublished;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDatePublished() {
        return datePublished;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Published: " + datePublished;
    }
}

