package com.CA_Assignment.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyScreen extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;

	ArrayList<NaiveBayes> personListGUI = new ArrayList<>();
	String labelText;
	int result = 0;
	
	private JButton buttonSave;
	private JButton buttonShow;
	private JButton buttonDelete;
	private JTextField textFirstName;
	private JTextField textSurName;
	private JTextField textCity;
	private JLabel labelTitle;
	private JTextArea textAreaShow;
	
	public MyScreen() 
	{
		super("Tonsillitis");
		setLayout(new BorderLayout());
		
		JPanel PanelT = new JPanel();
		JPanel PanelM = new JPanel();
		JPanel PanelB = new JPanel();
		
		add(PanelT, BorderLayout.NORTH);
		add(PanelM, BorderLayout.CENTER);
		add(PanelB, BorderLayout.SOUTH);

		setLocation(100,100);
		setSize(1200,800);
		
		labelTitle = new JLabel("Naive Bayes Probability of Tonsillitis");
		textAreaShow = new JTextArea("");
		textAreaShow.setPreferredSize(new Dimension(300,200));
		
		textFirstName = new JTextField("\t");
		textFirstName.setToolTipText("First Name Here");
		textFirstName.setPreferredSize(new Dimension(300,100));
		textSurName = new JTextField("\t");
		textSurName.setToolTipText("Surname Here");
		textSurName.setPreferredSize(new Dimension(300,100));
		textCity = new JTextField("\t");
		textCity.setToolTipText("City Here");
		textCity.setPreferredSize(new Dimension(300,100));
		
		buttonSave = new JButton("Save");
		buttonShow = new JButton("Show all");
		buttonDelete = new JButton("Delete");
		
		PanelT.add(labelTitle);
		PanelT.setPreferredSize(new Dimension(300,100));
		
		PanelM.add(textFirstName);
		PanelM.add(textSurName);
		PanelM.add(textCity);
		
		PanelM.add(buttonSave);
		PanelM.add(buttonShow);
		PanelM.add(buttonDelete);
		
		PanelB.add(textAreaShow);
		PanelB.setPreferredSize(new Dimension(300,300));

		buttonSave.addActionListener(this);
		buttonShow.addActionListener(this);
		buttonDelete.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == buttonSave) 
		{
			if(personListGUI.size()<20) 
			{
				JOptionPane.showMessageDialog(this, "You added ");
			}
		}
		else if(arg0.getSource() == buttonShow)
		{
			if(personListGUI.size() > 0) 
			{
				labelText = " Array List with all people elements \n";
				for(NaiveBayes element: personListGUI)
				{
					labelText = labelText + element + "\n";
				}
				labelText = labelText + "\n";
			}
			else
			{
				labelText = "";
			}
			textAreaShow.setText(labelText);
		}
		else if(arg0.getSource() == buttonDelete)
		{
			result = JOptionPane.showConfirmDialog(this, "Do you wish to delete array list?","Delete Dialog", 1);
			if(result == 0) 
			{
				personListGUI.clear();
				labelText = "";
				textAreaShow.setText(labelText);
			}
		}
	}
}
