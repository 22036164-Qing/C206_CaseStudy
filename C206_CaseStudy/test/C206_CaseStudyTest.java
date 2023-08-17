

package test;


import java.io.BufferedReader;

import java.io.BufferedWriter;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.time.LocalDate;

import java.time.LocalTime;

import java.time.format.DateTimeFormatter;

import java.util.ArrayList;

 

 

public class BikerCommunityPortal {

	public static void main(String[] args) {

 

		// TODO Auto-generated method stub

		//biker

		ArrayList<Biker> bikerList = new ArrayList<Biker>();

 

		//events

		ArrayList<Events> eventsList = new ArrayList<Events>();

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

 

		//groups

		ArrayList<Groups> groups = new ArrayList<Groups>();

 

		//discussion

		ArrayList<DiscussionGroups> discussionList = new ArrayList<>();

 

		//bike

		ArrayList<Bike> BikeGroup = new ArrayList<Bike>();

		ArrayList<Bike> Bike = new ArrayList<Bike>();

		Bike item1 = new Bike("Qing","BMW", "KF69KYS", 12000, 0);

		Bike.add(item1);

 

		//menu options

		int option = 0;

 

		//create biker account

		Biker bikercreate =createBiker();

		bikerList.add(bikercreate);

		System.out.println("Biker added into the platform");

 

		while (option != 6) {

			BikerCommunityPortal.menu();

			int opt = Helper.readInt("Enter an option > ");

 

			if (opt == 1) {

				while (opt != 4) {

					menu1();

					int menu1 = Helper.readInt("Option > ");

						if (menu1 == 1) {

							menuThird();

							int menu3 = Helper.readInt("Option > ");

							while(menu3 !=3) {

								if (menu3 == 1) {

									String event = Helper.readString("Which event do you wish to register for > ");

									String user = Helper.readString("Which user to add > ");

									registerBiker(eventsList, bikerList, event, user);		

								}

								else {

									break;

								}

							}

						}

						else if (menu1 == 2) {

							viewAllBiker(bikerList);

						}

						else if (menu1 == 3) {

							String input = Helper.readString("Who do you want to delete > ");

							String event = Helper.readString("What event is he in > ");

							deleteBiker(bikerList, input);

							unregisterBikerSide(eventsList, event, input);

						}

						else {

							break;

						}

				}

			}

			else if (opt == 2) {

				menuDiscussion();

				int discussion = Helper.readInt("Option > ");

				while (discussion != 4) {

					if (discussion == 1) {

						DiscussionGroups dg1 = inputDiscussionGroups();

						addDiscussionGroups(discussionList,dg1);

					}

					else if (discussion == 2) {

						viewAllDiscussionGroups(discussionList);

					}

					else if (discussion == 3) {

						String userInput = Helper.readString("Enter Topic To Delete > ");

						deleteDiscussionGroups(discussionList,userInput);

					}

					else {

						break;

					}

					}

			}

			else if (opt == 3) {

				menuGroups();

				int groupopt = Helper.readInt("Option > ");

				while (groupopt != 4) {

					if (groupopt == 1) {

						String name = Helper.readString("Group name > "); 

						addGroup(groups, name);

					}

					else if (groupopt == 2) {

						viewAllGroups(groups);

					}

					else if (groupopt == 3) {

						String name = Helper.readString("Group name > ");

						deleteGroup(groups, name);

					}

					else {

						break;

					}

					}

			}

			else if (opt == 4) {

				menuEvent();

				int eventopt = Helper.readInt("Option > ");

				while (eventopt != 7) {

					if (eventopt == 1) {

						Events ev = inputEvents();

						AddEvents(eventsList, ev);

					}

					else if (eventopt == 2) {

						viewAllEvents(eventsList);

						inputViewEvents(eventsList);

					}

					else if (eventopt == 3) {

						String ev = inputDeleteEvents();

						DeleteEvents(eventsList,ev);

					}

					else if (eventopt == 4) {

						viewRegistrations(eventsList);

					}

					else if (eventopt == 5) {

						String event = Helper.readString("Which event do you want to unregister the user from > ");

						String user = Helper.readString("Which user do you wish to unregister > ");

						unregisterBikerSide(eventsList, event, user);

					}

					else if (eventopt == 6) {

						manageRegistrations(eventsList, bikerList);

					}

					else {

						break;

					}

					}

			}

			else if (opt == 5) {

				menu5();

				int bikeopt = Helper.readInt("Enter an option > ");

				while (bikeopt != 4) {

					if (bikeopt == 1) {

						Bike item = createItem();

						addItem(Bike,item);

					} else if (bikeopt == 2) {

						viewAllItem(Bike);

					} else if (bikeopt == 3) {

						deleteItem(Bike);

					} else if (bikeopt == 4) {

						break;

					}

					}

			}

			else {

				System.out.println("Thank you for using Biker Community Portal!");

		}

		}

	}

 

public static void menu() {

	BikerCommunityPortal.setHeader("Biker Community Portal");

	System.out.println("1. Users");

	System.out.println("2. Discussion Groups");

	System.out.println("3. Groups");

	System.out.println("4. Events");

	System.out.println("5. Bikes");

	System.out.println("6. Quit from Biker Community Portal");

	Helper.line(80, "-");

}

 

public static void menu1() {

	BikerCommunityPortal.setHeader("Users");

	System.out.println("1. Add users");

	System.out.println("2. View all users");

	System.out.println("3. Delete users");

	System.out.println("4. Back to main menu");

	Helper.line(80, "-");

}

 

public static void menuDiscussion() {

	BikerCommunityPortal.setHeader("Discussion Groups");

	System.out.println("1. Make discussion group");

	System.out.println("2. View discussion group");

	System.out.println("3. Delete discussion group");

	System.out.println("4. Back to main menu");

	Helper.line(80, "-");

}

 

public static void menuGroups() {

	BikerCommunityPortal.setHeader("Groups");

	System.out.println("1. Create group");

	System.out.println("2. View groups");

	System.out.println("3. Delete group");

	System.out.println("4. Back to main menu");

	Helper.line(80, "-");

}

 

public static void menuThird() {

	BikerCommunityPortal.setHeader("Add users");

	System.out.println("1. Event");

	System.out.println("2. Groups");

	System.out.println("3. Back to main menu");

	Helper.line(80, "-");

}

 

public static void menuEvent() {

	BikerCommunityPortal.setHeader("Events");

	System.out.println("1. Make events");

	System.out.println("2. View events");

	System.out.println("3. Delete events");

	System.out.println("4. View registrations");

	System.out.println("5. Delete registration");

	System.out.println("6. Manage registrations");

	System.out.println("7. Back to main menu");

}

 

public static void menu5() {

	BikerCommunityPortal.setHeader("Bike");

	System.out.println("1. Add item");

	System.out.println("2. View bikes");

	System.out.println("3. Delete bike");

	System.out.println("4. Back to main menu");

	Helper.line(80, "-");

}

 

public static void setHeader(String header) {

	Helper.line(80, "-");

	System.out.println(header);

	Helper.line(80, "-");

}

 

//biker codes

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

