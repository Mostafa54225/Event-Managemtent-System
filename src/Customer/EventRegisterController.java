
package Customer;

import Request.RequestCustomer;
import Request.RequestEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khalifa
 */
public class EventRegisterController {
    private Stage window;
    private HBox food;
    private Label EnameLbl, EtypeLbl, noOfPplLbl,foodLbl, cityLbl,EdateLbl;
    private Button submitBtn;
    public static TextField EnameInput, noOfPplInput, cityInput;
    public static ComboBox EtypeCB;
    public static CheckBox dinner,breakfast,lunch;
    public static DatePicker Edate;

    public static int id = 1;
    private boolean answer;
    
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Event Register");
        
        window.setOnCloseRequest(e->{
            e.consume();
            answer = AlertBox.check("sure ?", "if you close without submit your information won't be saved.\nAre you sure you want exit ?");
            if(answer) {
                window.close();
            }
                    });

        GridPane layout = new GridPane();
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
        EtypeCB.setPromptText("Choose");
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


        // to get Value from RadioButton
        RadioButton radioButton = (RadioButton)RegisterController.genderGroup.getSelectedToggle();
        
        
        submitBtn = new Button("Submit");
        submitBtn.setPrefSize(200, 23);
        GridPane.setConstraints(submitBtn, 1, 6);


        Customer1 register = new Customer1();
        RequestEvent requestEvent = new RequestEvent();


        submitBtn.setOnAction(e-> {
            if(EnameInput.getText().isEmpty() || noOfPplInput.getText().isEmpty() || cityInput.getText().isEmpty()
            || EtypeCB.getSelectionModel().isEmpty() || Edate.getValue() == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please Enter Your Details Completely");
                alert.showAndWait();
            }
            else {
                try {
                    register.addGuest(register.getFileName(), RegisterController.nameInput.getText(), RegisterController.emailInput.getText(), radioButton);
                } catch (IOException ex) {
                    Logger.getLogger(EventRegisterController.class.getName()).log(Level.SEVERE, null, ex);
                }
                requestEvent.addEvent(requestEvent.getFileName());

                Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                alertInfo.setContentText("You Registered Successfully :)");
                alertInfo.showAndWait();
                // Disable Submit Button After Registration
                submitBtn.setDisable(true);
            }

        });
        
        layout.getChildren().addAll(EnameLbl,EnameInput,EtypeLbl,EtypeCB,noOfPplLbl,noOfPplInput,foodLbl,food,cityLbl,cityInput,submitBtn,EdateLbl,Edate);
        layout.setAlignment(Pos.CENTER);


        Scene EInfoScene = new Scene(layout, 500, 600);    //event information scene

        window.setScene(EInfoScene);
        window.show();
    }
}
