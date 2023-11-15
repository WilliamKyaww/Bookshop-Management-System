
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BookWriter {
    public static void writeBooksToFile(String filename, List<Book> books) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Book book : books) {
                writer.write(book.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
