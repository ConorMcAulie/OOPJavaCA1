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

public class MyScreen extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;

	ArrayList<NaiveBayes> personListGUI = new ArrayList<>();
	String labelText;
	int result = 0;
	
	private JButton buttonTest;
	private JButton buttonTrain;
	private JButton buttonAdd;
	private JButton buttonReset;
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
		setSize(2400,800);
		
		labelTitle = new JLabel("Naive Bayes Probability of Tonsillitis");
		textAreaShow = new JTextArea("");
		textAreaShow.setPreferredSize(new Dimension(300,200));
		
		buttonTest = new JButton("Test a patient");
		buttonTrain = new JButton("Train using data set");
		buttonAdd = new JButton("Add more data");
		buttonReset = new JButton("Reset to given data set");
		
		
		PanelT.add(labelTitle);
		PanelT.setPreferredSize(new Dimension(300,100));
		
		PanelM.add(buttonTest);
		PanelM.add(buttonTrain);
		PanelM.add(buttonAdd);
		
		PanelB.add(textAreaShow);
		PanelB.setPreferredSize(new Dimension(300,300));

		buttonTest.addActionListener(this);
		buttonTrain.addActionListener(this);
		buttonAdd.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == buttonTest) 
		{
			if(personListGUI.size()<20) 
			{
				JOptionPane.showMessageDialog(this, "You added ");
			}
		}
		else if(arg0.getSource() == buttonTrain)
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
		else if(arg0.getSource() == buttonReset)
		{
			result = JOptionPane.showConfirmDialog(this, "Do you wish to Reset data set?","Delete Dialog", 1);
			if(result == 0) 
			{
				
			}
		}
	}
}
