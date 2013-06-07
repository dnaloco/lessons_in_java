package br.org.arthur.lessonTwentyNine;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Lesson29 extends JFrame 
{
	JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
		btnPlus, btnMinus, btnMult, btnDiv, btnClearAll;
	
	JTextField txtResult;
	
	static String inputNumbers = "";
	static Double num1, num2, result, visor;
	
	public static void main(String[] args)
	{
		new Lesson29();
	}
	
	public Lesson29()
	{
		this.setSize(300, 300);
		this.setMinimumSize(new Dimension(200, 250));
		this.setMaximumSize(new Dimension(350, 350));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calculadora");
		
		JPanel thePanel = new JPanel();
		
		// thePanel.setLayout(new GridLayout(0, 3, 2, 2));
		thePanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		gridConstraints.weightx = 100/3;
		gridConstraints.weighty = 1;
		gridConstraints.insets = new Insets(5, 5, 5, 5);
		gridConstraints.anchor = GridBagConstraints.CENTER;
		gridConstraints.fill = GridBagConstraints.BOTH;
		
		txtResult = new JTextField("0", 20);
		
		Font font = new Font("Helvetica", Font.PLAIN, 18);
		txtResult.setFont(font);
		
		ListenButtons lForButton = new ListenButtons();
		
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btnPlus = new JButton("+");
		btn0 = new JButton("0");
		btnMinus = new JButton("-");
		btnClearAll = new JButton("C");
		
		btn0.addActionListener(lForButton);
		
		thePanel.add(btnClearAll, gridConstraints);
		gridConstraints.gridwidth = 2;
		gridConstraints.gridx = 2;
		thePanel.add(txtResult, gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		thePanel.add(btn1, gridConstraints);
		gridConstraints.gridx = 2;
		thePanel.add(btn2, gridConstraints);
		gridConstraints.gridx = 3;
		thePanel.add(btn3, gridConstraints);
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		thePanel.add(btn4, gridConstraints);
		gridConstraints.gridx = 2;
		thePanel.add(btn5, gridConstraints);
		gridConstraints.gridx = 3;
		thePanel.add(btn6, gridConstraints);
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 4;
		thePanel.add(btn7, gridConstraints);
		gridConstraints.gridx = 2;
		thePanel.add(btn8, gridConstraints);
		gridConstraints.gridx = 3;
		thePanel.add(btn9, gridConstraints);
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 5;
		thePanel.add(btnPlus, gridConstraints);
		gridConstraints.gridx = 2;
		thePanel.add(btn0, gridConstraints);
		gridConstraints.gridx = 3;
		thePanel.add(btnMinus, gridConstraints);
		
		this.add(thePanel);
		
		this.setVisible(true);
		
		/*
		JPanel thePanel = new JPanel();
		
		ListenNumberButtons lForNumberButtons = new ListenNumberButtons();
		
		txtResult = new JTextField();
		txtResult.setPreferredSize(new Dimension(390, 30));
		
		btn0 = new JButton("0");
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		
		btn0.addActionListener(lForNumberButtons);
		btn1.addActionListener(lForNumberButtons);
		btn2.addActionListener(lForNumberButtons);
		btn3.addActionListener(lForNumberButtons);
		btn4.addActionListener(lForNumberButtons);
		btn5.addActionListener(lForNumberButtons);
		btn6.addActionListener(lForNumberButtons);
		btn7.addActionListener(lForNumberButtons);
		btn8.addActionListener(lForNumberButtons);
		btn9.addActionListener(lForNumberButtons);
		
		thePanel.add(txtResult);
		thePanel.add(btn0);
		thePanel.add(btn1);
		thePanel.add(btn2);
		thePanel.add(btn3);
		thePanel.add(btn4);
		thePanel.add(btn5);
		thePanel.add(btn6);
		thePanel.add(btn7);
		thePanel.add(btn8);
		thePanel.add(btn9);
		
		this.add(thePanel);
		*/		
	}
	
	private class ListenNumberButtons implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			/*
			inputNumbers += e.getActionCommand();
			visor = Double.parseDouble(inputNumbers);
			txtResult.setText(visor.toString());
			*/
		}
	}
	
	public class ListenButtons implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(Lesson29.this, Lesson29.this.getSize());
		}
	}
}
