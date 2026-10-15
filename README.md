# Library Management System

This project demonstrates the Facade Design Pattern using a simple Library Management System

## Structure

```
SDPAssignment4/
└── src/
    ├── client/
    │   ├── AdvancedClient.java
    │   └── Main.java
    ├── facade/
    │   └── LibraryFacade.java
    ├── model/
    │   ├── Book.java
    │   ├── Loan.java
    │   └── Member.java
    └── subsystem/
        ├── BookCatalog.java
        ├── FineCalculator.java
        ├── LoanManager.java
        ├── MemberRegistry.java
        └── NotificationService.java
```

## Features

- List available books
- Borrow and return books
- Validate members and book availability
- Calculate fines for overdue books
- Display borrowing and returning notifications
