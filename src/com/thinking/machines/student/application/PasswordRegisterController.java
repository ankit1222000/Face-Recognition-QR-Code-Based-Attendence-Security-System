
package com.thinking.machines.student.application;
import com.thinking.machines.student.admin.*;
import com.thinking.machines.student.exception.*;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import static jdk.jfr.FlightRecorder.register;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


public class PasswordRegisterController 

{
    ObservableList<String>password=FXCollections.observableArrayList();
    @FXML Label StudentName,KeyValue,match;
    @FXML ComboBox<String> Password_register,ConfirmPass;
    @FXML TextField message,error;
    @FXML Button AllGood;
    @FXML String PhoneNumber,Namer;
    
   List<String> list=new ArrayList<>();

public void initialize()
{
    
		list.add("#");
		list.add("@");
		list.add("&");
		list.add("%");
		list.add("*");
		list.add("/;");
		list.add("+-");
		list.add("$");
}
public void setPhoneNumber(String Phone)
{
this.PhoneNumber=Phone;
}

public String getPhoneNumber()
{
return this.PhoneNumber;

}
public void setNamer(String Namer)
{
this.Namer=Namer;
}

public String getNamer()
{
return this.Namer;

}

    
    public void setALL(String FirstName,String Namer,String KeyID,LocalDate localdate,String Phonenumber)
    {
    String Name=FirstName;
    String Keyvalue=KeyID;
String name=Namer;

    setPhoneNumber(Phonenumber);
    setNamer(name);
    String Date=localdate.toString();
     String var1=Date.substring(2,4);
            String var2=Date.substring(8,10);
            String Dat=var2+var1;
            KeyValue.setText(Keyvalue);
            StudentName.setText(FirstName);
            Random rand=new Random();
            for(int i=0;i<5;i++)
            {
            password.add(Name+list.get(rand.nextInt(list.size()))+Dat+list.get(rand.nextInt(list.size())));
            System.out.println(password.get(i));
            }
    
    }
    public void SetPassword()
    {
    Password_register.setItems(password);
    }
    public void setConfirmPassword()
    {
    ConfirmPass.setItems(password);
    }
    public void SendingMessageToParent(ActionEvent e) throws DAOException
        {
            try
            {
              //  if(Password_register.getValue().toString().equals(ConfirmPass.getValue().toString()))
                //{

                
                    String mes=(String)message.getText();
                    String Key=(String)KeyValue.getText();
                    String password=(String)Password_register.getValue();
                    String PhoneNumber=getPhoneNumber();
                    String Namer=getNamer();
        
                    String Message= mes+" With Key ID: "+Key+".You can Login to the website with password as: "+password;
                    System.out.println(Message);
                    System.out.println(PhoneNumber);

                    CreateLogin cl=new CreateLogin(Namer,PhoneNumber,password,Key);
                    
                    SendSms sendsms=new SendSms(PhoneNumber,Message);


                   


    
                    String title = "Registered and QRCode created Successfully";
                    String message="you can login to the website";
                    TrayNotification tray=new TrayNotification();
              
              //send SMS to parent
              //Backend  Part yet to be  completed;
                    AnimationType type = AnimationType.POPUP;
              tray.setAnimationType(type);
              tray.setTitle(title);
              tray.setMessage(message);
              tray.setNotificationType(NotificationType.SUCCESS);
              tray.showAndDismiss(Duration.millis(2500)); 
              Stage primaryStage=(Stage)AllGood.getScene().getWindow();
              primaryStage.close();
              Stage stage=new Stage();
              stage.setTitle("StaySafe");
              Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
              stage.initStyle(StageStyle.DECORATED);
              Scene scene = new Scene(root, 730, 455);
              stage.setScene(scene);
              stage.resizableProperty().setValue(false);
              stage.initModality(Modality.APPLICATION_MODAL);
              stage.show(); 
                

                //match.setText("Password does not matches");
                //error.setStyle("-fx-border-color:red");
                //error.requestFocus();
                

        
        
            }catch(IOException u){
throw new DAOException(u.getMessage());
}

        }
    

    
}
