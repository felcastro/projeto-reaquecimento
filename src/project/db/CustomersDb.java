package project.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import project.models.Customer;

public class CustomersDb {

public ArrayList<Customer> customers = new ArrayList<>();
	
	public final String file = "../projeto-reaquecimento/src/project/db/CustomersDb";

	public CustomersDb() {
		loadCustomers();
	}
	
	public void loadCustomers(){
		customers = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		String[] lineContent;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file));
			while ((sCurrentLine = br.readLine()) != null) {
				lineContent = sCurrentLine.split(",");
				customers.add(new Customer(lineContent[0], Integer.parseInt(lineContent[1]), lineContent[2], lineContent[3]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public String getFullCustomers(){
		String customersToString = "";
		for(Customer customer: customers){
			customersToString += customer.toString() + "\n";
		}
		return customersToString;
	}
	
	public boolean registerCustomer(Customer customer){
		if(customers.stream().anyMatch(c -> c.cpf == customer.cpf)){
			return false;
		}
		try {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(customer.toStringDb());
		writer.close();
		return true;
		} catch (IOException e) {return false;}
	}
	
}
