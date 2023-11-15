import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookParser {
	public static List<Book> parseBookFile(String fileName) {
	    List<Book> books = new ArrayList<>();
	    try {
	        Scanner scanner = new Scanner(new File(fileName));
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] bookDetails = line.split(", ");
	            String barcode = bookDetails[0];
	            String typeStr = bookDetails[1].toUpperCase(); // Convert to uppercase for case-insensitive matching
	            BookType type = getBookType(typeStr);
	            String title = bookDetails[2];
	            Language language = Language.valueOf(bookDetails[3].toUpperCase());
	            Genre genre = getGenre(bookDetails[4]);
	            String releaseDate = bookDetails[5];
	            int quantity = Integer.parseInt(bookDetails[6]);
	            double retailPrice = Double.parseDouble(bookDetails[7]);

	            switch (type) {
	                case AUDIOBOOK:
	                    double listeningLength = Double.parseDouble(bookDetails[8]);
	                    AudiobookFormat audiobookFormat = AudiobookFormat.valueOf(bookDetails[9].toUpperCase());
	                    Audiobook audiobook = new Audiobook(barcode, type, title, language, genre, releaseDate, quantity, retailPrice, listeningLength, audiobookFormat);
	                    books.add(audiobook);
	                    break;

	                case PAPERBACK:
	                    int numPages = Integer.parseInt(bookDetails[8]);
	                    Condition condition = Condition.valueOf(bookDetails[9].toUpperCase());
	                    Paperback paperback = new Paperback(barcode, type, title, language, genre, releaseDate, quantity, retailPrice, numPages, condition);
	                    books.add(paperback);
	                    break;

	                case EBOOK:
	                    int numberOfPages = Integer.parseInt(bookDetails[8]);
	                    EbookFormat ebookFormat = EbookFormat.valueOf(bookDetails[9].toUpperCase());
	                    Ebook ebook = new Ebook(barcode, type, title, language, genre, releaseDate, quantity, retailPrice, numberOfPages, ebookFormat);
	                    books.add(ebook);
	                    break;

	                default:
	                    System.out.println("Invalid book type: " + type); //just in case
	                    break;
	            }
	        }
	        scanner.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    return books;
	}

	private static BookType getBookType(String typeStr) {
	    for (BookType type : BookType.values()) {
	        if (type.name().equalsIgnoreCase(typeStr)) {
	            return type;
	        }
	    }
	    throw new IllegalArgumentException("No enum constant BookType." + typeStr); //just in case
	}

	private static Genre getGenre(String genreStr) {
	    for (Genre genre : Genre.values()) {
	        if (genre.name().equalsIgnoreCase(genreStr.replace(" ", "_"))) {
	            return genre;
	        }
	    }
	    throw new IllegalArgumentException("No enum constant Genre." + genreStr); // just in case
	}
	
}