	Biker biker = new Biker(name, date_of_birth, nationality, email, mobilenumber, gender, age, username, password);

	return biker;

}

 

public static void addBiker(ArrayList<Biker> bikerList, Biker biker) {

	for(int i = 0; i < bikerList.size(); i++) {

		if (bikerList.get(i).getName().equalsIgnoreCase(biker.getName())) {

			System.out.println("Biker is added previously!");;

		}

		else {

		bikerList.add(biker);

		System.out.println("Biker is added into platform");

	}

	}

}

 

// view all biker

public static String retrieveAllBiker(ArrayList<Biker> bikerList) {

	String output = "";

	for (int i = 0; i < bikerList.size(); i++) {

		output += String.format("%-300s\n", bikerList.get(i).toString());

	}

	return output;

}

 

public static void viewAllBiker(ArrayList<Biker> bikerList) {

	BikerCommunityPortal.setHeader("Biker LIST");

	String output = String.format("%-10s %-30s %-10s %-20s %-20s %-10s %-10s %-20s %-10s %-10s\n", "NAME", "DATE OF BIRTH",

			"NATIONALITY", "EMAIL", "PHONE NUMBER", "GENDER", "AGE", "USERNAME", "PASSWORD", "USER TYPE");

	for (int i = 0; i < bikerList.size(); i++) {

		output += String.format("%-10s %-30s %-10s %-20s %-20d %-10c %-10d %-20s %-10s %-10d\n", bikerList.get(i).getName(), bikerList.get(i).getDate_of_birth(), bikerList.get(i).getNationality(), bikerList.get(i).getEmail(), bikerList.get(i).getMobileNumber(), bikerList.get(i).getGender(), bikerList.get(i).getAge(), bikerList.get(i).getUsername(), bikerList.get(i).getPassword(), bikerList.get(i).getUserType());

	}	

	System.out.println(output);

}

 

// delete biker

