package br.org.arthur.lessonTwentyEight;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;


public class LessonTwentyEight extends JFrame
{
	JButton btn1, btn2, btn3, btn4, btn5, btn6;
	public static void main(String[] args)
	{
		new LessonTwentyEight();
	}
	
	public LessonTwentyEight()
	{
		this.setSize(550,400);
		this.setMinimumSize(new Dimension(500, 100));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("About Layouts - Part I");
		
		JPanel thePanel = new JPanel();
		/* FlowLayout
		
		thePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		btn1 = new JButton("Botão 1");
		btn2 = new JButton("Botão 2");
		btn3 = new JButton("Botão 3");
		btn4 = new JButton("Botão 4");
		btn5 = new JButton("Botão 5");
		btn6 = new JButton("Botão 6");
		
		thePanel.add(btn1);
		thePanel.add(btn2);
		thePanel.add(btn3);
		thePanel.add(btn4);
		thePanel.add(btn5);
		thePanel.add(btn6);
		
		*/
		
		/* BorderLayou
		thePanel.setLayout(new BorderLayout());
		
		btn1 = new JButton("Botão 1");
		btn2 = new JButton("Botão 2");
		btn3 = new JButton("Botão 3");
		btn4 = new JButton("Botão 4");
		btn5 = new JButton("Botão 5");
		btn6 = new JButton("Botão 6");
		
		JPanel thePanel2 = new JPanel();
		thePanel2.setLayout(new FlowLayout(FlowLayout.LEADING));
		thePanel2.add(btn5);
		thePanel2.add(btn6);
		
		thePanel.add(btn1, BorderLayout.NORTH);
		thePanel.add(btn2, BorderLayout.WEST);
		thePanel.add(btn3, BorderLayout.EAST);
		thePanel.add(btn4, BorderLayout.SOUTH);
		thePanel.add(thePanel2, BorderLayout.CENTER);
		
		
		this.add(thePanel);
		
		*/
		/* Box Layout */
		Box theBox = Box.createHorizontalBox();
		
		btn1 = new JButton("Botão 1");
		btn2 = new JButton("Botão 2");
		btn3 = new JButton("Botão 3");
		btn4 = new JButton("Botão 4");
		btn5 = new JButton("Botão 5");
		btn6 = new JButton("Botão 6");
		
		theBox.add(btn1);
		theBox.add(Box.createHorizontalStrut(5));
		theBox.add(btn2);
		theBox.add(Box.createHorizontalStrut(5));
		theBox.add(btn3);
		theBox.add(Box.createHorizontalStrut(5));
		theBox.add(btn4);
		theBox.add(Box.createHorizontalStrut(5));
		theBox.add(btn5);
		theBox.add(Box.createHorizontalGlue());
		theBox.add(btn6);
		
		this.add(theBox);
		this.setVisible(true);
	}

}
