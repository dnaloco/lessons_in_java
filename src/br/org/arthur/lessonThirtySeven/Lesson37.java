package br.org.arthur.lessonThirtySeven;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;
import java.text.ParseException;

import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Lesson37 extends JFrame
{
	static JLabel lblFirstName, lblLastName, lblState, lblBirthDate;
	static JTextField txtFirstName, txtLastName, txtState, txtBirthDate;
	
	static java.util.Date dateBirthDate, sqlBirthDate;
	
	static Object[][] databaseResults;
	static Object[] columns = {"First Name", "Last Name", "State", "Birth Date"};
	
	static DefaultTableModel dTableModel = new DefaultTableModel(databaseResults, columns){
		public Class getColumnClass(int column)
		{
			Class returnValue;
			
			if((column >= 0) && (column < getColumnCount()))
			{
				returnValue = getValueAt(0, column).getClass();
			}
			else
			{
				returnValue = Object.class;
			}
			
			return returnValue;
		}
	};
	
	static JTable table = new JTable(dTableModel);
	
	public static void main(String[] args)
	{
		new Lesson37();
	}
	
	public Lesson37()
	{
		super("Lesson 37 - Derek Banas");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		populateTableModel();
	}
	
	public static void populateTableModel()
	{
		Connection conn = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/derek_java_lessons", "arthur", "artdna07");
			
			Statement sqlState = conn.createStatement();
			
			String sqlQuery = "SELECT first_name, last_name, state, birth FROM president";
			
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Class not fount.");
			System.out.println("Message: " + e.getMessage());
			System.exit(0);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception Error: " + e.getMessage());
			System.out.println("Vendor Code Error:" + e.getErrorCode());
			System.exit(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}