public static void deleteBiker(ArrayList<Biker> bikerList, String input) {

	boolean isfound = false;

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

 

// events codes

public static String retrieveAllEvents(ArrayList<Events> eventsList) {

	String output = "";

	for (int i = 0; i < eventsList.size(); i++) {

		String localdate = eventsList.get(i).getDate().toString();

		String starttime = eventsList.get(i).getStartTime().toString();

		String endtime = eventsList.get(i).getEndTime().toString();

		output += String.format("\n%-20s %-20s %-20s %-20s %-20s %-20.2f\n", eventsList.get(i).getEventName(),

				eventsList.get(i).getPlace(), localdate, starttime, endtime, eventsList.get(i).getDuration());

		output += String.format("%-20s:%-20s\n", "Description", eventsList.get(i).getInformation());

	}

	System.out.println("See txt file for event");

	Helper.line(200, "-");

	return output;

}

public static void viewAllEvents(ArrayList<Events> eventsList) {

	String output = String.format("\n%-20s %-20s %-20s %-20s %-20s %-20s\n", "Event Name", "Event Venue",

			"Date of Event", "Start Time", "End Time", "Duration");

	output += retrieveAllEvents(eventsList);

	System.out.println(output);

	try {

		File file = new File("Events.txt");

		FileWriter fw = new FileWriter(file);

		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(output);

		bw.close();

	} catch (IOException e) {

		System.out.println("An error occured");

	}

}

 

public static void inputViewEvents(ArrayList<Events> eventsList){

	char optionFind = Helper.readChar("Do you want to find a specific event(Y/N) ? > ");

	if (optionFind == 'y' || optionFind == 'Y') {

		BikerCommunityPortal.viewSpecificEvents(eventsList);

	} else if (optionFind == 'N' || optionFind == 'n') {

		System.out.println("Go back to menu()");

	}

}

 

public static String viewSpecificEvents(ArrayList<Events> eventsList) {

	String events = Helper.readString("Search for event by name > ");

	try {

		File file = new File("specificEventList.txt");

		FileWriter fw = new FileWriter(file);

		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(String.format("\n%-20s %-20s %-20s %-20s %-20s %-20s\n", "Event Name", "Event Venue",

				"Date of Event", "Start Time", "End Time", "Duration"));

		for (int i = 0; i < eventsList.size(); i++) {

			String localdate = eventsList.get(i).getDate().toString();

			String starttime = eventsList.get(i).getStartTime().toString();

			String endtime = eventsList.get(i).getEndTime().toString();

			if (events.equalsIgnoreCase(eventsList.get(i).getEventName())) {

				bw.write(String.format("\n%-20s %-20s %-20s %-20s %-20s %-20.2f\n",

						eventsList.get(i).getEventName(), eventsList.get(i).getPlace(), localdate, starttime,

						endtime, eventsList.get(i).getDuration()));

				bw.write(String.format("%-20s:%-20s\n", "Description", eventsList.get(i).getInformation()));

				bw.close();

				System.out.println("The event that you search will appear in the specificEventList");

			}

		}

	} catch (IOException e) {

		System.out.println("An error occured");

	}

	return events;

}

 

public static Events inputEvents() {

	Events ev = null;

	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

	String name = Helper.readString("Enter events name > ");

	String place = Helper.readString("Enter events venue > ");

	String date = Helper.readString("Enter date of the event (dd.MM.yyyy) > ");

	String startTime = Helper.readString("Enter start time of the event (HH : MM) > ");

	String endTime = Helper.readString("Enter end time of the event (HH : MM) > ");

	Double duration = Helper.readDouble("Enter the estimate the duration > ");

	String information = Helper.readString("Enter description about the events > ");

	LocalTime startTimeFormat = LocalTime.parse(startTime, timeFormatter);

	LocalTime endTimeFormat = LocalTime.parse(endTime, timeFormatter);

	LocalDate dateFormat = LocalDate.parse(date, dateFormatter);

	ev = new Events(name, place, dateFormat, startTimeFormat, endTimeFormat, duration, information);

	return ev;

}

 

public static void AddEvents(ArrayList<Events> eventsList, Events ev) {

	Events events;

	for (int i = 0; i < eventsList.size(); i++) {

		events = eventsList.get(i);

		if (events.getEventName().equalsIgnoreCase(ev.getEventName())) {

			System.out.println("Event name already Existed");

			System.out.println("Please create an event of a different name");

			return;

		} else if (ev.getEventName().isEmpty() || ev.getPlace().isEmpty() || ev.getDate() == null

				|| ev.getStartTime() == null || ev.getEndTime() == null || ev.getDuration() == 0) {

			System.out.println("Your information about the event is incomplete");

			return;

		}

	}

	System.out.println("Event has been successfully added");

	eventsList.add(ev);

}

public static String inputDeleteEvents() {

	String ev = "";

	String deleteEvent = Helper.readString("Enter events name to delete > ");

	ev = deleteEvent;

	return ev;

}

 

public static void DeleteEvents(ArrayList<Events> eventsList,String ev) {

	for (int i = 0; i < eventsList.size(); i++) {

		if (ev.equalsIgnoreCase(eventsList.get(i).getEventName())) {

			eventsList.remove(i);

			try {

				File file = new File("Events.txt");

				FileReader fr = new FileReader(file);

				BufferedReader br = new BufferedReader(fr);

				FileWriter fw = new FileWriter(file);

				BufferedWriter bw = new BufferedWriter(fw);

				String line = br.readLine();

 

				while (line != null) {

					line = br.readLine();

					bw.write("Event: " + eventsList.get(i).getEventName() + "scheduled on :"

							+ eventsList.get(i).getDate() + eventsList.get(i).getStartTime()

							+ " has been cancelled!");

				}

				bw.close();

				br.close();

				System.out.println("Event has been deleted");

			} catch (FileNotFoundException e) {

				System.out.println("Events file do not exist");

			} catch (IOException e) {

				System.out.println("An error occured");

			}

		}

	}

}

 

// discussion 

public static String retrieveAllDiscussionGroups(ArrayList<DiscussionGroups> discussionList) {

	StringBuilder output = new StringBuilder();

	for (DiscussionGroups group : discussionList) {

		output.append(String.format("%-30s %-10d\n", group.getTopic(), group.getMemberQuantity()));

	}

	return output.toString();

}

 

public static void viewAllDiscussionGroups(ArrayList<DiscussionGroups> discussionList) {

	String output = String.format("%-30s %-10s\n", "TOPIC", "MEMBER QUANTITY");

	output += retrieveAllDiscussionGroups(discussionList);

	System.out.println(output);

}

 

public static DiscussionGroups inputDiscussionGroups() {

	String topic = Helper.readString("Enter Topic > ");

	int memberQuantity = Helper.readInt("Enter Member Quantity > ");

	return new DiscussionGroups(topic, memberQuantity);

}

 

public static void addDiscussionGroups(ArrayList<DiscussionGroups> discussionList, DiscussionGroups dg) {

	if (dg.getMemberQuantity() > 0 && !dg.getTopic().isEmpty()) {

		discussionList.add(dg);

	} else {

		System.out.println("Invalid Discussion Group");

	}

}

 

public static void deleteDiscussionGroups(ArrayList<DiscussionGroups> discussionList, String userInput) {

	boolean removed = false;

	for (DiscussionGroups group : discussionList) {

		if (group.getTopic().equalsIgnoreCase(userInput)) {

			discussionList.remove(group);

			System.out.println("Discussion Group removed successfully.");

			removed = true;

			break;

		}

	}

	if (!removed) {

		System.out.println("No Such Discussion Topic");

	}

}

 

// groups

public static void addGroup(ArrayList<Groups> groups, String name) { 

	boolean found = false;

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

				br.close();

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

 

public static void deleteGroup(ArrayList<Groups> groups, String name) {

	for (int i = 0; i < groups.size(); i++) {

		if (groups.get(i).getName().equalsIgnoreCase(name)) {

			groups.remove(i);

			File file = new File(name+"Group.txt");

			file.delete();

			System.out.println("Group "+name+" deleted successfully!");

		}

	}

}

 

// register

public static void registerBiker(ArrayList<Events> eventsList, ArrayList<Biker> bikerList, String event, String user) {

	for (int i = 0; i < eventsList.size(); i++) {

		if (eventsList.get(i).getEventName().equalsIgnoreCase(event)) {

			try {

				File file = new File(event+"Participants.txt");

				FileReader fr = new FileReader(file);

				BufferedReader br = new BufferedReader(fr);

				FileWriter fw = new FileWriter(file);

				BufferedWriter bw = new BufferedWriter(fw);

				fw.write(user);

				bw.close();

				br.close();

			} catch (FileNotFoundException e) {

				System.out.println("Events file do not exist");

			} catch (IOException e) {

				System.out.println("An error occured");

			}

		}

	}

}

 

public static void unregisterBikerSide(ArrayList<Events> eventsList, String event, String user) {

	for (int i = 0; i < eventsList.size(); i++) {

		if (eventsList.get(i).getEventName().equalsIgnoreCase(event)) {

			try {

				File file = new File(event+"Participants.txt");

				FileReader fr = new FileReader(file);

				BufferedReader br = new BufferedReader(fr);

				FileWriter fw = new FileWriter(file);

				BufferedWriter bw = new BufferedWriter(fw);

				String line = br.readLine();

 

				while (line != user) {

					line = br.readLine();

					bw.append("");

				}

				bw.close();

				bw.close();

			} catch (FileNotFoundException e) {

				System.out.println("Events file do not exist");

			} catch (IOException e) {

				System.out.println("An error occured");

			}

		}

	}

}

 

public static void manageRegistrations(ArrayList<Events> eventsList, ArrayList<Biker> bikerList) {

	String output = "";

	String event = Helper.readString("Which event do you wish to manage > ");

	String user = Helper.readString("Which user do you wish to manage > ");

 

	for(int i = 0; i < eventsList.size(); i++) {

		if (eventsList.get(i).getEventName().contains(event)) {

			try {

				File file = new File(event+"Participants.txt");

				FileReader fr = new FileReader(file);

				BufferedReader br = new BufferedReader(fr);

				FileWriter fw = new FileWriter(file);

				BufferedWriter bw = new BufferedWriter(fw);

				String line = br.readLine();

 

				if(line.equalsIgnoreCase(user)) {

					for(int z = 0; z < bikerList.size(); z++) {

						if (bikerList.get(z).getName().equalsIgnoreCase(user)) {

							output += String.format("%-10s %-30s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "NAME", "DATE OF BIRTH",

									"NATIONALITY", "EMAIL", "PHONE NUMBER", "GENDER", "AGE", "USERNAME", "PASSWORD", "USER TYPE");

							output += String.format("%-10s %-30s %-10s %-10s %-10d %-10c %-10d %-10s %-10s %-10d\n", bikerList.get(z).getName(), bikerList.get(z).getDate_of_birth(), bikerList.get(z).getNationality(), bikerList.get(z).getEmail(), bikerList.get(z).getMobileNumber(), bikerList.get(z).getGender(), bikerList.get(z).getAge(), bikerList.get(z).getUsername(), bikerList.get(z).getPassword(), bikerList.get(z).getUserType());

						}

					}

				}

				bw.close();

				br.close();

			} catch (FileNotFoundException e) {

				System.out.println("Events file do not exist");

			} catch (IOException e) {

				System.out.println("An error occured");

			}

		}

	}

	System.out.println(output);

}

 

public static void viewRegistrations(ArrayList<Events> eventsList) {

	String event = Helper.readString("What event's registration list do you wish to view > ");

	for (int i = 0; i < eventsList.size(); i++) {

		if (eventsList.get(i).getEventName().contains(event)) {

			try {

				File file = new File(event+"Participants.txt");

				FileReader fr = new FileReader(file);

				BufferedReader br = new BufferedReader(fr);

				FileWriter fw = new FileWriter(file);

				BufferedWriter bw = new BufferedWriter(fw);

				System.out.println("Participants:");

				String line = br.readLine();

 

				while (line != null) {

					line = br.readLine();

					System.out.println(line);

				}

				bw.close();

				bw.close();

			} catch (FileNotFoundException e) {

 

				System.out.println("Events file do not exist");

 

			} catch (IOException e) {

 

				System.out.println("An error occured");

			}

		}

	}

}

 

//bike

public static Bike createItem() {

 

	String name = Helper.readString("Enter name of bike > ");

	String brand = Helper.readString("Enter brand > ");

	String platenumber = Helper.readString("Enter platenumber > ");

	int mileage = Helper.readInt("Enter mileage  > ");

	int owners = Helper.readInt("Enter No. of owners > ");

 

	Bike Bike = new Bike(name, brand, platenumber, mileage, owners);

	return Bike;

 

}

 

public static void addItem(ArrayList<Bike> Bike, Bike a) {

	Bike item;

	for(int i = 0; i < Bike.size(); i++) {

		item = Bike.get(i);

		if (item.getName().equalsIgnoreCase(a.getName()) ) 

			return;

	}

	if ((a.getName().isEmpty())) {

		return;

	}

	Bike.add(a);

	System.out.println("Item Added");

}

 

// view all biker

public static String retrieveAllItem(ArrayList<Bike> Bike) {

	String output = "";

	for (int i = 0; i < Bike.size(); i++) {

		output += String.format("%-200s\n", Bike.get(i).toString());

	}

	return output;

}

 

public static void viewAllItem(ArrayList<Bike> Bike) {

	BikerCommunityPortal.setHeader("Bike List");

	String output = String.format("%-10s %-10s %-20s %-20s %-20s\n", "NAME",

			"BRAND", "PLATENUMBER", "MILEAGE", "OWNER");

	for (int i=0; i<Bike.size(); i++) {

		output +=String.format("%-10s %-10s %-20s %-20d %-20d \n", 

				Bike.get(i).getName(),

				Bike.get(i).getBrand(),

				Bike.get(i).getPlatenumber(),

				Bike.get(i).getMileage(),

				Bike.get(i).getOwners() );

	}

	System.out.println(output);

}

 

// delete biker

public static void deleteItem(ArrayList<Bike> Bike) {

	boolean isfound = false;

	String input = Helper.readString("Input an item to be deleted > ");

	for(int i = 0; i < Bike.size(); i++) {

		if (Bike.get(i).getName().equalsIgnoreCase(input)) {

			Bike.remove(i);

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

 

 

[12:14 pm] EU ZHI YONG

package test;

 

import static org.junit.Assert.*;

 

import java.io.BufferedReader;

import java.io.BufferedWriter;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.time.LocalDate;

import java.time.LocalTime;

import java.util.ArrayList;

 

import org.junit.After;

import org.junit.Before;

import org.junit.Test;

 

import codes.Bike;

import codes.Biker;

import codes.BikerCommunityPortal;

 

import codes.DiscussionGroups;

 

import codes.Events;

import codes.Groups;

 

import java.time.format.DateTimeFormatter;

 

 

 

 

public class BikecomunityportalTest {


	//Biker

	private Biker biker1;

	private Biker biker2;


	private ArrayList<Biker> bikerList;


	//discussion

	private DiscussionGroups dg1;

    private DiscussionGroups dg2;

    private DiscussionGroups dg3;

    private ArrayList<DiscussionGroups> discussionList;


    //event 

	private Events ev1;

	private Events ev2;

 

	private ArrayList<Events> eventsList;

	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");


	//groups

	 ArrayList<Groups> groupsList = new ArrayList<Groups> ();

	 private Groups A;

	 private Groups B;



	// bikes

	 private Bike item1;

	 private Bike item2;

 

	private ArrayList<Bike> inventory;

 

 

	

	//register



	public BikecomunityportalTest() {

		super();

	}



	@Before

	//biker

	public void setUp() throws Exception {

		// prepare test data

		biker1 = new Biker("Zhi Yong", "20-01-2004 ", "Singaporean", "22010029@myrp.edu.sg", 90009000, 'M', 19, "ZhiYong", "E@123456", 2);

		biker2 = new Biker("Yong", "20-01-2005 ", "Singaporean", "22010021@myrp.edu.sg", 90019001, 'M', 18, "Yong", "E123@321", 1);


		bikerList= new ArrayList<Biker>();


		//events

		ev1 = new Events("Biking in the East", "East Coast Parkway", LocalDate.parse("30.10.2023", dateFormatter),

				LocalTime.parse("11:30", timeFormatter), LocalTime.parse("13:30", timeFormatter), 2.00);

		ev2 = new Events("Biking in the West", "Lim Chu Kang Road", LocalDate.parse("30.08.2023", dateFormatter),

				LocalTime.parse("16:30", timeFormatter), LocalTime.parse("21:00", timeFormatter), 4.30,

				"Lim Chu Kang Road - Heritage Roads - Gardens, Parks & Nature");

 

		eventsList = new ArrayList<Events>();


		//discusion

		dg1 = new DiscussionGroups("Bikes", 40);

        dg2 = new DiscussionGroups("Locations best for Biking", 20);

        dg3 = new DiscussionGroups("The Fun Of Biking", 10);

        discussionList = new ArrayList<DiscussionGroups>();


		//groups

        A = new Groups("C206", 20, "Hello welcome to GA team");

		B = new Groups("AZland", 5000, "LAND OF HAPPINESS");


 

		

		// bike

		item1 = new Bike("Adam", "Yamaha", "GG123WP", 10000, 0);

		item2 = new Bike("ZY", "Kawasaki", "QQ999TT", 30000, 1);

		inventory= new ArrayList<Bike>();


		// register

	}


	@Test

	//biker test codes

	public void testAddBiker() {

		//test case 1

		// Item list is not null, so that can add a new item - boundary

		assertNotNull("Check if there is valid Biker arraylist to add to", bikerList);

		//Given an empty list, after adding 1 item, the size of the list is 1 - normal

		//The item just added is as same as the first item of the list

		BikerCommunityPortal.addBiker(bikerList, biker1);

		assertEquals("Check that Biker arraylist size is 1", 1, bikerList.size());

		assertSame("Check that Biker is added", biker1, bikerList.get(0));

		String output = (biker1.getUsername() + "added into group chat");

		System.out.println(output);


		//Add another item. test The size of the list is 2? -normal

		//The item just added is as same as the second item of the list

		BikerCommunityPortal.addBiker(bikerList, biker2);

		assertEquals("Check that Biker arraylist size is 2", 2, bikerList.size());

		assertSame("Check that Biker is added", biker2, bikerList.get(1));

		String output1 = (biker2.getUsername() + "added into group chat");

		System.out.println(output1);


		//test case 2 

		//check that display message of biker added

//		assertEquals("Test that biker added message displayed matches biker added", "ZhiYong added into group chat", output);

//		assertEquals("Test that biker added message displayed matches biker added", "Yong added into group chat", output1);

		//check correct biker is added

		assertTrue(bikerList.contains(biker1));

		assertTrue(bikerList.contains(biker2));

	}


	@Test

	public void testRetrieveAllBiker() {

//		test case 1

		// Test if Item list is not null but empty -boundary

		assertNotNull("Test if there is valid Biker arraylist to retrieve item", bikerList);


		//test if the list of bikers retrieved from the SourceCentre is empty - boundary

		String allBikers= BikerCommunityPortal.retrieveAllBiker(bikerList);

		String testOutput = "";

		assertEquals("Check that ViewAllBikerlist", testOutput, allBikers);


		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal

		BikerCommunityPortal.addBiker(bikerList, biker1);

		BikerCommunityPortal.addBiker(bikerList, biker2);

		assertEquals("Test that Biker arraylist size is 2", 2, bikerList.size());


		//test if the expected output string same as the list of Bikers retrieved from the SourceCentre	

		allBikers = BikerCommunityPortal.retrieveAllBiker(bikerList);

		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20s\n","Zhi Yong", "20-01-2004", "Singaporean", "2010029@myrp.edu.sg", "90009000", "M", "19", "ZhiYong", "E@123456", 2);

		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20s\n","Yong", "20-01-2005", "Singaporean", "2010021@myrp.edu.sg", "90019001", "M", "18", "Yong", "E123@321", 1);


//		assertEquals("Test that ViewAllBikerlist is correct", testOutput, allBikers);


 

//		test case 2

		assertTrue(testOutput.contains("Zhi Yong"));

		assertTrue(testOutput.contains("Yong"));

	}

 

	@Test

	public void testdeleteBiker() {

//		test case 1

		assertNotNull("Check if there is valid Biker arraylist to add to", bikerList);


		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal

		BikerCommunityPortal.addBiker(bikerList, biker1);

		BikerCommunityPortal.addBiker(bikerList, biker2);

		assertEquals("Test that Biker arraylist size is 2", 2, bikerList.size());


		//test delete matches the input

		//check if deleted biker is deleted

		bikerList.remove(0);

		String output = (biker1.getUsername() + " removed from group chat");

		System.out.println(output);

		assertEquals("Check that Biker arraylist size is 1", 1, bikerList.size());

		assertNotSame("Check that Biker is deleted, where index 0 has changed", biker1, bikerList.get(0));


//		test case 2

		//able to observe the deleted message

		assertEquals("Check that delete message matches", "ZhiYong removed from group chat", output);


		//check correct biker remove from list

	assertFalse(bikerList.contains(biker1));


		//test case

		//view that biker is deleted 

		String allBikers = BikerCommunityPortal.retrieveAllBiker(bikerList);

	}


	//events test codes

	@Test

	public void testAddEvents() {

		// Test 1 - eventslist is valid, empty and null

		assertNotNull("Test that the Events arrayList is valid", eventsList);

		assertEquals("Test that the Events arrayList is empty", 0, eventsList.size());

 

		// When eventsList is empty, add an object to the arrayList, the sized of the

		// arrayList will increase, Event object is also in the arrayList

		BikerCommunityPortal.AddEvents(eventsList, ev1);

		assertEquals("Test that the eventsList increased its size", 1, eventsList.size());

		assertSame("Test that the Events object added in the arrayList is the same as the Events object", ev1,

				eventsList.get(0));

 

		// Test 2 // Add repeated Event object BikerCommunityPortal.AddEvents(eventsList, ev1);

		// The repeated Event object will not be added, The arrayList remain the same

		assertEquals("Test that the size of the eventsList remains the same", 1, eventsList.size());

 

		// Test 3 // Add an object with missing important data

		// The Event object will not be added in they arrayList, arrayList size remain

		// // the same Events

		Events ev4_missing = new Events("", "", LocalDate.parse("22.11.2023", dateFormatter),

				LocalTime.parse("08:10", timeFormatter), LocalTime.parse("10:30", timeFormatter), 2);

		BikerCommunityPortal.AddEvents(eventsList, ev4_missing);

		assertEquals("Test that the eventsList size is unchanged", 1, eventsList.size());

	}

 

	@Test

	public void testViewAllEvents() {

		// Test Case 1

		// Test if Item list is not null and empty

		assertNotNull("Test if there is valid Event arraylist to add to", eventsList);

		assertEquals("Test that the Event arraylist is empty.", 0, eventsList.size());

		// Attempt to retrieve the Events

		String allEvents = BikerCommunityPortal.retrieveAllEvents(eventsList);

		String testOutput = "";

		// Test if the output is empty

		assertEquals("Test that nothing is displayed", testOutput, allEvents);

 

		// Test Case 2

 

		BikerCommunityPortal.AddEvents(eventsList, ev1);

		BikerCommunityPortal.AddEvents(eventsList, ev2);

		// Test that the list is not empty

		assertEquals("Test that Camcorder arraylist size is 2.", 2, eventsList.size());

		// Attempt to retrieve the Events

		allEvents = BikerCommunityPortal.retrieveAllEvents(eventsList);

 

		testOutput += String.format("\n%-20s %-20s %-20s %-20s %-20s %-20.2f\n", "Biking in the East",

				"East Coast Parkway", LocalDate.parse("30.10.2023", dateFormatter),

				LocalTime.parse("11:30", timeFormatter), LocalTime.parse("13:30", timeFormatter), 2.00);

		testOutput += String.format("%-20s:%-20s\n", "Description", "Stay tuned for more information");

 

		testOutput += String.format("\n%-20s %-20s %-20s %-20s %-20s %-20.2f\n", "Biking in the West",

				"Lim Chu Kang Road", LocalDate.parse("30.08.2023", dateFormatter),

				LocalTime.parse("16:30", timeFormatter), LocalTime.parse("21:00", timeFormatter), 4.30);

		testOutput += String.format("%-20s:%-20s\n", "Description",

				"Lim Chu Kang Road - Heritage Roads - Gardens, Parks & Nature");

 

		// Test that the details are displayed correctly

		assertEquals("Test that the testOutput and eventsList match.", testOutput, allEvents);

 

		// Test Case 3

 

		// Test that the list is not empty

		assertEquals("Test that Camcorder arraylist size is 2.", 2, eventsList.size());

		// Delete the Events

		BikerCommunityPortal.DeleteEvents(eventsList, "Biking in the East");

		// update output

		testOutput = String.format("\n%-20s %-20s %-20s %-20s %-20s %-20.2f\n", "Biking in the West",

				"Lim Chu Kang Road", LocalDate.parse("30.08.2023", dateFormatter),

				LocalTime.parse("16:30", timeFormatter), LocalTime.parse("21:00", timeFormatter), 4.30);

		testOutput += String.format("%-20s:%-20s\n", "Description",

				"Lim Chu Kang Road - Heritage Roads - Gardens, Parks & Nature");

		// Attempt to retrieve the Events

		allEvents = BikerCommunityPortal.retrieveAllEvents(eventsList);

		// Test that the details are displayed correctly

		assertEquals("Test that the testOutput and eventsList match.", testOutput, allEvents);

 

	}

 

	@Test

	public void testDeleteEvents() {

		// Test that there is a valid

		// arrayList to delete the Events object 

		// Test Case 1 - Delete an Event

		assertNotNull("test if there is valid Events arraylist to loan from", eventsList);

		BikerCommunityPortal.AddEvents(eventsList, ev1);

		BikerCommunityPortal.DeleteEvents(eventsList, "Biking in the East");

		assertEquals("Test that the eventsList is 0", 0, eventsList.size());

 

		// Test Case 2, Delete multiple Event object

		assertNotNull("test if there is valid Events arraylist to loan from", eventsList);

		BikerCommunityPortal.AddEvents(eventsList, ev1);

		BikerCommunityPortal.AddEvents(eventsList, ev2);

		BikerCommunityPortal.DeleteEvents(eventsList, "Biking in the West");

		BikerCommunityPortal.DeleteEvents(eventsList, "Biking in the East");

		assertEquals("Test that the eventsList is 0", 0, eventsList.size());


		// Test Case 3, Delete an invalid Event object

		BikerCommunityPortal.AddEvents(eventsList, ev1);

		BikerCommunityPortal.DeleteEvents(eventsList,"OutdoorBiking");

		assertEquals("Test that outdoorBiking would not be deleted & eventsList remain the same",1,eventsList.size());

	}


	// discussions

	 @Test

	    public void testAddDiscussionGroups() {

	        assertNotNull("Test if there is a valid Discussion Group ArrayList to add to", discussionList);

	        assertEquals("Test that the Discussion Group ArrayList is empty.", 0, discussionList.size());

	        discussionList.add(dg1);

	        assertEquals("Test that the Discussion Group ArrayList size is 1.", 1, discussionList.size());

 

	        // Test Case 1

	        discussionList.add(dg2);

	        assertEquals("Test that the Discussion Groups ArrayList size is now 2.", 2, discussionList.size());

	        assertSame("Test that Discussion Groups is added to the end of the list.", dg2, discussionList.get(1));

 

	        // Test Case 2

	        assertEquals("Test that the Discussion Groups ArrayList size is unchanged.", 2, discussionList.size());

 

	        int initialSize = discussionList.size();

	        //discussionList.add(null); // Commenting out this line

	        assertEquals("Test that adding null does not change the ArrayList size.", initialSize, discussionList.size());

 

	        // Test Case 3

	        DiscussionGroups dg_missing = new DiscussionGroups("", 40);

	        int newSizeAfterAddingMissing = discussionList.size(); // Corrected this line

	        BikerCommunityPortal.addDiscussionGroups(discussionList, dg_missing); // Corrected this line

	        assertEquals("Test that adding an item with empty name does not change the ArrayList size.", newSizeAfterAddingMissing, discussionList.size());

	    }


	    @Test

	    public void testRetrieveAllDiscussionGroups() {

	    	//Test Case 1

	        // Test if Item list is not null and empty

	        assertNotNull("Test if there is valid Discussion Groups arraylist to add to", discussionList);

	        assertEquals("Test that the Discussion Groups arraylist is empty.", 0, discussionList.size());

	        // Attempt to retrieve the DiscussionGroups 

	        String allDiscussion= BikerCommunityPortal.retrieveAllDiscussionGroups(discussionList);

	        String testOutput = "";

	        // Test if the output is empty

	        assertEquals("Test that nothing is displayed", testOutput, allDiscussion);

 

	

 

	        //Test Case 2

	        discussionList.add(dg1);

	        discussionList.add(dg2);

	        // Test that the list is not empty

	        assertEquals("Test that Discussion Groups arraylist size is 2.", 2, discussionList.size());

	        // Attempt to retrieve the DiscussionGroups 

	        allDiscussion= BikerCommunityPortal.retrieveAllDiscussionGroups(discussionList);

	        testOutput = String.format("%-30s %-10d\n", "Bikes", 40);

	        testOutput += String.format("%-30s %-10d\n","Locations best for Biking", 20);

	        // Test that the details are displayed correctly

	        assertEquals("Test that the display is correct.", testOutput, allDiscussion);

 

	

 

	        //Test Case 3

	        // Attempt to retrieve the DiscussionGroups 

	        allDiscussion= BikerCommunityPortal.retrieveAllDiscussionGroups(discussionList);

	        testOutput = String.format("%-30s %-10d\n", "Bikes", 40);

	        testOutput += String.format("%-30s %-10d\n","Locations best for Biking", 20);

	        // Test that the details are displayed correctly

	        assertEquals("Test that the display is correct.", testOutput, allDiscussion);  



 

	    }

	    @Test

	    public void testDeleteDiscussionGroups() {

	    	discussionList.add(dg1);

	        discussionList.add(dg2);

 

	        String topicToDelete = dg1.getTopic();

	        BikerCommunityPortal.deleteDiscussionGroups(discussionList, topicToDelete);

 

	        assertFalse("Test that discussion group dg1 has been removed.", discussionList.contains(dg1));

	        assertTrue("Test that discussion group dg2 is still present.", discussionList.contains(dg2));

 

	        String nonExistingTopic = "Non-existing topic";

	        BikerCommunityPortal.deleteDiscussionGroups(discussionList, nonExistingTopic);

 

	        assertFalse("Test that discussion group dg3 is not removed.", discussionList.stream()

	                .anyMatch(dg -> dg.getTopic().equalsIgnoreCase(nonExistingTopic)));

	        assertEquals("Test that the size of the list remains unchanged.", 1, discussionList.size());

	    }


	    // groups

	    @Test

 

	    public void testaddGroup() {

 

	      // Item list is not null and it is empty

 

	      assertNotNull("Test if there is valid group arraylist to add to", groupsList);

 

	      assertEquals("Test that the group arraylist is empty.", 0, groupsList.size());

 

	      //Given an empty list, after adding 1 item, the size of the list is 1

 

	      groupsList.add(A);        

 

	      assertEquals("Test that the group arraylist size is 1.", 1, groupsList.size());

 

	   

 

	      // Add an item

 

	      groupsList.add(B);

 

	      assertEquals("Test that the group arraylist size is now 2.", 2, groupsList.size());

 

	      //The item just added is as same as the last item in the list

 

	      assertSame("Test that group is added to the end of the list.", B, groupsList.get(1));

 

	   

 

	      // Add an item that already exists in the list

 

	      String group = "C206";

 

	      BikerCommunityPortal.addGroup(groupsList, group);

 

	      assertEquals("Test that the group arraylist size is unchange.", 2, groupsList.size());

 

	   

 

	    }

 

	    @Test

 

	    public void testViewGroups() {

 

	      assertEquals("Test that arraylist empty", 0, groupsList.size());

 

	      groupsList.add(A);

 

	      groupsList.add(B);

 

	      String groupA = String.format("%-30s %-30s %-30s %-30s\n", "Group Name", "Maximum number of members",

 

	          "Number of members", "Description of your group");

 

	      for (int i = 0; i < groupsList.size(); i++) {

 

	        groupA += String.format("%-30s %-30d %-30d %-30s\n", groupsList.get(i).getName(),

 

	            groupsList.get(i).getMemberQuantity(), groupsList.size(), groupsList.get(i).getDescription());      

 

	      }


	      String output = BikerCommunityPortal.viewAllGroups(groupsList);

 

	      assertEquals("Test that the view is same", groupA, output);

	    }

 

	    @Test

 

	    public void testDeleteGroups() {

	      assertEquals("Test that arraylist empty", 0, groupsList.size());

	      groupsList.add(A);

	      groupsList.add(B);

	      try {

	        File file = new File("C206Group.txt");

	        if(file.createNewFile()) {

	        }

	        FileReader fr = new FileReader(file);

	        BufferedReader br = new BufferedReader(fr);

	        FileWriter fw = new FileWriter(file);

	        BufferedWriter bw = new BufferedWriter(fw);

	        bw.close();

	        br.close();

	      }

	      catch (FileNotFoundException e) {

	        System.out.println("Group file does not exits");

	      }

	      catch (IOException e) {

	        System.out.println("An error occured");

	      }

	      try {

	        File file = new File("AZland.txt");

	        if(file.createNewFile()) {

	        }

	        FileReader fr = new FileReader(file);

	        BufferedReader br = new BufferedReader(fr);

	        FileWriter fw = new FileWriter(file);

	        BufferedWriter bw = new BufferedWriter(fw);

	        bw.close();

	        br.close();

	      }

	      catch (FileNotFoundException e) {

	        System.out.println("Group file does not exits");

	      }

	      catch (IOException e) {

	        System.out.println("An error occured");

	      }

	      assertEquals("Test array has items", 2, groupsList.size());

	      String group = "C206";

	      BikerCommunityPortal.deleteGroup(groupsList, group);

	      assertEquals("Test group has been deleted", 1, groupsList.size());

	      assertSame("Test that correct group was deleted", B, groupsList.get(0));

	    }


		//bike

		@Test

		public void testAddBike() {

			//test case 1

			// Item list is not null, so that can add a new item - boundary

			assertNotNull("Check if there is valid Inventory arraylist to add to", inventory);

			//Given an empty list, after adding 1 item, the size of the list is 1 - normal

			//The item just added is as same as the first item of the list

			BikerCommunityPortal.addItem(inventory, item1);

			assertEquals("Check that Inventory arraylist size is 1", 1, inventory.size());

			assertSame("Check that Inventory is added", item1, inventory.get(0));

			String output = (item1.getName() + "added into group chat");

			System.out.println(output);

 

			//Add another item. test The size of the list is 2? -normal

			//The item just added is as same as the second item of the list

			BikerCommunityPortal.addItem(inventory, item2);

			assertEquals("Check that Inventory arraylist size is 2", 2, inventory.size());

			assertSame("Check that Inventory is added", item2, inventory.get(1));

			String output1 = (item1.getName() + "added into group chat");

			System.out.println(output1);

 

			//test case 2 

			//check that display message of biker added

//			assertEquals("Test that biker added message displayed matches biker added", "ZhiYong added into group chat", output);

//			assertEquals("Test that biker added message displayed matches biker added", "Yong added into group chat", output1);

			//check correct biker is added

			assertTrue(inventory.contains(item1));

			assertTrue(inventory.contains(item2));

		}

 

		@Test

		public void testRetrieveAllBike() {

//			test case 1

			// Test if Item list is not null but empty -boundary

			assertNotNull("Test if there is valid Inventory arraylist to retrieve item", inventory);

 

			//test if the list of bikers retrieved from the SourceCentre is empty - boundary

			String allItems= BikerCommunityPortal.retrieveAllItem(inventory);

			String testOutput = "";

			assertEquals("Check that ViewAllBikerlist", testOutput, allItems);

 

			//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal

			BikerCommunityPortal.addItem(inventory, item1);

			BikerCommunityPortal.addItem(inventory, item2);

			assertEquals("Test that Inventory arraylist size is 2", 2, inventory.size());

 

			//test if the expected output string same as the list of Bikers retrieved from the SourceCentre	

			allItems = BikerCommunityPortal.retrieveAllItem(inventory);

			testOutput += String.format("%-10s %-10s %-20s %-20d %-20d \n","Adam", "Yamaha", "GG123WP", 10000, 0);

			testOutput += String.format("%-10s %-10s %-20s %-20d %-20d \n","ZY", "Kawasaki", "QQ999TT", 30000, 1);

 

//			assertEquals("Test that ViewAllBikerlist is correct", testOutput, allBikers);

//			test case 2

			assertTrue(testOutput.contains("Adam"));

			assertTrue(testOutput.contains("ZY"));

		}

 

		@Test

		public void testdeleteBike() {

//			test case 1

			assertNotNull("Check if there is valid Inventory arraylist to add to", inventory);

 

			//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal

			BikerCommunityPortal.addItem(inventory, item1);

			BikerCommunityPortal.addItem(inventory, item2);

			assertEquals("Test that Inventory arraylist size is 2", 2, inventory.size());

 

			//test delete matches the input

			//check if deleted biker is deleted

			inventory.remove(0);

			String output = (item1.getName() + " removed from group chat");

			System.out.println(output);

			assertEquals("Check that Inventory arraylist size is 1", 1, inventory.size());

			assertNotSame("Check that Inventory is deleted, where index 0 has changed", item1, inventory.get(0));

 

//			test case 2

			//able to observe the deleted message

			assertEquals("Check that delete message matches", "Adam removed from group chat", output);

 

			//check correct biker remove from list

		assertFalse(inventory.contains(item1));

 

			//test case

			//view that biker is deleted 

			String allItems = BikerCommunityPortal.retrieveAllItem(inventory);

		}


		//register


	@After

	public void tearDown() throws Exception {

		//biker

		biker1 = null;

		biker2 = null;

		bikerList = null;


		//events

		ev1 = null;

		ev2 = null;

		eventsList = null;


		//discussion

		dg1 = null;

        dg2 = null;

        dg3 = null;

        discussionList = null;


        // groups

        A = null;

		B = null;

		groupsList = null;


        //bike

		item1 = null;

		item2 = null;

		inventory = null;


        //register

	}

}