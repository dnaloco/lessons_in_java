package br.org.arthur.lessonTwentyFive;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.List;

public class LessonTwentyFive extends JFrame
{
	private static final long serialVersionUID = 1788251255718134763L;
	
	JButton button1;
	String infoOnComponent = "";
	JList<String> favoriteMovies, favoriteColors;
	DefaultListModel<String> defListModel = new DefaultListModel<String>();
	JScrollPane scrollerMovies, scrollerColors;
	
	public static void main(String[] args)
	{
		new LessonTwentyFive();
	}
	
	public LessonTwentyFive()
	{
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Fifth Frame");
		
		JPanel thePanel = new JPanel();
		
		button1 = new JButton("Get Answer");
		ListenForButton lForButton = new ListenForButton();
		button1.addActionListener(lForButton);
		thePanel.add(button1);
		
		String[] movies = {
			"Matrix",
			"Minority Report",
			"Oldboy",
			"Let Me In",
			"The Shawshank Redemption",
			"The Godfather"
		};
		
		favoriteMovies = new JList<String>(movies);
		favoriteMovies.setFixedCellHeight(30);
		favoriteMovies.setFixedCellWidth(150);
		favoriteMovies.setVisibleRowCount(3);
		favoriteMovies.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		favoriteMovies.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		// All th methods for lists:
			/*
			 * getSelectedIndex()
			 * getSelectedIndexes()
			 * getSelectedValue()
			 * getSelectedValues()
			 * isSelectedIndex() 
			 */
		scrollerMovies = new JScrollPane(favoriteMovies, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		thePanel.add(scrollerMovies);
		
		String[] colors = {"Black", "Blue", "Gray", "Orange", "Green", "Blue", "Yellow", "Purple", "White", "Red", "Pink"};

		for(String color : colors)
		{
			defListModel.addElement(color);
		}
		defListModel.add(3, "Brown");

		
		favoriteColors = new JList<String>(defListModel);
		
		favoriteColors.setVisibleRowCount(4);
		
		favoriteColors.setFixedCellHeight(30);
		
		favoriteColors.setFixedCellWidth(150);
		
		scrollerColors = new JScrollPane(favoriteColors, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		thePanel.add(scrollerColors);
		
		this.add(thePanel);
		
		this.setVisible(true);
		
	}
	
	private class ListenForButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == button1)
			{
				infoOnComponent += "List of Colors\n";
				if(defListModel.contains("Black")) infoOnComponent += "Black is here\n";
				if(defListModel.isEmpty()) infoOnComponent += "defListModel is empty\n";
				
				infoOnComponent += "Number of elements in the list: " + defListModel.size() + "\n";
				infoOnComponent += "Last Element: " + defListModel.lastElement() + "\n";
				infoOnComponent += "First Element: " + defListModel.firstElement() + "\n";
				infoOnComponent += "In Index 3: " + defListModel.get(3) + "\n";
				
				defListModel.remove(2);
				defListModel.removeElement("Pink");
				infoOnComponent += "Number of elements in the list: " + defListModel.size() + "\n";
				
				List<String> arrayOfFavMovies = favoriteMovies.getSelectedValuesList();
				
				infoOnComponent += "CORES:\n";
				for(Object color: defListModel.toArray())
				{
					infoOnComponent += color + "\n";
				}
				infoOnComponent += "\nFilmes Preferidos\n";
				for(Object movie : arrayOfFavMovies)
				{
					infoOnComponent += movie + "\n";
				}
				
				JOptionPane.showMessageDialog(LessonTwentyFive.this,infoOnComponent, "Information", JOptionPane.INFORMATION_MESSAGE);
				
				infoOnComponent = "";
			}
		}

	}
}
