package project.forms;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import project.models.Customer;
import project.db.CustomersDb;
import project.db.LineDb;
import project.forms.InfoDisplay;

import javax.swing.JButton;
import javax.swing.JTextField;

public class HomeMenu {

	public JFrame frmHomeMenu;
	private JTextField txtAtendant;
	private LineDb lineDb;

	/**
	 * Create the application.
	 */
	public HomeMenu() {
		lineDb = new LineDb();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomeMenu = new JFrame();
		frmHomeMenu.setResizable(false);
		frmHomeMenu.setTitle("Home");
		frmHomeMenu.setBounds(100, 100, 233, 367);
		frmHomeMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomeMenu.getContentPane().setLayout(null);
		
		JLabel lblOptions = new JLabel("O que você deseja fazer?");
		lblOptions.setBounds(23, 27, 202, 15);
		frmHomeMenu.getContentPane().add(lblOptions);
		
		JButton btnCreateCustomer = new JButton("Cadastrar cliente");
		btnCreateCustomer.setBounds(12, 69, 202, 25);
		frmHomeMenu.getContentPane().add(btnCreateCustomer);
		
		JButton btnNextCustomer = new JButton("Proximo Cliente");
		btnNextCustomer.setBounds(12, 106, 202, 25);
		frmHomeMenu.getContentPane().add(btnNextCustomer);
		
		JButton btnRegisteredCustomers = new JButton("Clientes Cadastrados");
		btnRegisteredCustomers.setBounds(12, 143, 202, 25);
		frmHomeMenu.getContentPane().add(btnRegisteredCustomers);
		
		JButton btnCustomersOnLine = new JButton("Clientes na fila");
		btnCustomersOnLine.setBounds(12, 180, 202, 25);
		frmHomeMenu.getContentPane().add(btnCustomersOnLine);
		
		JLabel lblAtendant = new JLabel("Caixa:");
		lblAtendant.setBounds(23, 254, 49, 15);
		frmHomeMenu.getContentPane().add(lblAtendant);
		
		txtAtendant = new JTextField();
		txtAtendant.setBounds(100, 252, 114, 19);
		frmHomeMenu.getContentPane().add(txtAtendant);
		txtAtendant.setColumns(10);
		
		btnRegisteredCustomers.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  displayRegisteredCustomers();
		  }
		});
		
		btnCustomersOnLine.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  displayCustomersInLine();
		  }
		});
	}
	
	private void displayRegisteredCustomers(){
		CustomersDb customersDb = new CustomersDb();

		InfoDisplay display = new InfoDisplay(customersDb.getFullCustomers(), "Clientes Registrados");
		display.frmInfoDisplay.setVisible(true);
	}
	
	private void displayCustomersInLine(){
		InfoDisplay display = new InfoDisplay(lineDb.getFullCustomers(), "Clientes na Fila");
		display.frmInfoDisplay.setVisible(true);
	}
}
