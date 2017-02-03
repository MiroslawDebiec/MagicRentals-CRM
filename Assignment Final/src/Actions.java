/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: Actions
 * Description: links the actions with relevant components,
 *      performs validation of input values and selections
 *******************************************************/

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Actions {
    private static  boolean flag;
    private static TableView<Customer> customerTable;
    private static TableView<Item> inventoryTable;
    private static TableView<Order> orderTable;

    private static ObservableList<Customer> allCustomers, selectedCustomers;
    private static ObservableList<Item> allItems, selectedItems;
    private static ObservableList<Order> allOrders, selectedOrders;

    private static Customer newCustomer, oldCustomer, selectedCustomer;
    private static Item oldItem, selectedItem;
    private static Order newOrder, selectedOrder;

    //Initiates selected values
    public static void getValues()
    {
        customerTable = CustomerView.getCustomerTable();
        inventoryTable = InventoryView.getInventoryTable();
        orderTable = OrderTable.getOrderTable();

        allCustomers = customerTable.getItems();
        selectedCustomers = customerTable.getSelectionModel().getSelectedItems();

        allItems = inventoryTable.getItems();
        selectedItems =inventoryTable.getSelectionModel().getSelectedItems();

        allOrders = orderTable.getItems();
        selectedOrders = orderTable.getSelectionModel().getSelectedItems();

        selectedCustomer = customerTable.getSelectionModel().getSelectedItem();
        selectedItem = inventoryTable.getSelectionModel().getSelectedItem();
        selectedOrder = orderTable.getSelectionModel().getSelectedItem();
    }

    //CUSTOMER ACTIONS
    public static void AddCustomer() //adding new customer
    {
        //getValues();
        AddCustomerWindow.display();
        newCustomer = AddCustomerWindow.getCustomer(); //AddWindow call
        flag = AddCustomerWindow.getFlag();
        if (flag) {
            CustomerView.getCustomerTable().getItems().add(newCustomer);
            StatsBar.refreshStats();
        }
        else return;
        StatsBar.setActionLabel(newCustomer.getName() + " - ADDED");
    }

    public static void EditCustomer()  //edits selected customer
    {
        getValues();
        try
        {
            oldCustomer = selectedCustomer;
            EditCustomerWindow.editCustomer(oldCustomer); //EditWindow call
            newCustomer = EditCustomerWindow.getCustomer();
            flag = EditCustomerWindow.getFlag();
            if (flag)
            {
                selectedCustomers.forEach(allCustomers::remove);
                CustomerView.getCustomerTable().getItems().add(newCustomer);
                StatsBar.refreshStats();
            }
            else return;
        }
        catch(Exception ex)
        {
            ErrorWindow.display("Error: customer not selected");
        }
        StatsBar.setActionLabel(newCustomer.getName() + " - EDITED");
    }

    public static void RemoveCustomer()  //Removes customer from list
    {
        getValues();
        try
        {
            selectedCustomers.forEach(allCustomers::remove);
            StatsBar.refreshStats();
        }
        catch(Exception ex)
        {
            ErrorWindow.display("Error: customer not selected");
        }
        StatsBar.setActionLabel(selectedCustomer.getName() + " - REMOVED");
    }

    public static void ExportCustomer() //Links with OutpuWriter for exporting values
    {
        OutputWriter.exportCustomers();
        StatsBar.setActionLabel("Customers - EXPORTED");
    }

    //INVENTORY ACTIONS
    public static void AddItem()
    {
       getValues();
        try
        {
            AddItemWindow.display();    //Call to Add Window
            StatsBar.refreshStats();
        }
        catch (Exception ex)
        {
            ErrorWindow.display("Error: select type of item");
        }

    }

    public static void EditItem()// Edits the selected item
    {
       getValues();
        try
        {
            if (selectedItem.getRentedQuantity() > 0 )
            {
                ErrorWindow.display("cannot modify item if has been rented");
                return;
            }
            EditItemWindow.editItem(selectedItem); //Edit Window call
            StatsBar.refreshStats();
            StatsBar.setActionLabel(selectedItem.getTitle() + " - AMMENDED");
        }
        catch (Exception ex)
        {
            ErrorWindow.display("Error: " + ex.getMessage());
        }

    }
    public static void RemoveItem() //Removes item from the list
    {
        getValues();
        try
        {
            if (selectedItem.getRentedQuantity() > 0 )
            {
                ErrorWindow.display("cannot delete item if has been rented");
                return;
            }
            Inventory.removeItem(selectedItem);
            StatsBar.refreshStats();
            StatsBar.setActionLabel(selectedItem.getTitle() + " - REMOVVED");
        }
        catch(Exception ex)
        {
            ErrorWindow.display("Error: " + ex.getMessage());
        }
    }

    public static void ExportInventory() //Links with OutpuWriter for exporting values
    {
        OutputWriter.exportInventory();
        StatsBar.setActionLabel("Inventory - EXPORTED");
    }

    //ORDER ACTIONS
    public static void CreateOrder() { //creates new order, updates inventory list
        getValues();
        try
        {
            if (selectedItem.getTotalQuantity() == selectedItem.getRentedQuantity())
            {
                ErrorWindow.display("no copies in stock");
                return;
            }
            oldItem = selectedItem;
            newOrder = new Order(selectedCustomer, selectedItem);
            selectedItem.setRentedQuantity(selectedItem.getRentedQuantity() + 1);
            orderTable.getItems().add(newOrder);
            Inventory.replaceItem(oldItem, selectedItem);
            StatsBar.refreshStats();
            StatsBar.setActionLabel(newOrder.getOrderId() + " - CREATED");
        }
        catch (Exception ex)
        {
            ErrorWindow.display("Error: select both customer and item");
        }
    }

    public static void CompleteOrder() //updates item in items list
    {
        getValues();
        try
        {
            selectedOrders.forEach(allOrders::remove);
            selectedItem = selectedOrder.getItem();
            oldItem = selectedItem;
            selectedItem.setRentedQuantity(selectedItem.getRentedQuantity() - 1);
            Inventory.replaceItem(oldItem, selectedItem);
            StatsBar.refreshStats();
        }
        catch (Exception ex)
        {
            ErrorWindow.display("Error: order not selected");
        }
        StatsBar.setActionLabel(selectedOrder.getOrderId() + " - COMPLETED");
    }

    public static void ExportOrders() //Links with OutpuWriter for exporting values
    {
        OutputWriter.exportOrders();
        StatsBar.setActionLabel("Oders - EXPORTED");
    }
}
