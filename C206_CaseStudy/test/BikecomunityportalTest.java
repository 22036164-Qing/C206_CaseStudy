import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
public class BikecomunityportalTest {

 

	private Biker biker1;

	private Biker biker2;


	private ArrayList<Biker> bikerList;


	public BikecomunityportalTest() {

		super();

	}


	@Before

	public void setUp() throws Exception {

		// prepare test data

		biker1 = new Biker("Zhi Yong", "20-01-2004 ", "Singaporean", "22010029@myrp.edu.sg", 90009000, 'M', 19, "ZhiYong", "E@123456", 2);

		biker2 = new Biker("Yong", "20-01-2005 ", "Singaporean", "22010021@myrp.edu.sg", 90019001, 'M', 18, "Yong", "E123@321", 1);


		bikerList= new ArrayList<Biker>();

	}

 

	

	@Test

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

		String output1 = (biker1.getUsername() + "added into group chat");

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

		BikerCommunityPortal.deleteBiker(bikerList, biker1);

		String output = (biker1.getUsername() + " removed from group chat");

		System.out.println(output);

//		assertEquals("Check that Biker arraylist size is 1", 1, bikerList.size());

//		assertNotSame("Check that Biker is deleted, where index 0 has changed", biker1, bikerList.get(0));


//		test case 2

		//able to observe the deleted message

//		assertEquals("Check that delete message matches", "ZhiYong removed from group chat", output)


		//check correct biker remove from list

//		assertFalse(bikerList.contains(biker1));


		//test case

		//view that biker is deleted 

		String allBikers = BikerCommunityPortal.retrieveAllBiker(bikerList);

	}


	@After

	public void tearDown() throws Exception {

		biker1 = null;

		biker2 = null;

		bikerList = null;

	}

}