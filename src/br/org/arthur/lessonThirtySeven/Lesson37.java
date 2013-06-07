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
				returnValue = getValue(0, column).getClass();
			}
			
			return returnValue;
		}
	};
	
	public static void main(String[] args)
	{
		
	}
}