import static org.junit.Assert.*;

 

 

import java.util.ArrayList;

 

 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 

 

import codes.Inventory;
import codes.InventoryMain;


 

public class BikeInventoryTest {

 

 

	private Inventory item1;
	private Inventory item2;

 

	private ArrayList<Inventory> inventory;

 

	public BikeInventoryTest() {
		super();
	}

 

	@Before
	public void setUp() throws Exception {
		// prepare test data
		item1 = new Inventory("Adam", "Yamaha", "GG123WP", 10000, 0);
		item2 = new Inventory("ZY", "Kawasaki", "QQ999TT", 30000, 1);
		inventory= new ArrayList<Inventory>();
	}

 

 

	
	@Test
	public void testAddBiker() {
		//test case 1
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Inventory arraylist to add to", inventory);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		InventoryMain.addItem(inventory, item1);
		assertEquals("Check that Inventory arraylist size is 1", 1, inventory.size());
		assertSame("Check that Inventory is added", item1, inventory.get(0));
		String output = (item1.getName() + "added into group chat");
		System.out.println(output);

 

		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		InventoryMain.addItem(inventory, item2);
		assertEquals("Check that Inventory arraylist size is 2", 2, inventory.size());
		assertSame("Check that Inventory is added", item2, inventory.get(1));
		String output1 = (item1.getName() + "added into group chat");
		System.out.println(output1);

 

		//test case 2 
		//check that display message of biker added
//		assertEquals("Test that biker added message displayed matches biker added", "ZhiYong added into group chat", output);
//		assertEquals("Test that biker added message displayed matches biker added", "Yong added into group chat", output1);
		//check correct biker is added
		assertTrue(inventory.contains(item1));
		assertTrue(inventory.contains(item2));
	}

 

	@Test
	public void testRetrieveAllBiker() {
//		test case 1
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Inventory arraylist to retrieve item", inventory);

 

		//test if the list of bikers retrieved from the SourceCentre is empty - boundary
		String allItems= InventoryMain.retrieveAllItem(inventory);
		String testOutput = "";
		assertEquals("Check that ViewAllBikerlist", testOutput, allItems);

 

		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		InventoryMain.addItem(inventory, item1);
		InventoryMain.addItem(inventory, item2);
		assertEquals("Test that Inventory arraylist size is 2", 2, inventory.size());

 

		//test if the expected output string same as the list of Bikers retrieved from the SourceCentre	
		allItems = InventoryMain.retrieveAllItem(inventory);
		testOutput += String.format("%-10s %-10s %-20s %-20d %-20d \n","Adam", "Yamaha", "GG123WP", 10000, 0);
		testOutput += String.format("%-10s %-10s %-20s %-20d %-20d \n","ZY", "Kawasaki", "QQ999TT", 30000, 1);

 

//		assertEquals("Test that ViewAllBikerlist is correct", testOutput, allBikers);

 

 

 

//		test case 2
		assertTrue(testOutput.contains("Adam"));
		assertTrue(testOutput.contains("ZY"));
	}

 

 

	@Test
	public void testdeleteBiker() {
//		test case 1
		assertNotNull("Check if there is valid Inventory arraylist to add to", inventory);

 

		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		InventoryMain.addItem(inventory, item1);
		InventoryMain.addItem(inventory, item2);
		assertEquals("Test that Inventory arraylist size is 2", 2, inventory.size());

 

		//test delete matches the input
		//check if deleted biker is deleted
		inventory.remove(0);
		String output = (item1.getName() + " removed from group chat");
		System.out.println(output);
		assertEquals("Check that Inventory arraylist size is 1", 1, inventory.size());
		assertNotSame("Check that Inventory is deleted, where index 0 has changed", item1, inventory.get(0));

 

//		test case 2
		//able to observe the deleted message
		assertEquals("Check that delete message matches", "Adam removed from group chat", output);

 

		//check correct biker remove from list
	assertFalse(inventory.contains(item1));

 

		//test case
		//view that biker is deleted 
		String allItems = InventoryMain.retrieveAllItem(inventory);
	}

 

	@After
	public void tearDown() throws Exception {
		item1 = null;
		item2 = null;
		inventory = null;
	}
}
