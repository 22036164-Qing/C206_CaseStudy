
import java.time.LocalDateTime;

 

public class Biker {
	private String name;
	private String date_of_birth;
	private String nationality;
	private String email;
	private int mobileNumber;
	private char gender;
	private int age;
	private String username;
	private String password;
	private int userType;

	public Biker(String name, String date_of_birth, String nationality, String email, int mobileNumber, char gender,
			int age, String username, String password, int userType) {
		this.name = name;
		this.date_of_birth = date_of_birth;
		this.nationality = nationality;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.age = age;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

 

	public Biker(String name, String date_of_birth, String nationality, String email, int mobileNumber,
			char gender, int age, String username, String password) {
		this.name = name;
		this.date_of_birth = date_of_birth;
		this.nationality = nationality;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.age = age;
		this.username = username;
		this.password = password;
		this.userType = 1;
	}

 

	public String getName() {
		return name;
	}

 

	public String getDate_of_birth() {
		return date_of_birth;
	}

 

	public String getNationality() {
		return nationality;
	}

 

	public String getEmail() {
		return email;
	}

 

	public int getMobileNumber() {
		return mobileNumber;
	}

 

	public char getGender() {
		return gender;
	}

 

	public int getAge() {
		return age;
	}

 

	public String getUsername() {
		return username;
	}

 

	public String getPassword() {
		return password;
	}

 

	public int getUserType() {
		return userType;
	}


 

}