import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        System.out.println("List of valid usernames: ");
        List<User> users = UserParser.parseUserFile("UserAccounts.txt");

        // Display the parsed users
        for (User user : users) {
            System.out.println(user.getUsername());
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        User currentUser = null; // to check type of user later

        while (!loggedIn) {
            System.out.print("Enter your username to log in: ");
            String input = scanner.nextLine();
            for (User user : users) {
                if (user.getUsername().equalsIgnoreCase(input)) {
                    // I made the message green to show it's successful
                    System.out.println("\u001B[32m" + "Login successful!" + "\u001B[0m");
                    System.out.println();
                    loggedIn = true;
                    currentUser = user;
                    break;
                }
            }
            if (!loggedIn) {
                // I made the error message red to show it's unsuccessful
                System.out.println("\u001B[31m" + "Login failed. Please try again." + "\u001B[0m");
                System.out.println();
            }
        }

        if (currentUser instanceof Admin) {
            Admin admin = (Admin) currentUser;
            boolean logOff = false;

          //will repeat until user exits
            while (!logOff) {
                System.out.println("--You are logged in as Admin: " + currentUser.getUsername() + "--");
                System.out.print("1 - View all books"
                        + "\n2 - Add book"
                        + "\n3 - Exit"
                        + "\nEnter the number for the action you want to perform: ");
                String input = scanner.nextLine();

                System.out.println();
                
                // switch case for admin options
                switch (input) {
                    case "1":
                        admin.viewAllBooks();
                        System.out.println();
                        break;
                    case "2":
                        admin.addBook();
                        System.out.println();
                        break;
                    case "3":
                    	System.out.println("\u001B[32m" + "Logged Off!" + "\u001B[0m");
                    	logOff = true;
                        System.out.println();
                        break;
                    default:
                        System.out.println("\u001B[31m" + "Invalid option. Please try again." + "\u001B[0m");
                        System.out.println();
                        break;
                }
            }
        } else {
            Customer customer = (Customer) currentUser;
            boolean logOff = false;

            //will repeat until user exits
            while (!logOff) {
            	System.out.println("--You are logged in as Customer: " + currentUser.getUsername() + "--");
                System.out.print("1 - View all books "
                        + "\n2 - Add book into basket "
                        + "\n3 - View basket "
                        + "\n4 - Checkout basket "
                        + "\n5 - Empty basket "
                        + "\n6 - Search for books "
                        + "\n7 - Exit "
                        + "\nEnter the number for the action you want to perform: ");

                String input = scanner.nextLine();

                System.out.println();

                // switch case for customer options
                switch (input) {
                    case "1":
                        customer.viewAllBooks();
                        System.out.println();
                        break;
                    case "2":
                        customer.addBookToBasket();
                        System.out.println();
                        break;
                    case "3":
                        customer.viewShoppingBasket();
                        System.out.println();
                        break;
                    case "4":
                    	customer.checkout();
                        System.out.println();
                        break;
                    case "5":
                    	customer.clearBasket();
                        System.out.println();
                        break;
                    case "6":
                    	customer.searchAndFilter();
                        System.out.println();
                        break;
                    case "7":
                    	System.out.println("\u001B[32m" + "Logged Off!" + "\u001B[0m");
                    	logOff = true;
                        break;
                    default:
                        System.out.println("\u001B[31m" + "Invalid option. Please try again." + "\u001B[0m");
                        System.out.println();
                        break;
                }
            }
        }
    }
}
