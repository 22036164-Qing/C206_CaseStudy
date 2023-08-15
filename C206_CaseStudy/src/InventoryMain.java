import java.util.ArrayList;

 

public class InventoryMain {

 

	public static void main(String[] args) {

		// TODO Auto-generated method stub

 

		ArrayList<Inventory> inventoryGroup = new ArrayList<Inventory>();

		

		ArrayList<Inventory> inventory = new ArrayList<Inventory>();

		Inventory item1 = new Inventory("Qing","BMW", "KF69KYS", 12000, 0);

		inventory.add(item1);

//

 

		int option = 0;

 

		while (option != 4) {

 

			InventoryMain.menu();

			option = Helper.readInt("Enter an option > ");

			

			if (option == 1) {

				

			

				Inventory item = createItem();

				addItem(inventory,item);

				

 

			} else if (option == 2) {

				viewAllItem(inventory);

			} else if (option == 3) {

 

				deleteItem(inventory);

 

			} else if (option == 4) {

				System.out.println("Thank You for using InventoryMain!");

 

			}

		}

	}

 

	public static void menu() {

		InventoryMain.setHeader("Inventory");

 

		

		System.out.println("1. Add item");

		System.out.println("2. View bikes");

		System.out.println("3. Delete bike");

		System.out.println("4. Exit");

		Helper.line(80, "-");

	}

 

	public static void setHeader(String header) {

		Helper.line(80, "-");

		System.out.println(header);

		Helper.line(80, "-");

	}

 

// add biker

	public static Inventory createItem() {

 

		String name = Helper.readString("Enter name of bike > ");

		String brand = Helper.readString("Enter brand > ");

		String platenumber = Helper.readString("Enter platenumber > ");

		int mileage = Helper.readInt("Enter mileage  > ");

		int owners = Helper.readInt("Enter No. of owners > ");

 

		Inventory inventory = new Inventory(name, brand, platenumber, mileage, owners);

		return inventory;

		

	}

 

	public static void addItem(ArrayList<Inventory> inventory, Inventory a) {

		Inventory item;

		for(int i = 0; i < inventory.size(); i++) {

			item = inventory.get(i);

			if (item.getName().equalsIgnoreCase(a.getName()) )

				return;

		}

		if ((a.getName().isEmpty())) {

			return;

		}

		inventory.add(a);

		System.out.println("Item Added");

	}

	

	

 

// view all biker

	public static String retrieveAllItem(ArrayList<Inventory> inventory) {

		String output = "";

 

		for (int i = 0; i < inventory.size(); i++) {

			output += String.format("%-200s\n", inventory.get(i).toString());

		}

		return output;

	}

 

	public static void viewAllItem(ArrayList<Inventory> inventory) {

		InventoryMain.setHeader("Inventory List");

		String output = String.format("%-10s %-10s %-20s %-20s %-20s\n", "NAME",

				"BRAND", "PLATENUMBER", "MILEAGE", "OWNER");

		for (int i=0; i<inventory.size(); i++) {

			output +=String.format("%-10s %-10s %-20s %-20d %-20d \n",

					inventory.get(i).getName(),

					inventory.get(i).getBrand(),

					inventory.get(i).getPlatenumber(),

					inventory.get(i).getMileage(),

					inventory.get(i).getOwners() );

		}

		

		System.out.println(output);

	}

 

// delete biker

	public static void deleteItem(ArrayList<Inventory> inventory) {

		boolean isfound = false;

		String input = Helper.readString("Input a user to be deleted > ");

		for(int i = 0; i < inventory.size(); i++) {

			if (inventory.get(i).getName().equalsIgnoreCase(input)) {

				inventory.remove(i);

				isfound = true;

			}

		}

		if (isfound == true) {

			System.out.println("Item deleted");

		}

		else {

			System.out.println("Item not found");

		}

	}

}
