package Customer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Khalifa
 */
public class RegisterController {
    Stage window;
    Scene PInfoScene;
    GridPane layout;
    HBox gender;
    Label nameLbl, emailLbl, genderLbl;
    public static TextField nameInput, emailInput;
    public static RadioButton maleRB,femaleRB;
    ToggleGroup genderGroup;
    Button nextBtn;
    boolean answer;
    
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
        
        //componants declration 
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
        
        //next buuton to take you to event scene
        nextBtn = new Button("Next"); 
        nextBtn.setPrefSize(200, 23);
        GridPane.setConstraints(nextBtn, 1, 4);
        nextBtn.setOnAction(e->{
            EventRegisterController ERC = new EventRegisterController();
            ERC.start(window);
        });
        
        layout.getChildren().addAll(nameLbl,nameInput,emailLbl,emailInput,genderLbl,gender,nextBtn);
        layout.setAlignment(Pos.CENTER);
        
        PInfoScene = new Scene(layout,500,600);  //personal information scene
        window.setScene(PInfoScene);
        window.show();
    }
}