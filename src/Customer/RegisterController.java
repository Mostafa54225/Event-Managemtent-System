package Customer;

import Request.RequestCustomer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RegisterController {
    private Stage window;
    private GridPane layout;
    private HBox gender;
    private Label nameLbl, emailLbl, genderLbl;
    private Button nextBtn;
    public static TextField nameInput, emailInput;
    public static RadioButton maleRB,femaleRB;
    public static ToggleGroup genderGroup;

    private boolean answer;

    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Register");
        window.setOnCloseRequest(e->{
            e.consume();
            answer = AlertBox.check("sure ?", "if you close without submit your information won't be saved.\nAre you sure you want exit ?");
            if(answer) {
                window.close();
            }
        });
        //layout declare and set gaps
        layout = new GridPane();
        layout.setVgap(8);
        layout.setHgap(8);
        
        //Components  Declaration
        nameLbl = new Label("Name :");
        GridPane.setConstraints(nameLbl, 0, 0);
        
        nameInput = new TextField();
        nameInput.setPromptText("ex:Mahmoud");
        nameInput.setPrefSize(200, 23);
        GridPane.setConstraints(nameInput, 1, 0);
        
        
        emailLbl = new Label("e-mail :");
        GridPane.setConstraints(emailLbl, 0, 1);
        
        emailInput = new TextField();
        emailInput.setPromptText("ex:mohamed@mail.com");
        emailInput.setPrefSize(200, 23);
        GridPane.setConstraints(emailInput, 1, 1);
        
        genderLbl = new Label("Gender :");
        GridPane.setConstraints(genderLbl, 0, 3);
        
        genderGroup = new ToggleGroup();
                
        maleRB = new RadioButton("Male");
        femaleRB = new RadioButton("Female");
        maleRB.setToggleGroup(genderGroup);
        femaleRB.setToggleGroup(genderGroup);
        gender = new HBox();
        femaleRB.setPadding(new Insets(0, 0, 0 ,50));



        gender.getChildren().addAll(maleRB,femaleRB);
        GridPane.setConstraints(gender,1,3);
        
        //next Button to take you to event scene
        nextBtn = new Button("Next"); 
        nextBtn.setPrefSize(200, 23);
        GridPane.setConstraints(nextBtn, 1, 4);

        nextBtn.setOnAction(e->{
            if(nameInput.getText().isEmpty() || emailInput.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please Enter Your Email and Username");
                alert.showAndWait();
            }

            else {
                EventRegisterController ERC = new EventRegisterController();
                ERC.start(window);
            }
        });

        
        layout.getChildren().addAll(nameLbl,nameInput,emailLbl,emailInput,genderLbl,gender,nextBtn);
        layout.setAlignment(Pos.CENTER);

        Scene PInfoScene = new Scene(layout, 500, 600);  //personal information scene
        window.setScene(PInfoScene);
        window.show();
    }
}
