# Java-Library-System
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

A simple, console-based library management system written in Java. This project was created to demonstrate core Java concepts, including object-oriented programming, data structures, and user input handling.

## 📚 Features

*   **Add Books**: Add new books to the library collection. If a book already exists, its quantity is updated.
*   **Borrow Books**: Borrow one or more copies of a book. The system validates that the book exists and has sufficient stock.
*   **Return Books**: Return books to the library, increasing the available quantity.
*   **User-Friendly Menu**: A straightforward command-line interface for easy navigation.
*   **Robust Error Handling**: Gracefully handles invalid user input (e.g., non-numeric choices) and logical errors (e.g., borrowing an out-of-stock book).
*   **Object-Oriented Design**: Uses a `Book` class to model book data and a `LibrarySystem` class to manage the application logic.

## 🚀 Getting Started

### Prerequisites

You need to have a Java Development Kit (JDK) installed on your system (version 8 or later is recommended).

*   [Download Java JDK](https://www.oracle.com/java/technologies/downloads/)

### How to Run

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/Toothless5143/Java-Library-System.git
    cd Java-Library-System
    ```

2.  **Compile the Java files:**
    Open a terminal or command prompt in the project's root directory and run the following command to compile the source code:
    ```sh
    javac Book.java LibrarySystem.java
    ```
    This will create `Book.class` and `LibrarySystem.class` files.

3.  **Run the application:**
    Execute the main program with the following command:
    ```sh
    java LibrarySystem
    ```

The library menu will now appear in your console, and you can start interacting with the system.

## 📝 Usage Example

Here is a sample session demonstrating the program's functionality:

```
Welcome to the Java Library System!

--- Library Menu ---
1. Add Books
2. Borrow Books
3. Return Books
4. Exit
Please enter your choice: 1
Enter book title: The Hobbit
Enter book author: J.R.R. Tolkien
Enter quantity: 5

Success: New book "The Hobbit" added to the library.

--- Library Menu ---
1. Add Books
2. Borrow Books
3. Return Books
4. Exit
Please enter your choice: 2
Enter the title of the book to borrow: The Hobbit
Enter the number of books to borrow: 3

Success: You have borrowed 3 copies of "The Hobbit".
Remaining quantity: 2

--- Library Menu ---
1. Add Books
2. Borrow Books
3. Return Books
4. Exit
Please enter your choice: 2
Enter the title of the book to borrow: The Hobbit
Enter the number of books to borrow: 5

Error: Insufficient stock. Available quantity for "The Hobbit" is 2.

--- Library Menu ---
1. Add Books
2. Borrow Books
3. Return Books
4. Exit
Please enter your choice: 4

Thank you for using the Library System. Exiting.
```
## 🏗️ Code Structure

The project is organized into two classes:

*   **`Book.java`**: A model class that represents a single book. It encapsulates the book's `title`, `author`, and `quantity` and provides methods to manage these properties.
*   **`LibrarySystem.java`**: The main class that drives the application. It contains the `main` method, handles user input, displays the menu, and manages the collection of `Book` objects in an `ArrayList`.

## 📜 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE.md) file for details.
