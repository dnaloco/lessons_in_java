package br.org.arthur.lessonTwentyFour;

import javax.swing.*;
import java.awt.event.*;

public class LessonTwentyFour extends JFrame 
{
	JComboBox favoriteShows;
	JButton button1;
	JLabel  label1;
	String infoOnComponent = "";
	
	public static void main(String[] args)
	{
		new LessonTwentyFour();
	}
	
	public LessonTwentyFour()
	{
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel thePanel = new JPanel();

		label1 = new JLabel("What's your favorite show?");
		thePanel.add(label1);
		
		String[] shows = {"Breaking Bad", "The Game of Thrones", "Walking Dead"};
		favoriteShows = new JComboBox(shows);
		favoriteShows.addItem("Supernatural");
		
		thePanel.add(favoriteShows);
		
				
		button1 = new JButton("Get Answer");
		ListenForButtons lForButton = new ListenForButtons();
		button1.addActionListener(lForButton);
		thePanel.add(button1);
		
		this.add(thePanel);
		this.setVisible(true);
		
		favoriteShows.insertItemAt("Dexter", 1);
		favoriteShows.setMaximumRowCount(5);
		favoriteShows.removeItemAt(1);
		
	}
	
	private class ListenForButtons implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == button1)
			{
				favoriteShows.setEditable(true);
				
				infoOnComponent += "Item at 0: " + favoriteShows.getItemAt(0) + "\n";
				infoOnComponent += "Num of Shows: " + favoriteShows.getItemCount() + "\n";
				infoOnComponent += "Selected ID: " + favoriteShows.getSelectedIndex() +"\n";
				infoOnComponent += "Selected Value: " + favoriteShows.getSelectedItem() +"\n";
				infoOnComponent += "Are Editable: " + favoriteShows.isEditable() +"\n";
				JOptionPane.showMessageDialog(LessonTwentyFour.this,infoOnComponent, "Information", JOptionPane.INFORMATION_MESSAGE);
				infoOnComponent = "";
			}
		}
	}
}
