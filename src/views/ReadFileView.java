package views;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import io.ReadFile;

public class ReadFileView extends JFrame implements ActionListener {
//	Container cont;
	JPanel panel;
	JTextArea ta;
	JButton btnSave;
	
	public ReadFileView(String content) throws HeadlessException, IOException {
		
		super();
//		cont = this.getContentPane();
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		
		ta = new JTextArea(content,10,20);
//		ta.setFont(new Font("Monospaced", Font.PLAIN, 14));
		ta.setBounds(10, 30, 300, 300);
//		ta.append(content);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(ta);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(this);
		
		panel.add(scrollPane, BorderLayout.CENTER);
//		panel.add(scrollPane);
		panel.add(btnSave, BorderLayout.SOUTH);
		
		this.add(panel);
		
		this.setSize(500, 500);
		this.setLocation(500, 200);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Save")) {
			String content = ta.getText();
			if(content.contains("post =")) {
				try {
					ReadFile.saveFile(content, "./config.properties");
					System.exit(0);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
//				this.setVisible(false);
			}
			else {
				this.setVisible(false);
			}
		}
	}
}
