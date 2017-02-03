/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: StasBar
 * Description: displays the data for all lists, selections
 *              and actions performed.
 * *******************************************************/

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class StatsBar {
    private static Label resultLabel, actionLabel;
    private static ObservableList<Customer> customers;
    private static ObservableList<Item> items;
    private static ObservableList<Order> orders;
    private static ObservableList<GameItem> games;
    private static ObservableList<DvdItem> dvds;


    public static HBox getStatsBar()
    {
        HBox statsBar = new HBox();
        resultLabel = new Label();
        resultLabel.setPadding(new Insets(5,10,10,10));
        resultLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        actionLabel = new Label();
        actionLabel.setPadding(new Insets(5,10,10,10));
        actionLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        actionLabel.setMaxWidth(300);
        actionLabel.setAlignment(Pos.BASELINE_CENTER);
        refreshStats();
        statsBar.getChildren().addAll(resultLabel, actionLabel);
        return statsBar;
    }


    public static void refreshStats()
    {
        customers = CustomerView.getCustomerTable().getItems();
        items = Inventory.getItemList();
        orders = OrderTable.getOrderTable().getItems();
        games = Inventory.getGameList();
        dvds =Inventory.getDVDList();

        resultLabel.setText("Customers: "  + customers.size()
                + "\r\nOrders: " + orders.size()
                + "\r\nInventory Items: " + items.size() + " - Games: " + Inventory.getGameList().size() + " - DVDs: " + Inventory.getDVDList().size()
                + "\r\nTotal Items: " + getItemQuntity(items) + " - Rented: " + getItemRemtedQuntity(items) + " - Availaible: " + getAvailableQuntity(items));
    }

    public static void setActionLabel(String message)
    {
        actionLabel.setText("\r\n" + message);
    }

    private static int getItemQuntity(ObservableList<Item> items)
    {
        int quantity = 0;
        for (Item i:items)
        {
            quantity += i.getTotalQuantity();
        }
        return quantity;
    }

    private static int getItemRemtedQuntity(ObservableList<Item> items)
    {
        int quantity = 0;
        for (Item i:items)
        {
            quantity += i.getRentedQuantity();
        }
        return quantity;
    }

    private static int getAvailableQuntity(ObservableList<Item> items)
    {
        int quantity = 0;
        for (Item i:items)
        {
            quantity += i.getAvailableQuantity();
        }
        return quantity;
    }
}
