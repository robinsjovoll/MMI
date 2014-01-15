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

   protected static Person model;
   protected JPanel genderPanel;
   protected JPanel heightPanel;
   private static JTextField gender;
   private static JTextField heightField;
   
   protected JTextField NamePropertyComponent = new JTextField();
   protected JTextField DateOfBirthPropertyComponent = new JTextField();
   protected JTextField EmailPropertyComponent = new JTextField();
   protected JComboBox<?> GenderPropertyComponent = new JComboBox<Object>(Gender.values());
   protected JSlider HeightPropertyComponent = new JSlider(120, 220, 120);
   
   //Initialisering av alle fieldvariablene.
   
   public static Person getModel() {
      return model;
   }
   
   

   public void setModel(Person person) {
      this.model = person;
      NamePropertyComponent.setText(person.getName());
      DateOfBirthPropertyComponent.setText(person.getDateOfBirth());
      EmailPropertyComponent.setText(person.getEmail());
      GenderPropertyComponent.setSelectedItem(person.getGender());
      HeightPropertyComponent.setValue(person.getHeight());
      
   }
   
   public void propertyChange(PropertyChangeEvent evt) {
	   System.out.println("Før: " + NamePropertyComponent.getText());
       String PropertyName = evt.getPropertyName();
       switch(PropertyName){
       		case Person.NAME_PROPERTY:
       			NamePropertyComponent.setText(model.getName());
       			System.out.println("Etter: " + NamePropertyComponent.getText());
       			break;
       		case Person.DATEOFBIRTH_PROPERTY:
       			DateOfBirthPropertyComponent.setText(model.getDateOfBirth());
       			break;
       		case Person.GENDER_PROPERTY:
       			GenderPropertyComponent.setSelectedItem(model.getGender());
       			gender.setText(model.getGender().toString());
       			break;
       		case Person.EMAIL_PROPERTY:
       			EmailPropertyComponent.setText(model.getEmail());
       			break;
       		case Person.HEIGHT_PROPERTY:
       			HeightPropertyComponent.setValue(model.getHeight());
       			heightField.setText(Integer.toString(model.getHeight()));
       			break;
       		}   
       }
   
   public static JTextField getGender(){
	   return gender;
   }
   
   public static JTextField getHeightField(){
	   return heightField;
   }
   
   
   public PersonPanel() {
	  
	  heightField = new JTextField();
	  gender = new JTextField();
	  model = new Person("");
	  model.addPropertyChangeListener(this);
	   
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
  
      NamePropertyComponent.addKeyListener(new FieldListeners());
      DateOfBirthPropertyComponent.addKeyListener(new FieldListeners());
      EmailPropertyComponent.addKeyListener(new FieldListeners());
      GenderPropertyComponent.addActionListener(new GenderListener());
      HeightPropertyComponent.addChangeListener(new HightListener());
      
      //Adding av listeners til de forskjellige komponentene.
   
   }
   

   
   class FieldListeners implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(NamePropertyComponent.isFocusOwner()){
			model.setName(Textfield(NamePropertyComponent, e));	
		}else if(DateOfBirthPropertyComponent.isFocusOwner()){
			model.setDateOfBirth(Textfield(DateOfBirthPropertyComponent, e));
		}else if(EmailPropertyComponent.isFocusOwner()){
			model.setEmail(Textfield(EmailPropertyComponent,e));
		}
	}
	   
   }
   
   public String Textfield(JTextField field, KeyEvent e){
	   
	   char c = e.getKeyChar(); 
	   int caret = field.getCaretPosition(); //Får tak i posisjonen til hvor bokstaven skal bli skrevet.
	   String st = field.getText().substring(0, caret) + c + field.getText().substring(caret, field.getText().length()); //Setter bokstaven inn manuelt mellom
	   														//de to substringene som allerede var der.
	   return st;
   }
   //Fikser problemet med at KeyListener kjører før JTextField klarer å legge til bokstaven i tekstfeltet.
   
   
   
  
   
   class GenderListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		model.setGender((Gender)GenderPropertyComponent.getSelectedItem());   
	}
	   
   }
   
   class HightListener implements ChangeListener{

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		model.setHeight(HeightPropertyComponent.getValue());   
	}

	
	//Forskjellige listeners for å holde variablene til personinstansene oppdaterte.
	   
   }
   
   public static void main(String[] args) {
	      
		
     	PersonPanel panel1 = new PersonPanel();
     	PassivePersonPanel panel2 = new PassivePersonPanel();
     	JFrame frame1 = new JFrame("Øving 3 - PersonPanel");
     	JFrame frame2 = new JFrame("Øving 3 - PassivePersonPanel");
     	panel1.setModel(model);
     	panel2.setModel(model);
     	frame1.setContentPane(panel1);
     	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	frame1.pack();
     	frame1.setVisible(true);
     	frame2.setContentPane(panel2);
     	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	frame2.pack();
     	frame2.setVisible(true);
     
     
     
     
  }
   
}