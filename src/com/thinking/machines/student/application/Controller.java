 
package com.thinking.machines.student.application;

import com.thinking.machines.student.admin.*;
import com.thinking.machines.student.application.*;
import com.thinking.machines.student.data.*;
import com.thinking.machines.student.exception.*;
import com.thinking.machines.student.face_recognition.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.management.Notification;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.text.*;


public class Controller
{
    ObservableList<String> StateNames=FXCollections.observableArrayList("Maharastra","Gujarat","MadhyaPradesh","UttarPradesh");
    ObservableList<String> MadhyaPradesh=FXCollections.observableArrayList("Ujjain","Indore","Dewas","Nagda","Bhopal");
        ObservableList<String>Maharastra=FXCollections.observableArrayList("Mumbai","Pune","Nagpur","Nasik","Lonavala");
        ObservableList<String>Gujarat=FXCollections.observableArrayList("Gandhinagar","Porbandar","Ahemdabad","Surat","Vadodara");
ObservableList<String>UttarPradesh=FXCollections.observableArrayList("Bihar","Patna","Lucknow","Kanpur","Agra");
ObservableList<String>ClassList=FXCollections.observableArrayList("XI","XII");
ObservableList<String>StreamList=FXCollections.observableArrayList("Maths","Biology","Commerce");
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
@FXML
    private Label Errormsg,SecureError,PleaseEnter;
@FXML
    private TextField Username,SecureKey,FirstName,SecondName,PhoneNumber,Address1,Address2,FatherName,MotherName;
@FXML
    private TextField Password,message;
@FXML
private BorderPane Mainpane,showRecordPane;
@FXML
private Button SecureBtn,button,Admin,ConfirmNO,sms,createNew,logout,presenties,register,Cancel,showRecord,cancelRecord,logoutbtn,showDataButton,showDataButton2;
@FXML
private ComboBox<String> State,City,Country,Class,Streamselect;
@FXML
private RadioButton genderradio;
@FXML
private ToggleGroup Gender;
@FXML
private TextArea Absent,Present,Late,SNo,sno;
@FXML
private LocalDate localdate;
@FXML 
private DatePicker DOB;
String Firstname,Secondname,address1,address2,Mothername,Fathername,Phonenumber,city,state,country,classvalue,gender,Message;


