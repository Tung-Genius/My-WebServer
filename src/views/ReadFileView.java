package views;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import io.ReadFile;

public class ReadFileView extends JFrame implements ActionListener {
	Container cont;
	JTextArea ta;
	JButton btnSave;
//	String content;
	
	public ReadFileView(String content) throws HeadlessException, IOException {
		
		super();
		
		cont = this.getContentPane();
		
		ta = new JTextArea();
		ta.append(content);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(this);
		
		cont.add(ta);
		cont.add(btnSave, "South");
		
		this.setSize(400, 500);
//		this.setVisible(true);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Save")) {
			String content = ta.getText();
			try {
				ReadFile.saveFile(content, "./config.properties");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			this.setVisible(false);
		}
	}
}
