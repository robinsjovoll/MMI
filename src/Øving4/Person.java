package Øving4;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {
	
	public final static String NAME_PROPERTY = "name";
	public final static String DATEOFBIRTH_PROPERTY = "dateOfBirth";
	public final static String GENDER_PROPERTY = "gender";
	public final static String EMAIL_PROPERTY = "email";
	public final static String HEIGHT_PROPERTY = "height";
	
	private PropertyChangeSupport pcs;
	private String name;
	private String dateOfBirth;
	private Gender gender;
	private String email;
	private int height;
	
	
	
	
	public Person(String name){
		pcs = new PropertyChangeSupport(this);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldname = this.name;
		this.name = name;
		pcs.firePropertyChange(NAME_PROPERTY, oldname, name);
		
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener){
		pcs.removePropertyChangeListener(listener);
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		String olddate = this.dateOfBirth;
		this.dateOfBirth = dateOfBirth;
		pcs.firePropertyChange(DATEOFBIRTH_PROPERTY, olddate, dateOfBirth);
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		Gender oldgender = this.gender;
		this.gender = gender;
		pcs.firePropertyChange(GENDER_PROPERTY, oldgender, gender);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		String oldemail = this.email;
		this.email = email;
		pcs.firePropertyChange(EMAIL_PROPERTY, oldemail, email);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		int oldheight = this.height;
		this.height = height;
		pcs.firePropertyChange(HEIGHT_PROPERTY, oldheight, height);
	}

	
	public enum Gender {
		male, female;
	}
	
}
