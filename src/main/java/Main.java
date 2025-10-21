import models.Book;
import models.User;
import services.LibraryService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Library Management System");

        while(true) {
            System.out.println("\nMenu:\n1. List Books\n2. Borrow Book\n3. Return Book\n4. Exit");
            System.out.print("Choose option: ");
            String choice = sc.nextLine();

            switch(choice) {
                case "1":
                    for(Book b : library.getBooks()) System.out.println(b);
                    break;
                case "2":
                    System.out.print("Your name: ");
                    String userName = sc.nextLine();
                    User user = library.findUser(userName);
                    if(user == null) {
                        System.out.println("User not found!");
                        break;
                    }
                    System.out.print("Book title to borrow: ");
                    String bookTitle = sc.nextLine();
                    Book book = library.findBook(bookTitle);
                    if(book == null || book.isBorrowed()) {
                        System.out.println("Book not available!");
                        break;
                    }
                    user.borrowBook(book);
                    System.out.println("Book borrowed!");
                    break;
                case "3":
                    System.out.print("Your name: ");
                    String returnUserName = sc.nextLine();
                    User returnUser = library.findUser(returnUserName);
                    if(returnUser == null) {
                        System.out.println("User not found!");
                        break;
                    }
                    System.out.print("Book title to return: ");
                    String returnTitle = sc.nextLine();
                    Book returnBook = library.findBook(returnTitle);
                    if(returnBook == null || !returnBook.isBorrowed()) {
                        System.out.println("Book not borrowed!");
                        break;
                    }
                    returnUser.returnBook(returnBook);
                    System.out.println("Book returned!");
                    break;
                case "4":
                    System.out.println("Exiting..."); sc.close(); return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
