package facade;

import model.Book;
import model.Loan;
import model.Member;
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

    public String borrowBook(int bookId, int memberId) {
        return borrowBook(bookId, memberId, java.time.LocalDate.now());
    }

    public String borrowBook(int bookId, int memberId, java.time.LocalDate borrowDate) {
        Member member = memberRegistry.findMember(memberId);
        if (member == null) {
            return "Error: member not found";
        }
        if (!member.isActive()) {
            return "Error: membership is inactive";
        }
        Book book = bookCatalog.findBook(bookId);
        if (book == null) {
            return "Error: book not found";
        }
        if (!book.isAvailable()) {
            return "Error: book is not available";
        }

        Loan loan = loanManager.createLoan(bookId, memberId, borrowDate);
        bookCatalog.updateAvailability(bookId, false);
        notificationService.notifyBorrowed(member, book);

        return "Book borrowed successfully. Due date: " + loan.getDueDate();
    }

    public String returnBook(int bookId) {
        return returnBook(bookId, java.time.LocalDate.now());
    }

    public String returnBook(int bookId, java.time.LocalDate returnDate) {
        Loan loan = loanManager.findActiveLoan(bookId);
        if (loan == null) {
            return "Error: no active loan found for this book";
        }

        Book book = bookCatalog.findBook(bookId);
        Member member = memberRegistry.findMember(loan.getMemberId());

        if (book == null || member == null) {
            return "Error: book or member not found";
        }

        double fine = fineCalculator.calculateFine(loan, returnDate);
        loanManager.returnLoan(loan);
        bookCatalog.updateAvailability(bookId, true);
        notificationService.notifyReturned(member, book, fine);

        return "Book returned successfully";
    }
}