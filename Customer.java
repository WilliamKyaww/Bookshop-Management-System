import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//Customer inherits from User class
public class Customer extends User {
    private double creditBalance;
    private ArrayList<Book> shoppingBasket;

    //constructor
    public Customer(int userID, String username, String surname, int houseNumber, String postcode, String city, double creditBalance) {
        super(userID, username, surname, houseNumber, postcode, city);
        this.creditBalance = creditBalance;
        this.shoppingBasket = new ArrayList<>();
    }

    //getters
    public double getCreditBalance() {
        return creditBalance;
    }

    public ArrayList<Book> getShoppingBasket() {
        return shoppingBasket;
    }
    
    //setter
    public void setCreditBalance(double creditBalance) {
        this.creditBalance = creditBalance;
    }


  //view books
    public void viewAllBooks() {
    	List<Book> books = BookParser.parseBookFile("Stock.txt");
        System.out.println("All books sorted ascending by their prices: ");
        
        Collections.sort(books, Comparator.comparingDouble(book -> book.getRetailPrice()));
           
        for (Book book : books) {
            System.out.println(book);
        }
    }
    
    //add item
    public void addBookToBasket() {
        System.out.print("Enter the barcode of the book to add into basket: ");
        Scanner scanner = new Scanner(System.in);
        String barcode = scanner.nextLine();
        List<Book> books = BookParser.parseBookFile("Stock.txt");
        
        // Search for the book by barcode
        Book bookToAdd = null;
        for (Book book : books) {
            if (book.getBarcode().equals(barcode)) {
                bookToAdd = book; //bookToAdd isn't null anymore
                break;
            }
        }
        
        if (bookToAdd != null) {
            shoppingBasket.add(bookToAdd);
            System.out.println("\u001B[32m" + "Book added to the shopping basket!" + "\u001B[0m");

        } else {
            System.out.println("\u001B[31m" + "Book not found!" + "\u001B[0m");
        }
    }

    
    //view basket
    public void viewShoppingBasket() {
        if (shoppingBasket.isEmpty()) {
            System.out.println("The shopping basket is empty.");
        } else {
            System.out.println("Items in the shopping basket:");
            for (Book book : shoppingBasket) {
                System.out.println(book);
            }
        }
    }
    


   
  //checkout
    public void checkout() {
        double totalPrice = 0;
        for (Book book : shoppingBasket) {
            totalPrice += book.getRetailPrice();
        }

        if (totalPrice > creditBalance) {
            System.out.println("\u001B[31m" + "Error: Insufficient credit balance to complete the purchase." + "\u001B[0m");
            System.out.println("\u001B[31m" + "You only have " + creditBalance + ". The total price is " + totalPrice + "!\u001B[0m");
        } else {
            creditBalance -= totalPrice;
            //User user = main.currentUser();
            //String fullAddress = user.getHouseNumber() + ", " + user.getPostcode() + ", " + user.getCity(); 
            String fullAddress = ("Placeholder location");
            System.out.println("\u001B[32m" + "Thank you for the purchase! £" 
            					+ totalPrice + " paid and your remaining credit balance is £" 
            					+ creditBalance + ". Your delivery address is " 
            					+ fullAddress + "." + "\u001B[0m");
            
            // Update stock levels
            for (Book book : shoppingBasket) {
                book.decreaseStock();
            }
            
            clearBasket();
        }
    }

    
    //clear basket
    public void clearBasket() {
    	System.out.println("Basket cleared");
        shoppingBasket.clear();
    }
    
    //search by barcode
    public Book barcodeSearch(String barcode) {
    	List<Book> searchBooks = BookParser.parseBookFile("Stock.txt");
    	for (Book book : searchBooks) {
            if (book.getBarcode().equals(barcode)) {
                return book;
            }
        }
        return null; // Book with the given barcode not found
    }
    
    //filter by audiobook duration
    public List<Book> audiobooksDurationFilter(double listeningLength) {
    	List<Book> filteredBooks = BookParser.parseBookFile("Stock.txt");
        //List<Book> filteredBooks = new ArrayList<>();
        for (Book book : filteredBooks) {
            if (book instanceof Audiobook && ((Audiobook) book).getListeningLength() > listeningLength) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }
    
    
    //combining the two previous methods into one
    public void searchAndFilter() {
        Scanner scanner = new Scanner(System.in);

        // Barcode search
        System.out.print("Enter the barcode to search: ");
        String barcode = scanner.nextLine();
        Book book = barcodeSearch(barcode);
        
        if (book != null) { //if book isn't empty
            System.out.println("Book found:");
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
        
        
        System.out.println();

        // Audiobook duration/listening length filter
        System.out.print("Enter the minimum audiobook duration (in hours) to filter: ");
        double duration = scanner.nextDouble();
        List<Book> filteredBooks = audiobooksDurationFilter(duration);

        if (!filteredBooks.isEmpty()) {
            System.out.println("Filtered books (Audiobooks with duration > " + duration + " hours):");
            for (Book filteredBook : filteredBooks) {
                System.out.println(filteredBook);
            }
        } else {
            System.out.println("No books match the filter criteria.");
        }
    }

    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


  















