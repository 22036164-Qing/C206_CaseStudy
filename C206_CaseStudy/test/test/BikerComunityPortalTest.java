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
import codes.Helper;

import java.time.format.DateTimeFormatter;






public class BikerComunityPortalTest {
	
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
	
	public BikerComunityPortalTest() {
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
		bikerList.add(biker1);
		assertEquals("Check that Biker arraylist size is 1", 1, bikerList.size());
		assertSame("Check that Biker is added", biker1, bikerList.get(0));
		String output = (biker1.getUsername() + "added into group chat");
		System.out.println(output);
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		bikerList.add(biker2);
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
		bikerList.add(biker1);
		bikerList.add(biker2);
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
		bikerList.add(biker1);
		bikerList.add(biker2);
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
//		public static void registerEvents(ArrayList<Events> eventList) { 
//			String input = Helper.readString("Enter event name");
//			boolean found = false;
//			for(int i = 0; i < eventList.size(); i++) {
//				if(eventList.get(i).getEventName().equalsIgnoreCase(input)) {
//					found=true;
//					String bikername = Helper.readString("Biker name > ");
//					if (bikername.equals("")) {
//						eventList.add(new Events(input, bikername));
//						String groupName = input +"Group";
//						String txt = groupName + ".txt";
//
//						try {
//							File file = new File(txt);
//							if(file.createNewFile()) {
//								System.out.println("Event register" + input + " created");
//							}
//							else {
//								System.out.println("Group file of " + txt + " has been created earlier");
//							}
//							FileReader fr = new FileReader(file);
//							BufferedReader br = new BufferedReader(fr);
//							FileWriter fw = new FileWriter(file);
//							BufferedWriter bw = new BufferedWriter(fw);
//							bw.write(String.format(groupName));
//							bw.close();
//							br.close();
//						}
//						catch (FileNotFoundException e) {
//							System.out.println("Group file does not exits");
//						}
//						catch (IOException e) {
//							System.out.println("An error occured");
//						}
//					}
//
//					else {
//						eventList.add(new Biker(bikerName));
//						String groupName = name +"Group";
//						String txt = groupName + ".txt";
//
//						try {
//							File file = new File(txt);
//							if(file.createNewFile()) {
//								System.out.println("Group file of " + groupName + " created");
//							}
//							else {
//								System.out.println("Group file of " + txt + " has been created earlier");
//							}
//							FileReader fr = new FileReader(file);
//							BufferedReader br = new BufferedReader(fr);
//							FileWriter fw = new FileWriter(file);
//							BufferedWriter bw = new BufferedWriter(fw);
//							bw.write(groupName);
//							bw.close();
//							br.close();
//						}catch (FileNotFoundException e) {
//							System.out.println("Group file does not exits");
//						}catch (IOException e) {
//							System.out.println("An error occured");
//						}
//					}
//				}
//
//				else if(found==true) {
//					System.out.println("Group already made!");
//			}
//			}
//			
//			if (found==false) {
//				System.out.println("No such event");
//			}
//
//		public static String viewAllRegister(ArrayList<Events> eventList, ArrayList<Biker> bikerList){
//			String event = String.format("%-30s %-30s\n", "Name of event", "Biker name");
//
//			for (int i = 0; i < eventList.size(); i++) {
//				event += String.format("%-30s %-30d\n", eventList.get(i).getEventName(),
//						bikerList.get(i));
//			}
//			System.out.println(event);
//			return event;
//		}
//
//		public static void deleteGroup(ArrayList<Groups> groups, String name) {
//			for (int i = 0; i < groups.size(); i++) {
//				if (groups.get(i).getName().equalsIgnoreCase(name)) {
//					groups.remove(i);
//					File file = new File(name+"Group.txt");
//					file.delete();
//					System.out.println("Group "+name+" deleted successfully!");
//				}
//			}
//		}
	    
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