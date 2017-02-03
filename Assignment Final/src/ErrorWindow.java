/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: ErrorWindow
 * Description: opens with custome message when Exception occurs
 *******************************************************/


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorWindow {
    public static void display(String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Error");
        Label messageError = new Label(message);
        Button okButton = new Button("Ok");
        okButton.setOnAction(e-> window.close());
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.getChildren().addAll(messageError, okButton);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox, 400, 100);
        window.setScene(scene);
        window.showAndWait();
    }
}
