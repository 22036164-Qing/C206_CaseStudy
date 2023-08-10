import java.util.ArrayList;

 

public class DiscussionGroupsMain {

 

	public static void main(String[] args) {

		ArrayList<DiscussionGroups> discussionList = new ArrayList<>();

		

		discussionList.add(new DiscussionGroups("Bikes", 40));

		discussionList.add(new DiscussionGroups("Locations best for Biking", 20));

		discussionList.add(new DiscussionGroups("The Fun Of Biking", 10));

		

		DiscussionGroups dg1 = inputDiscussionGroups();

		addDiscussionGroups(discussionList, dg1);

        viewAllDiscussionGroups(discussionList);

        deleteDiscussionGroups(discussionList , dg1);

        viewAllDiscussionGroups(discussionList);

		// You can add more DiscussionGroups objects here or use a loop to add multiple

		// groups.

	}

 

	public static String retrieveAllDiscussionGroups(ArrayList<DiscussionGroups> discussionList) {

		String output = "";

		for (int i = 0; i < discussionList.size(); i++) {

			output += String.format("%-30s %-10d\n", discussionList.get(i).getTopic(),

					discussionList.get(i).getMemberQuantity());

		}

		return output;

	}

 

	public static void viewAllDiscussionGroups(ArrayList<DiscussionGroups> discussionList) {

		String output = String.format("%-30s %-10s\n", "TOPIC", "MEMBER QUANTITY");

		output += retrieveAllDiscussionGroups(discussionList);

		System.out.println(output);

	}

 

	public static DiscussionGroups inputDiscussionGroups() {

		String topic = Helper.readString("Enter Topic > ");

		int memberQuantity = Helper.readInt("Enter Member Quantity > ");

 

		DiscussionGroups dg = new DiscussionGroups(topic, memberQuantity);

		return dg;

	}

 

	public static void addDiscussionGroups(ArrayList<DiscussionGroups> discussionList, DiscussionGroups dg) {

		// Check if the member quantity is positive and if the topic is not empty before

		// adding to the list

		for (int i = 0; i < discussionList.size(); i++) {

			if (dg.getMemberQuantity() > 0 && dg.getTopic() != "") {

				discussionList.add(dg);

				return;

			}

			if (dg.getMemberQuantity() == 0 && dg.getTopic() == "") {

				System.out.println("Invalid Discussion Group");

				break;

			}

		}

	}

	public static void deleteDiscussionGroups(ArrayList<DiscussionGroups> discussionList , DiscussionGroups dg) {

		String userInput = Helper.readString("Enter The Topic To Delete > ");

		for (int i = 0; i < discussionList.size(); i++) {

			if (dg.getTopic().equalsIgnoreCase(userInput)) {

				discussionList.remove(dg);

				return;

			} else {

				System.out.println("No Such Discussion Topic");

				break;

			}

		}

	}

 

}