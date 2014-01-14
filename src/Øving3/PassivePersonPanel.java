package Øving3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PassivePersonPanel extends PersonPanel {
	
	private JTextField gender;
	private JTextField height;
	 
	public PassivePersonPanel(){
		super();
		this.gender = new JTextField();
        this.height = new JTextField();
        
        
        NamePropertyComponent.setEditable(false);
        DateOfBirthPropertyComponent.setEditable(false);
        EmailPropertyComponent.setEditable(false);
        gender.setEditable(false);
        height.setEditable(false);
        
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
        heightComp.add(height);
        height.setPreferredSize(new Dimension(270,20));
        
        
        add(genderComp);
        add(heightComp);
        
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
	       String PropertyName = evt.getPropertyName();
	       switch(PropertyName){
	       		case Person.NAME_PROPERTY:
	       			NamePropertyComponent.setText(model.getName());
	       			break;
	       		case Person.DATEOFBIRTH_PROPERTY:
	       			DateOfBirthPropertyComponent.setText(model.getDateOfBirth());
	       			break;
	       		case Person.GENDER_PROPERTY:
	       			gender.setText(model.getGender().toString());
	       			break;
	       		case Person.EMAIL_PROPERTY:
	       			EmailPropertyComponent.setText(model.getEmail());
	       			break;
	       		case Person.HEIGHT_PROPERTY:
	       			height.setText(Integer.toString(model.getHeight()));
	       			break;
	       		}
	       
		   
	       }
}
