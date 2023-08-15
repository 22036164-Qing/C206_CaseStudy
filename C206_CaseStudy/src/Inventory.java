public class Inventory {

	String name;

	String brand;

	String platenumber;

	int mileage;

	int owners;

 

	public Inventory(String name, String brand, String platenumber, int mileage, int owners) {

		

		this.name = name;

 

		this.brand = brand;

		this.platenumber = platenumber;

		this.mileage = mileage;

		this.owners = owners;

	}

 

 

 

	public String getName() {

		return name;

	}

 

 

	public String getBrand() {

		return brand;

	}

 

 

 

	public String getPlatenumber() {

		return platenumber;

	}

 

 

 

	public int getMileage() {

		return mileage;

	}

 

 

 

	public int getOwners() {

		return owners;

	}

 

 

}