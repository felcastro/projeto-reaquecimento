package project.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextArea;

public class InfoDisplay {

	public JFrame frmInfoDisplay;
    private String info;
    private String title;
	
	/**
	 * Create the application.
	 */
	public InfoDisplay(String info, String title) {
		this.info = info;
		this.title = title;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInfoDisplay = new JFrame();
		frmInfoDisplay.setResizable(false);
		frmInfoDisplay.setTitle(title);
		frmInfoDisplay.setBounds(100, 100, 388, 400);
		frmInfoDisplay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInfoDisplay.getContentPane().setLayout(null);
		
		JTextArea textAreaInfo = new JTextArea();
		textAreaInfo.setEditable(false);
		textAreaInfo.setBounds(12, 12, 364, 376);
		frmInfoDisplay.getContentPane().add(textAreaInfo);
		textAreaInfo.setText(info);
	}
}
