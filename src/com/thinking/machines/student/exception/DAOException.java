package com.thinking.machines.student.exception;
import java.sql.SQLException;
import java.io.IOException;
public class DAOException extends Exception
{
public DAOException(String message)
{
super(message);
}
}