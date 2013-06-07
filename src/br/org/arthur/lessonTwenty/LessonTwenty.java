package br.org.arthur.lessonTwenty;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class LessonTwenty extends JFrame 
{
	
	public static void main(String[] args) 
	{
		new LessonTwenty();
	}
	
	public LessonTwenty()
	{
		this.setSize(400, 400);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Dimension dim = tk.getScreenSize();
		
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		
		this.setLocation(xPos, yPos);
		
		this.setResizable(false);		
						
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setTitle("My First Frame");
		JPanel thePanel = new JPanel();
		
		JLabel label1 = new JLabel("Tell me something");
		
		label1.setText("New Text");
		
		label1.setToolTipText("Doesn't do anything");
		
		JButton button1 = new JButton("Send");
		button1.setText("New Button");
		button1.setToolTipText("It's a button");
		
		JTextField txtField1 = new JTextField("Type here ", 15);
		
		txtField1.setText("Type again");
		txtField1.setColumns(10);
		
		thePanel.add(label1);
		
		thePanel.add(button1);
		
		thePanel.add(txtField1);
		
		JTextArea txtArea1 = new JTextArea(15, 20);
		txtArea1.setText("Just a whole bunch of useless information");
		txtArea1.setLineWrap(true);
		txtArea1.setWrapStyleWord(true);
		int numOfLines = txtArea1.getLineCount();
		txtArea1.append(" number of lines: " + numOfLines);
		JScrollPane scrollbar1 = new JScrollPane(txtArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		thePanel.add(txtArea1);
		thePanel.add(scrollbar1);
		
		this.add(thePanel);
		
		this.setVisible(true);
		
		txtArea1.requestFocus();
	}
}
