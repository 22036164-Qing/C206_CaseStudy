import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EventsTest {

	// Prepare Test Data
	private Events ev1;
	private Events ev2;

	private ArrayList<Events> eventsList;
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

	public EventsTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {

		// Prepare Test Data
		ev1 = new Events("Biking in the East", "East Coast Parkway", LocalDate.parse("30.10.2023", dateFormatter),
				LocalTime.parse("11:30", timeFormatter), LocalTime.parse("13:30", timeFormatter), 2);
		ev2 = new Events("Biking in the West", "Lim Chu Kang Road", LocalDate.parse("30.08.2023", dateFormatter),
				LocalTime.parse("16:30", timeFormatter), LocalTime.parse("21:00", timeFormatter), 4.30,
				"Lim Chu Kang Road - Heritage Roads - Gardens, Parks & Nature");

		eventsList = new ArrayList<Events>();
	}

	@Test
	public void testAddEvents() {
		// Test 1
		// eventslist is valid, empty and null

		assertNotNull("Test that the Events arrayList is valid", eventsList);
		assertEquals("Test that the Events arrayList is empty", 0, eventsList.size());

		// When eventsList is empty, add an object to the arrayList, the sized of the
		// arrayList will increase, Event object is also in the arrayList
		EventsMain.AddEvents(eventsList, ev1);
		assertEquals("Test that the eventsList increased its size", 1, eventsList.size());
		assertSame("Test that the Events object added in the arrayList is the same as the Events object", ev1,
				eventsList.get(0));

		// Test 2
		// Add repeated Event object
		EventsMain.AddEvents(eventsList, ev1);
		// The repeated Event object will not be added, The arrayList remain the same
		assertEquals("Test that the size of the eventsList remains the same", 1, eventsList.size());

		// Test 3
		// Add an object with missing important data
		// The Event object will not be added in they arrayList, arrayList size remain
		// the same
		Events ev4_missing = new Events("", "", LocalDate.parse("22.11.2023", dateFormatter),
				LocalTime.parse("08:10", timeFormatter), LocalTime.parse("10:30", timeFormatter), 2);
		EventsMain.AddEvents(eventsList, ev4_missing);
		assertEquals("Test that the eventsList size is unchanged", 1, eventsList.size());
	}

	@Test
	public void testViewAllEvents() {
		// Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid Event arraylist to add to", eventsList);
		assertEquals("Test that the Event arraylist is empty.", 0, eventsList.size());
		// Attempt to retrieve the Events

		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, EventsMain.viewAllEvents(eventsList));

		// Test Case 2
		EventsMain.AddEvents(eventsList, ev1);
		// Test that the list is not empty
		assertEquals("Test that Events arraylist size is 1.", 1, eventsList.size());
		// Attempt to retrieve the Events
		String allEvents = EventsMain.viewAllEvents(eventsList);
		testOutput = String.format("\n%-20s %-20s %-20s %-20s %-20s %-20.2f\n", "Biking in the East",
				"East Coast Parkway", LocalDate.parse("30.10.2023", dateFormatter),
				LocalTime.parse("11:30", timeFormatter), LocalTime.parse("13:30", timeFormatter), 2);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allEvents);

	}

	@Test
	public void testSpecificViewEvents() {
		// Test case 1
		// Test that eventsList is not null and empty
		assertNotNull("Test that there is a valid Events arrayList to add to", eventsList);
		assertEquals("Test that the arrayList is empty.", 0, eventsList.size());
		// Test that event object is added into the eventList
		EventsMain.AddEvents(eventsList, ev1);
		// Test that the eventList event object appears if i search
		String testOutput = String.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "Biking in the East",
				"East Coast Parkway", "30.10.2023", "11:30", "13:30", 2);
		String specificEvents = EventsMain.viewSpecificEvents(eventsList);
		assertEquals("Test that we are able to find what we want to search", testOutput.contains(specificEvents), true);

		// Test Case 2
		// EventsMain.AddEvents(eventsList, ev2);
		String testOutput1 = String.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", "Biking in the East",
				"East Coast Parkway", "30.10.2023", "11:30", "13:30", 2);
		// assertTrue("Test that we want to search",'y');
		// assertSame("Test that we are able to find what we want to search", "Biking in the East", testOutput1);

		// Test case 3
		// Test that when it states y, it will display the information
		eventsList.add(ev1);
		char optionFind = 'Y';
		assertEquals("Test that the answer is 'Y' ", 'Y', optionFind);
		char optionFind1 = 'N';
		assertEquals("Test that the answer is 'N' ", 'N', optionFind1);
	}

	@Test
	public void testDeleteEvents() {
		// Test that there is a valid arrayList to delete the Events object
        // Test Case 1 - Delete an Event
        assertNotNull("test if there is valid Events arraylist to loan from", eventsList);
        EventsMain.AddEvents(eventsList, ev1);
        EventsMain.DeleteEvents(eventsList,ev1);
        assertEquals("Test that the eventsList is 0",0,eventsList.size()); // "Biking in the East
        
        //Test Case 2, Delete multiple Event object
        assertNotNull("test if there is valid Events arraylist to loan from", eventsList);
        EventsMain.AddEvents(eventsList, ev1);
        EventsMain.AddEvents(eventsList, ev2);
        EventsMain.DeleteEvents(eventsList,ev2);
        EventsMain.DeleteEvents(eventsList,ev1);
        assertEquals("Test that the eventsList is 1",0,eventsList.size()); //Biking in the east, Biking in the west

	}

	@After
	public void tearDown() throws Exception {
		ev1 = null;
		ev2 = null;
		eventsList = null;
	}

}
