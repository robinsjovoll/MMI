package Øving3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Øving3.Person.Gender;

public class PersonPanel extends JPanel implements PropertyChangeListener {

   protected Person model = new Person("default");
   protected JPanel genderPanel;
   protected JPanel heightPanel;
   
   protected JTextField NamePropertyComponent = new JTextField();
   protected JTextField DateOfBirthPropertyComponent = new JTextField();
   protected JTextField EmailPropertyComponent = new JTextField();
   protected JComboBox<?> GenderPropertyComponent = new JComboBox<Object>(Gender.values());
   protected JSlider HeightPropertyComponent = new JSlider(120, 220, 120);
   
   //Initialisering av alle fieldvariablene.
   
   public Person getModel() {
      return model;
   }
   
   

   public void setModel(Person person) {
      this.model = person;
      NamePropertyComponent.setText(person.getName());
      DateOfBirthPropertyComponent.setText(person.getDateOfBirth());
      EmailPropertyComponent.setText(person.getEmail());
      GenderPropertyComponent.setSelectedItem(person.getGender());
      HeightPropertyComponent.setValue(person.getHeight());
      
      model.addPropertyChangeListener(this);
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
       			GenderPropertyComponent.setSelectedItem(model.getGender());
       			break;
       		case Person.EMAIL_PROPERTY:
       			EmailPropertyComponent.setText(model.getEmail());
       			break;
       		case Person.HEIGHT_PROPERTY:
       			HeightPropertyComponent.setValue(model.getHeight());
       			break;
       		}   
       }
   
   
   public PersonPanel() {
	   
	  NamePropertyComponent.setName("NamePropertyComponent");
	  DateOfBirthPropertyComponent.setName("DateOfBirthPropertyComponent");
	  EmailPropertyComponent.setName("EmailPropertyComponent");
	  GenderPropertyComponent.setName("GenderPropertyComponent");
	  HeightPropertyComponent.setName("HeightPropertyComponent");
      
      Dimension labelSize = new Dimension(75,15);
      Dimension textBoxSize = new Dimension(270,20);
      Dimension sliderSize = new Dimension(270,45);
      
      //Dimensjoner til de forskjellige komponentene.
      
      
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
      //For å sette komponentene nedover y-aksen.
      
      
      JPanel namePanel = new JPanel();
      JLabel nameLabel = new JLabel("Name:");
      nameLabel.setPreferredSize(labelSize);
      namePanel.add(nameLabel);
      namePanel.add(NamePropertyComponent);
      NamePropertyComponent.setPreferredSize(textBoxSize);
      
      add(namePanel);
      
      
      JPanel emailPanel = new JPanel();
      JLabel emailLabel = new JLabel("Email:");
      emailLabel.setPreferredSize(labelSize);
      emailPanel.add(emailLabel);
      emailPanel.add(EmailPropertyComponent);
      EmailPropertyComponent.setPreferredSize(textBoxSize);
      
      add(emailPanel);
      

      JPanel DateOfBirthPanel = new JPanel();
      JLabel DateOfBirthLabel = new JLabel("Birthday:");
      DateOfBirthLabel.setPreferredSize(labelSize);
      DateOfBirthPanel.add(DateOfBirthLabel);
      DateOfBirthPanel.add(DateOfBirthPropertyComponent);
      DateOfBirthPropertyComponent.setPreferredSize(textBoxSize);
      
      add(DateOfBirthPanel);
      
      genderPanel = new JPanel();
      genderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      JLabel genderLabel = new JLabel("Gender:");
      genderLabel.setPreferredSize(labelSize);
      genderPanel.add(genderLabel);
      genderPanel.add(GenderPropertyComponent);
      
      add(genderPanel);
      
      heightPanel = new JPanel();
      heightPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      JLabel heightLabel = new JLabel("Height:");
      heightLabel.setPreferredSize(labelSize);
      heightPanel.add(heightLabel);
      heightPanel.add(HeightPropertyComponent);
      HeightPropertyComponent.setMajorTickSpacing(10);
      HeightPropertyComponent.setMinorTickSpacing(5);
      HeightPropertyComponent.setPaintTicks(true);
      HeightPropertyComponent.setPaintLabels(true);
      HeightPropertyComponent.setPreferredSize(sliderSize);
      
      add(heightPanel);
  
      NamePropertyComponent.addKeyListener(new NameListener());
      DateOfBirthPropertyComponent.addKeyListener(new DateOfBirthListener());
      EmailPropertyComponent.addKeyListener(new EmailListener());
      GenderPropertyComponent.addActionListener(new GenderListener());
      HeightPropertyComponent.addChangeListener(new HightListener());
      
      //Adding av listeners til de forskjellige komponentene.
   
   }
   
   class NameListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		model.setName(NamePropertyComponent.getText());
		System.out.println(model.getName());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	   
   }
   
   class DateOfBirthListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		model.setDateOfBirth(DateOfBirthPropertyComponent.getText());
        System.out.println(model.getDateOfBirth());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	   
   }
   
   class EmailListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		model.setEmail(EmailPropertyComponent.getText());
        System.out.println(model.getEmail());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	   
   }
   
   class GenderListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		model.setGender((Gender)GenderPropertyComponent.getSelectedItem());   
        System.out.println(model.getGender());
	}
	   
   }
   
   class HightListener implements ChangeListener{

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		model.setHeight(HeightPropertyComponent.getValue());   
        System.out.println(model.getHeight());
	}

	
	//Forskjellige listeners for å holde variablene til personinstansene oppdaterte.
	   
   }
   
   
}