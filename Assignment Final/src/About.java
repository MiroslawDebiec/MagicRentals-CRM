import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Miro on 13/12/2016.
 */
public class About {
    public static void display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("About");
        Label messageLabel = new Label();
        Label messageLabel1 = new Label();
        messageLabel.setText("Created by Miroslaw Debiec - B00540796");
        messageLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        messageLabel1.setText("COM187 - Final Assignment");
        messageLabel1.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        Button okButton = new Button("Ok");
        okButton.setOnAction(e-> window.close());
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.getChildren().addAll(messageLabel, messageLabel1, okButton);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox, 400, 100);
        window.setScene(scene);
        window.showAndWait();
    }
}
