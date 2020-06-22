package com.thinking.machines.student.admin;
import com.thinking.machines.student.data.*;
import com.thinking.machines.student.exception.*;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.text.*;
import java.sql.*; 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class CreateReport 
{  
public static void CreateCompleteAttendenceRecord() throws DAOException
{
try
{
DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
Date date=new Date();
String current_date=df.format(date);

Connection conn =DAOConnection.getConnection();
Statement stmt = conn.createStatement();
ResultSet query_set = stmt.executeQuery("Select * from Attendence_Record");
Document my_pdf_report = new Document();
PdfWriter.getInstance(my_pdf_report, new FileOutputStream("C:/minor/Staysafe/reports/"+current_date+"CompleteAttendenceRecord.pdf"));
my_pdf_report.open();          
String para1="Staysafe Security System Report";
Font font1 = new Font(Font.FontFamily.HELVETICA  , 25, Font.BOLD);
Paragraph paragraph1 = new Paragraph(para1,font1); 
paragraph1.setAlignment(Element.ALIGN_CENTER);
paragraph1.setSpacingAfter(25);
Image image1 = Image.getInstance("Staysafe security.png");
image1.setAbsolutePosition(73f,769f);
image1.scaleAbsolute(90f, 90f);
my_pdf_report.add(image1);
my_pdf_report.add(paragraph1);   
String para2="Complete Attendence Record";
Font font2=new Font(Font.FontFamily.HELVETICA  , 23);
Paragraph paragraph2=new Paragraph(para2,font2);
paragraph2.setAlignment(Element.ALIGN_CENTER);
paragraph2.setSpacingAfter(25);
my_pdf_report.add(paragraph2);   

PdfPTable my_report_table = new PdfPTable(8);
my_report_table.setWidthPercentage(100);
PdfPCell table_cell;
table_cell=new PdfPCell(new Phrase("SNo."));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase(" Roll Number"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase(" Student Name"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase(" Gender"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase(" Stream"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase(" Date"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase(" Status"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase(" Punch Time"));
my_report_table.addCell(table_cell);
int dept_id=1;               
while (query_set.next()) 
{                
table_cell=new PdfPCell(new Phrase(dept_id+"."));
my_report_table.addCell(table_cell);
int roll=query_set.getInt("Rollnumber");
String Roll=Integer.toString(roll);
table_cell=new PdfPCell(new Phrase(Roll));
my_report_table.addCell(table_cell);
String dept_name=query_set.getString("Name");
table_cell=new PdfPCell(new Phrase(dept_name));
my_report_table.addCell(table_cell);
String gender=query_set.getString("Gender");
table_cell=new PdfPCell(new Phrase(gender));
my_report_table.addCell(table_cell);
String stream=query_set.getString("Stream");
table_cell=new PdfPCell(new Phrase(stream));
my_report_table.addCell(table_cell);
String dater=query_set.getString("Date");
table_cell=new PdfPCell(new Phrase(dater));
my_report_table.addCell(table_cell);
String manager_id=query_set.getString("Status");
table_cell=new PdfPCell(new Phrase(manager_id));
my_report_table.addCell(table_cell);
String timer=query_set.getString("Punch_time");
table_cell=new PdfPCell(new Phrase(timer));
my_report_table.addCell(table_cell);
dept_id++;
}
my_pdf_report.add(my_report_table);                       
my_pdf_report.close();
query_set.close();
stmt.close(); 
conn.close();               
}catch(Exception ee)
{
throw new DAOException(ee.getMessage());
}
}
public static void CreateDailyAttendenceRecord() throws DAOException
{
try
{
DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
Date date=new Date();
String current_date=df.format(date);
Connection conn =DAOConnection.getConnection();
Statement stmt = conn.createStatement();
ResultSet query_set = stmt.executeQuery("Select * from student_view");
Document my_pdf_report = new Document();
PdfWriter.getInstance(my_pdf_report, new FileOutputStream("C:/minor/Staysafe/reports/"+current_date+"DailyAttendenceRecord.pdf"));
my_pdf_report.open();          
String para1="Staysafe Security System Report";
Font font1 = new Font(Font.FontFamily.HELVETICA  , 25, Font.BOLD);
Paragraph paragraph1 = new Paragraph(para1,font1); 
paragraph1.setAlignment(Element.ALIGN_CENTER);
paragraph1.setSpacingAfter(25);
Image image1 = Image.getInstance("Staysafe security.png");
image1.setAbsolutePosition(73f,769f);
image1.scaleAbsolute(90f, 90f);
my_pdf_report.add(image1);
my_pdf_report.add(paragraph1);   
String para2="Daily Attendence Record";
Font font2=new Font(Font.FontFamily.HELVETICA  , 23);
Paragraph paragraph2=new Paragraph(para2,font2);
paragraph2.setAlignment(Element.ALIGN_CENTER);
paragraph2.setSpacingAfter(25);
my_pdf_report.add(paragraph2);   
PdfPTable my_report_table = new PdfPTable(8);
my_report_table.setWidthPercentage(100);
PdfPCell table_cell;
table_cell=new PdfPCell(new Phrase("SNo."));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase(" Roll Number"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase(" Student Name"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase(" Gender"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase(" Stream"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase(" Date"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase(" Punch Time"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase(" Phone Number"));
my_report_table.addCell(table_cell);
int dept_id=1;               
while (query_set.next()) 
{                
table_cell=new PdfPCell(new Phrase(dept_id+"."));
my_report_table.addCell(table_cell);
int roll=query_set.getInt("Rollnumber");
String Roll=Integer.toString(roll);
table_cell=new PdfPCell(new Phrase(Roll));
my_report_table.addCell(table_cell);
String dept_name=query_set.getString("Name");
table_cell=new PdfPCell(new Phrase(dept_name));
my_report_table.addCell(table_cell);
String gender=query_set.getString("Gender");
table_cell=new PdfPCell(new Phrase(gender));
my_report_table.addCell(table_cell);
String stream=query_set.getString("Stream");
table_cell=new PdfPCell(new Phrase(stream));
my_report_table.addCell(table_cell);
String dater=query_set.getString("Date");
table_cell=new PdfPCell(new Phrase(dater));
my_report_table.addCell(table_cell);
String timer=query_set.getString("Punch_time");
table_cell=new PdfPCell(new Phrase(timer));
my_report_table.addCell(table_cell);
String manager_id=query_set.getString("PhoneNo");
table_cell=new PdfPCell(new Phrase(manager_id));
my_report_table.addCell(table_cell);
dept_id++;
}
my_pdf_report.add(my_report_table);                       
my_pdf_report.close();
query_set.close();
stmt.close(); 
conn.close();               
}catch(Exception ee)
{
throw new DAOException(ee.getMessage());
}
}
public static void CreateStudentDetailRecord() throws DAOException
{
try
{
DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
Date date=new Date();
String current_date=df.format(date);
Connection conn =DAOConnection.getConnection();
Statement stmt = conn.createStatement();
ResultSet query_set = stmt.executeQuery("Select * from student_detail");
Document my_pdf_report = new Document();
PdfWriter.getInstance(my_pdf_report, new FileOutputStream("C:/minor/Staysafe/reports/"+current_date+"StudentDetailRecord.pdf"));
my_pdf_report.open();          
String para1="Staysafe Security System Report";
Font font1 = new Font(Font.FontFamily.HELVETICA  , 25, Font.BOLD);
Paragraph paragraph1 = new Paragraph(para1,font1); 
paragraph1.setAlignment(Element.ALIGN_CENTER);
paragraph1.setSpacingAfter(25);
Image image1 = Image.getInstance("Staysafe security.png");
image1.setAbsolutePosition(73f,769f);
image1.scaleAbsolute(90f, 90f);
my_pdf_report.add(image1);
my_pdf_report.add(paragraph1);   
String para2="Class 12th Student's Detail Record";
Font font2=new Font(Font.FontFamily.HELVETICA  , 23);
Paragraph paragraph2=new Paragraph(para2,font2);
paragraph2.setAlignment(Element.ALIGN_CENTER);
paragraph2.setSpacingAfter(25);
my_pdf_report.add(paragraph2);   
PdfPTable my_report_table = new PdfPTable(11);
my_report_table.setWidthPercentage(110);
PdfPCell table_cell;
table_cell=new PdfPCell(new Phrase("SNo."));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase("RollNumber"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase("Student"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase("Stream"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase("Phone"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase("DOB"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase("Father"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase("Mother"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase("Address"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase("State"));
my_report_table.addCell(table_cell);
table_cell=new PdfPCell(new Phrase("City"));
my_report_table.addCell(table_cell);
int dept_id=1;               
while (query_set.next()) 
{                
table_cell=new PdfPCell(new Phrase(dept_id+"."));
my_report_table.addCell(table_cell);
int roll=query_set.getInt("Rollnumber");
String Roll=Integer.toString(roll);
table_cell=new PdfPCell(new Phrase(Roll));
my_report_table.addCell(table_cell);
String dept_name=query_set.getString("Name");
table_cell=new PdfPCell(new Phrase(dept_name));
my_report_table.addCell(table_cell);
String stream=query_set.getString("Stream");
table_cell=new PdfPCell(new Phrase(stream));
my_report_table.addCell(table_cell);
String manager_id=query_set.getString("PhoneNo");
table_cell=new PdfPCell(new Phrase(manager_id));
my_report_table.addCell(table_cell);
String dater=query_set.getString("Date_of_Birth");
table_cell=new PdfPCell(new Phrase(dater));
my_report_table.addCell(table_cell);
String father=query_set.getString("Father_Name");
table_cell=new PdfPCell(new Phrase(father));
my_report_table.addCell(table_cell);
String mother=query_set.getString("Mother_Name");
table_cell=new PdfPCell(new Phrase(mother));
my_report_table.addCell(table_cell);
String address=query_set.getString("Address");
table_cell=new PdfPCell(new Phrase(address));
my_report_table.addCell(table_cell);
String state=query_set.getString("State");
table_cell=new PdfPCell(new Phrase(state));
my_report_table.addCell(table_cell);
String city=query_set.getString("City");
table_cell=new PdfPCell(new Phrase(city));
my_report_table.addCell(table_cell);
dept_id++;
}
my_pdf_report.add(my_report_table);                       
my_pdf_report.close();
query_set.close();
stmt.close(); 
conn.close();               
}catch(Exception ee)
{
throw new DAOException(ee.getMessage());
}
}


}
                