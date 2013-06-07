package br.org.arthur.lessonTwentySeven;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.util.Enumeration;
import javax.swing.tree.*;

public class LessonTwentySeven extends JFrame 
{
	JButton button1;
	String outputString = "";
	JTree theTree;
	
	DefaultMutableTreeNode documents, work, games, emails;
	DefaultMutableTreeNode fileSystem = new DefaultMutableTreeNode("C Drive");
	
	public static void main(String[] args)
	{
		new LessonTwentySeven();
	}
	
	public LessonTwentySeven()
	{
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("This Is My Seventh Frame");
		
		JPanel thePanel = new JPanel();
		
		button1 = new JButton("Get Answer");
		ListenForButton lForButton = new ListenForButton();
		button1.addActionListener(lForButton);
		thePanel.add(button1);
		
		theTree = new JTree(fileSystem);
		theTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		theTree.setVisibleRowCount(8);
		
		documents = addAFile("Docs", fileSystem);
		addAFile("Taxes.txt", documents);
		addAFile("Story.txt", documents);
		addAFile("Calendas.exl", documents);
		
		emails = addAFile("Emails", documents);
		addAFile("Schedule.txt", documents);
		addAFile("SendAMessageToBod.txt", emails);
		
		work = addAFile("Work Applications", fileSystem);
		addAFile("Spreadsheet.exe", work);
		addAFile("Wordprocessor.exe", work);
		
		games = addAFile("Games", fileSystem);
		addAFile("SpaceInvaders.exe", games);
		addAFile("PacMan.exe", games);
		
		JScrollPane scrollBox = new JScrollPane(theTree);
		
		Dimension d= scrollBox.getPreferredSize();
		d.width = 200;
		scrollBox.setPreferredSize(d);
		
		thePanel.add(scrollBox);
		
		this.add(thePanel);
		this.setVisible(true);	
	}
	
	private class ListenForButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == button1)
			{
				Object treeObject = theTree.getLastSelectedPathComponent();
				
				DefaultMutableTreeNode theFile = (DefaultMutableTreeNode)treeObject;
				
				String treeNode = (String) theFile.getUserObject();
				
				outputString += "The Selected Node: " + treeNode + "\n";
				outputString += "Number of Childern: " + theFile.getChildCount() + "\n";
				outputString += "Number of Siblings: " + theFile.getSiblingCount() + "\n";
				outputString += "Parent: " + theFile.getParent() + "\n";
				outputString += "Next Node: " + theFile.getNextNode() + "\n";
				outputString += "Previous Node: " + theFile.getPreviousNode() + "\n";
				
				outputString +=  "\nChildren of Node\n";
				for(Enumeration enumValue = theFile.children(); enumValue.hasMoreElements();)
				{
					outputString += enumValue.nextElement() + "\n";
				}
				
				outputString = "\nPath From Root\n";
				
				TreeNode[] pathNodes = theFile.getPath();
				
				for(TreeNode indivNode : pathNodes)
				{
					outputString += indivNode + "\n";
				}
				
				JOptionPane.showMessageDialog(LessonTwentySeven.this, outputString, "Information", JOptionPane.INFORMATION_MESSAGE);
				outputString = "";
			}
		}
	}
	
	private DefaultMutableTreeNode addAFile(String fileName, DefaultMutableTreeNode parentFolder)
	{
		DefaultMutableTreeNode newFile = new DefaultMutableTreeNode(fileName);
		parentFolder.add(newFile);
		
		return newFile;
	}
}
