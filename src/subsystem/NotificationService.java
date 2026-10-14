package subsystem;

import model.Book;
import model.Member;

public class NotificationService {
    public void notifyBorrowed(Member member, Book book) {
        System.out.println("Notification: " + member.getName()
                + " borrowed \"" + book.getTitle() + "\"");
    }

    public void notifyReturned(Member member, Book book, double fine) {
        System.out.println("Notification: " + member.getName()
                + " returned \"" + book.getTitle()
                + "\". Fine: $" + String.format("%.2f", fine));
    }
}