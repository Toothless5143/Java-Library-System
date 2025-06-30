import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class for the Library Management System.
 * Handles user interaction, menu display, and library operations.
 */
public class LibrarySystem {

    private static ArrayList<Book> library = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Java Library System!");

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    System.out.println("\nThank you for using the Library System. Exiting.");
                    scanner.close();
                    return; // Exit the main method, terminating the program
                default:
                    System.out.println("\nInvalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("\n--- Library Menu ---");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
        System.out.print("Please enter your choice: ");
    }

    /**
     * Gets and validates the user's menu choice.
     * @return The validated integer choice.
     */
    private static int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear the invalid input from the scanner
            return -1; // Return an invalid choice to be handled by the switch default
        }
    }

    /**
     * Handles the logic for adding a new book or updating an existing one.
     */
    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity;
        try {
            quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid quantity. Please enter a whole number.");
            scanner.nextLine(); // Clear buffer
            return;
        }

        if (quantity <= 0) {
            System.out.println("Error: Quantity must be a positive number.");
            return;
        }

        Book existingBook = findBookByTitle(title);

        if (existingBook != null) {
            // Book already exists, so update its quantity
            existingBook.addQuantity(quantity);
            System.out.println("\nSuccess: Quantity for \"" + existingBook.getTitle() + "\" updated. New total: " + existingBook.getQuantity());
        } else {
            // Book is new, add it to the library
            Book newBook = new Book(title, author, quantity);
            library.add(newBook);
            System.out.println("\nSuccess: New book \"" + title + "\" added to the library.");
        }
    }

    /**
     * Handles the logic for borrowing a book.
     */
    private static void borrowBook() {
        System.out.print("Enter the title of the book to borrow: ");
        String title = scanner.nextLine();
        Book book = findBookByTitle(title);

        if (book == null) {
            System.out.println("\nError: Book not found in the library.");
            return;
        }

        System.out.print("Enter the number of books to borrow: ");
        int quantityToBorrow;
        try {
            quantityToBorrow = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid quantity. Please enter a whole number.");
            scanner.nextLine();
            return;
        }

        if (quantityToBorrow <= 0) {
            System.out.println("Error: Quantity to borrow must be a positive number.");
            return;
        }

        if (book.getQuantity() >= quantityToBorrow) {
            book.removeQuantity(quantityToBorrow);
            System.out.println("\nSuccess: You have borrowed " + quantityToBorrow + " copies of \"" + book.getTitle() + "\".");
            System.out.println("Remaining quantity: " + book.getQuantity());
        } else {
            System.out.println("\nError: Insufficient stock. Available quantity for \"" + book.getTitle() + "\" is " + book.getQuantity() + ".");
        }
    }

    /**
     * Handles the logic for returning a book.
     */
    private static void returnBook() {
        System.out.print("Enter the title of the book to return: ");
        String title = scanner.nextLine();
        Book book = findBookByTitle(title);

        if (book == null) {
            System.out.println("\nError: This book does not belong to our library system.");
            return;
        }

        System.out.print("Enter the number of books to return: ");
        int quantityToReturn;
        try {
            quantityToReturn = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid quantity. Please enter a whole number.");
            scanner.nextLine();
            return;
        }

        if (quantityToReturn <= 0) {
            System.out.println("Error: Quantity to return must be a positive number.");
            return;
        }

        book.addQuantity(quantityToReturn);
        System.out.println("\nSuccess: You have returned " + quantityToReturn + " copies of \"" + book.getTitle() + "\".");
        System.out.println("New quantity: " + book.getQuantity());
    }

    /**
     * Finds a book in the library by its title (case-insensitive).
     * @param title The title of the book to find.
     * @return The Book object if found, otherwise null.
     */
    private static Book findBookByTitle(String title) {
        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Return null if no book with that title is found
    }
}
