package codes;

public class Groups {

	private String name;
	private int memberQuantity;
	private String description;
	public Groups(String name, int memberQuantity, String description) {

		this.name = name;
		this.memberQuantity = memberQuantity;
		this.description = description;
	}
	// overriding description 
	public Groups(String name, int memberQuantity) {
		this.name = name;
		this.memberQuantity = memberQuantity;
		this.description = "";
	}
	
	public String getName() {
		return name;
	}
	public int getMemberQuantity() {
		return memberQuantity;
	}
	public String getDescription() {
		return description;
	}
}
