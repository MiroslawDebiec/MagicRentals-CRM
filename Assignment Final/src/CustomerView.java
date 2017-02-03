/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: CustomerView
 * Description: returns Tab object to main
 *******************************************************/

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CustomerView {
    private static TableView<Customer> customerTable;
    public static Tab getCustomerTab()
    {
        //MAIN TABLE
        customerTable = new TableView<>();

        TableColumn<Customer, String> customerNameCol = new TableColumn<>("Name");
        customerNameCol.setMinWidth(100);
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn < Customer, Integer > customerAgeCol = new TableColumn<>("Age");
        customerAgeCol.setMinWidth(30);
        customerAgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Customer, Long> customerPhoneCol = new TableColumn<>("Phone");
        customerPhoneCol.setMinWidth(80);
        customerPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Customer, String> customerEmailCol = new TableColumn<>("Email");
        customerEmailCol.setMinWidth(150);
        customerEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        customerTable.setOnMouseClicked(e -> StatsBar.setActionLabel(customerTable.getSelectionModel().getSelectedItem().getName() + " - SELECTED"));// sets value of stats label
        customerTable.setItems(InputReader.readCustomers()); // loads data from .txt file
        customerTable.getColumns().addAll(customerNameCol, customerAgeCol, customerPhoneCol, customerEmailCol);
        customerTable.setPrefSize(610,300);

        //ACTION BUTTONS
        Button addButton = new Button("Add");
        addButton.setMinWidth(85);
        addButton.setOnAction(e -> Actions.AddCustomer());

        Button deleteButton = new Button("Delete");
        deleteButton.setMinWidth(85);
        deleteButton.setOnAction(e -> Actions.RemoveCustomer());

        Button editButton = new Button("Edit");
        editButton.setMinWidth(85);
        editButton.setOnAction(e -> Actions.EditCustomer());

        Button createOrderButton = new Button("Create Order");
        createOrderButton.setMinWidth(85);
        createOrderButton.setOnAction(e -> Actions.CreateOrder() );

        Button completeOrderButton = new Button("Complete Order");
        completeOrderButton.setMinWidth(85);
        completeOrderButton.setOnAction(e -> Actions.CompleteOrder());

        Button exportCustomerButton = new Button("Export Customers");
        exportCustomerButton.setMinWidth(85);
        exportCustomerButton.setOnAction(e -> Actions.ExportCustomer());

        HBox actionMenu = new HBox();
        actionMenu.setPadding(new Insets(5,5,5,5));
        actionMenu.setSpacing(10);
        actionMenu.getChildren().addAll(addButton, editButton, deleteButton, exportCustomerButton, createOrderButton, completeOrderButton);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(customerTable, actionMenu);

        Tab customerView = new Tab("Customer View");
        customerView.setContent(vBox);
        return customerView;
    }

    public static TableView<Customer> getCustomerTable()
    {
        return customerTable;
    }


}
