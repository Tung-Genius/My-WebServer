package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ControView extends JFrame implements ActionListener{

	public void hello() {
		System.out.println("test branch");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
