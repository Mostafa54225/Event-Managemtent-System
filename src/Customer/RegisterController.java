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
    Scene EInfoScene;
    GridPane layout;
    GridPane layout2;
    HBox gender;
    HBox food;
    Label nameLbl;
    Label emailLbl;
    Label genderLbl;
    Label EnameLbl;
    Label EtypeLbl;
    Label noOfPplLbl;
    Label foodLbl;
    Label cityLbl;
    TextField nameInput;
    TextField emailInput;
    TextField EnameInput;
    TextField noOfPplInput;
    TextField cityInput;
    ComboBox EtypeCB;
    RadioButton maleRB,femaleRB;
    ToggleGroup genderGroup;
    CheckBox dinner,breakfast,lunch;
    Button nextBtn;
    Button submitBtn;
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
        
        layout2 = new GridPane();
        layout2.setVgap(8);
        layout2.setHgap(8);
        
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
            window.setTitle("Register");
            window.setScene(EInfoScene);
        });
        
        layout.getChildren().addAll(nameLbl,nameInput,emailLbl,emailInput,genderLbl,gender,nextBtn);
        layout.setAlignment(Pos.CENTER);
        
        PInfoScene = new Scene(layout,500,600);  //personal information scene
        
        EnameLbl = new Label("Event's name :");
        GridPane.setConstraints(EnameLbl, 0, 0);
        
        EnameInput = new TextField();
        EnameInput.setPromptText("ex:ICT");
        EnameInput.setPrefSize(200, 23);
        GridPane.setConstraints(EnameInput, 1, 0);
        
        EtypeLbl = new Label("Event's type:");
        GridPane.setConstraints(EtypeLbl, 0, 1);
        
        EtypeCB = new ComboBox();
        EtypeCB.setPrefSize(200, 23);
        GridPane.setConstraints(EtypeCB, 1, 1);
        EtypeCB.getItems().addAll(
                "Technology",
                "Motivation",
                "Coaching",
                "religous",
                "political",
                "Sport"
        );
        EtypeCB.setEditable(true);
        
        noOfPplLbl = new Label("Number of vistors :");
        GridPane.setConstraints(noOfPplLbl, 0, 2);
        
        noOfPplInput = new TextField();
        noOfPplInput.setPromptText("ex:500");
        noOfPplInput.setPrefSize(200, 23);
        GridPane.setConstraints(noOfPplInput, 1, 2);
        
        food = new HBox();
        
        foodLbl = new Label("Food :");
        GridPane.setConstraints(foodLbl, 0, 3);
        
        breakfast = new CheckBox("Breakfast");
        lunch = new CheckBox("Lunch");
        dinner = new CheckBox("Dinner");
        
        breakfast.setPadding(new Insets(0,20,0,0));
        lunch.setPadding(new Insets(0,20,0,0));
        dinner.setPadding(new Insets(0,20,0,0));
        
        food.getChildren().addAll(breakfast,lunch,dinner);
        GridPane.setConstraints(food, 1, 3);
        
        
       
        cityLbl = new Label("City of event :");
        GridPane.setConstraints(cityLbl, 0, 4);
        
        cityInput = new TextField();
        cityInput.setPromptText("ex:Cairo");
        cityInput.setPrefSize(200, 23);
        GridPane.setConstraints(cityInput, 1, 4);
        
        
        
        submitBtn = new Button("Submit");
        submitBtn.setPrefSize(200, 23);
        GridPane.setConstraints(submitBtn, 1, 5);
        submitBtn.setOnAction(e->{
            /*
            ///////////////////////////////////////////////////////
            <<<<<<<<<<<<<<<(Mostafa writes code here)>>>>>>>>>>>>>>
            \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
            */
        });
        
        layout2.getChildren().addAll(EnameLbl,EnameInput,EtypeLbl,EtypeCB,noOfPplLbl,noOfPplInput,foodLbl,food,cityLbl,cityInput,submitBtn);
        layout2.setAlignment(Pos.CENTER);
        
        
        EInfoScene = new Scene(layout2,500,600);    //event information scene
        
        window.setScene(PInfoScene);
        window.show();
    }
}