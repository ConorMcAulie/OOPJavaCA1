/****************************************
 * My Screen	: This class is to be the screen and contains the 
 * 				: link between all used classes
 * Author		: Conor McAuley
 * Date Start 	: 06/04/2019
 * Date	End		: 14/04/2019
****************************************/
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
	
	// All attributes of the frame/GUI
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
		
		// Top, Middle, and Bottom panels
		JPanel PanelT = new JPanel();
		JPanel PanelM = new JPanel();
		JPanel PanelB = new JPanel();

		setLocation(100,100);
		setSize(450,200);
		
		// All the Labels incl. title and symptom labels
		labelTitle = new JLabel("Naive Bayes Probability of Tonsillitis");
		labelTrait1 = new JLabel(" Temperature : ");
		labelTrait2 = new JLabel(" Aches : ");
		labelTrait3 = new JLabel(" Sore Throat : ");

		// Symptom combo boxes
	    trait1 = new JComboBox<String>(choices);
		trait2 = new JComboBox<String>(choices2);
		trait3 = new JComboBox<String>(choices2);
		
		// Buttons (3 of which don't work)
		buttonCheckP = new JButton("Submit Symptoms");
		buttonAddP = new JButton("Add instance of patient");
		buttonResetP = new JButton("Reset Data Training Set");
		buttonCheckRel = new JButton("Check Reliability");
		
		// Panel Layout
		// Top Panel (Reserved for title)
		PanelT.add(labelTitle);
		add(PanelT, BorderLayout.NORTH);

		// Middle Panel (Reserved for symptoms)
		PanelM.add(labelTrait1, BorderLayout.NORTH);
		PanelM.add(trait1, BorderLayout.NORTH);
		PanelM.add(labelTrait2, BorderLayout.CENTER);
		PanelM.add(trait2, BorderLayout.CENTER);
		PanelM.add(labelTrait3, BorderLayout.SOUTH);
		PanelM.add(trait3, BorderLayout.SOUTH);
		add(PanelM, BorderLayout.CENTER);

		// Bottom Panel (Reserved for buttons -UD- one button)
		PanelB.add(buttonCheckP);
		//PanelB.add(buttonAddP);
		//PanelB.add(buttonResetP);
		//PanelB.add(buttonCheckRel);
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
			// Getting combo box feedback and checking it with algorithm
			String[] options = new String[3];
			options[0] = (String) trait1.getSelectedItem();
			options[1] = (String) trait2.getSelectedItem();
			options[2] = (String) trait3.getSelectedItem();
			
			float answerYes = test.Algorithm(options);
			System.out.println(answerYes);
				
			JOptionPane.showMessageDialog(this, " Probability of Having Tonsilitis : " + answerYes + " %");
		}
		else if(arg0.getSource() == buttonAddP)
		{
			// Getting combo box feedback to add patient
			
			/*				-UD-
			had to remove as was overriding existing data
			*/
			String[] options = new String[4];
			options[0] = (String) trait1.getSelectedItem();
			options[1] = (String) trait2.getSelectedItem();
			options[2] = (String) trait3.getSelectedItem();
			float answerYes = test.Algorithm(options);
			// To add if patient has tonsilitis
			if(answerYes >= 50)
			{
				options[3] = "Yes";
			}
			else
			{
				options[3] = "No";
			}
			Patient tempPat = new Patient(options);
			test.dataSetAcc.addPatientToData(tempPat);
			
		}
		else if(arg0.getSource() == buttonResetP)
		{
			// Give confirmation dialog option if wanting to reset data
			
			/*				-UD-
			had to remove as was removing existing data
			*/
			result = JOptionPane.showConfirmDialog(this, "Do you wish to Reset Data?","Delete Dialog", 1);
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
			// Check reliability
			
			/*				-UD-
			had to remove as was crashing program with a infinite loop 
			reason not known
			*/
			reliability = test.CheckRel();
			JOptionPane.showMessageDialog(this, " Reliability of algorithm = " + reliability + " %");
		}
	}
}
