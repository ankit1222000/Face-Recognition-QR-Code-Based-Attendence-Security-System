/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinking.machines.student.application;


import java.awt.Color;
import java.io.File;
import java.io.IOException;
import static java.lang.Boolean.FALSE;
import java.lang.System.Logger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class SplashUIController implements Initializable {

    @FXML
    private AnchorPane parent;
    @FXML
    private Pane animationPane;
    @FXML
    private ProgressBar ProgressBar;
    
    Color[] colors;
    
        

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("initialize chala");
        
       
        
        
        
        ProgressBar.setStyle("-fx-accent:green");
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                File file = new File("C:\\minor\\Staysafe");
                File[] listOfFile = file.listFiles();

                for (int i = 0; i < listOfFile.length; i++) {
                    updateProgress(i, listOfFile.length);
                    updateMessage(listOfFile[i].getName());
                    Thread.sleep(1000);

                }
                return null;
            }

        };

        ProgressBar.progressProperty().unbind();
        ProgressBar.progressProperty().bind(task.progressProperty());
        
        
        
        task.setOnSucceeded(e -> {
            Stage stageparent = (Stage) parent.getScene().getWindow();
            stageparent.close();
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                stage.setTitle("StaySafe");

                stage.initStyle(StageStyle.DECORATED);

                Scene scene = new Scene(root, 860, 540);

                stage.setScene(scene);
                stage.resizableProperty().setValue(FALSE);
                stage.show();
                

            } catch (IOException io) {
            }
        });

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();

        // TODO
    }

    
}

