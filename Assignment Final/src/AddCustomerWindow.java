import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Miro on 10/12/2016.
 */
public class AddCustomerWindow {
    private static Stage window;
    private static TextField nameTextField, ageTextField, phoneTextField, emailTextField;
    private static Button saveButton;
    private static Customer newCustomer;
    private static  boolean flag;

    public static void display()
    {
        window = new Stage();
        window.setTitle("Add Customer");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(200);
        window.setMinHeight(250);
        window.setOnCloseRequest(e->
        {
            e.consume();
            flag =false;
            window.close();
        });
        Label text = new Label("Customer Details");

        saveButton = new Button("Save");
        saveButton.setOnAction(e -> saveButtonClick());

        nameTextField = new TextField();
        nameTextField.setPromptText("Enter name");
        nameTextField.setMinWidth(100);

        ageTextField = new TextField();
        ageTextField.setPromptText("age");
        ageTextField.setMinWidth(20);

        phoneTextField = new TextField();
        phoneTextField.setPromptText("Enter phone");
        phoneTextField.setMinWidth(50);

        emailTextField = new TextField();
        emailTextField.setPromptText("Enter email");
        emailTextField.setMinWidth(100);
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(text, nameTextField, ageTextField, phoneTextField, emailTextField, saveButton);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 200,250);
        window.setScene(scene);
        window.showAndWait();
    }

    private static void saveButtonClick()
    {
        flag = true;
        newCustomer = new Customer();
        try
        {
            if (nameTextField.getText().length()==0)
                throw new Exception("Enter name field");
            if (ageTextField.getText().length()==0)
                throw new Exception("Enter age");
            if (phoneTextField.getText().length()==0)
                throw new Exception("Enter phone number");
            if (emailTextField.getText().length()==0)
                throw new Exception("Enter email address");

            newCustomer.setName(nameTextField.getText());
            newCustomer.setAge(Integer.parseInt(ageTextField.getText()));
            newCustomer.setPhone(Long.parseLong(phoneTextField.getText()));
            newCustomer.setEmail(emailTextField.getText());
            window.close();
            nameTextField.clear();
            ageTextField.clear();
            phoneTextField.clear();
            emailTextField.clear();
        }
        catch (Exception ex)
        {
            ErrorWindow.display("Error: " + ex.getMessage());
            flag = false;
        }

    }

    public static Customer getCustomer()
    {
        return newCustomer;
    }

    public static boolean getFlag()
    {
        return flag;
    }
}
