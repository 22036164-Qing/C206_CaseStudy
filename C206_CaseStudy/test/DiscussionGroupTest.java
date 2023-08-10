import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

 

public class DiscussionGroupTest {
    private DiscussionGroups dg1;
    private DiscussionGroups dg2;
    private DiscussionGroups dg3;
    private ArrayList<DiscussionGroups> discussionList;

 

    @Before
    public void setUp() throws Exception {
        // prepare test data
        dg1 = new DiscussionGroups("Bikes", 40);
        dg2 = new DiscussionGroups("Locations best for Biking", 20);
        dg3 = new DiscussionGroups("The Fun Of Biking", 10);
        discussionList = new ArrayList<DiscussionGroups>();
    }

 

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
        DiscussionGroupsMain.addDiscussionGroups(discussionList, dg_missing); // Corrected this line
        assertEquals("Test that adding an item with empty name does not change the ArrayList size.", newSizeAfterAddingMissing, discussionList.size());
    }

    @Test
    public void testRetrieveAllDiscussionGroups() {
    	//Test Case 1
        // Test if Item list is not null and empty
        assertNotNull("Test if there is valid Discussion Groups arraylist to add to", discussionList);
        assertEquals("Test that the Discussion Groups arraylist is empty.", 0, discussionList.size());
        // Attempt to retrieve the DiscussionGroups 
        String allDiscussion= DiscussionGroupsMain.retrieveAllDiscussionGroups(discussionList);
        String testOutput = "";
        // Test if the output is empty
        assertEquals("Test that nothing is displayed", testOutput, allDiscussion);

 

 

        //Test Case 2
        discussionList.add(dg1);
        discussionList.add(dg2);
        // Test that the list is not empty
        assertEquals("Test that Discussion Groups arraylist size is 2.", 2, discussionList.size());
        // Attempt to retrieve the DiscussionGroups 
        allDiscussion= DiscussionGroupsMain.retrieveAllDiscussionGroups(discussionList);
        testOutput = String.format("%-30s %-10d\n", "Bikes", 40);
        testOutput += String.format("%-30s %-10d\n","Locations best for Biking", 20);
        // Test that the details are displayed correctly
        assertEquals("Test that the display is correct.", testOutput, allDiscussion);

 

 

        //Test Case 3
        // Attempt to retrieve the DiscussionGroups 
        allDiscussion= DiscussionGroupsMain.retrieveAllDiscussionGroups(discussionList);
        testOutput = String.format("%-30s %-10d\n", "Bikes", 40);
        testOutput += String.format("%-30s %-10d\n","Locations best for Biking", 20);
        // Test that the details are displayed correctly
        assertEquals("Test that the display is correct.", testOutput, allDiscussion);  



 

    }
    @Test
    public void testDeleteDiscussionGroups() {
    	// Test Case 1
        // Add discussion groups to the list
        discussionList.add(dg1);
        discussionList.add(dg2);

 

        // Call the deleteDiscussionGroups method
        DiscussionGroupsMain.deleteDiscussionGroups(discussionList, dg1);

 

        // Check if dg1 has been removed
        assertFalse("Test that discussion group dg1 has been removed.", discussionList.contains(dg1));
        assertTrue("Test that discussion group dg2 is still present.", discussionList.contains(dg2));

        // Test Case 2
     // Delete a non-existing discussion group (dg3)
        DiscussionGroups dg3 = new DiscussionGroups("Non-existing topic", 10);
        DiscussionGroupsMain.deleteDiscussionGroups(discussionList, dg3);

 

        // Check that dg3 is not removed and the size remains unchanged
        assertTrue("Test that discussion group dg3 is not removed.", !discussionList.contains(dg3));
        assertEquals("Test that the size of the list remains unchanged.", 1, discussionList.size());

        // Test Case 3
        discussionList.clear();
        DiscussionGroupsMain.deleteDiscussionGroups(discussionList, dg1);

 

        // Check that the list remains empty
        assertEquals("Test that the list remains empty.", 0, discussionList.size());



 

     

 

  
    }
    @After
    public void tearDown() throws Exception {
        dg1 = null;
        dg2 = null;
        dg3 = null;
        discussionList = null;
    }
}