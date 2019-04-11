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

	String labelText;
	int result = 0;
	String[] choices = { "Hot", "Normal", "Cool"};
	String[] choices2 = { "Yes", "No"};
	
	private JButton buttonCheckP;
	private JButton buttonResetP;
	private JButton buttonFileChooserP;
	private JLabel labelTitle;
	private JLabel labelTrait1;
	private JLabel labelTrait2;
	private JLabel labelTrait3;
	private JComboBox<String> trait1 = new JComboBox<String>();
	private JComboBox<String> trait2 = new JComboBox<String>();
	private JComboBox<String> trait3 = new JComboBox<String>();
	private JFileChooser fileAdd;
	
	public MyScreen() 
	{
		super("Tonsillitis");
		setLayout(new BorderLayout());
		
		JPanel PanelT = new JPanel();
		JPanel PanelM = new JPanel(new GridLayout(3,2,1,1));
		JPanel PanelB = new JPanel();
		
		add(PanelT, BorderLayout.NORTH);
		add(PanelM, BorderLayout.CENTER);
		add(PanelB, BorderLayout.SOUTH);

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
		buttonResetP = new JButton("Reset Data Training Set");
		buttonFileChooserP = new JButton("Add file of patients");
		
		PanelT.add(labelTitle);
		
		PanelM.add(labelTrait1);
		PanelM.add(trait1);
		PanelM.add(labelTrait2);
		PanelM.add(trait2);
		PanelM.add(labelTrait3);
		PanelM.add(trait3);
		
		PanelB.add(buttonCheckP);
		PanelB.add(buttonResetP);
		PanelB.add(buttonFileChooserP);

		fileAdd = new JFileChooser();

		buttonCheckP.addActionListener(this);
		buttonResetP.addActionListener(this);
		buttonFileChooserP.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == buttonCheckP) 
		{
			
			JOptionPane.showMessageDialog(this, "Don't know yet");
		}
		else if(arg0.getSource() == buttonFileChooserP)
		{
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
            int r = j.showOpenDialog(null); 

            FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", ".csv");
            fileAdd.setFileFilter(filter);
            
            if (r == JFileChooser.APPROVE_OPTION) 
            { 
            	System.out.println(j.getSelectedFile().getAbsolutePath()); 
            } 
            else 
            {
            	System.out.println("the user cancelled the operation"); 
            }
		}
		else if(arg0.getSource() == buttonResetP)
		{
			result = JOptionPane.showConfirmDialog(this, "Do you wish to delete array list?","Delete Dialog", 1);
		}
	}
}
