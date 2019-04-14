package com.CA_Assignment.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

@SuppressWarnings("unused")
public class MyScreen extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	int i;
	int result = 0;
	float reliability=0;
	String labelText;
	String[] choices = { "hot", "normal", "cool"};
	String[] choices2 = { "yes", "no"};
	NaiveBayes test = new NaiveBayes();
	
	private JButton buttonCheckP;
	private JButton buttonAddP;
	private JButton buttonResetP;
	private JButton buttonCheckRel;
	private JLabel labelTitle;
	private JLabel labelTrait1;
	private JLabel labelTrait2;
	private JLabel labelTrait3;
	private JComboBox<String> trait1 = new JComboBox<String>();
	private JComboBox<String> trait2 = new JComboBox<String>();
	private JComboBox<String> trait3 = new JComboBox<String>();
	
	public MyScreen() 
	{
		super("Tonsillitis");
		setLayout(new BorderLayout());
		
		JPanel PanelT = new JPanel();
		JPanel PanelM = new JPanel();
		JPanel PanelB = new JPanel();

		setLocation(100,100);
		setSize(1200,800);
		
		labelTitle = new JLabel("Naive Bayes Probability of Tonsillitis");
		labelTrait1 = new JLabel(" Temperature : ");
		labelTrait2 = new JLabel(" Aches : ");
		labelTrait3 = new JLabel(" Sore Throat : ");

	    trait1 = new JComboBox<String>(choices);
		trait2 = new JComboBox<String>(choices2);
		trait3 = new JComboBox<String>(choices2);
		
		buttonCheckP = new JButton("Submit Symptoms");
		buttonAddP = new JButton("Add instance of patient");
		buttonResetP = new JButton("Reset Data Training Set");
		buttonCheckRel = new JButton("Check Reliability");
		
		PanelT.add(labelTitle);
		add(PanelT, BorderLayout.NORTH);
		
		PanelM.add(labelTrait1, BorderLayout.NORTH);
		PanelM.add(trait1, BorderLayout.NORTH);
		PanelM.add(labelTrait2, BorderLayout.CENTER);
		PanelM.add(trait2, BorderLayout.CENTER);
		PanelM.add(labelTrait3, BorderLayout.SOUTH);
		PanelM.add(trait3, BorderLayout.SOUTH);
		add(PanelM, BorderLayout.CENTER);
		
		PanelB.add(buttonCheckP);
		PanelB.add(buttonAddP);
		PanelB.add(buttonResetP);
		PanelB.add(buttonCheckRel);
		add(PanelB, BorderLayout.SOUTH);

		buttonCheckP.addActionListener(this);
		buttonResetP.addActionListener(this);
		buttonAddP.addActionListener(this);
		buttonCheckRel.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == buttonCheckP) 
		{
			String[] options = new String[3];
			options[0] = (String) trait1.getSelectedItem();
			options[1] = (String) trait2.getSelectedItem();
			options[2] = (String) trait3.getSelectedItem();
			
			float answerYes = test.Algorithm(options);
			System.out.println(answerYes);
				
			JOptionPane.showMessageDialog(this, " Probability of Having Tonsilitis = " + answerYes + " %");
		}
		else if(arg0.getSource() == buttonAddP)
		{
			String[] options = new String[4];
			options[1] = (String) trait1.getSelectedItem();
			options[2] = (String) trait2.getSelectedItem();
			options[3] = (String) trait3.getSelectedItem();
			float answerYes = test.Algorithm(options);
			if(answerYes >= 50)
			{
				options[4] = "Yes";
			}
			else
			{
				options[4] = "No";
			}
		}
		else if(arg0.getSource() == buttonResetP)
		{
			result = JOptionPane.showConfirmDialog(this, "Do you wish to delete array list?","Delete Dialog", 1);
			if(result == 0) 
			{
				test.dataSetAcc.resetData();
			}
			else
			{
				System.out.println("the user cancelled the operation"); 
			}
		}
		else if(arg0.getSource() == buttonCheckRel)
		{
			reliability = test.CheckRel();
			JOptionPane.showMessageDialog(this, " Reliability of algorithm = " + reliability + " %");
		}
	}
}
