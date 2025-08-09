import java.util.ArrayList;
import java.util.Scanner;

// Book Class
class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public void displayBook() {
        System.out.println(id + " | " + title + " | " + author + " | " + (isIssued ? "Issued" : "Available"));
    }
}

// User Class
class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void displayUser() {
        System.out.println(id + " | " + name);
    }
}

// Library Class
class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    // Add a new book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Add a new user
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully!");
    }

    // Display all books
    public void showBooks() {
        System.out.println("\n--- Book List ---");
        for (Book b : books) {
            b.displayBook();
        }
    }

    // Display all users
    public void showUsers() {
        System.out.println("\n--- User List ---");
        for (User u : users) {
            u.displayUser();
        }
    }

    // Issue a book
    public void issueBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book is already issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // Return a book
    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
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
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Show Books");
            System.out.println("4. Show Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bid, title, author));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();
                    library.addUser(new User(uid, name));
                    break;

                case 3:
                    library.showBooks();
                    break;

                case 4:
                    library.showUsers();
                    break;

                case 5:
                    System.out.print("Enter Book ID to issue: ");
                    int ibid = sc.nextInt();
                    library.issueBook(ibid);
                    break;

                case 6:
                    System.out.print("Enter Book ID to return: ");
                    int rbid = sc.nextInt();
                    library.returnBook(rbid);
                    break;

                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
    

