/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: main
 * Description: launches the main window interface and links
 *          with all the views
 *******************************************************/


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main extends Application {
    Group root;
    Stage window;
    Scene scene;
    BorderPane subPame, mainPane;
    TabPane upperTab;
    MenuBar menuBar;
    VBox vboxBottom;

    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Magic Rentals CRM system");

        menuBar = MainMenu.getMenuBar(); //Menu tab

        upperTab = new TabPane();
        upperTab.getTabs().addAll(CustomerView.getCustomerTab(), InventoryView.getInventoryTab()); //adds Tabs for Customers and Inventory

        subPame = new BorderPane();
        subPame.setCenter(upperTab);

        vboxBottom = new VBox();
        vboxBottom.getChildren().addAll(OrderTable.setOrderTable(), StatsBar.getStatsBar());

        mainPane = new BorderPane();
        mainPane.setTop(menuBar);
        mainPane.setCenter(subPame); //Nested border panes , containing tabs and action buttons.
        mainPane.setBottom(vboxBottom);

        root = new Group();
        root.getChildren().add(mainPane);
        scene = new Scene(root, 600, 600);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
}
