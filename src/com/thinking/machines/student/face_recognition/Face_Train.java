package com.thinking.machines.student.face_recognition;
import com.thinking.machines.student.data.*;
import com.thinking.machines.student.exception.*;
import com.thinking.machines.student.application.*;
import java.io.*;
public class Face_Train extends Thread
{
public static void Train()
{
try
{
Process p = Runtime.getRuntime().exec("python C:/minor/Staysafe/src/com/thinking/machines/student/face_recognition/faces-train.py ");
BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
}catch(Exception ee)
{
System.out.println(ee.getMessage());
}
}
}