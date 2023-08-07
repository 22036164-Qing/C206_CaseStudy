import java.util.ArrayList;

public class BikerCommunityPortal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ArrayList<Bikers> bikerGroup = new ArrayList<Bikers>();

		int option = 0;



		while (option != 4) {



			BikerCommunityPortal.menu();
			option = Helper.readInt("Enter an option > ");



			if (option == 1) {
				
			}
			else if (option == 2) {

			}
			else if (option == 3) {
				
			}
			else if (option == 4) {
				System.out.println("Bye!");
			}
		}
	}
	public static void menu() {
		BikerCommunityPortal.setHeader("Biker Community Portal");
		System.out.println("1. Users");
		System.out.println("2. Groups");
		System.out.println("3. Events");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
}
