import java.util.ArrayList;

public class BikerCommunityPortal {

 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

 

		ArrayList<Biker> bikerGroup = new ArrayList<Biker>();

		//list for overall system
		ArrayList<Biker> bikerList = new ArrayList<Biker>();

 

		int option = 0;

 

		while (option != 5) {

			BikerCommunityPortal.menu();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				createBiker();

 

				
			}
			else if (option == 2) {
//				addbikeunderBiker();
				addBiker(bikerGroup, null);
			}
			else if (option == 3) {
//				addnewRegistration();
				deleteBiker(bikerGroup, null);
			}
			else if (option == 4) {
//				if(usertype == admin) {
//					addBiker(bikerGroup);
//					deleteBiker(bikerGroup);
//					viewAllBiker(bikerGroup);
//					addDiscussionGroups(bikerGroup);
//					viewDiscussionGroups(bikerGroup);
//					deleteDiscussionGroups(bikerGroup);
//				}
//				else {
//					System.out.println("Only admin can access");
//				}
				viewAllBiker(bikerGroup);
			}
			else if (option == 5) {
				System.out.println("Thank You for using Biking Community Portal!");
				}
			}
		}

	public static void menu() {
		BikerCommunityPortal.setHeader("Biker Community Portal");
		System.out.println("1. Create account");
		System.out.println("2. Add bike");
		System.out.println("3. Register to event");
		System.out.println("4. Group Admin");
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
		String passwordpattern = "[a-z]{1} &&([0-9] || [a-z]){8}";
		String name = Helper.readString("Enter name > ");
		String date_of_birth = Helper.readString("Enter date of birth > ");
		String nationality = Helper.readString("Enter nationality > ");
		String email = Helper.readString("Enter email address > ");
		int mobilenumber = Helper.readInt("Enter mobile number > ");
		char gender = Helper.readChar("Enter gender (M/F) > ");
		int age = Helper.readInt("Enter age > ");
		String username = Helper.readString("Create a username > ");
		String password = Helper.readStringRegEx("Create a password > ", passwordpattern);
		int userType = Helper.readInt("Update user to admin by entering 2 >");

 

		Biker biker= new Biker(name, date_of_birth, nationality, email, mobilenumber, gender, age, username, password, userType);
		return biker;
	}

 

	public static void addBiker(ArrayList<Biker> bikerList, Biker biker1) {
		Biker item;
		for(int i = 0; i < bikerList.size(); i++) {
			item = bikerList.get(i);
			if (item.getName().equalsIgnoreCase(biker1.getName()) )
				return;
			}
		if ((biker1.getName().isEmpty()) || (biker1.getDate_of_birth().isEmpty()) ) {
			return;
		}
		bikerList.add(biker1);
		System.out.println(biker1 + "added into group");
		}

 

// view all biker
	public static String retrieveAllBiker(ArrayList<Biker> bikerList) {
		String output = "";

		for (int i = 0; i < bikerList.size(); i++) {
	           output += String.format("%-150s\n", bikerList.get(i).toString());
	    }
		return output;
	}

	public static void viewAllBiker(ArrayList<Biker> bikerList) {
			BikerCommunityPortal.setHeader("Biker LIST");
			String output = String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20s\\n", "NAME", "DATE OF BIRTH",
					"NATIONALITY", "EMAIL", "PHONE NUMBER", "GENDER", "AGE");
			 output += retrieveAllBiker(bikerList);	
			System.out.println(output);
		}


 

// delete biker
	public static void deleteBiker(ArrayList<Biker> bikerList, Biker biker1) {
		String input = Helper.readString("Input a usr to be deleted");

	}
}
