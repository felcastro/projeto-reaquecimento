package project.models;

public class Customer {
	public String cpf;
	public int age;
	public String firstName;
	public String lastName;
	
	public Customer(String cpf, int age, String firstName, String lastName){
		this.cpf = cpf;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getName(){
		return firstName + " " + lastName;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getCpf(){
		return cpf;
	}
	
	public String toString(){
		String str;
		str = firstName + " " + lastName + ", " + age + " anos." + " CPF: " + cpf;
		return str;
	}
}
