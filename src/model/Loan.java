package model;

import java.time.LocalDate;

public class Loan {
    private final int bookId;
    private final int memberId;
    private final LocalDate dueDate;
    private boolean returned;

    public Loan(int bookId, int memberId, LocalDate dueDate) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.dueDate = dueDate;
        this.returned = false;
    }

    public int getBookId() {
        return bookId;
    }
    public int getMemberId() {
        return memberId;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public boolean isReturned() {
        return returned;
    }
    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}