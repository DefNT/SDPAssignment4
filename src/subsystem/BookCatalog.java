package subsystem;

import model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookCatalog {
    private final List<Book> books = new ArrayList<>();

    public BookCatalog() {
        books.add(new Book(1, "AdventureBook"));
        books.add(new Book(2, "HistoryBook"));
        books.add(new Book(3, "MathBook"));
    }

    public Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId)
                return book;
        }
        return null;
    }

    public boolean isAvailable(int bookId) {
        Book book = findBook(bookId);
        return book != null && book.isAvailable();
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) availableBooks.add(book);
        }
        return availableBooks;
    }

    public void updateAvailability(int bookId, boolean available) {
        Book book = findBook(bookId);
        if (book != null) book.setAvailable(available);
    }
}