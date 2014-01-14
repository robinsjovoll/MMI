package Øving1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ButtonsNText extends JPanel {
	private JTextField TextLine;
	private JToggleButton UpperCaseButton;
	private JToggleButton LowerCaseButton;
	private JCheckBox ContinuousButton;
	private ButtonGroup Groupofbuttons;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Øving 1");
		frame.add(new ButtonsNText());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	//Initialiserer frame

	public ButtonsNText() {
		TextLine = new JTextField(20);
		Font font = new Font("Monospaced", Font.PLAIN,14);
		TextLine.setFont(font);
		add(TextLine);
		this.setBackground(Color.PINK);
		this.setForeground(Color.PINK);
		//Endrer font og farge.
		
		Groupofbuttons = new ButtonGroup();

		UpperCaseButton = new JToggleButton("Upper case");
		LowerCaseButton = new JToggleButton("Lower case");
		ContinuousButton = new JCheckBox("Continuous?");

		UpperCaseButton.setName("UpperCaseButton");
		LowerCaseButton.setName("LowerCaseButton");
		TextLine.setName("TextLine");
		ContinuousButton.setName("ContinuousButton");

		Groupofbuttons.add(UpperCaseButton);
		Groupofbuttons.add(LowerCaseButton);

		UpperCaseButton.addActionListener(new ButtontoUpperCase());
		LowerCaseButton.addActionListener(new ButtontoLowerCase());
		TextLine.addKeyListener(new ActionEnterListener());
		TextLine.addKeyListener(new TextLineActioner());
		
		//Legger til actionlisteners og keylisteners for funksjonalitet.
		
		add(UpperCaseButton);
		add(LowerCaseButton);
		add(ContinuousButton);

	}

	private void toUppercase() {
		TextLine.setText(TextLine.getText().toUpperCase());
	}
	
	//Gjør teksten i textline til uppercase.
	
	
	private void toLowercase() {
		TextLine.setText(TextLine.getText().toLowerCase());
	}
	
	//Gjør teksten i textline til lowercase.

	class ActionEnterListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(TextLine.isEnabled() && e.getKeyCode() == KeyEvent.VK_ENTER && UpperCaseButton.isSelected()){
				toUppercase();
			}
			else if(TextLine.isEnabled() && e.getKeyCode() == KeyEvent.VK_ENTER && LowerCaseButton.isSelected()){
				toLowercase();
			}
		}
		
		//Keylistener som for ENTER-funksjonalitet. Kan også bruke actionlistener.

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		
	}

	class ButtontoUpperCase implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			toUppercase();
		}
	}
	
	//Actionlistener til når man trykker på UpperCaseButton.

	class ButtontoLowerCase implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			toLowercase();
		}
	}
	
	//Actionlistener til når man trykker på LowerCaseButton.
	
	class TextLineActioner implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			keyTyped(e);

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			if (Character.isLetter(e.getKeyChar())
					&& ContinuousButton.isSelected()) {
				if (LowerCaseButton.isSelected()){
				e.setKeyChar(Character.toLowerCase(e.getKeyChar()));
				}
				if (UpperCaseButton.isSelected()){
				e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
				}
			}
		}
		
		//For bruk av continuousbutton.

	}
	
		
	}


