package project.db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import project.models.User;

public class UsersDb {

	public ArrayList<User> users = new ArrayList<>();
	
	public UsersDb() {
		loadUsers();
	}
	
	public void loadUsers(){
		users = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		String file = "../projeto-reaquecimento/src/project/db/UsersDb";
		String[] lineContent;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file));
			while ((sCurrentLine = br.readLine()) != null) {
				lineContent = sCurrentLine.split(",");
				users.add(new User(lineContent[0], lineContent[1]));
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
	
	public boolean validateUser(User user){
		return users.stream().filter(u -> u.getUserCode().equals(user.getUserCode())).findFirst().isPresent();
	}
	
}
