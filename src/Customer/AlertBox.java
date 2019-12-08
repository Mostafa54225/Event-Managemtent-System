
package Customer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Khalifa
 */
public class AlertBox {

    private static boolean answer;
    public static boolean check(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(500);
        window.setMinHeight(200);



        Button yes = new Button("Yes");
        Button no = new Button("No");
        yes.setPrefSize(70, 30);
        no.setPrefSize(70, 30);


        
        yes.setOnAction(e->{
            answer = true;
            window.close();
        });
        
        no.setOnAction(e->{
            answer = false;
            window.close();
        });
        
        Label lbl = new Label(message);
        
        VBox layout = new VBox();
        layout.getChildren().addAll(lbl,yes,no);
        layout.setAlignment(Pos.CENTER);
        // For Spacing between Buttons (Yes, No)
        layout.setSpacing(10);

        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }
    
    public static void errorAlert(String title,String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(280);
        window.setMinHeight(250);
        Label lbl = new Label(message);
        VBox layout = new VBox();
        Button btn = new Button("ok");
        btn.setOnAction(e->window.close());
        layout.getChildren().addAll(lbl,btn);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
    }
        
}
