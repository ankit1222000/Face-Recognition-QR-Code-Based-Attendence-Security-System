package com.thinking.machines.student.admin;
import com.thinking.machines.student.data.*;
import com.thinking.machines.student.exception.*;
import java.sql.*;
import java.util.Date;
import java.text.*;
import java.util.*;

public class AdminSendSms
{
int c1,c2;
String hours,minutes;
String name,phone,time,late;
Connection c;
Statement s;
ResultSet r;
java.sql.Time now;
DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
ArrayList<Information_Wrapper> PresentList=new ArrayList<Information_Wrapper>();
ArrayList<Information_Wrapper> AbsentList=new ArrayList<Information_Wrapper>();
Date date=new Date();
public ArrayList<Information_Wrapper> getPresentList() throws DAOException
{
try
{
c=DAOConnection.getConnection();
s=c.createStatement();
r=s.executeQuery("Select Name,PhoneNo,TIMEDIFF('10:00:00',Punch_time) AS Timer from student_view where Punch_time IS NOT NULL");
while(r.next())
{
name=r.getString("Name");
phone=r.getString("PhoneNo");
time=r.getTime("Timer").toString();
c1=time.indexOf(":");
c2=time.indexOf(":",c1+1);
hours=time.substring(0,c1);
minutes=time.substring(c1+1,c2);
late="Late by "+hours+" Hour and "+minutes+" Minute";
Information_Wrapper info=new Information_Wrapper(name,phone,late);
PresentList.add(info);
}
c.close();
s.close();
r.close();
}catch(Exception dao)
{
throw new DAOException(dao.getMessage());
}
return PresentList;
}

public ArrayList<Information_Wrapper> getAbsentList() throws DAOException
{
try
{
c=DAOConnection.getConnection();
s=c.createStatement();
r=s.executeQuery("Select Name,PhoneNo from student_view where Punch_time IS NULL");
System.out.println("Name of Absent");
while(r.next())
{
name=r.getString("Name");
phone=r.getString("PhoneNo");
Information_Wrapper info=new Information_Wrapper(name,phone,"");
AbsentList.add(info);
}
c.close();
s.close();
r.close();

}catch(Exception ee)
{
throw new DAOException(ee.getMessage());
}
return AbsentList;
}
}
