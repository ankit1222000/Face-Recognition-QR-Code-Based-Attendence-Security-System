package com.thinking.machines.student.data;
import com.thinking.machines.student.exception.*;
import java.sql.*;

public class DAOConnection 
{
private DAOConnection()
{
}
public static Connection getConnection() throws DAOException
{
Connection c=null;
try
{

Class.forName("com.mysql.cj.jdbc.Driver");
c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Staysafedb","Staysafe","Acedevelopers");

}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return c;
}
}
