package project.forms;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.db.UsersDb;
import project.models.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Login{

	public JFrame frmLogin;
	private JTextField txtUsername;
	private UsersDb usersDb;
	private JPasswordField txtPassword;
	private JButton btnLogin;

	/**
	 * Create the application.
	 */
	public Login() {
		usersDb = new UsersDb();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 380, 251);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(50, 58, 80, 15);
		frmLogin.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(148, 56, 200, 19);
		frmLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setBounds(50, 104, 80, 15);
		frmLogin.getContentPane().add(lblNewLabel);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(231, 157, 117, 25);
		frmLogin.getContentPane().add(btnLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(148, 104, 200, 15);
		frmLogin.getContentPane().add(txtPassword);
		
		btnLogin.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e)
		  {
			  login();
		  }
		});
		txtUsername.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			  {
				  login();
			  }
		});
		txtPassword.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			  {
				  login();
			  }
		});
	}
	
	private void login(){
		User user = new User(txtUsername.getText(), txtPassword.getText());
		  if(usersDb.validateUser(user)){
			  frmLogin.setVisible(false);
			  HomeMenu menu = new HomeMenu();
			  menu.frmHomeMenu.setVisible(true);
		  }
		  else {
			  JOptionPane.showMessageDialog(null, "Nome de usuario ou senha incorreto.", "Erro", JOptionPane.WARNING_MESSAGE);
		  }
	}
}
