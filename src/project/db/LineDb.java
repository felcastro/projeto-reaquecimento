package project.db;

import java.util.ArrayList;

import project.models.Customer;

public class LineDb {
	public ArrayList<Customer> lineCustomers;

	public LineDb() {
		lineCustomers = new ArrayList<>();
		initializeLine();
	}

	private void initializeLine() {
		lineCustomers.add(new Customer("12312312312", 40, "Joao", "Silva"));
		lineCustomers.add(new Customer("23423423423", 71, "Pedro", "Augusto"));
		lineCustomers.add(new Customer("34534534534", 32, "Luisa", "Klever"));
		lineCustomers.add(new Customer("45645645645", 24, "Amanda", "Gomes"));
		lineCustomers.add(new Customer("56756756756", 45, "Paulo", "Terreira"));
		lineCustomers.add(new Customer("67867867867", 61, "Henrique", "Oliveira"));
		lineCustomers.add(new Customer("78978978978", 19, "Laura", "Ferraz"));
		lineCustomers.add(new Customer("89089089089", 33, "Jhonas", "Domingues"));
		lineCustomers.add(new Customer("90190190190", 55, "Jack", "Sparrow"));
		lineCustomers.add(new Customer("12012012012", 42, "Fernanda", "Montenegro"));
		lineCustomers.add(new Customer("02102102102", 74, "Ana", "Marques"));
		lineCustomers.add(new Customer("23498723498", 29, "Joaquim", "Rodrigues"));
		lineCustomers.add(new Customer("87612212379", 57, "Mauricio", "Mendes"));
		lineCustomers.add(new Customer("12474512365", 69, "Marcelo", "Santana"));
		lineCustomers.add(new Customer("12354523236", 49, "Pietra", "Alves"));
	}

	public Customer getNext() {
		return lineCustomers.remove(0);	
	}

	public Customer getNextElder(){
		Customer elder = lineCustomers.stream().filter(c -> c.age >= 60).findFirst().orElse(null);
		if(elder != null){
			lineCustomers.remove(elder);
		}
		return elder;
	}
	
	public String getFullCustomers(){
		String customersToString = "";
		for(Customer customer: lineCustomers){
			customersToString += customer.toString() + "\n";
		}
		return customersToString;
	}
}