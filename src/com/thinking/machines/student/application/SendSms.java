package com.thinking.machines.student.application;
import com.thinking.machines.student.data.*;
import com.thinking.machines.student.exception.*;
import java.sql.*;
import java.io.*;
import java.net.*;
public class SendSms
{
public SendSms(String number,String message) throws DAOException
{
try
{
System.out.println("Send sms function start");
String api_key="Wh21bjaYI367mZMxdCpFkf5cuiJtnXg8SGKerURsBTDzV4loLHRWYJ6fNEKhcgUy9T0pB1XIP5Fq3rno";
String Message  = message;
String Sender_Id = "FSTSMS";
String Numbers= number;
String Language="english";
String Route="p";
String start="https://www.fast2sms.com/dev/bulk?";
String encoding = "UTF-8";
      String queryString =start+"authorization=" + URLEncoder.encode(api_key, encoding)
        + "&sender_id=" + URLEncoder.encode(Sender_Id, encoding)
        + "&message=" + URLEncoder.encode(Message, encoding)
        + "&language=" + URLEncoder.encode(Language, encoding)
        + "&route=" + URLEncoder.encode(Route, encoding)
        +"&numbers="+URLEncoder.encode(Numbers, encoding);
URL url=new URL(queryString);
HttpURLConnection con=(HttpURLConnection)url.openConnection();
con.setRequestMethod("GET");
con.setRequestProperty("User-Agent","Mozilla/5.0");
con.setRequestProperty("cache-control","no-cache");
//System.out.println("Wait.........");
int code=con.getResponseCode();
//System.out.println("Response code: "+code);
StringBuffer response=new StringBuffer();
BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
while(true)
{
String line=br.readLine();
if(line==null)
{
break;
}
response.append(line);
}
//System.out.println(response);

System.out.println("Send sms end");
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
}
} 
