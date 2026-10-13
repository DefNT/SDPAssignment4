package subsystem;

import model.Loan;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FineCalculator {
    private static final double FINE_PER_DAY = 1.0;

    public double calculateFine(Loan loan, LocalDate returnDate) {
        long overdueDays = ChronoUnit.DAYS.between(loan.getDueDate(), returnDate);
        if (overdueDays > 0) {
            return overdueDays * FINE_PER_DAY;
        }
        return 0;
    }
}