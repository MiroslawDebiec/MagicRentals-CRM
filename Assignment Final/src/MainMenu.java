/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: MainMenu
 * Description: returns MenuBar object to main, adds more functionality
 *              to the program by cooperating different menus
 * *******************************************************/

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class MainMenu {
    public static MenuBar getMenuBar()
    {
        MenuBar mainMenu = new MenuBar();

        //FIle Menu
        Menu fileMenu = new Menu("File");
        MenuItem addCustomer = new MenuItem("Add Customer...");
        addCustomer.setOnAction(e -> Actions.AddCustomer());
        MenuItem addOrder = new MenuItem("Create Order...");
        addOrder.setOnAction(e -> Actions.CreateOrder());
        MenuItem addInventory = new MenuItem("Add Inventory...");
        addInventory.setOnAction(e -> Actions.AddItem());
        fileMenu.getItems().addAll(addCustomer, addInventory, addOrder);
        fileMenu.getItems().addAll(new SeparatorMenuItem());
        fileMenu.getItems().addAll(new MenuItem("Exit"));

        //Export Menu
        Menu exportMenu = new Menu("Export");
        MenuItem exportCustomers = new MenuItem("Export Customers");
        exportCustomers.setOnAction(e-> Actions.ExportCustomer());
        MenuItem exportInventory = new MenuItem("Export Inventory");
        exportInventory.setOnAction(e-> Actions.ExportInventory());
        MenuItem exportOrders = new MenuItem("Export Orders");
        exportOrders.setOnAction(e-> Actions.ExportOrders());
        exportMenu.getItems().addAll(exportCustomers, exportInventory, exportOrders);

        //About Menu
        Menu aboutMenu = new Menu("About");
        MenuItem about = new MenuItem("About");
        about.setOnAction(e-> About.display());
        aboutMenu.getItems().add(about);

        mainMenu.getMenus().addAll(fileMenu,exportMenu,aboutMenu);
        return mainMenu;
    }
}
