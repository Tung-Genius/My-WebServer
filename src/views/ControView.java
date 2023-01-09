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
import webserver.ClientManager;

public class ControView extends JFrame implements ActionListener{
	private JPanel panel = new JPanel();
	private JButton btnStop, btnPost, btnFileHt, btnAdmin;
	private JFileChooser chooser;
	public ControView(String title) throws HeadlessException {
		super(title);
		
		btnStop = new JButton("Stop");
		btnPost = new JButton("Post");
		btnFileHt = new JButton("File hệ thống");
		btnAdmin = new JButton("Admin");
		
		btnStop.addActionListener(this);
		btnPost.addActionListener(this);
		btnFileHt.addActionListener(this);
		btnAdmin.addActionListener(this);
		
		panel.add(btnAdmin);
		panel.add(btnStop);
		panel.add(btnPost);
		panel.add(btnFileHt);
		
		this.add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Stop")) {
			System.exit(0);
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
			if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				String fileName = chooser.getSelectedFile().getAbsolutePath();
				String content;
				try {
					content = ReadFile.readFile(fileName);
					ReadFileView rfw = new ReadFileView(content);
					rfw.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
//			chooser.showOpenDialog(this);
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
