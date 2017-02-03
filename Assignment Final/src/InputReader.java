/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: InputREADER
 * Description: reads data from text files and passes to
 *              objects Customer or Inventory
 *******************************************************/

//import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
//import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.util.Scanner;

public class InputReader {

    private static Scanner scanner;

    //Reading Customers
    public static ObservableList<Customer> readCustomers()
    {
        ObservableList<Customer> customers = FXCollections.observableArrayList();
        try
        {
            scanner = new Scanner(new File("Customers.txt"));
        }
        catch (FileNotFoundException ex)
        {
            ErrorWindow.display("Error: file not found"); //Error check
        }

        while (scanner.hasNext())
        {
            String firstName = scanner.next();
            String lastName = scanner.next();
            String name = firstName + " " + lastName;
            String age = scanner.next();
            String phone = scanner.next();
            String email = scanner.next();

            customers.add(new Customer(name, age, phone, email));
        }
        return customers;
    }

    //Reading Inventory
    public static void readInventory()
    {
        Inventory inventory = new Inventory();
        try
        {
            scanner = new Scanner(new File("Inventory.txt"));
        }
        catch (FileNotFoundException ex)
        {
            ErrorWindow.display("Error: file not found"); //Error check
        }

        try {
            while (scanner.hasNext()) {
                String type = scanner.next();
                if (type.equals("DVD")) //Checks first value of DvD, creates DVDItem
                {
                    String title = scanner.next();
                    Integer quantity = Integer.parseInt(scanner.next()); ///
                    String genre = scanner.next();
                    DvdItem dvd = new DvdItem(title, type, quantity, genre);
                    inventory.addDvD(dvd);
                }
                else //Checks first value of Game, creates GameItem
                {
                    String title = scanner.next();
                    Integer quantity = Integer.parseInt(scanner.next()); ///
                    String genre = scanner.next();
                    String platform = scanner.next();
                    GameItem game = new GameItem(title, type, quantity, genre, platform);
                    inventory.addGame(game);
                }
            }
        }
        catch (Exception ex)
        {
            ErrorWindow.display(ex.getMessage()); //Error check
        }
    }
}
