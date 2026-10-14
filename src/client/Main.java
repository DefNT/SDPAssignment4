package client;

import facade.LibraryFacade;

public class Main {
    public static void main(String[] args) {
        LibraryFacade library = new LibraryFacade();

        System.out.println("---Available books---");
        printList(library);

        System.out.println("\n---Borrow a book---");
        System.out.println(library.borrowBook(1, 1));
    }

    private static void printList(LibraryFacade library) {
        for (String book : library.listAvailableBooks()) {
            System.out.println(book);
        }
    }
}