package br.org.arthur.lessonThirtySix;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Lesson36 
{
	static Object[][] databaseInfo;
	static Object[] columns = {"Year", "PlayerID", "Name", "TTRC", "Team", "Salary", "CPR", "POS"};
	
	static ResultSet rows;
	static ResultSetMetaData metaData;
	
	static DefaultTableModel dTableModel = new DefaultTableModel(databaseInfo, columns)
	{
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
	
	public static void main(String[] args)
	{
		new Lesson36() {
			public void welcomeMsg()
			{
				System.out.println("Loading...(about 6sec)");
			}
		}.welcomeMsg();
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Connection conn = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/lahman", "arthur", "artdna07");
			
			Statement sqlState = conn.createStatement();
			
			//{"Year", "PlayerID", "Name", "TTRC", "Team", "Salary", "CPR", "POS"};
			// 0 		1			2		3		4		5		 6		7 ...
			
			String sqlQuery = "select b.yearID, b.playerID, " + // (1)yearID, (2)playerID
                    "CONCAT(m.nameFirst, ' ', m.nameLast) AS Name, " + // (3)Name
                    "((b.H+b.BB)+(2.4*(b.AB+b.BB)))*(t.BB+(3*(b.AB+b.BB)))/(9*(b.AB+b.BB))-(.9*(b.AB+b.BB)) AS TTRC, " + // (4)TTRC
                    "b.teamID AS Team," + // (5)Team
                    "s.salary AS Salary, " + // (6)Salary
                    "CAST( s.salary/(((b.H+b.BB)+(2.4*(b.AB+b.BB)))*(t.BB+(3*(b.AB+b.BB)))/(9*(b.AB+b.BB))-(.9*(b.AB+b.BB))) as decimal(10,2)) AS CPR, " + // (7)CPR
                    "f.POS AS POS " + // (8)POS
                    "FROM Batting b, Master m, Salaries s, Pitching t, Fielding f " +
                    "WHERE b.playerID = m.playerID AND t.playerID = m.playerID " +
                    "AND t.yearID = 2010 AND b.yearID = t.yearID AND s.playerID = b.playerID " +
                    "AND s.yearID = b.yearID AND b.AB > 50 AND b.playerID = f.playerID " +
                    "AND b.playerID = t.playerID GROUP BY b.playerID ORDER BY TTRC DESC LIMIT 200;";
			
			rows = sqlState.executeQuery(sqlQuery);
			Object[] tempRow;
			
			// {"Year", "PlayerID", "Name", "TTRC", "Team", "Salary", "CPR", "POS"};
			while(rows.next())
			{
				// instead of inialize through put the int number into square brackets, you could put the elements between curly brackets...
				// you already had got it...Just to memorize...
				tempRow = new Object[]{
					rows.getInt(1), 
					rows.getString(2),
					rows.getString(3),
					rows.getDouble(4),
					rows.getString(5),
					rows.getInt(6),
					rows.getDouble(7),
					rows.getString(8)
				};
				dTableModel.addRow(tempRow);
			}
			
			/*
			System.out.println("Executando query 'rows = sqlState.executeQuery(sqlQuery)'");
			System.out.println("START: 0s");
			long startTime = System.currentTimeMillis();
			rows = sqlState.executeQuery(sqlQuery);
			System.out.println("STOP: " + (System.currentTimeMillis()-startTime)/1000 + "s");
			System.out.println("Buscando meta data 'metaData = rows.getMetaData()'");
			metaData = rows.getMetaData();
			
			System.out.println("Buscando quantidade de colunas em 'int numOfCol = metaData.getColumnCount()'");
			int numOfCols = metaData.getColumnCount();
			System.out.println("Amount of Columns: " + numOfCols);
			
			int numOfRows = 0;
			try
			{
				while(rows.next()) numOfRows++;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println(numOfRows);
			System.out.println();
			for(Object column : columns)
			{
				System.out.println(column);
			}
			
			columns = new String[numOfCols];
			
			for(int i = 1; i <= numOfCols; i++)
			{
				columns[i-1] = metaData.getColumnName(i);
			}
			
			System.out.println();
			
			for(Object column : columns)
			{
				System.out.println(column);
			}
			*/
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			System.out.println("SQL Error: " + e.getMessage());
			System.out.println("Vendor Error: " + e.getErrorCode());
			System.exit(0);
		}
		catch(Exception e)
		{
			System.out.println("Holy shit. Mess up the program. What the hell I did?");
			e.printStackTrace();
		} // END OF try&catch (
			// make a connection, 
			// initiate the 'ResultSet rows' set 'Statement sqlState' and executeQuery() to rows. 
			// Get through rows with while to store in a variable tempRow Object array with right types and addRow(temRow) to dTableModel)
		
		JTable table = new JTable(dTableModel);
		table.setRowHeight(table.getRowHeight() + 10);
		table.setFont(new Font("Serif", Font.PLAIN,20));
		table.setAutoCreateRowSorter(true);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		DefaultTableCellRenderer cellsToLeft = new DefaultTableCellRenderer();
		cellsToLeft.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
		
		DefaultTableCellRenderer cellsToRight = new DefaultTableCellRenderer();
		cellsToRight.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		
		DefaultTableCellRenderer cellsToCenter = new DefaultTableCellRenderer();
		cellsToCenter.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
	
		// {"Year", "PlayerID", "Name", "TTRC", "Team", "Salary", "CPR", "POS"};
		TableColumn tcYear = table.getColumn("Year");
		tcYear.setCellRenderer(cellsToCenter);
		
		TableColumn tcPlayerID = table.getColumn("PlayerID");
		tcPlayerID.setCellRenderer(cellsToLeft);
		
		TableColumn tcTTRC = table.getColumn("TTRC");
		tcTTRC.setCellRenderer(cellsToLeft);
		
		TableColumn tcTeam = table.getColumn("Team");
		tcTeam.setCellRenderer(cellsToCenter);	
		
		TableColumn tcPOS = table.getColumn("POS");
		tcPOS.setCellRenderer(cellsToCenter);	
		
		
		TableColumn col1 = table.getColumnModel().getColumn(0);
		col1.setPreferredWidth(100);
		
		TableColumn col2 = table.getColumnModel().getColumn(1);
		col2.setPreferredWidth(120);
		
		TableColumn col3 = table.getColumnModel().getColumn(2);
        col3.setPreferredWidth(260);
        
        TableColumn col4 = table.getColumnModel().getColumn(3);
        col4.setPreferredWidth(120);

        TableColumn col5 = table.getColumnModel().getColumn(5);
        col5.setPreferredWidth(200);

        TableColumn col6 = table.getColumnModel().getColumn(6);
        col6.setPreferredWidth(200);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
		
		JScrollPane scrollTable = new JScrollPane(table);
		frame.add(scrollTable, BorderLayout.CENTER);
		frame.setTitle("Sabermetrics Tutorial Java 36 - Derek Banas");
		frame.setSize(dim);
		frame.setVisible(true);
		
		
	}
}


/*
~ = tilde
! = exclamation mark
() = parentheses
- = hyphen
_ = underscore
+ = plus sign
= = equals sign
[] = square brackets
{} = curly brackets (is there something more "official"? braces?)
\ = backslash
/ = slash, solidus
<> = angle brackets
¶ = paragraph mark, pilcrow sign
§ = section sign
© = copyright sign
¥ = Yen sign
¢ = cent sign
º = degree symbol, ordinal indicator
× = multiplication sign
÷ = division sign
*/