import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserParser {
    public static List<User> parseUserFile(String filename) {
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String username = parts[1].trim();
                String surname = parts[2].trim();
                int houseNumber = Integer.parseInt(parts[3].trim());
                String postcode = parts[4].trim();
                String city = parts[5].trim();
                double creditBalance = parts[6].trim().equals("") ? 0.0 : Double.parseDouble(parts[6].trim());
                String role = parts[7].trim();

                if (role.equals("admin")) {
                    User user = new Admin(id, username, surname, houseNumber, postcode, city);
                    users.add(user);
                } else if (role.equals("customer")) {
                    User user = new Customer(id, username, surname, houseNumber, postcode, city, creditBalance);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}

