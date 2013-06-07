package br.org.arthur.lessonThirty;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.Calendar;
import java.util.Date;

public class Lesson30 extends JFrame 
{
	// LEGENDA:
	/*
	 * lbl = label
	 * txt = textfield
	 * cb = combo box
	 * spin = spinner
	 * slid = slider
	 * rb = radio button
	 * gbtn = button group
	 * chk = check box
	 * atxt = textarea
	 * 
	 */
	
	JLabel 
		lblName, 
		lblStreet, 
		lblState, 
		lblDate,
		lblAge, 
		lblSex, 
		lblOptions, 
		lblAbout;
	
	JTextField 
		txtName, 
		txtStreet;
	
	JComboBox cbStateList;
	JSpinner spinDate;
	JSlider slidAge;
	
	JRadioButton 
		rbMale, 
		rbFemale;
	ButtonGroup gbtnSex;
	
	JCheckBox 
		chkMorning, 
		chkAfterN, 
		chkEveging;
	
	JTextArea atxtAboutYou;
			
	public static void main(String[] args)
	{
		new Lesson30();		
	}
	
	public Lesson30()
	{
		super("Random Layout");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel thePanel = new JPanel();
		
		thePanel.setLayout(new GridBagLayout());
		
		lblName = new JLabel(" Name: ");		
		addComp(thePanel, lblName, 0,0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		
		txtName = new JTextField(30);
		addComp(thePanel, txtName, 1,0, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		lblStreet = new JLabel(" Street: ");
		addComp(thePanel, lblStreet, 0,1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		
		txtStreet = new JTextField(30);
		addComp(thePanel, txtStreet, 1,1, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		Box sexBox = Box.createVerticalBox();
		
		rbMale = new JRadioButton("Male");
		rbFemale = new JRadioButton("Female");
		
		gbtnSex = new ButtonGroup();
		gbtnSex.add(rbMale);
		gbtnSex.add(rbFemale);
		
		sexBox.add(rbMale);
		sexBox.add(rbFemale);
		sexBox.setBorder(BorderFactory.createTitledBorder("Sex"));
		
		addComp(thePanel, sexBox, 3,0, 2, 2, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		JPanel statePanel = new JPanel();
		statePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		lblState = new JLabel("State");
		statePanel.add(lblState);
		
		String[] states = {"CA", "PA", "NY", "OH", "WV"};
		cbStateList = new JComboBox<String>(states);
		statePanel.add(cbStateList);
		
		lblDate = new JLabel("Appointment Date");
		statePanel.add(lblDate);
		
		Date todaysDate = new Date();
		spinDate = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinDate, "dd/MM/yy");
		spinDate.setEditor(dateEditor);
		statePanel.add(spinDate);
		
		lblAge = new JLabel("Age: 50");
		statePanel.add(lblAge);
		
		slidAge = new JSlider(1, 99, 50);
		
		ListenForSlider lForSlider =  new ListenForSlider();
		slidAge.addChangeListener(lForSlider);
		statePanel.add(slidAge);
		
		addComp(thePanel, statePanel, 1, 2, 5, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		Box optionsBox = Box.createVerticalBox();
		
		chkMorning = new JCheckBox("Morning");
		chkAfterN = new JCheckBox("Afternoon");
		chkEveging = new JCheckBox("Evening");
		
		optionsBox.add(chkMorning);
		optionsBox.add(chkAfterN);
		optionsBox.add(chkEveging);
		
		optionsBox.setBorder(BorderFactory.createTitledBorder("Time of Day"));
		
		addComp(thePanel, optionsBox, 1, 3, 2, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);
		
		atxtAboutYou = new JTextArea(6, 40);
		atxtAboutYou.setText("Tell us about you");
		atxtAboutYou.setLineWrap(true);
		atxtAboutYou.setWrapStyleWord(true);
		
		JScrollPane scrollAboutYou = new JScrollPane(atxtAboutYou, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		addComp(thePanel, scrollAboutYou, 2, 3, 3, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		this.add(thePanel);
		this.pack();
		this.setVisible(true);
	}
	
	private class ListenForSlider implements ChangeListener
	{

		@Override
		public void stateChanged(ChangeEvent e) {
			if(e.getSource() == slidAge)
			{
				lblAge.setText("Age: " + slidAge.getValue());
			}
		}
		
	}
	
	private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth,int compHeight, int place, int stretch)
	{
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = xPos;
		gridConstraints.gridy = yPos;
		gridConstraints.gridwidth = compWidth;
		gridConstraints.gridheight = compHeight;
		gridConstraints.weightx = 100;
		gridConstraints.weighty = 100;
		gridConstraints.insets = new Insets(5, 5, 5, 5);
		gridConstraints.anchor = place;
		gridConstraints.fill = stretch;
		
		thePanel.add(comp, gridConstraints);
		
	}
}
