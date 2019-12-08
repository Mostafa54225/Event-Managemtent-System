package sample;

import Admin.*;
import Customer.Customer1;
import Customer.CustomerController;
import Customer.RegisterController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginController {
    private Stage window;
    private Text welcomeText;
    private static ComboBox<String> comboBox;
    private Button loginButton, registerButton;
    public static TextField user;
    public static PasswordField pass;
    Customer1 register;

    public void start(Stage primaryStage)  {
        window = primaryStage;
        // Primary Stage Title
        window.setTitle("Login Page");
        // Layout for Main Page
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        welcomeText = new Text("Welcome");
        welcomeText.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));
        user = new TextField();
        user.setPromptText("Username");
        pass = new PasswordField();
        pass.setPromptText("Password");

        // Options to choose between them to login
        ObservableList<String> options = FXCollections.observableArrayList(
                "Admin",
                "Customer",
                "Project Manager",
                "Service Provider");
        comboBox = new ComboBox<>();
        comboBox.setPromptText("Choose");
        comboBox.setPrefSize(150, 23);
        comboBox.setItems(options);
        loginButton = new Button("Login");
        loginButton.setPrefSize(150, 23);

        registerButton = new Button("Register");
        registerButton.setPrefSize(150, 23);
        User admin = new Admin1();
        //register = new Customer1(); ///////////////////////////////////////////////////<<<ERROR>>>//////////////////////////////////
        loginButton.setOnAction(e -> {
            try {
                if(comboBox.getSelectionModel().isSelected(0)){

                    if(admin.isLogin(admin.getFileName(), user.getText(), pass.getText())) {
                        AdminController a = new AdminController();
                        a.start(window);
                    }
                }
                if(comboBox.getSelectionModel().isSelected(1)){ ///////////////////////////////////////////////////////////////////////////
                    if(admin.isLogin(admin.getFileName(), user.getText(), pass.getText())) { //////////<<<<REPLACE admin with customer object>>>>////////////////////////////////
                        CustomerController c = new CustomerController();  /////////////////////////////////////////////////////////////////
                        c.start(window); //////////////////////////////////////////////////////////////////////////////////////////////////
                    }
                }
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        registerButton.setOnAction(e->{
            RegisterController RC = new RegisterController();
            RC.start(window);
        });

        // Build the Layout
        gridPane.add(welcomeText, 0, 0);
        gridPane.add(user, 0, 1);
        gridPane.add(pass, 0 ,2);
        gridPane.add(comboBox, 0, 3);
        gridPane.add(loginButton, 0, 4);
        gridPane.add(registerButton, 0, 5);


        // Background Image
        Image image = new Image("file:Images/test.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        gridPane.setBackground(background);

        // Icon
        window.getIcons().add(new Image("file:Images/Icon1.jpg"));

        // set The scene of the window ("Primary Stage")
        Scene scene = new Scene(gridPane, 600,400);
        window.setScene(scene);
        window.show();
    }
}
