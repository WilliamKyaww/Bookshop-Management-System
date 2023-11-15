
public class Book {
    private String barcode;
    private BookType type;
    private String title;
    private Language language;
    private Genre genre;
    private String releaseDate;
    private int quantity;
    private double retailPrice;
    
    //constructor
    public Book(String barcode, BookType type, String title, Language language, Genre genre, String releaseDate, int quantity, double retailPrice) {
        this.barcode = barcode;
        this.type = type;
        this.title = title;
        this.language = language;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.quantity = quantity;
        this.retailPrice = retailPrice;
    }
    
    //getters
    public String getBarcode() {
        return barcode;
    }
    
    public String getTitle() {
        return title;
    }
    
    public Language getLanguage() {
        return language;
    }
    
    public Genre getGenre() {
        return genre;
    }
    
    public String getReleaseDate() {
        return releaseDate;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getRetailPrice() {
        return retailPrice;
    }
    
    //setters
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setLanguage(Language language) {
        this.language = language;
    }
    
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
    
    public void decreaseStock() {
        if (quantity > 0) {
            quantity--;
        } else {
            System.out.println("\u001B[31m" + "Invalid: Stock quantity is already 0 for this book." + "\u001B[0m");
        }
    }
    
    /*
    //toString method to override so that it shows the attributes and not the object itself
    @Override
    public String toString() {
        return "Barcode: " + barcode +
               ", Type: " + type +
               ", Title: " + title +
               ", Language: " + language +
               ", Genre: " + genre +
               ", Release Date: " + releaseDate +
               ", Quantity: " + quantity +
               ", Retail Price: " + retailPrice;
    }
    */
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(barcode).append(", ");
        sb.append(type).append(", ");
        sb.append(title).append(", ");
        sb.append(language).append(", ");
        sb.append(genre).append(", ");
        sb.append(releaseDate).append(", ");
        sb.append(quantity).append(", ");
        sb.append(retailPrice).append(", ");

        if (type == BookType.PAPERBACK) {
            Paperback paperback = (Paperback) this;
            sb.append(paperback.getNumPages()).append(", ");
            sb.append(paperback.getCondition());
        } else if (type == BookType.EBOOK) {
            Ebook ebook = (Ebook) this;
            sb.append(ebook.getNumberOfPages()).append(", ");
            sb.append(ebook.getFormat());
        } else if (type == BookType.AUDIOBOOK) {
            Audiobook audiobook = (Audiobook) this;
            sb.append(audiobook.getListeningLength()).append(", ");
            sb.append(audiobook.getFormat());
        }

        return sb.toString();
    }
}

