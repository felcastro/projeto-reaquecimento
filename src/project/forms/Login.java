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
	private JLabel lblBoxNumber;
	private JTextField txtBoxNumber;

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
		lblUsername.setBounds(50, 42, 80, 15);
		frmLogin.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(149, 40, 200, 19);
		frmLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setBounds(50, 94, 80, 15);
		frmLogin.getContentPane().add(lblNewLabel);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(254, 168, 95, 25);
		frmLogin.getContentPane().add(btnLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(149, 94, 200, 15);
		frmLogin.getContentPane().add(txtPassword);
		
		lblBoxNumber = new JLabel("Box No:");
		lblBoxNumber.setBounds(60, 173, 70, 15);
		frmLogin.getContentPane().add(lblBoxNumber);
		
		txtBoxNumber = new JTextField();
		txtBoxNumber.setBounds(149, 171, 70, 19);
		frmLogin.getContentPane().add(txtBoxNumber);
		txtBoxNumber.setColumns(10);
		
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
		txtBoxNumber.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			  {
				  login();
			  }
		});
	}
	
	private void login(){
		User user = new User(txtUsername.getText(), txtPassword.getText());
		  if(usersDb.validateUser(user)){
			  if(!txtBoxNumber.getText().equals("")){
				  frmLogin.setVisible(false);
				  HomeMenu menu = new HomeMenu(Integer.parseInt(txtBoxNumber.getText()), user);
				  menu.frmHomeMenu.setVisible(true);
			  }
			  else {
				  JOptionPane.showMessageDialog(null, "Insira o numero do caixa.", "Erro", JOptionPane.WARNING_MESSAGE);
			  }
		  }
		  else {
			  JOptionPane.showMessageDialog(null, "Nome de usuario ou senha incorreto.", "Erro", JOptionPane.WARNING_MESSAGE);
		  }
	}
}
