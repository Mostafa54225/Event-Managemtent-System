/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sample.Main;

/**
 *
 * @author Khalifa
 */
public class CustomerController extends Main {
    private Stage window;
    
    @Override
    public void start(Stage primaryStage)  {
        window = primaryStage;
        window.setTitle("Customer home page");
        StackPane stackPane = new StackPane();
        Label label = new Label("customer Page");
        stackPane.getChildren().add(label);
        Scene scene = new Scene(stackPane, 600,600);
        window.setScene(scene);
        window.show();
    }
}
