import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


//Admin inherits from User class
public class Admin extends User {
    public Admin(int userID, String username, String surname, int houseNumber, String postcode, String city) {
        super(userID, username, surname, houseNumber, postcode, city);
    }

    public void viewAllBooks() {
    	List<Book> books = BookParser.parseBookFile("Stock.txt");
        System.out.println("All books sorted ascending by their quantities: ");

        Collections.sort(books, Comparator.comparingInt(book -> book.getQuantity()));
           
        for (Book book : books) {
            System.out.println(book);
        }
    }
    
    public void addBook() {
    	
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the barcode: ");
        String barcode = scanner.nextLine();
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the language: ");
        Language language = Language.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter the genre: ");
        Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter the release date: ");
        String releaseDate = scanner.nextLine();
        System.out.print("Enter the quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the retail price: ");
        double retailPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter the book type (Paperback, Ebook, or Audiobook): ");
        String bookTypeStr = scanner.nextLine().toUpperCase();
        BookType type = BookType.valueOf(bookTypeStr);

        switch (type) {
            case PAPERBACK:
                System.out.print("Enter the condition: ");
                Condition condition = Condition.valueOf(scanner.nextLine().toUpperCase());
                System.out.print("Enter the number of pages: ");
                int numPages = Integer.parseInt(scanner.nextLine());
                Paperback paperback = new Paperback(barcode, type, title, language, genre, releaseDate, quantity, retailPrice, numPages, condition);
                addBookToStock(paperback);
                break;
            case EBOOK:
                System.out.print("Enter the number of pages: ");
                int ebookPages = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter the ebook format: ");
                EbookFormat ebookFormat = EbookFormat.valueOf(scanner.nextLine().toUpperCase());
                Ebook ebook = new Ebook(barcode, type, title, language, genre, releaseDate, quantity, retailPrice, ebookPages, ebookFormat);
                addBookToStock(ebook);
                break;
            case AUDIOBOOK:
                System.out.print("Enter the length: ");
                double length = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter the audiobook format: ");
                AudiobookFormat audiobookFormat = AudiobookFormat.valueOf(scanner.nextLine().toUpperCase());
                Audiobook audiobook = new Audiobook(barcode, type, title, language, genre, releaseDate, quantity, retailPrice, length, audiobookFormat);
                addBookToStock(audiobook);
                break;
            default:
                System.out.println("Invalid book type: " + type);
                break;
        } 
    }
	    
    private void addBookToStock(Book book) {
        List<Book> books = BookParser.parseBookFile("Stock.txt");
        books.add(book);
        // Write the updated book list back to the file
        BookWriter.writeBooksToFile("Stock.txt", books);
        System.out.println("\u001B[32m" + "Book added successfully!" + "\u001B[0m");
    }

}

  
    