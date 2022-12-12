import java.io.IOException;

import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("seatarrange.fxml"));
            primaryStage.setTitle("Gui Assignment");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } 
        catch (IOException e) 
        {
            
        }  
        
    }
 
 public static void main(String[] args) {
        launch(args);
    }
}