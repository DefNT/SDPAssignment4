package facade;

import model.Book;
import subsystem.*;

import java.util.ArrayList;
import java.util.List;

public class LibraryFacade {
    private final BookCatalog bookCatalog;
    private final MemberRegistry memberRegistry;
    private final LoanManager loanManager;
    private final FineCalculator fineCalculator;
    private final NotificationService notificationService;

    public LibraryFacade() {
        this.bookCatalog = new BookCatalog();
        this.memberRegistry = new MemberRegistry();
        this.loanManager = new LoanManager();
        this.fineCalculator = new FineCalculator();
        this.notificationService = new NotificationService();
    }

    public List<String> listAvailableBooks() {
        List<String> titles = new ArrayList<>();
        for (Book book : bookCatalog.getAvailableBooks()) {
            titles.add(book.toString());
        }
        return titles;
    }
}