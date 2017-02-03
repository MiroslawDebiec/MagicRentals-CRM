/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: OutputWriter
 * Description: writes the data into .txt files for all tables
 * *******************************************************/

import java.io.FileNotFoundException;
import java.util.Formatter;


public class OutputWriter {
    private static Formatter myOutput;
    private static int counter = 0;

    //EXPORTS LIST OF CUSTOMERS
    public static void exportCustomers()
    {
        counter++;
        try
        {
            myOutput = new Formatter("CustomerExport" + counter + ".txt");
        }
        catch (FileNotFoundException ex)
        {
            ErrorWindow.display("Error: Cannot find file" + ex.getMessage());
        }
        for (Customer customer:CustomerView.getCustomerTable().getItems())
        {
            myOutput.format("Name: %s - Age: %s - Phone: %s - Email: %s \r\n", customer.getName(),customer.getAge().toString(),customer.getPhone(),customer.getEmail());
        }
        myOutput.close();
    }

    //EXPORTS LIST OF ITEMS
    public static void exportInventory()
    {
        counter++;
        try
        {
            myOutput = new Formatter("InventoryExport" + counter + ".txt");
        }
        catch (FileNotFoundException ex)
        {
            ErrorWindow.display("Error: Cannot find file" + ex.getMessage());
        }
        for (Item item:Inventory.getItemList())
        {
            myOutput.format("Title: %s - Type: %s - Description: %s - Total: %s - Rented: %s - Available: %s\r\n", item.getTitle(), item.getType(), item.getDescription(), item.getTotalQuantity(), item.getRentedQuantity(), item.getAvailableQuantity());
        }
        myOutput.close();
    }

    //EXPORTS LIST OF ORDERS
    public static void exportOrders()
    {
        counter++;
        try
        {
            myOutput = new Formatter("OrderExport" + counter + ".txt");
        }
        catch (FileNotFoundException ex)
        {
            ErrorWindow.display("Error: Cannot find file" + ex.getMessage());
        }
        for (Order order:OrderTable.getOrderTable().getItems())
        {
            myOutput.format("OrderId: %s - Customer: %s - Item: %s - Type: %s\r\n", order.getOrderId(), order.getCustomerName(), order.getItemName(), order.getItemType());
        }
        myOutput.close();
    }
}
