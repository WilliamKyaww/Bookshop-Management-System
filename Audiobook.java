
//Audiobook inherits from Book class
public class Audiobook extends Book {
    private double listeningLength;
    private AudiobookFormat format;

    //constructor
    public Audiobook(String barcode, BookType type, String title, Language language, Genre genre, String releaseDate,
                     int quantity, double retailPrice, double listeningLength, AudiobookFormat format) {
        super(barcode, type, title, language, genre, releaseDate, quantity, retailPrice);
        this.listeningLength = listeningLength;
        this.format = format;
    }

    //getters
    public double getListeningLength() {
        return listeningLength;
    }
    
    public AudiobookFormat getFormat() {
        return format;
    }
    
    //setters
    public void setListeningLength(double listeningLength) {
        this.listeningLength = listeningLength;
    }

    public void setFormat(AudiobookFormat format) {
        this.format = format;
    }
}

