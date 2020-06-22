package com.thinking.machines.student.admin;
import com.thinking.machines.student.data.*;
import com.thinking.machines.student.application.*;
import com.thinking.machines.student.exception.*;
import java.sql.*;
import java.util.*;
import java.io.*;
public class CreateNew 
{
private String Name;
private int Rollnumber;
private String PhoneNumber;
private String Gender;
private String DOB;
private String Address;
private String Father;
private String Mother;
private String Country;
private String State;
private String City;
private String Class;
private String Stream;
private String Message;
Connection c;
PreparedStatement ps;
ResultSet s;
public CreateNew(String Name,String Gender,String Class,String Stream,String PhoneNumber,String DOB,String Father,String Mother,String Address,String State,String City,String Country,String Message) throws DAOException
{
this.Name=Name;
this.PhoneNumber=PhoneNumber;
this.Gender=Gender;
this.DOB=DOB;
this.Address=Address;
this.Father=Father;
this.Mother=Mother;
this.Country=Country;
this.State=State;
this.City=City;
this.Class=Class;
this.Stream=Stream;
this.Message=Message;
setStudentDetails();
}
public void setStudentDetails() throws DAOException
{
try
{
c=DAOConnection.getConnection();
ps=c.prepareStatement("Select Max(Rollnumber) AS maxroll from student_detail");
s=ps.executeQuery();
while(s.next())
{
Rollnumber=s.getInt("maxroll");
Rollnumber++;
}
int first=Name.indexOf(" ");
String number1=Name.substring(0,first);
String number2=Name.substring(first+1);
String number3=Integer.toString(Rollnumber);
Process p = Runtime.getRuntime().exec("python C:/minor/Staysafe/src/com/thinking/machines/student/admin/ankit.py "+number1+" "+number2+" "+number3);
BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

ps=c.prepareStatement("insert into student_detail(Rollnumber,Name,Gender,Class,Stream,PhoneNo,Date_of_Birth,Father_Name,Mother_Name,Address,State,City,Country) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
ps.setInt(1,Rollnumber);
ps.setString(2,Name);
ps.setString(3,Gender);
ps.setString(4,Class);
ps.setString(5,Stream);
ps.setString(6,PhoneNumber);
ps.setString(7,DOB);
ps.setString(8,Father);
ps.setString(9,Mother);
ps.setString(10,Address);
ps.setString(11,State);
ps.setString(12,City);
ps.setString(13,Country);
ps.executeUpdate();
}catch(Exception ee)
{
throw new DAOException(ee.getMessage());
}
finally
{
try
{
ps.close();
c.close();
s.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
}
}
}

