package Øving4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Øving4.Person.Gender;

public class PersonListPanel extends JPanel implements ListSelectionListener{
	private JList<Person> PersonList;
	private PersonPanel personpanel;
	private DefaultListModel<Person> model;
	private JButton addPerson;
	private JButton deletePerson;
	
	//Fields
	
	public PersonListPanel(){
		
		model = new DefaultListModel<Person>();
		PersonList = new JList<Person>();
		personpanel = new PersonPanel();
		
		//Initialiserer fields
		
		PersonList.setName("PersonList");
		personpanel.setName("PersonPanel");
		
		PersonList.setModel(model);
		PersonList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PersonList.addListSelectionListener(this);
		PersonList.setCellRenderer(new PersonRenderer()); //Hvordan cellene skal oppføre seg når de blir selected eller ikke.
		
		//Setter opp hvordan listen skal oppføre seg med dens funksjoner.
		
		setLayout(new BorderLayout());
		add(personpanel,BorderLayout.WEST);
		add(PersonList, BorderLayout.EAST);	
		
		//Setter opp layout for å fordele komponentene.
		
		JScrollPane myJScrollpane = new JScrollPane(PersonList);
		myJScrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(myJScrollpane);
		
		//Lager scrollfunksjon til listen.
		
		JPanel deleteaddPanel = new JPanel();
		
		addPerson = new JButton("Add person");
		addPerson.setName("NewPersonButton");
		addPerson.addActionListener(new addPersonListener());
		
		deletePerson = new JButton("Delete person");
		deletePerson.setName("DeletePersonButton");
		deletePerson.addActionListener(new deletePersonListener());
		
		deleteaddPanel.add(addPerson);
		deleteaddPanel.add(deletePerson);
		add(deleteaddPanel, BorderLayout.SOUTH);
		
		//Lager add og delete funksjoner i et eget panel som deretter blir lagt til nederst i vinduet.
	}
	
	public class deletePersonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			deletePerson();
			
		}
		
	}
	
	public class addPersonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addPerson();
		}
		
	}
	
	public void deletePerson(){
		if(PersonList.getSelectedValue() != null){
			model.remove(PersonList.getSelectedIndex());
		}
	}
	
	//Delete person funksjonalitet
	
	public void addPerson(){
		Person person = new Person("");
		model.addElement(person);
		PersonList.setSelectedValue(person, true);
	}
	
	//Add person funksjonalitet
	
	public void setModel(DefaultListModel<Person> defaultmodel){
		this.model = defaultmodel;
		PersonList.setModel(model);
		
	}
	
	public DefaultListModel getModel(){
		return this.model;
	}
	
	public static void main(String[] args){
		
		Person p1 = new Person("Robin Sjøvoll");
		p1.setEmail("robinss@stud.ntnu.no");
		Person p2 = new Person("Anders Lunde");
		p2.setEmail("anderlu@stud.ntnu.no");
		Person p3 = new Person("Kristian Huse");
		p3.setEmail("kristhu@stud.ntnu.no");
	
		
		
		PersonListPanel paneltest = new PersonListPanel();
		DefaultListModel model = paneltest.getModel();
		model.addElement(p1);
		model.addElement(p2);
		model.addElement(p3);
		paneltest.setModel(model);
		
		JFrame frame = new JFrame("Øving 4");
		frame.add(paneltest);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		if(PersonList.getSelectedValue() != null) {
			personpanel.setModel(PersonList.getSelectedValue());
		}
		else {
			personpanel.setModel(new Person(""));
		}
	}
	
	// Sammenhengen mellom listen og PersonPanel. 
}