        public void ButtonPressed(ActionEvent event) throws Exception
        {
            
            Stage stage =new Stage();
            
          if (Username.getText().isEmpty()|| Password.getText().isEmpty()) 
          {
              Errormsg.setText("Please Enter your UserName or Password!!!");
          }
          
          
          if(Username.getText().equals("a") && Password.getText().equals("a")) 
          {   //System.out.println("Mil gaya");
              
              Stage primaryStage=(Stage)button.getScene().getWindow();
              primaryStage.close();
              stage.setTitle("StaySafe");
              Parent root = FXMLLoader.load(getClass().getResource("Function.fxml"));
              stage.initStyle(StageStyle.DECORATED);
              Scene scene = new Scene(root, 780, 470);
              stage.setScene(scene);
              //stage.setOnHidden(primaryStage.show());
              stage.resizableProperty().setValue(false);
              stage.show();
          }
        }
        public void logoutButton(ActionEvent e)
        {
            try
            {
        Stage primaryStage=(Stage)logoutbtn.getScene().getWindow();
              primaryStage.close();
              Stage stage=new Stage();
              stage.setTitle("StaySafe");
              Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
              stage.initStyle(StageStyle.DECORATED);
              Scene scene = new Scene(root, 860, 540);
              stage.setScene(scene);
              stage.resizableProperty().setValue(false);
              stage.initModality(Modality.APPLICATION_MODAL);
              stage.show(); 
        
        }catch(IOException i){}
            
        }
         public void QRScan(ActionEvent event) throws Exception
        {
        boolean condition;
    
        Face_Train.Train();

       
        condition=Face_Recognition.Recognise();
        if(!condition)
        {
              //ScanModule scan=new ScanModule();
              
              String title = "Registered Successfully";
              String message="You have registered successfully";
              TrayNotification tray=new TrayNotification();
              AnimationType type = AnimationType.POPUP;
              tray.setAnimationType(type);
              tray.setTitle(title);
              tray.setMessage(message);
              tray.setNotificationType(NotificationType.SUCCESS);
              tray.showAndDismiss(Duration.millis(3000));     
        }
        else
        {
        String title = "Already Punched";
              String message="You have already punched your attendence";
              TrayNotification tray=new TrayNotification();
              AnimationType type = AnimationType.POPUP;
              tray.setAnimationType(type);
              tray.setTitle(title);
              tray.setMessage(message);
              tray.setNotificationType(NotificationType.WARNING);
              tray.showAndDismiss(Duration.millis(3000)); 
        
        
        }
        }
         public void Admin(ActionEvent event) throws Exception
        {     Stage functionalXML=(Stage)Admin.getScene().getWindow();
              functionalXML.close();
              Stage stage=new Stage();
              stage.setTitle("StaySafe");
              Parent root = FXMLLoader.load(getClass().getResource("Dialog.fxml"));
              stage.initStyle(StageStyle.DECORATED);
              Scene scene = new Scene(root, 500, 283);
              stage.setScene(scene);
              stage.resizableProperty().setValue(false);
              stage.initModality(Modality.APPLICATION_MODAL);
              stage.show(); 
              
              
    }
          public void AdminPortal(ActionEvent event) throws Exception
        {   
            
            Stage stage =new Stage();
            //System.out.println(Username.getText());
          if (SecureKey.getText().isEmpty()) 
          {
              System.out.println("Hello");
              SecureError.setText("Please Enter Security Key!!!");
          }
          if(SecureKey.getText().equals("a"))
          {
            Stage DiaglogBoxScene=(Stage)SecureBtn.getScene().getWindow();
            DiaglogBoxScene.close();
            
              
              stage.setTitle("StaySafe");
              Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
              stage.initStyle(StageStyle.DECORATED);
              Scene scene = new Scene(root, 740, 480);
              stage.setScene(scene);
              stage.resizableProperty().setValue(false);
              stage.initModality(Modality.APPLICATION_MODAL);
              stage.show(); 
          }   
        }
          public void SecureCancel(ActionEvent event)
          {
              Stage DiaglogBoxScene=(Stage)SecureBtn.getScene().getWindow();
            DiaglogBoxScene.close();
              try
              {
              Stage stage=new Stage();
          stage.setTitle("StaySafe");
              Parent root = FXMLLoader.load(getClass().getResource("Function.fxml"));
              stage.initStyle(StageStyle.DECORATED);
              Scene scene = new Scene(root, 780, 470);
              stage.setScene(scene);
              //stage.setOnHidden(primaryStage.show());
              stage.resizableProperty().setValue(false);
              stage.show();
          
          
          }catch(IOException i)
          {}}
          
          public void BackToFunction(ActionEvent event)
          {
          Stage AdminPortal=(Stage)logout.getScene().getWindow();
          AdminPortal.close();
          
          try
              {
              Stage stage=new Stage();
          stage.setTitle("StaySafe");
              Parent root = FXMLLoader.load(getClass().getResource("Function.fxml"));
              stage.initStyle(StageStyle.DECORATED);
              Scene scene = new Scene(root, 780, 470);
              stage.setScene(scene);
              //stage.setOnHidden(primaryStage.show());
              stage.resizableProperty().setValue(false);
              stage.show();
          
          
          }catch(IOException i)
          {}
          }

    /**
     *
     * @param event
     */
    public void SendSMS(ActionEvent event)
          {
              Stage stageold=(Stage)sms.getScene().getWindow();
              stageold.close();
              try
              {
              Stage stage=new Stage();
              stage.setTitle("StaySafe");
              
              Parent root = FXMLLoader.load(getClass().getResource("SMSPanel.fxml"));
              stage.initStyle(StageStyle.DECORATED);
              Scene scene = new Scene(root, 861,600);
              stage.setScene(scene);
               
              //stage.setOnHidden(primaryStage.show());
              stage.resizableProperty().setValue(false);
              stage.show();
          
          
          }catch(IOException i)
          {}}
    
