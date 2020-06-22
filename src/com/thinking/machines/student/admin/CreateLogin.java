package com.thinking.machines.student.admin;
import com.thinking.machines.student.data.*;
import com.thinking.machines.student.application.*;
import com.thinking.machines.student.exception.*;
import java.sql.*;
import java.util.*;
import java.io.*;
public class CreateLogin 
{
private int Rollnumber;
private String Key;
private String Name;
private String Password;
private String Phone;
public CreateLogin(String Name,String Phone,String Password,String Key)
{
this.Name=Name;
this.Phone=Phone;
this.Key=Key;
this.Password=Password;
setLoginDetails();
}
public void setLoginDetails()
{
Connection c;
ResultSet rs;
PreparedStatement ps;
PreparedStatement psp;
try
{
c=DAOConnection.getConnection();
ps=c.prepareStatement("Select rollnumber from student_detail where Name=? AND PhoneNo=?");
ps.setString(1,Name);
ps.setString(2,Phone);
rs=ps.executeQuery();
while(rs.next())
{
this.Rollnumber=rs.getInt("rollnumber");
}
psp=c.prepareStatement("Insert into login(Rollnumber,Name,Password,Special) values(?,?,?,?)");
psp.setInt(1,Rollnumber);
psp.setString(2,Name);
psp.setString(3,Password);
psp.setString(4,Key);
psp.executeUpdate();
rs.close();
ps.close();
psp.close();
c.close();
}catch(Exception e)
{
e.printStackTrace();
}
}
}