package Øving3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Øving3.Person.Gender;

public class PassivePersonPanel extends PersonPanel {
	
	private static JTextField gender;
	private static JTextField heightField;
	private static Person model = PersonPanel.getModel();
	 
	public PassivePersonPanel(){
		super();
		gender = PersonPanel.getGender();
        heightField = PersonPanel.getHeightField();
        
        gender.setText("male");
        
        NamePropertyComponent.setEditable(false);
        NamePropertyComponent.setFocusable(false);
        DateOfBirthPropertyComponent.setEditable(false);
        DateOfBirthPropertyComponent.setFocusable(false);
        EmailPropertyComponent.setEditable(false);
        EmailPropertyComponent.setFocusable(false);
        gender.setEditable(false);
        heightField.setEditable(false);
        
        this.remove(genderPanel);
        this.remove(heightPanel);
        
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setPreferredSize(new Dimension(75,15));
        
        
        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setPreferredSize(new Dimension(75,15));
        
        JPanel genderComp = new JPanel();
        genderComp.add(genderLabel);
        genderComp.add(gender);
        gender.setPreferredSize(new Dimension(270,20));
        
        JPanel heightComp = new JPanel();
        heightComp.add(heightLabel);
        heightComp.add(heightField);
        heightField.setPreferredSize(new Dimension(270,20));
        
        
        add(genderComp);
        add(heightComp);
        
        
        
	}
	
	
	

}
