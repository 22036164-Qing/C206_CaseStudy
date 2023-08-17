package codes;

 

 

 

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

						int optbiker = 0;

						while(optbiker !=3) {

							menuThird();

							int menu3 = Helper.readInt("Option > ");

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

				int optdiscussion = 0;

				while (optdiscussion != 4) {

					menuDiscussion();

					int discussion = Helper.readInt("Option > ");

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

				int optgrp = 0;

				while (optgrp != 4) {

					menuGroups();

					int groupopt = Helper.readInt("Option > ");

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

				int optevent = 0;

				while (optevent != 7) {

					menuEvent();

					int eventopt = Helper.readInt("Option > ");

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

				int optbike = 0;

				while (optbike != 4) {

					menu5();

					int bikeopt = Helper.readInt("Enter an option > ");

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

		System.out.println("3. Back to user menu");

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

 

 

 

	public static String viewAllGroups(ArrayList<Groups> groups){

		String groupA = String.format("%-30s %-30s %-30s %-30s\n", "Group Name", "Maximum number of members",

				"Number of members", "Description of your group");

 

 

 

		for (int i = 0; i < groups.size(); i++) {

			groupA += String.format("%-30s %-30d %-30d %-30s\n", groups.get(i).getName(),

					groups.get(i).getMemberQuantity(), groups.size(), groups.get(i).getDescription());

		}

		System.out.println(groupA);

		return groupA;

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

					file.createNewFile();

					FileReader fr = new FileReader(file);

					BufferedReader br = new BufferedReader(fr);

					FileWriter fw = new FileWriter(file);

					BufferedWriter bw = new BufferedWriter(fw);

					bw.write(String.format(user));

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

					br.close();

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

					br.close();

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

 