/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Khalifa
 */
public class EventRegisterController {
    Stage window;
    Scene EInfoScene;
    GridPane layout;
    HBox food;
    Label EnameLbl, EtypeLbl, noOfPplLbl,foodLbl, cityLbl,EdateLbl;
    TextField nameInput, emailInput, EnameInput, noOfPplInput, cityInput;
    ComboBox EtypeCB;
    CheckBox dinner,breakfast,lunch;
    DatePicker Edate;
    Button submitBtn;
    boolean answer;
    
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Event egister");
        
        window.setOnCloseRequest(e->{
            e.consume();
            answer = AlertBox.check("sure ?", "if you close without submit your information won't be saved.\nAre you sure you want exit ?");
            if(answer) {
                window.close();
            }
                    });
        
        layout = new GridPane();
        layout.setVgap(8);
        layout.setHgap(8);
        
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
        
        EdateLbl = new Label("Date of event :");
        GridPane.setConstraints(EdateLbl, 0, 4);
        
        Edate = new DatePicker();
        Edate.setPromptText("MM/DD/YYYY");
        GridPane.setConstraints(Edate, 1, 4);
        Edate.setPrefSize(200, 23);
       
        cityLbl = new Label("City of event :");
        GridPane.setConstraints(cityLbl, 0, 5);
        
        cityInput = new TextField();
        cityInput.setPromptText("ex:Cairo");
        cityInput.setPrefSize(200, 23);
        GridPane.setConstraints(cityInput, 1, 5);
        
        
        
        submitBtn = new Button("Submit");
        submitBtn.setPrefSize(200, 23);
        GridPane.setConstraints(submitBtn, 1, 6);
        submitBtn.setOnAction(e->{
            /*
            ///////////////////////////////////////////////////////
            <<<<<<<<<<<<<<<(Mostafa writes code here)>>>>>>>>>>>>>>
            \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
            */
        });
        
        layout.getChildren().addAll(EnameLbl,EnameInput,EtypeLbl,EtypeCB,noOfPplLbl,noOfPplInput,foodLbl,food,cityLbl,cityInput,submitBtn,EdateLbl,Edate);
        layout.setAlignment(Pos.CENTER);
        
        
        EInfoScene = new Scene(layout,500,600);    //event information scene
        
        window.setScene(EInfoScene);
        window.show();
    }
}
