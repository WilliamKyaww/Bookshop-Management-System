
//Paperback inherits from Book class
public class Paperback extends Book {
    private int numPages;
    private Condition condition;

    // Constructor
    public Paperback(String barcode, BookType type, String title, Language language, Genre genre, String releaseDate,
                     int quantityInStock, double retailPrice, int numPages, Condition condition) {
        super(barcode, type, title, language, genre, releaseDate, quantityInStock, retailPrice);
        this.numPages = numPages;
        this.condition = condition;
    }

    // Getters and setters
    public int getNumPages() {
        return numPages;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}

