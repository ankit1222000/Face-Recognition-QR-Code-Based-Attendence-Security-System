package com.thinking.machines.student.face_recognition;
import com.thinking.machines.student.data.*;
import com.thinking.machines.student.exception.*;
import com.thinking.machines.student.application.*;
import java.io.*;
import java.sql.*;
public class Face_Recognition
{
public static boolean Recognise() 
{
Connection ccc;
PreparedStatement pss;
ResultSet ress;
String Value="P";
try
{
Process p = Runtime.getRuntime().exec("python C:/minor/Staysafe/src/com/thinking/machines/student/face_recognition/kalu.py");
BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
String ret = new String(in.readLine()).toString();
ccc=DAOConnection.getConnection();
pss=ccc.prepareStatement("Select Name from student_view where Name=? AND Status=?");
pss.setString(1,ret);
pss.setString(2,Value);
ress=pss.executeQuery();
if(ress.next())
{
System.out.println("Hai Already");
return true;
}
else
{
System.out.println("Nahi Hai");
ScanModule sc=new ScanModule();
}
ccc.close();
pss.close();
ress.close();
}catch(Exception ee)
{
System.out.println(ee.getMessage());
}
return false;
}
}
