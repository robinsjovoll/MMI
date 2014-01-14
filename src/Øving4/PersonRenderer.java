package �ving4;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import �ving4.Person.Gender;

public class PersonRenderer extends JPanel implements ListCellRenderer<Person> {

	@Override
	public Component getListCellRendererComponent(JList list,
			Person person, int index, boolean selected, boolean cellfocus) {
		// TODO Auto-generated method stub
		
		String info = person.getName() + " : " + person.getEmail();
		JLabel label = new JLabel(info);
		label.setOpaque(true); //Gj�r det mulig � fargelegge alle pixlene i valgte omr�der vha label.
		
		
		if(selected) {
			label.setBackground(list.getSelectionBackground());
		}
		else {
			label.setForeground(list.getForeground());
			label.setBackground(list.getBackground());
		}
		
		//Forskjellig merking av cellene n�r de blir selected eller ikke.
		
		return label;
	}
	

}