    public void PresentStudentsClicked(ActionEvent event) throws DAOException
    {
              
            //Loading part
       try{     
  
         AnchorPane pane1 = FXMLLoader.load(getClass().getResource("PresentPane.fxml"));
               Mainpane.setCenter(pane1); 
}catch(IOException e)
{
}

    } 
    public void FeedDataPresenties(ActionEvent e) throws DAOException
    { 
try
{
  ArrayList<Information_Wrapper> present=new ArrayList<Information_Wrapper>();
AdminSendSms c=new AdminSendSms();
present=c.getPresentList();
Iterator itr=present.iterator();  
int count=1;
while(itr.hasNext()){  
Information_Wrapper  abc=(Information_Wrapper)itr.next();  
sno.appendText(String.valueOf(count)+"."+'\n');
Present.appendText(abc.Name+'\n');
Late.appendText(abc.Late+'\n');
count++;
}
      showDataButton.setDisable(true);
}catch(Exception ee){}
    }
    public void AbsentStudentsClicked(ActionEvent event)
    {
        try{
            
        AnchorPane pane= FXMLLoader.load(getClass().getResource("AbsentPane.fxml"));
        Mainpane.setCenter(pane);
        }catch(IOException i){}  
     }
    public void FeedDataAbsenties(ActionEvent e) throws DAOException
    {
  try
{

    ArrayList<Information_Wrapper> absent=new ArrayList<Information_Wrapper>();
AdminSendSms c=new AdminSendSms();

absent=c.getAbsentList();
Iterator it=absent.iterator();  
int count=1;
while(it.hasNext()){  
 
Information_Wrapper  abc=(Information_Wrapper)it.next();  
SNo.appendText(String.valueOf(count)+"."+'\n');

Absent.appendText(abc.Name+'\n');
count++;
}  
showDataButton2.setDisable(true);
}catch(Exception eee){}
    }
    public void SendingSMSToPresenties(ActionEvent e) throws DAOException
    {
try
{
 ArrayList<Information_Wrapper> present=new ArrayList<Information_Wrapper>();
AdminSendSms c=new AdminSendSms();
SendSms sms=new SendSms();
present=c.getPresentList();
Iterator itr=present.iterator();  
while(itr.hasNext()){  
Information_Wrapper  abc=(Information_Wrapper)itr.next();  
String Phone=(String)abc.Phone;
String Message="Your Ward "+(String)abc.Name+" Has Reached School Safely and is "+(String)abc.Late+".";
sms.SendSms(Phone,Message);
}

        
              String title = "Send Successfully";
              String message="Message has been send Successfully!";
              TrayNotification tray=new TrayNotification();
              AnimationType type = AnimationType.POPUP;
              tray.setAnimationType(type);
              tray.setTitle(title);
              tray.setMessage(message);
              tray.setNotificationType(NotificationType.SUCCESS);
              tray.showAndDismiss(Duration.millis(3000));
  
    }catch(Exception efg){}
}
    
   
    public void SendingSMSToAbsenties(ActionEvent e) throws DAOException
    {
try
{
 ArrayList<Information_Wrapper> absent=new ArrayList<Information_Wrapper>();
AdminSendSms c=new AdminSendSms();
SendSms sms=new SendSms();
absent=c.getAbsentList();
Iterator it=absent.iterator();  
while(it.hasNext()){  
 Information_Wrapper  abc=(Information_Wrapper)it.next();  
String Phone=(String)abc.Phone;
String Message="Your Ward "+(String)abc.Name+" is Absent Today.";
sms.SendSms(Phone,Message);
}  
              String title = "Send Successfully";
              String message="Message has been send Successfully!";
              TrayNotification tray=new TrayNotification();
              AnimationType type = AnimationType.POPUP;
              tray.setAnimationType(type);
              tray.setTitle(title);
              tray.setMessage(message);
              tray.setNotificationType(NotificationType.SUCCESS);
              tray.showAndDismiss(Duration.millis(3000));
             
    }catch(Exception abc){}
}
    
          public void CreateNew(ActionEvent event)
          {
              Stage DiaglogBoxScene=(Stage)createNew.getScene().getWindow();
              DiaglogBoxScene.close();
              try
              {
              Stage stage=new Stage();
              stage.setTitle("StaySafe");
              Parent root = FXMLLoader.load(getClass().getResource("Form.fxml"));
              stage.initStyle(StageStyle.DECORATED);
              Scene scene = new Scene(root, 897,675);
              stage.setScene(scene);
              //stage.setOnHidden(primaryStage.show());
              stage.resizableProperty().setValue(false);
              stage.show();
          
          
          }catch(IOException i)
          {}}
          
          
          
