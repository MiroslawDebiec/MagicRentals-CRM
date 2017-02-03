/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: InventoryView
 * Description: returns Tab object to main
 *******************************************************/

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InventoryView {
    private static ObservableList<Item> inventoryList;
    private static TableView<Item> inventoryTable;

    public static Tab getInventoryTab()
    {
        //MAIN TABLE
        inventoryTable = new TableView<>();

        TableColumn<Item, String> titleCol = new TableColumn<>("Title");//1st Col
        titleCol.setMinWidth(150);
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Item, String> typeCol = new TableColumn<>("Type");//2nd Col
        typeCol.setMinWidth(50);
        typeCol.setCellValueFactory(new PropertyValueFactory<Item, String>("type"));

        TableColumn<Item, String> descriptionCol = new TableColumn<>("Description");//2nd Col
        descriptionCol.setMinWidth(50);
        descriptionCol.setCellValueFactory(new PropertyValueFactory<Item, String>("Description"));

        TableColumn<Item, Integer> totalQyantityCol = new TableColumn<>("Total");//3rd Col
        totalQyantityCol.setMinWidth(20);
        totalQyantityCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("totalQuantity"));

        TableColumn<Item, Integer> rentedQyantityCol = new TableColumn<>("Rented");//4th Col
        rentedQyantityCol.setMinWidth(20);
        rentedQyantityCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("rentedQuantity"));

        TableColumn<Item, Integer> availableQyantityCol = new TableColumn<>("Available");//5th Col
        availableQyantityCol.setMinWidth(20);
        availableQyantityCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("availableQuantity"));

        InputReader.readInventory(); //loads data from .txt file to table via Inventory class.
        inventoryTable.setOnMouseClicked(e -> StatsBar.setActionLabel(inventoryTable.getSelectionModel().getSelectedItem().getTitle() + " - SELECTED"));
        inventoryList = Inventory.getItemList();
        inventoryTable.setItems(inventoryList);
        inventoryTable.getColumns().addAll(titleCol, typeCol,descriptionCol, totalQyantityCol, rentedQyantityCol, availableQyantityCol);
        inventoryTable.setPrefSize(610,300);

        //ACTION BUTTONS
        Button addButton = new Button("Add");
        addButton.setMinWidth(85);
        addButton.setOnAction(e -> Actions.AddItem());

        Button deleteButton = new Button("Delete");
        deleteButton.setMinWidth(85);
        deleteButton.setOnAction(e -> Actions.RemoveItem());

        Button editButton = new Button("Edit");
        editButton.setMinWidth(85);
        editButton.setOnAction(e -> Actions.EditItem());

        Button createOrderButton = new Button("Create Order");
        createOrderButton.setMinWidth(85);
        createOrderButton.setOnAction(e -> Actions.CreateOrder() );

        Button completeOrderButton = new Button("Complete Order");
        completeOrderButton.setMinWidth(85);
        completeOrderButton.setOnAction(e -> Actions.CompleteOrder());

        Button exportOrderButton = new Button("Export Inventory");
        exportOrderButton.setMinWidth(85);
        exportOrderButton.setOnAction(e -> Actions.ExportInventory());

        HBox actionMenu = new HBox();
        actionMenu.setPadding(new Insets(5,5,5,5));
        actionMenu.setSpacing(10);
        actionMenu.getChildren().addAll(addButton, editButton, deleteButton, exportOrderButton, createOrderButton, completeOrderButton);
        actionMenu.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(inventoryTable, actionMenu);

        Tab inventoryView = new Tab("Inventory View");
        inventoryView.setContent(vBox);
        return inventoryView;
    }

    public static TableView<Item> getInventoryTable()
    {
        return inventoryTable;
    }

}
