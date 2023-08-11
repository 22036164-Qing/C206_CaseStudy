import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EventsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Events> eventsList = new ArrayList<Events>();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

		eventsList.add(
				new Events("Biking in the East", "East Coast Parkway", LocalDate.parse("30.10.2023", dateFormatter),
						LocalTime.parse("11:30", timeFormatter), LocalTime.parse("13:30", timeFormatter), 2));
		eventsList
				.add(new Events("Biking in the West", "Lim Chu Kang Road", LocalDate.parse("30.08.2023", dateFormatter),
						LocalTime.parse("16:30", timeFormatter), LocalTime.parse("21:00", timeFormatter), 4.30,
						"Lim Chu Kang Road - Heritage Roads - Gardens, Parks & Nature"));

		// --- User Side Event ---
		int option = 0;
		while (option != 4) {
			menu();
			option = Helper.readInt("Enter option > ");
			if (option == 1) {
				EventsMain.viewAllEvents(eventsList);
				EventsMain.viewSpecificEvents(eventsList);// View events + view events by search
			} else if (option == 2) {
				Events ev = inputEvents();
				EventsMain.AddEvents(eventsList, ev); // Add events
			} else if (option == 3) {
				Events ev = 
				EventsMain.DeleteEvents(eventsList, ev); // search for event to be deleted
				// EventsMain.displayDeleteEvents //display events
			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
	}

	public static void menu() {
		System.out.println("Users Event Menu");
		Helper.line(50, "=");
		System.out.println("1. View Events");
		System.out.println("2. Add Event");
		System.out.println("3. Delete Event");
		System.out.println("4. Quit");
		Helper.line(50, "=");
	}

	public static String viewAllEvents(ArrayList<Events> eventsList) {
		Helper.line(200, "-");
		String Events = String.format("\n%-20s %-20s %-20s %-20s %-20s %-20s\n", "Event Name", "Event Venue",
				"Date of Event", "Start Time", "End Time", "Duration");

		for (int i = 0; i < eventsList.size(); i++) {
			String localdate = eventsList.get(i).getDate().toString();
			String starttime = eventsList.get(i).getStartTime().toString();
			String endtime = eventsList.get(i).getEndTime().toString();

			Events += String.format("\n%-20s %-20s %-20s %-20s %-20s %-20.2f\n", eventsList.get(i).getEventName(),
					eventsList.get(i).getPlace(), localdate, starttime, endtime, eventsList.get(i).getDuration());
			Events += String.format("%-20s:%-20s\n", "Description", eventsList.get(i).getInformation());
		}
		System.out.println(Events);
		System.out.println("See txt file for event");
		Helper.line(200, "-");

		try {
			File file = new File("Events.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(Events);
			bw.close();
		} catch (IOException e) {
			System.out.println("An error occured");

		}

		char optionFind = Helper.readChar("Do you want to find a specific event(Y/N) ? > ");
		if (optionFind == 'y' || optionFind == 'Y') {
			EventsMain.viewSpecificEvents(eventsList);
		} else if (optionFind == 'N' || optionFind == 'n') {
			System.out.println("Go back to menu()");
		}
		return Events;

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


	public static void DeleteEvents(ArrayList<Events> eventsList, Events ev) {
		String deleteEvents = Helper.readString("What event do you wish to delete ? > ");
		for (int i = 0; i < eventsList.size(); i++) {
			if (deleteEvents.contains(eventsList.get(i).getEventName())) {
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

}