package codes;

 

import java.util.ArrayList;


 

public class BikerCommunityPortal {

 

 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Biker> bikerGroup = new ArrayList<Biker>();

 

		//list for overall system
		ArrayList<Biker> bikerList = new ArrayList<Biker>();
//		
		int option = 0;

 

		while (option != 5) {
			BikerCommunityPortal.menu();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				Biker createBiker = createBiker();
				bikerList.add(createBiker);
			}
			else if (option == 2) {
				Biker biker = createBiker();
				addBiker(bikerList, biker);
				System.out.println("Biker added");
			}
			else if (option == 3) {
				deleteBiker(bikerList);
			}
			else if (option == 4) {
				viewAllBiker(bikerList);
			}
			else if (option == 5) {
				System.out.println("Thank You for using Biking Community Portal!");
			}
		}
	}

 

 

	public static void menu() {
		BikerCommunityPortal.setHeader("Biker Community Portal");
		System.out.println("1. Create account");
		System.out.println("2. Add biker");
		System.out.println("3. Delete biker");
		System.out.println("4. View all biker");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

 

 

	// add biker 
	public static Biker createBiker() {

		String name = Helper.readString("Enter name > ");
		String date_of_birth = Helper.readString("Enter date of birth > ");
		String nationality = Helper.readString("Enter nationality > ");
		String email = Helper.readString("Enter email address > ");
		int mobilenumber = Helper.readInt("Enter mobile number > ");
		char gender = Helper.readChar("Enter gender (M/F) > ");
		int age = Helper.readInt("Enter age > ");
		String username = Helper.readString("Create a username > ");
		String password = Helper.readString("Create a password > ");
		int userType = Helper.readInt("Update user to admin by entering 2 >");

 

		Biker biker = new Biker(name, date_of_birth, nationality, email, mobilenumber, gender, age, username, password, userType);
		return biker;
	}

 

	public static void addBiker(ArrayList<Biker> bikerList, Biker b) {
		Biker item;
		for(int i = 0; i < bikerList.size(); i++) {
			item = bikerList.get(i);
			if (item.getName().equalsIgnoreCase(b.getName()) ) 
				return;
		}
		if ((b.getName().isEmpty()) || (b.getDate_of_birth().isEmpty()) ) {
			return;
		}
		bikerList.add(b);
		System.out.println(bikerList.get(0).getName());
	}

 

 

	// view all biker
	public static String retrieveAllBiker(ArrayList<Biker> bikerList) {
		String output = "";

 

		for (int i = 0; i < bikerList.size(); i++) {
			output += String.format("%-200s\n", bikerList.get(i).toString());
		}
		return output;
	}

 

 

	public static void viewAllBiker(ArrayList<Biker> bikerList) {
		BikerCommunityPortal.setHeader("Biker LIST");
		String output = String.format("%-10s %-30s %-10s %-20s %-20s %-10s %-10s %-10s %-20s %-10s\n", "NAME", "DATE OF BIRTH",
				"NATIONALITY", "EMAIL", "PHONE NUMBER", "GENDER", "AGE", "USERNAME", "PASSWORD", "USER TYPE");
		for (int i = 0; i < bikerList.size(); i++) {
			output += String.format("%-10s %-30s %-10s %-20s %-20d %-10c %-10d %-10s %-20s %-10d\n", bikerList.get(i).getName(), bikerList.get(i).getDate_of_birth(), 
			bikerList.get(i).getNationality(), bikerList.get(i).getEmail(), bikerList.get(i).getMobileNumber(), bikerList.get(i).getGender(), bikerList.get(i).getAge(), 
			bikerList.get(i).getUsername(), bikerList.get(i).getPassword(), bikerList.get(i).getUserType());
		}	
		System.out.println(output);
	}

 

 

	// delete biker
	public static void deleteBiker(ArrayList<Biker> bikerList) {
		boolean isfound = false;
		String input = Helper.readString("Input a user to be deleted");
		for(int i = 0; i < bikerList.size(); i++) {
			if (bikerList.get(i).getName().equalsIgnoreCase(input)) {
				bikerList.remove(i);
				isfound = true;
			}
		}
		if (isfound == true) {
			System.out.println("Biker deleted");
		}
		else {
			System.out.println("Biker is unable to be deleted");
		}
	}
}