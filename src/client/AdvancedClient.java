package client;

import model.Loan;
import subsystem.BookCatalog;
import subsystem.FineCalculator;
import java.time.LocalDate;

public class AdvancedClient {
    public static void main(String[] args) {
        BookCatalog catalog = new BookCatalog();
        System.out.println("Book found directly in the catalog: " + catalog.findBook(1));

        FineCalculator calculator = new FineCalculator();
        Loan loan = new Loan(1, 1, LocalDate.now().minusDays(5));
        System.out.println("Fine calculated directly: $" + calculator.calculateFine(loan, LocalDate.now()));
    }
}