          public void Confirm_NO(ActionEvent event)
          {
          Stage Confirmation=(Stage)ConfirmNO.getScene().getWindow();
          Confirmation.close();
          try
          {
          Stage stage=new Stage();
          stage.setTitle("StaySafe");
              Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
              stage.initStyle(StageStyle.DECORATED);
              Scene scene = new Scene(root, 740, 480);
              stage.setScene(scene);
              stage.resizableProperty().setValue(false);
              stage.initModality(Modality.APPLICATION_MODAL);
              stage.show(); 
          
          }catch(IOException i)
          {}
          
          }
          
          
          public void setState()
          {
          State.setItems(StateNames);
          }
          public void setCity()
          {
            if(State.getValue()!=null)
            {
         String value=(String)State.getValue();
         if(value.equals("MadhyaPradesh"))
         {
         City.setItems(MadhyaPradesh);
         }
          if(value.equals("Gujarat"))
         {
         
         City.setItems(Gujarat);
         }
          if(value.equals("UttarPradesh"))
         {
         City.setItems(UttarPradesh);
         }
          if(value.equals("Maharastra"))
         {
         
         City.setItems(Maharastra);
         }
          Country.setValue("India");
            }
          }
          public void setClass()
          {
          //Streamselect.setDisable(true);
          Class.setItems(ClassList);
          Streamselect.setItems(StreamList);
          }  
          public Boolean ValidateForm()
          {
            
             Boolean Valid=true;
             
             Firstname=FirstName.getText().trim();
             Secondname=SecondName.getText().trim();
             address1=Address1.getText().trim();
             address2=Address2.getText().trim();
             Phonenumber=PhoneNumber.getText().trim();
             Fathername=FatherName.getText().trim();
             Mothername=MotherName.getText().trim();
             genderradio=(RadioButton)Gender.getSelectedToggle();
             gender=genderradio.getText();
             city=(String)City.getValue();
             state=(String)State.getValue();
             classvalue=(String)Class.getValue();
             String stream=(String)Streamselect.getValue();
             country="India";
             localdate=getDateOfBirth();
             
             
     
              if(FirstName.getText().isEmpty() || FirstName.getText()==null || FirstName.getText().length()==0)
            {
                FirstName.setStyle("-fx-border-color:red");
                FirstName.requestFocus();
                Valid=false;
                return Valid;
            }
            if(SecondName.getText().isEmpty() || SecondName.getText()==null || SecondName.getText().length()==0)
            {
                SecondName.setStyle("-fx-border-color:red");
                FirstName.requestFocus();
                Valid =false;
                return Valid;
            }
            if(PhoneNumber.getText().isEmpty() || PhoneNumber.getText()==null || PhoneNumber.getText().length()==0)
            {
                PhoneNumber.setStyle("-fx-border-color:red");
                PhoneNumber.requestFocus();
                Valid=false;
                return Valid;
            }
            
            if(FatherName.getText().isEmpty() || FatherName.getText()==null || FatherName.getText().length()==0)
            {
                FatherName.setStyle("-fx-border-color:red");
                //if(InvalidComponent==null)InvalidComponent=FatherName;
                FatherName.requestFocus();
                Valid=false;
                return Valid;
            }
          if(MotherName.getText().isEmpty() || MotherName.getText()==null || MotherName.getText().length()==0)
            {
                MotherName.setStyle("-fx-border-color:red");
                //if(InvalidComponent==null)InvalidComponent=MotherName;
                MotherName.requestFocus();
                Valid=false;
                return Valid;
            
            }
          if(Address1.getText().isEmpty()|| Address1.getText()==null || Address1.getText().length()==0)
            {
                Address1.setStyle("-fx-border-color:red");
                
                Address1.requestFocus();
                
                Valid=false;
                return Valid;
            
            }
          
          if(Address2.getText().isEmpty() || Address2.getText()==null || Address2.getText().length()==0)
            {
                Address2.setStyle("-fx-border-color:red");
                Address2.requestFocus();
                
                Valid=false;
                return Valid;
            
            }
          if(genderradio.getText().isEmpty() || genderradio.getText()==null || genderradio.getText().length()==0)
          {
          genderradio.setStyle("-fx-border-color:red");
          Valid=false;
          return Valid;
          }
          
          
           if(city.isEmpty() || city.length()==0 || city==null)
          {
              Valid=false;
              return Valid;
          } 
        
          if(classvalue.isEmpty() || classvalue ==null || classvalue.length()==0)
          {
          //genderradio.setStyle("-fx-border-color:red");
          Valid=false;
          return Valid;
          }
          
          
             if(state.isEmpty() || state==null || state.length()==0)
          {
          //state.setStyle("-fx-border-color:red");
          Valid=false;
          return Valid;
          }
             
             
          if(stream.isEmpty() || stream.length()==0)
          {
          //genderradio.setStyle("-fx-border-color:red");
          Valid=false;
          return Valid;
          }
          if(localdate==null)
          {
          DOB.setStyle("-fx-border-color:red");
          DOB.requestFocus();
          Valid=false;
          return Valid;
          }
            return Valid;
          }      
          
