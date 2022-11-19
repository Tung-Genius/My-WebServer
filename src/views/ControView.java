package views;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import io.ReadFile;

public class ControView extends JFrame implements ActionListener{
	JPanel panel = new JPanel();
	JButton btnStart, btnStop, btnPost, btnFileHt, btnAdmin;
	JFileChooser chooser;
	public ControView(String title) throws HeadlessException {
		super(title);
		
		btnStart = new JButton("Start");
		btnStop = new JButton("Stop");
		btnPost = new JButton("Post");
		btnFileHt = new JButton("File hệ thống");
		btnAdmin = new JButton("Admin");
		
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);
		btnPost.addActionListener(this);
		btnFileHt.addActionListener(this);
		btnAdmin.addActionListener(this);
		
		panel.add(btnStart);
		panel.add(btnAdmin);
		panel.add(btnStop);
		panel.add(btnPost);
		panel.add(btnFileHt);
		
		this.add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.pack();
		this.setSize(600, 400);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Stop")) {
			
		}
		if(e.getActionCommand().equals("Start")) {
			
		}
		if(e.getActionCommand().equals("Admin")) {
			String content;
			try {
				content = ReadFile.readFile("./log.txt");
				ReadFileView rfw = new ReadFileView(content);
				rfw.setVisible(true);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getActionCommand().equals("File hệ thống")) {
			File file = new File(".");
			chooser = new JFileChooser();
//			chooser.setCurrentDirectory(new java.io.File("."));
			chooser.setCurrentDirectory(file);
			chooser.setDialogTitle("Chon file");
			chooser.showOpenDialog(this);
		}
		if(e.getActionCommand().equals("Post")) {
			try {
				String content = ReadFile.readFile("./config.properties");
				ReadFileView rfw = new ReadFileView(content);
				rfw.setVisible(true);
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
