import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Miro on 10/12/2016.
 */
public class AddItemWindow {
    private static Stage window;
    private static TextField tileTextField, quantityTextField, descriptionTextField;
    private static Button saveButton;
    private static Item newItem;
    private static DvdItem newDvd;
    private static GameItem newGame;
    private static ChoiceBox<String> choiceBox, platformBox;

    public static void display()
    {
        window = new Stage();
        window.setTitle("Add Item");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(200);
        window.setMinHeight(250);
        window.setOnCloseRequest(e->
        {
            e.consume();
            window.close();
        });
        Label text = new Label("Item Details");

        choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("DVD");
        choiceBox.getItems().add("Game");
        choiceBox.setValue("DVD");

        platformBox = new ChoiceBox<>();
        platformBox.getItems().addAll("(PC)", "(XBOX)", "(PS4)", "UNKNOWN");
        platformBox.setValue("UNKNOWN");

        tileTextField = new TextField();
        tileTextField.setPromptText("Enter title");
        tileTextField.setMinWidth(100);

        descriptionTextField = new TextField();
        descriptionTextField.setPromptText("enter genra ie. Action or FPS.");
        descriptionTextField.setPrefSize(150, 50);

        saveButton = new Button("Save");
        saveButton.setOnAction(e -> saveButtonClick());

        quantityTextField = new TextField();
        quantityTextField.setPromptText("Quantity");
        quantityTextField.setMinWidth(20);

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(text, choiceBox, platformBox, tileTextField, quantityTextField, descriptionTextField, saveButton);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 200,250);
        window.setScene(scene);
        window.showAndWait();
    }

    private static void saveButtonClick()
    {
        try
        {
            if (tileTextField.getText().length()==0)
                throw new Exception("enter title");
            if ((quantityTextField.getText().length()==0) || (Integer.parseInt(quantityTextField.getText()) < 1))
                throw new Exception("enter quantity");

            if (choiceBox.getValue().equals("DVD"))
            {
                platformBox.setValue("UNKNOWN");
                platformBox.setDisable(true);
                String title = tileTextField.getText();
                Integer quantity = Integer.parseInt(quantityTextField.getText());
                String description = descriptionTextField.getText();
                DvdItem dvd = new DvdItem(title, choiceBox.getValue(), quantity, description);
                Inventory.addDvD(dvd);
                StatsBar.setActionLabel(dvd.getTitle() + " - ADDED");
            }
            else
            {
                String title = tileTextField.getText();
                Integer quantity = Integer.parseInt(quantityTextField.getText());
                String description = descriptionTextField.getText();
                GameItem game = new GameItem(title, choiceBox.getValue(), quantity, description, platformBox.getValue());
                Inventory.addGame(game);
                StatsBar.setActionLabel(game.getTitle() + " - ADDED");
            }
            window.close();
            tileTextField.clear();
            descriptionTextField.clear();
            quantityTextField.clear();
        }
        catch (Exception ex)
        {
            ErrorWindow.display("Error: " + ex.getMessage());
        }

    }
}