        public void getDetails(ActionEvent event) throws DAOException
          {
            Boolean valid = false;
            try
            {
            valid=ValidateForm();
            if(valid==true)
            {
             System.out.println("***********");
             Firstname=FirstName.getText().trim();
             Secondname=SecondName.getText().trim();
             address1=Address1.getText().trim();
             address2=Address2.getText().trim();
             Phonenumber=PhoneNumber.getText().trim();
             Fathername=FatherName.getText().trim();
             Mothername=MotherName.getText().trim();
             genderradio=(RadioButton)Gender.getSelectedToggle();
             gender=genderradio.getText();
             city=(String)City.getValue();
             state=(String)State.getValue();
             classvalue=(String)Class.getValue();
             String stream=(String)Streamselect.getValue();
             
             country="India";
             localdate=getDateOfBirth();
             //String Message=message.getText().trim();
            System.out.println(Firstname);
            System.out.println(Secondname);
            System.out.println(address1);
            System.out.println(address2);
            System.out.println(city);
            System.out.println(state);
            System.out.println(country);
            System.out.println(Mothername);
            System.out.println(Fathername);
            System.out.println(classvalue);
            System.out.println(stream);
            System.out.println(Phonenumber);
            System.out.println(localdate);
            System.out.println(gender);
 String Addresser=address1+" "+address2;
                 
 String DOB=localdate.toString();
String Namer=Firstname+" "+Secondname;
      CreateNew cn=new CreateNew(Namer,gender,classvalue,stream,Phonenumber,DOB,Fathername,Mothername,Addresser,state,city,country,Message);
              
            String Keyvalue=GenerateKeyValue(Firstname,localdate);
            System.out.println(Keyvalue);
            Stage Confirmation=(Stage)register.getScene().getWindow();
            Confirmation.close();
              FXMLLoader loader=new FXMLLoader();
              loader.setLocation(getClass().getResource("RegisterModal.fxml"));
              
              loader.load();
              
              System.out.println("Loaded Key Modal");
              
              PasswordRegisterController prc=loader.getController();
              prc.setALL(Firstname,Namer, Keyvalue, localdate,Phonenumber);
              Parent root=loader.getRoot();
              Stage stage=new Stage();
              stage.setTitle("StaySafe");
              stage.initStyle(StageStyle.DECORATED);
              Scene scene = new Scene(root, 600, 400);
              stage.setScene(scene);
              stage.resizableProperty().setValue(false);
              stage.initModality(Modality.APPLICATION_MODAL);
              stage.show(); 
             
            }
            else
            {
            System.out.println("Please Fill all the Credentials");
            PleaseEnter.setText("* Please Fill all the Credentials");
            
            }
            
            }catch(IOException e)
            {
            }
            
            }
 public String GenerateKeyValue(String Firstname,LocalDate localdate)
        {
            String name=Firstname;
            String date=localdate.toString();
            	
        Random rand = new Random(); 
        String randChar=(String)list.get(rand.nextInt(list.size())); 
        System.out.println(randChar);
        String var1=date.substring(2,4);
        String var2=date.substring(8,10);
        String Date=var1+var2;
        String Keyvalue= name+randChar+Date;
        return Keyvalue;
        }
        
        
        
        public void formCancel(ActionEvent Event)
        {
            try
            {
              Stage primaryStage=(Stage)Cancel.getScene().getWindow();
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
            }catch(IOException io){}
        }
        
