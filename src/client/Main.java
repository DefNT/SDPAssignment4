package client;

import facade.LibraryFacade;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LibraryFacade library = new LibraryFacade();

        System.out.println("---Available books---");
        printList(library);

        System.out.println("\n---Borrow a book---");
        System.out.println(library.borrowBook(1, 1));

        System.out.println("\n---Try to borrow it again---");
        System.out.println(library.borrowBook(1, 2));

        System.out.println("\n---Inactive member---");
        System.out.println(library.borrowBook(2, 3));

        System.out.println("\n---Unknown member and unknown book---");
        System.out.println(library.borrowBook(2, 99));
        System.out.println(library.borrowBook(99, 1));

        System.out.println("\n---Return the book on time---");
        System.out.println(library.returnBook(1));

        System.out.println("\n---Return a book that was not borrowed---");
        System.out.println(library.returnBook(1));

        System.out.println("\n---Late return with a fine---");
        System.out.println(library.borrowBook(3, 2, LocalDate.now().minusDays(20)));
        System.out.println(library.returnBook(3));

        System.out.println("\n---Available books after all tests---");
        printList(library);
    }

    private static void printList(LibraryFacade library) {
        for (String book : library.listAvailableBooks()) {
            System.out.println(book);
        }
    }
}