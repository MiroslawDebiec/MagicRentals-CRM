/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: EditItemWindow
 * Description: allows to change inventory quantity
 *******************************************************/


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditItemWindow {
    private static Stage window;
    private static TextField descriptionTextField, quantityTextField;
    private static Button saveButton;
    private static Item newItem, oldItem;
    private static DvdItem newDvd, oldDvd;
    private static GameItem newGame, oldGame;
    private static  boolean flag;
    private static ChoiceBox<String> choiceBox, platformBox;

    public static void editItem(Item _oldItem)
    {
        oldItem = _oldItem;
        window = new Stage();
        window.setTitle("Edit Item");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(200);
        window.setMinHeight(250);
        window.setOnCloseRequest(e->
        {
            e.consume();
            flag =false;
            window.close();
        });
        Label text = new Label("Change Quantity");
        Label title = new Label("Title: " +_oldItem.getTitle());
        Label description = new Label(oldItem.getDescription());
        Label quantity = new Label("Total: " + oldItem.getTotalQuantity());

        saveButton = new Button("Save");
        saveButton.setOnAction(e -> saveButtonClick());

        quantityTextField = new TextField(oldItem.getTotalQuantity().toString());
        quantityTextField.setPromptText("Quantity");
        //quantityTextField.setMinWidth(20);
        quantityTextField.setMaxWidth(50);

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(text, title, description, quantity,  quantityTextField, saveButton);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 250,200);
        window.setResizable(false);
        window.setScene(scene);
        window.showAndWait();

    }

    private static void saveButtonClick()
    {
        flag = true;
        try
        {
            if ((quantityTextField.getText().length()==0) || (Integer.parseInt(quantityTextField.getText()) < 1))
                throw new Exception("enter quantity");
            if (Integer.parseInt(quantityTextField.getText()) < oldItem.getRentedQuantity())
               throw new Exception("cannot lower quantity, stock already rented");

            newItem = new Item(oldItem.getTitle(), oldItem.getType(),Integer.parseInt(quantityTextField.getText()),oldItem.getRentedQuantity(), oldItem.getAvailableQuantity(), oldItem.getDescription());
            Inventory.replaceItem(oldItem, newItem);
            quantityTextField.clear();
            window.close();
        }
        catch (Exception ex)
        {
            ErrorWindow.display("Error: " + ex.getMessage());
            flag = false;
        }

    }

    public static Item getItem()
    {
        return newItem;
    }

    public static boolean getFlag()
    {
        return flag;
    }
}
