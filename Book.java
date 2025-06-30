/**
 * Represents a book with a title, author, and available quantity.
 * This class encapsulates the data for a single book entry in the library.
 */
public class Book {
    private String title;
    private String author;
    private int quantity;

    /**
     * Constructs a new Book object.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param quantity The initial quantity of the book.
     */
    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    // Getters for book properties
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Increases the quantity of this book.
     * @param amount The number of books to add.
     */
    public void addQuantity(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        }
    }

    /**
     * Decreases the quantity of this book.
     * @param amount The number of books to remove.
     */
    public void removeQuantity(int amount) {
        if (amount > 0 && this.quantity >= amount) {
            this.quantity -= amount;
        }
    }
}
