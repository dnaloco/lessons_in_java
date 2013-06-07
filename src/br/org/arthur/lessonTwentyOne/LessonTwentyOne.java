package br.org.arthur.lessonTwentyOne;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

import java.awt.event.*;

public class LessonTwentyOne extends JFrame 
{
	
	JButton button1;
	JTextField txtField1;
	JTextArea txtArea1;
	int buttonClicked = 0;
	
	public static void main(String[] args) 
	{
		new LessonTwentyOne();
	}
	
	public LessonTwentyOne()
	{
		this.setSize(400, 400);
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Dimension dim = tk.getScreenSize();
		
		int xPos = (dim.width / 2) - (this.getWidth());
		int yPos = (dim.height / 2) - (this.getHeight());
		
		JPanel thePanel = new JPanel();
		button1 = new JButton("Click Here");
		
		ListenForButton lForButton = new ListenForButton();
		
		button1.addActionListener(lForButton);
		
		thePanel.add(button1);
		
		txtField1 = new JTextField("", 15);
		
		ListenForKeys lForKeys = new ListenForKeys();
		
		txtField1.addKeyListener(lForKeys);
		
		thePanel.add(txtField1);
		
		txtArea1 = new JTextArea(15, 20);
		txtArea1.setText("Tracking Events:\n");
		txtArea1.setLineWrap(true);
		txtArea1.setWrapStyleWord(true);
		
		thePanel.add(txtArea1);
		
		JScrollPane scrollbar1 = new JScrollPane(txtArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		thePanel.add(scrollbar1);
		
		this.add(thePanel);
		
		ListenForWindow lForWindow = new ListenForWindow();
		this.addWindowListener(lForWindow);
		
		this.setVisible(true);
		
		ListenForMouse lForMouse = new ListenForMouse();
		
		thePanel.addMouseListener(lForMouse);
		
	}
	
	// Implement Listeners
	private class ListenForButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == button1)
			{
				buttonClicked++;
				
				if(buttonClicked == 1) {
					txtArea1.append("Button clicked " + buttonClicked + " time.\n");
				}
				else
				{
					txtArea1.append("Button clicked " + buttonClicked + " times.\n");
				}
				
				e.getSource().toString();
			}
		}
	}
	
	private class ListenForKeys implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent e) {
			txtArea1.append("Key Hit: " + e.getKeyChar() + "\n");
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

		@Override
		public void keyTyped(KeyEvent e) {

		}
	}
	
	private class ListenForWindow implements WindowListener
	{

		@Override
		public void windowActivated(WindowEvent e) {
			txtArea1.append("Window is active\n");
		}

		@Override
		public void windowClosed(WindowEvent arg0) {

		}

		@Override
		public void windowClosing(WindowEvent arg0) {

		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			txtArea1.append("Window is not active\n");
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			txtArea1.append("Window in Normal State\n");
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			txtArea1.append("Window is minimized\n");
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			txtArea1.append("Window Created\n");
		}
	}
	
	private class ListenForMouse implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			txtArea1.append("Mouse Panel pos: " + e.getX() + " " + e.getY() + "\n");
			txtArea1.append("Mouse Screen pos: " + e.getXOnScreen() + " " + e.getYOnScreen() + "\n");
			txtArea1.append("Mouse Button : " + e.getButton() + "\n");
			txtArea1.append("Mouse Clicks : " + e.getClickCount() + "\n");
		} 

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

