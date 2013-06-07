package br.org.arthur.lessonTwentyTwoThree;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//import java.awt.Dimension;
//import java.awt.Toolkit;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.border.*;

public class LessonTwentyTwo extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5880865693752938531L;


	JButton btn1;
	JLabel lbl1, lbl2, lbl3;
	JTextField txtf1, txtf2;
	JCheckBox dollarSign, commaSeparator;
	JRadioButton addNums, subNums, multNums, divNums;
	JSlider howManyTimes;
	
	double num1, num2, totalCalc;
	
	public static void main(String[] args)
	{
		new LessonTwentyTwo();
	}
	
	public LessonTwentyTwo()
	{
		this.setSize(400, 400);
		//Toolkit tk = Toolkit.getDefaultToolkit();
		//Dimension dim = tk.getScreenSize();
		
		//int xPos = (dim.width/2) - (this.getWidth() /2);
		//int yPos = (dim.height/2) - (this.getHeight() / 2);
		
		//this.setLocation(xPos,yPos);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setTitle("My Third Frame");
		
		JPanel thePanel = new JPanel();
		
		btn1 = new JButton("Calculate");
		
		ListenForButton lForButton = new ListenForButton();
		
		btn1.addActionListener(lForButton);
		thePanel.add(btn1);
		
		lbl1 = new JLabel("Number 1");
		thePanel.add(lbl1);
		
		txtf1 = new JTextField("", 5);
		thePanel.add(txtf1);
		
		lbl2 = new JLabel("Number 2");
		thePanel.add(lbl2);
		
		txtf2 = new JTextField("", 5);
		thePanel.add(txtf2);
		
		dollarSign = new JCheckBox("Dollars");
		commaSeparator = new JCheckBox("Commas");
		
		thePanel.add(dollarSign);
		thePanel.add(commaSeparator, true);
		
		addNums = new JRadioButton("+");
		subNums = new JRadioButton("-");
		multNums = new JRadioButton("*");
		divNums = new JRadioButton("/");
		
		ButtonGroup operation = new ButtonGroup();
		operation.add(addNums);
		operation.add(subNums);
		operation.add(multNums);
		operation.add(divNums);		
		
		JPanel operPanel = new JPanel();
		
		Border operBorder = BorderFactory.createTitledBorder("Operation");
		
		operPanel.setBorder(operBorder);
		
		operPanel.add(addNums);
		operPanel.add(subNums);
		operPanel.add(multNums);
		operPanel.add(divNums);
		
		addNums.setSelected(true);
		
		thePanel.add(operPanel);
		
		lbl3 = new JLabel("Perform how many times?");
		thePanel.add(lbl3);
		
		howManyTimes = new JSlider(0, 100,1);
		howManyTimes.setMinorTickSpacing(1);
		howManyTimes.setMajorTickSpacing(10);
		howManyTimes.setPaintTicks(true);
		howManyTimes.setPaintLabels(true);
		
		ListenForSlider lForSlider = new ListenForSlider();
		howManyTimes.addChangeListener(lForSlider);
		
		thePanel.add(howManyTimes);
		this.add(thePanel);
		this.setVisible(true);
		txtf1.requestFocus();
	}
	
	private class ListenForButton implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn1)
			{
				try
				{
					num1 = Double.parseDouble(txtf1.getText());
					num2 = Double.parseDouble(txtf2.getText());
				}
				catch(NumberFormatException err)
				{
					JOptionPane.showMessageDialog(LessonTwentyTwo.this, "Please Enter the right info", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(addNums.isSelected()) 
				{
					totalCalc = addNumbers(num1, num2, howManyTimes.getValue());
				}
				else if(subNums.isSelected())
				{
					totalCalc = subNumbers(num1, num2, howManyTimes.getValue());
				}
				else if(multNums.isSelected())
				{
					totalCalc = multNumbers(num1, num2, howManyTimes.getValue());
				}
				else if(divNums.isSelected())
				{
					totalCalc = divNumbers(num1, num2, howManyTimes.getValue());
				}
				
				if(dollarSign.isSelected())
				{
					NumberFormat numFormat = NumberFormat.getCurrencyInstance(Locale.US);
					JOptionPane.showMessageDialog(LessonTwentyTwo.this, numFormat.format(totalCalc), "Solution", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(commaSeparator.isSelected())
				{
					NumberFormat numFormat = NumberFormat.getNumberInstance();
					JOptionPane.showMessageDialog(LessonTwentyTwo.this, numFormat.format(totalCalc), "Solution", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(LessonTwentyTwo.this, totalCalc, "Solution", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		}

		private double divNumbers(double num1, double num2, int howManyTimes) {
			double total = 0;
			int i =1;
			while(i <= howManyTimes)
			{
				total = total + (num1 / num2);
				i++;
			}
			return total;
		}

		private double multNumbers(double num1, double num2, int howManyTimes) {
			double total = 0;
			int i =1;
			while(i <= howManyTimes)
			{
				total = total + (num1 * num2);
				i++;
			}
			return total;
		}

		private double subNumbers(double num1, double num2, int howManyTimes) {
			double total = 0;
			int i =1;
			while(i <= howManyTimes)
			{
				total = total + (num1 - num2);
				i++;
			}
			return total;
		}

		private double addNumbers(double num1, double num2, int howManyTimes) {
			double total = 0;
			int i =1;
			while(i <= howManyTimes)
			{
				total = total + (num1 + num2);
				i++;
			}
			return total;
		}
	}
	
	private class ListenForSlider implements ChangeListener
	{
		public void stateChanged(ChangeEvent e)
		{
			if(e.getSource() == howManyTimes)
			{
				lbl3.setText("Perform How Many Time: " + howManyTimes.getValue());
			}
		}
	}
}


