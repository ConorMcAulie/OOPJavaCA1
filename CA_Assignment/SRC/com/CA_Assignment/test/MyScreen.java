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

@SuppressWarnings("unused")
public class MyScreen extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	String labelText;
	int result = 0;
	String[] choices = { "Hot", "Normal", "Cool"};
	String[] choices2 = { "Yes", "No"};
	
	private JButton buttonCheckP;
	private JButton buttonResetP;
	private JLabel labelTitle;
	private JLabel labelTrait1;
	private JLabel labelTrait2;
	private JLabel labelTrait3;
	private JComboBox<String> trait1 = new JComboBox<String>();
	private JComboBox<String> trait2 = new JComboBox<String>();
	private JComboBox<String> trait3 = new JComboBox<String>();
	private JTextArea textAreaShow;
	private JFileChooser fileAdd;
	
	public MyScreen() 
	{
		super("Tonsillitis");
		setLayout(new BorderLayout());
		
		JPanel PanelT = new JPanel();
		JPanel PanelM = new JPanel(new GridLayout(2,3,1,1));
		JPanel PanelB = new JPanel();
		
		add(PanelT, BorderLayout.NORTH);
		add(PanelM, BorderLayout.CENTER);
		add(PanelB, BorderLayout.SOUTH);

		setLocation(100,100);
		setSize(1200,800);
		
		labelTitle = new JLabel("Naive Bayes Probability of Tonsillitis");
		textAreaShow = new JTextArea("");
		textAreaShow.setPreferredSize(new Dimension(300,200));
		labelTrait1 = new JLabel(" Temperature : ");
		labelTrait2 = new JLabel(" Aches : ");
		labelTrait3 = new JLabel(" Sore Throat : ");

	    trait1 = new JComboBox<String>(choices);
		trait2 = new JComboBox<String>(choices2);
		trait3 = new JComboBox<String>(choices2);
		
		buttonCheckP = new JButton("Submit Symptoms");
		buttonResetP = new JButton("Reset Data Training Set");
		
		PanelT.add(labelTitle);
		PanelT.setPreferredSize(new Dimension(300,100));

		PanelM.add(labelTrait1);
		PanelM.add(trait1);
		PanelM.add(labelTrait2);
		PanelM.add(trait2);
		PanelM.add(labelTrait3);
		PanelM.add(trait3);
		
		PanelM.add(buttonCheckP);
		PanelM.add(buttonResetP);
		
		PanelB.add(textAreaShow);
		PanelB.setPreferredSize(new Dimension(300,300));

		fileAdd = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", ".csv");
	    fileAdd.setFileFilter(filter);
	    int returnVal = fileAdd.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) 
	    {
	    	System.out.println("You chose to add this file to data set : " + fileAdd.getSelectedFile().getName());
	    }
	    /*
	    
	     */

		buttonCheckP.addActionListener(this);
		buttonResetP.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == buttonCheckP) 
		{
			JOptionPane.showMessageDialog(this, "Don't know yet");
		}
		else if(arg0.getSource() == buttonResetP)
		{
			labelText = " Array List with all people elements \n";
			labelText = labelText + "\n";
			labelText = labelText + "\n";
			labelText = "";
			textAreaShow.setText(labelText);
		}
		else if(arg0.getSource() == buttonResetP)
		{
			result = JOptionPane.showConfirmDialog(this, "Do you wish to delete array list?","Delete Dialog", 1);
			labelText = "";
			textAreaShow.setText(labelText);
		}
	}
}
