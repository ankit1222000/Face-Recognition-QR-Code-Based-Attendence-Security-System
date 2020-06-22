package com.thinking.machines.student.application;
import com.thinking.machines.student.data.*;
import com.thinking.machines.student.exception.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.Date;

public class set
{
public set() throws DAOException
{
try
{
Connection con=DAOConnection.getConnection();
PreparedStatement psst;
ResultSet resultSet;
DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
Date date=new Date(); 

psst=con.prepareStatement("Select Date from attendence_record where Date=?");
psst.setString(1,df.format(date));
resultSet=psst.executeQuery();
if(resultSet.next()==false)
{
psst=con.prepareStatement("Select Rollnumber,Name,Gender,Stream from student_detail");
resultSet=psst.executeQuery();
while(resultSet.next())
{
int rollnumber=resultSet.getInt("Rollnumber");
String name=resultSet.getString("Name");
String status="NP";
String stream=resultSet.getString("Stream");
String gender=resultSet.getString("Gender");
psst=con.prepareStatement("Insert into attendence_record(Rollnumber,Name,Gender,Stream,Date,Status) values(?,?,?,?,?,?)");
psst.setInt(1,rollnumber);
psst.setString(2,name);
psst.setString(3,gender);
psst.setString(4,stream);
psst.setString(5,df.format(date));
psst.setString(6,status);
psst.executeUpdate();
}//while loop ends here
}  //if loop ends here
}catch(Exception de)
{
throw new DAOException(de.getMessage());
}

}
}