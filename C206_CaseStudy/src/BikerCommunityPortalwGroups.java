import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class BikerCommunityPortalwGroups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ArrayList<Bikers> bikerGroup = new ArrayList<Bikers>();
		ArrayList<Groups> groups = new ArrayList<Groups>();

		int option = 0;

		while (option != 4) {

			BikerCommunityPortalwGroups.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {

			} else if (option == 2) {
				grpMenu();
				int optGrps = Helper.readInt("Which option do you want > ");
				if (optGrps == 1) {
					addGroup(groups);
				}
				else if (optGrps == 2) {
					viewAllGroups(groups);
				}
				else if (optGrps == 3) {
					deleteGroup(groups);
				}
			} else if (option == 3) {

			} else if (option == 4) {
				System.out.println("Bye!");
			}
		}
	}

	public static void menu() {
		BikerCommunityPortalwGroups.setHeader("Biker Community Portal");
		System.out.println("1. Users");
		System.out.println("2. Groups");
		System.out.println("3. Events");
		System.out.println("4. Quit");
		Helper.line(120, "-");
	}
	
	public static void grpMenu() {
		BikerCommunityPortalwGroups.setHeader("Group options");
		System.out.println("1. Add groups");
		System.out.println("2. View all groups");
		System.out.println("3. Delete group");
	}

	public static void setHeader(String header) {
		Helper.line(120, "-");
		System.out.println(header);
		Helper.line(120, "-");

	}

	public static void addGroup(ArrayList<Groups> groups) { // NOT FINISHED
		boolean found = false;
		String name = Helper.readString("Group name > "); 
		for(int i = 0; i < groups.size(); i++) {
			if(groups.get(i).getName().equalsIgnoreCase(name)) {
				found=true;
			}
		}
		if (found==false) {
			int memberQuantity = Helper.readInt("Max number of members > ");
			String description = Helper.readString("Description of your group > ");
			if (description.equals("")) {
				groups.add(new Groups(name, memberQuantity));
				String groupName = name +"Group";
				String txt = groupName + ".txt";

				try {
					File file = new File(txt);
					if(file.createNewFile()) {
						System.out.println("Group " + name + " created");
					}
					else {
						System.out.println("Group file of " + txt + " has been created earlier");
					}
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);

					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(String.format(groupName));
					bw.close();
					br.close();
				}
				catch (FileNotFoundException e) {
					System.out.println("Group file does not exits");
				}
				catch (IOException e) {
					System.out.println("An error occured");
				}
			}
			else {
				groups.add(new Groups(name, memberQuantity, description));
				String groupName = name +"Group";
				String txt = groupName + ".txt";

				try {
					File file = new File(txt);
					if(file.createNewFile()) {
						System.out.println("Group file of " + groupName + " created");
					}
					else {
						System.out.println("Group file of " + txt + " has been created earlier");
					}
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);

					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(groupName);
					bw.close();
				}catch (FileNotFoundException e) {
					System.out.println("Group file does not exits");
				}catch (IOException e) {
					System.out.println("An error occured");
				}
			}
		}
		else if(found==true) {
			System.out.println("Group already made!");
		}
	}

	public static void viewAllGroups(ArrayList<Groups> groups){
		String groupA = String.format("%-30s %-30s %-30s %-30s\n", "Group Name", "Maximum number of members",
				"Number of members", "Description of your group");
		for (int i = 0; i < groups.size(); i++) {
			groupA += String.format("%-30s %-30d %-30d %-30s\n", groups.get(i).getName(),
					groups.get(i).getMemberQuantity(), groups.size(), groups.get(i).getDescription());
		}
		System.out.println(groupA);

	}

	public static void deleteGroup(ArrayList<Groups> groups) {
		String name = Helper.readString("Group name > ");
		for (int i = 0; i < groups.size(); i++) {
			if (groups.get(i).getName().equalsIgnoreCase(name)) {
				groups.remove(i);
				File file = new File(name+"Group.txt");
				file.delete();
				System.out.println("Group "+name+" deleted successfully!");
			}
		}
	}
}
