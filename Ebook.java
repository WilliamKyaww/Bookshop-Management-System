
//Ebook inherits from Book class
public class Ebook extends Book {
    private int numberOfPages;
    private EbookFormat format;

    //constructor
    public Ebook(String barcode, BookType type, String title, Language language, Genre genre, String releaseDate, int quantityInStock, double retailPrice, int numberOfPages, EbookFormat format) {
        super(barcode, type, title, language, genre, releaseDate, quantityInStock, retailPrice);
        this.numberOfPages = numberOfPages;
        this.format = format;
    }
    
    //getter
    public int getNumberOfPages() {
        return numberOfPages;
    }
    
    public EbookFormat getFormat() {
        return format;
    }

    //setter
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setFormat(EbookFormat format) {
        this.format = format;
    }
}
