package project.forms;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import project.models.Customer;
import project.models.User;
import project.db.CustomersDb;
import project.db.LineDb;
import project.forms.InfoDisplay;

import javax.swing.JButton;
import javax.swing.JTextField;

public class HomeMenu {

	public JFrame frmHomeMenu;
	private LineDb lineDb;
	private int userNumber;
	private User currentUser;
	private int boxNumber;
	private Customer currCustomer;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtCpf;

	/**
	 * Create the application.
	 */
	public HomeMenu(int boxNumber, User currentUser) {
		this.boxNumber = boxNumber;
		this.currentUser = currentUser;
		lineDb = new LineDb();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomeMenu = new JFrame();
		frmHomeMenu.setResizable(false);
		frmHomeMenu.setTitle("Home - " + currentUser.getName() + " - " + "Box: " + boxNumber);
		frmHomeMenu.setBounds(100, 100, 233, 367);
		frmHomeMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomeMenu.getContentPane().setLayout(null);

		JLabel lblOptions = new JLabel("O que você deseja fazer?");
		lblOptions.setBounds(23, 27, 202, 15);
		frmHomeMenu.getContentPane().add(lblOptions);

		JButton btnCreateCustomer = new JButton("Cadastrar Cliente");
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
		
		JLabel lblCustomerInfo = new JLabel("Atendendo o cliente:");
		lblCustomerInfo.setBounds(23, 217, 191, 15);
		frmHomeMenu.getContentPane().add(lblCustomerInfo);
		
		JLabel lblName = new JLabel("Nome:");
		lblName.setBounds(23, 262, 70, 15);
		frmHomeMenu.getContentPane().add(lblName);
		
		JLabel lblAge = new JLabel("Idade:");
		lblAge.setBounds(23, 289, 70, 15);
		frmHomeMenu.getContentPane().add(lblAge);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(23, 316, 70, 15);
		frmHomeMenu.getContentPane().add(lblCpf);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setBounds(100, 260, 114, 19);
		frmHomeMenu.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setEditable(false);
		txtAge.setBounds(100, 287, 114, 19);
		frmHomeMenu.getContentPane().add(txtAge);
		txtAge.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setEditable(false);
		txtCpf.setBounds(100, 314, 114, 19);
		frmHomeMenu.getContentPane().add(txtCpf);
		txtCpf.setColumns(10);

		btnRegisteredCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayRegisteredCustomers();
			}
		});

		btnCustomersOnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayCustomersInLine();
			}
		});
		
		btnNextCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callNextCustomer();
			}
		});
		
		btnCreateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerCustomer();
			}
		});
	}

	private void displayRegisteredCustomers() {
		CustomersDb customersDb = new CustomersDb();

		InfoDisplay display = new InfoDisplay(customersDb.getFullCustomers(), "Clientes Registrados");
		display.frmInfoDisplay.setVisible(true);
	}

	private void displayCustomersInLine() {
		InfoDisplay display = new InfoDisplay(lineDb.getFullCustomers(), "Clientes na Fila");
		display.frmInfoDisplay.setVisible(true);
	}
	
	private void callNextCustomer(){
		if(lineDb.getLineSize() > 0){
			currCustomer = lineDb.getNextCustomer(boxNumber);
			txtName.setText(currCustomer.getName());
			txtAge.setText(currCustomer.getAge() + "");
			txtCpf.setText(currCustomer.getCpf());
		}
		else {
			JOptionPane.showMessageDialog(null, "Nenhum cliente na fila!", "Erro", JOptionPane.WARNING_MESSAGE);
			currCustomer = null;
			txtName.setText("");
			txtAge.setText("");
			txtCpf.setText("");
		}
	}
	
	public void registerCustomer(){
		if(currCustomer != null){
			CustomersDb customersDb = new CustomersDb();
			if(customersDb.registerCustomer(currCustomer)){
				JOptionPane.showMessageDialog(null, "Cliente registrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Falha ao cadastrar cliente.", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar cliente.", "Erro", JOptionPane.WARNING_MESSAGE);
		}
	}
}