        public void ShowRecord(ActionEvent Event)        
        {            
        try
            {
              Stage primaryStage=(Stage)showRecord.getScene().getWindow();
              System.out.println("Close k pehle");
              primaryStage.close();
              Stage stage=new Stage();
              stage.setTitle("StaySafe");
              Parent root = FXMLLoader.load(getClass().getResource("showRecord.fxml"));
              stage.initStyle(StageStyle.DECORATED);
              System.out.println("Showrecord FXML opened");
              Scene scene = new Scene(root, 861, 600);
              stage.setScene(scene);
              stage.resizableProperty().setValue(false);
              stage.initModality(Modality.APPLICATION_MODAL);
              stage.show(); 
        
        
            }catch(IOException io){}
        }
        
        
        public void ShowALL(ActionEvent Event) throws DAOException
        {
            try
            {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("ShowALL.fxml"));
        showRecordPane.setCenter(pane);
        CreateReport.CreateCompleteAttendenceRecord();
        }
catch(DAOException e)
{
throw new DAOException(e.getMessage());
}
catch(IOException ioe)
{
}
        }   
        
        public void DownloadAllData(ActionEvent event) throws DAOException
        {
           
            String title = "Download Successfully";
              String message="C:/Staysafe/reports/";
              TrayNotification tray=new TrayNotification();
              
              
              //Backend  Part yet to be  completed;
              
              AnimationType type = AnimationType.POPUP;
              tray.setAnimationType(type);
              tray.setTitle(title);
              tray.setMessage(message);
              tray.setNotificationType(NotificationType.SUCCESS);
              tray.showAndDismiss(Duration.millis(3000));
              try{
         DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
            String current_date=df.format(date);
        File file=new File("C:\\minor\\Staysafe\\reports\\"+current_date+"CompleteAttendenceRecord.pdf");
        
        if(!Desktop.isDesktopSupported())
            {  
                System.out.println("not supported");  
                return;  
            }  
            Desktop desktop = Desktop.getDesktop();  
            if(file.exists())         
            desktop.open(file);            
            }  
            catch(IOException e)  
            {  
            System.out.println(e.getMessage());  
        }  
        
        
        }
        
        public void ShowTodays(ActionEvent event)  throws DAOException
        {
            try
            {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("ShowTodays.fxml"));
        showRecordPane.setCenter(pane);
        CreateReport.CreateDailyAttendenceRecord();
            }catch(DAOException e)
{
throw new DAOException(e.getMessage());
}
catch(IOException ioe)
{
}
        
        }
        
        public void DownloadTodays(ActionEvent event) throws DAOException
         {
            String title = "Download Successfully";
              String message="C:/Staysafe/reports/";
              TrayNotification tray=new TrayNotification();
              
              
              //Backend  Part yet to be  completed;
              
              AnimationType type = AnimationType.POPUP;
              tray.setAnimationType(type);
              tray.setTitle(title);
              tray.setMessage(message);
              tray.setNotificationType(NotificationType.SUCCESS);
              tray.showAndDismiss(Duration.millis(3000));
              try{
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
            String current_date=df.format(date);
       File file=new File("C:\\minor\\Staysafe\\reports\\"+current_date+"DailyAttendenceRecord.pdf");
        
        if(!Desktop.isDesktopSupported())
            {  
                System.out.println("not supported");  
                return;  
            }  
            Desktop desktop = Desktop.getDesktop();  
            if(file.exists())         
            desktop.open(file);            
            }  
            catch(IOException e)  
            {  
           System.out.println(e.getMessage());  
        }  
        
        
        }
public void ShowDetails(ActionEvent event)  throws DAOException
        {
            try
            {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("showDetails.fxml"));
        showRecordPane.setCenter(pane);
CreateReport.CreateStudentDetailRecord();
            }catch(IOException e){}
        
        }
        public void DownloadDetails(ActionEvent e)
        {
        String title = "Download Successfully";
              String message="C:/Staysafe/reports/";
              TrayNotification tray=new TrayNotification();
              
              
              //Backend  Part yet to be  completed;
              
              AnimationType type = AnimationType.POPUP;
              tray.setAnimationType(type);
              tray.setTitle(title);
              tray.setMessage(message);
              tray.setNotificationType(NotificationType.SUCCESS);
              tray.showAndDismiss(Duration.millis(1000));
              try{
DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
            String current_date=df.format(date);
       File file=new File("C:\\minor\\Staysafe\\reports\\"+current_date+"StudentDetailRecord.pdf");
        
        if(!Desktop.isDesktopSupported())
            {  
                System.out.println("not supported");  
                return;  
            }  
            Desktop desktop = Desktop.getDesktop();  
            if(file.exists())         
            desktop.open(file);            
            }  
            catch(Exception exception)  
            {  
            exception.printStackTrace();  
        }    
            
        
        }
        
        public void CancelRecordButton(ActionEvent event)
        {
            try
            {
              Stage primaryStage=(Stage)cancelRecord.getScene().getWindow();
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
        
        
            }catch(IOException io){}
        }
        
        public LocalDate getDateOfBirth()
             {
                 return DOB.getValue();   
             }
        
        
        
        }
        
        
        
        
        
        
             
        
        
        

