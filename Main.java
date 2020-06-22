

import java.awt.Color;
import static java.lang.Boolean.FALSE;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {



    @Override
    public void start(Stage stage) throws Exception
    {
    
      
        
        stage.setTitle("StaySafe");
        Parent root=FXMLLoader.load(getClass().getResource("SplashUI.fxml"));
        //StackPane stk=new StackPane()
        stage.initStyle(StageStyle.UNDECORATED);
        //Group group = new Group();
        Scene scene = new Scene(root, 459, 459);

       


         stage.setScene(scene);
         stage.resizableProperty().setValue(FALSE);
        stage.show();
            
    
    
    }
public static void main(String[] args) 
{


        Application.launch(args);
    }
    
}