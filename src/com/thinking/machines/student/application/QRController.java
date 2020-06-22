package com;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;  

public class QRController 
{
    @FXML
    private Button Admin;
    
    
    
    public void QRScan(ActionEvent event) throws Exception
        {
          Stage stage=new Stage();
          stage.setTitle("StaySafe");
          Parent root = FXMLLoader.load(getClass().getResource(".fxml"));
              stage.initStyle(StageStyle.DECORATED);
              Scene scene = new Scene(root, 803, 464);
              stage.setScene(scene);
              stage.resizableProperty().setValue(false);
              stage.show(); 
              //ScanModule sc=new ScanModule();
              
        }
    public void Admin(ActionEvent event) throws Exception
    {
    Stage stage=new Stage();
    stage.setTitle("StaySafe");
          Parent root = FXMLLoader.load(getClass().getResource("Dialog.fxml"));
              stage.initStyle(StageStyle.DECORATED);
              Scene scene = new Scene(root, 803, 464);
              stage.setScene(scene);
              stage.resizableProperty().setValue(false);
              stage.show(); 
              
              
              
              //Admin ad=new Admin();
    
    
    }     
    
}
