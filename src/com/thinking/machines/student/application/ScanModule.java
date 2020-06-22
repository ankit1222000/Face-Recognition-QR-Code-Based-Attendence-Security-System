package com.thinking.machines.student.application;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.Date;
import com.thinking.machines.student.data.*;
import com.thinking.machines.student.exception.*;
public class ScanModule 
{
Connection c;
PreparedStatement ps;
public ScanModule() throws DAOException
{
try
{
c=DAOConnection.getConnection();
Process p = Runtime.getRuntime().exec("python C:/minor/Staysafe/src/com/thinking/machines/student/application/scan.py ");
BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
String ret = new String(in.readLine()).toString();
System.out.println(ret);
/*int c1=ret.indexOf("'");
int c2=ret.indexOf("'",c1+1);
int c3=ret.indexOf(" ");

String Name=ret.substring(c1+1,c3);
int Rollnumber=Integer.parseInt(ret.substring(c3+1,c2));*/

int c1=ret.indexOf("'");
int c2=ret.indexOf(" ");
String first=ret.substring(c1+1,c2);
int c3=ret.indexOf(" ",c2+1);
String second=ret.substring(c2+1,c3);
int c4=ret.indexOf("'",c3+1);
int Rollnumber=Integer.parseInt(ret.substring(c3+1,c4));


String Name=first+" "+second;

//System.out.println("value is : "+name+","+rollnumber);
set sc=new set();

DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
Date date=new Date();
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
LocalDateTime now = LocalDateTime.now();  
String current_time=dtf.format(now);  

String present="P";
String current_date=df.format(date);
//System.out.println("update k pehle");

ps=c.prepareStatement("Update attendence_record SET Status=?,Punch_time=? where Rollnumber=? AND Name=? AND Date=?");
//System.out.println("Update k baad");
ps.setString(1,present);
ps.setString(2,current_time);
ps.setInt(3,Rollnumber);
ps.setString(4,Name);
ps.setString(5,current_date);
ps.executeUpdate();


c.close();
ps.close();
}catch(Exception de)
{
throw new DAOException(de.getMessage());
}
}
}
