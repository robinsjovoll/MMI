package Øving3;
import javax.swing.JFrame;



public class PersonPanelInitializer {
	
	public static void main(String[] args) {
	      
			Person model = new Person("");
	      	PersonPanel panel1 = new PersonPanel();
	      	PassivePersonPanel panel2 = new PassivePersonPanel();
	      	JFrame frame1 = new JFrame("Øving 3 - PersonPanel");
	      	JFrame frame2 = new JFrame("Øving 3 - PassivePersonPanel");
	      	panel1.setModel(model);
	      	panel2.setModel(model);
	      	frame1.add(panel1);
	      	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      	frame1.pack();
	      	frame1.setVisible(true);
	      	frame2.add(panel2);
	      	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      	frame2.pack();
	      	frame2.setVisible(true);
	      
	      
	      
	      
	   }
}
