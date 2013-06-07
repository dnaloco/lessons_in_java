package br.org.arthur.lessonTwentySix;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Calendar;


public class LessonTwentySix extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	JButton button1;
	JSpinner spin1, spin2, spin3, spin4;
	String outputString = "";
	
	public static void main(String[] args)
	{
		new LessonTwentySix();
	}
	
	public LessonTwentySix()
	{
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Sixty Frame");
		
		JPanel thePanel = new JPanel();
		
		button1 = new JButton("Get Answer");
		ListenForButton lForButton = new ListenForButton();
		button1.addActionListener(lForButton);
		thePanel.add(button1);
		
		spin1 = new JSpinner();
		Dimension d1 = spin1.getPreferredSize();
		d1.width = 40;
		spin1.setPreferredSize(d1);
		thePanel.add(spin1);
		
		spin2 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
		thePanel.add(spin2);
		
		String[] weekDays = {"Mon", "Tues", "Weds", "Thurs", "Fry"};
		spin3 = new JSpinner(new SpinnerListModel(weekDays));
		Dimension d2 = spin3.getPreferredSize();
		d2.width = 60;
		spin3.setPreferredSize(d2);
		thePanel.add(spin3);
		
		Date todaysDate = new Date();
		spin4 = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spin4, "dd/MM/yy");
		spin4.setEditor(dateEditor);
		thePanel.add(spin4);
		
		//ListenForSpinner lForSpinner = new ListenForSpinner();
		//spin3.addChangeListener(lForSpinner);
		
		this.add(thePanel);
		this.setVisible(true);
		
	}
	
	private class ListenForButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == button1)
			{
				outputString += "Spinner 1 value: " + spin1.getValue() + "\n";
				outputString += "Spinner 2 value: " + spin2.getValue() + "\n";
				outputString += "Spinner 3 value: " + spin3.getValue() + "\n";
				outputString += "Spinner 4 value: " + spin4.getValue() + "\n";
				JOptionPane.showMessageDialog(LessonTwentySix.this, outputString, "Information", JOptionPane.INFORMATION_MESSAGE);
				outputString = "";
			}
		}
		
	}
	
	private class ListenForSpinner implements ChangeListener
	{

		@Override
		public void stateChanged(ChangeEvent e) {
			JOptionPane.showMessageDialog(LessonTwentySix.this, spin4.getValue());
		}
		
	}
}
