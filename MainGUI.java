import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

public class MainGUI extends Application {

    private TextField usernameField;
    private TextField passwordField;
    private Button loginButton;
    private Text topText;

    public void start(Stage primaryStage) {

        primaryStage.setTitle("Doctors Office Management System");

        Label Username = new Label("Username:");
        usernameField = new TextField();
        usernameField.setOnAction(this::LoginAttempt);
        usernameField.setPrefWidth(150);

        Label Password = new Label("Password");
        passwordField = new TextField();
        passwordField.setOnAction(this::LoginAttempt);
        passwordField.setPrefWidth(150);

        loginButton = new Button("Login");
        loginButton.setOnAction(this::LoginAttempt);

        topText = new Text("Doctors Office Management System");
        topText.setFont(Font.font("Arial", 20));
    

        VBox topBox = new VBox(topText);
        topBox.setAlignment(Pos.CENTER);
        topBox.setMinHeight(150);

        FlowPane pane = new FlowPane(Username, usernameField, Password, passwordField, loginButton);
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(25);
        pane.setVgap(10);

        VBox mainBox = new VBox(topBox, pane);
        mainBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainBox, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void LoginAttempt(ActionEvent event) {

        if (event.getSource() == loginButton) {
            passwordField.clear();
            usernameField.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
