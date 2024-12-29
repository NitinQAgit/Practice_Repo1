

//Sortable tests class for sorting all the list options

package tests_for_interactions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mavenLibrary.MavenLibrary;
import pages_for_interactions.SortablePage;

public class SortableTests extends MavenLibrary {
	pages_for_interactions.SortablePage ob;

    @BeforeTest                     // BeforeTest method runs before any tests, to initialize browser and page object
    @Parameters("browser")          // Parameters from the testng.xml file, like browser name
	public void launchurl(String browser) throws InterruptedException {
    	System.out.println("Launching browser: " + browser);  // Debugging log
		launchUrl(browser);
		ob = new SortablePage();     // Instantiate the SortablePage object to interact with elements on the page
	}

	@Test(priority = 1)
	public void clickoninteractions() {
		ob.clickOnInteractions();
	}
	
	@Test(priority = 2)
	public void clickonsortable() {
		ob.clickOnSortableOption();
	}

	@Test(priority = 3,enabled=true)
	public void sortnamelistusingmap()  {
		ob.sortNameListUsingMap();
	}
	
	@Test(priority = 4,enabled=false)
	public void sortnamelistusingloop()  {
     ob.sortNameListUsingTraditionalForLoop();
	}
	
	@Test(priority = 5,enabled=false)
	public void sortnamelistusingehancedforloop()  {
		ob.sortNameListUsingEnhancedForLoop();
	}
	
	@Test(priority = 6,enabled=false)
	public void sortnamelistbygetetxtmethod()  {
		ob.sortNameListUsingGetText();
	}
	
	@Test(priority = 7,enabled=false)
	public void sortnameandvalidate()  {
		ob.sortNameListAndValidate();
	}
}
