
//Droppable tests class for checking the drag & drop feature

package tests_for_interactions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mavenLibrary.MavenLibrary;
import pages_for_interactions.DroppablePage;

public class DroppableTests extends MavenLibrary {
	pages_for_interactions.DroppablePage ob;

    @BeforeTest                     // BeforeTest method runs before any tests, to initialize browser and page object
    @Parameters("browser")          // Parameters from the testng.xml file, like browser name
	public void launchurl(String browser) throws InterruptedException {
    	System.out.println("Launching browser: " + browser);  // Debugging log
		launchUrl(browser);
		ob = new DroppablePage();    //// Instantiate the DroppablePage object to interact with elements on the page
	}

	@Test(priority = 1)
	public void clickoninteractions() {
		ob.clickOnInteractions();
	}

	@Test(priority = 2)
	public void clickondroppableoption() {
		ob.clickOnDroppableOption();
	}

	@Test(priority = 3,enabled=false)
	public void droppableelement() {
		ob.dropElement();
    }
	
	@Test(priority = 4)
	public void droppableelementwithvalidation() {
		ob.dropElementAndValidate();
	}
}