package Admin;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sample.Main;

public class AdminController extends Main {
    private Stage window;
    @Override
    public void start(Stage primaryStage)  {
        window = primaryStage;
        window.setTitle("Admin");
        StackPane stackPane = new StackPane();
        Label label = new Label("Admin Page");
        stackPane.getChildren().add(label);
        Scene scene = new Scene(stackPane, 600,600);
        window.setScene(scene);
        window.show();
    }
}
