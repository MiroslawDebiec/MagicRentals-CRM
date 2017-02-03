/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: OrderTable
 * Description: returns Table object to main
 *******************************************************/

//import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class OrderTable {
    private static TableView<Order> orderTable;
    public static TableView setOrderTable()
    {
        //ORDER TABLE
        orderTable = new TableView<>();
        TableColumn<Order, String> ordrIdCol = new TableColumn<>("Order ID");
        ordrIdCol.setMinWidth(50);
        ordrIdCol.setCellValueFactory(new PropertyValueFactory<Order, String>("orderId"));

        TableColumn<Order, String> orderCustCol = new TableColumn<>("Customer");
        orderCustCol.setMinWidth(150);
        orderCustCol.setCellValueFactory(new PropertyValueFactory<Order, String>("customerName"));

        TableColumn<Order, String> ordrItemCol = new TableColumn<>("Item");
        ordrItemCol.setMinWidth(150);
        ordrItemCol.setCellValueFactory(new PropertyValueFactory<Order, String>("itemName"));

        TableColumn<Order, String> ordrItemTypeCol = new TableColumn<>("Type");
        ordrItemTypeCol.setMinWidth(150);
        ordrItemTypeCol.setCellValueFactory(new PropertyValueFactory<Order, String>("itemType"));

        orderTable.setOnMouseClicked(e -> StatsBar.setActionLabel(orderTable.getSelectionModel().getSelectedItem().getOrderId() + " - SELECTED"));//sets stats label with orderID
        orderTable.getColumns().addAll(ordrIdCol, orderCustCol, ordrItemCol, ordrItemTypeCol);
        orderTable.setPrefSize(610,150);
        return orderTable;
    }
    public static TableView<Order> getOrderTable()
    {
        return orderTable;
    }
}
