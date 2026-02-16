import java.util.ArrayList;
import java.util.Scanner;

// Book Class
class Book {
    int bookId;
    String title;
    String author;
    boolean isIssued;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false; // default not issued
    }

    public void displayBook() {
        System.out.println("ID: " + bookId +
                ", Title: " + title +
                ", Author: " + author +
                ", Issued: " + isIssued);
    }
}

// User Class
class User {
    int userId;
    String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

// Library Class
class Library {
    ArrayList<Book> books = new ArrayList<>();

    // Add Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Display All Books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book b : books) {
                b.displayBook();
            }
        }
    }

    // Issue Book
    public void issueBook(int bookId) {
        for (Book b : books) {
            if (b.bookId == bookId) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book already issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // Return Book
    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b.bookId == bookId) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n==== Library Menu ====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    Book book = new Book(id, title, author);
                    library.addBook(book);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;

                case 5:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
