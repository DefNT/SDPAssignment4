package subsystem;

import model.Loan;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanManager {
    private static final int LOAN_DAYS = 14;
    private final List<Loan> loans = new ArrayList<>();

    public Loan createLoan(int bookId, int memberId, LocalDate borrowDate) {
        Loan loan = new Loan(bookId, memberId, borrowDate.plusDays(LOAN_DAYS));
        loans.add(loan);
        return loan;
    }

    public Loan findActiveLoan(int bookId) {
        for (Loan loan : loans) {
            if (loan.getBookId() == bookId && !loan.isReturned())
                return loan;
        }
        return null;
    }

    public void returnLoan(Loan loan) {
        loan.setReturned(true);
    }
}