
//Draggable tests class for checking the drag feature

package tests_for_interactions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mavenLibrary.MavenLibrary;
import pages_for_interactions.DraggablePage;

public class DraggableTests extends MavenLibrary {
	pages_for_interactions.DraggablePage ob;

	@BeforeTest(groups = {"smoke" ,"sanity"  , "regression"})
	@Parameters("browser")            // Parameters from the testng.xml file, like browser name
	public void launchurl(String browser) throws InterruptedException {
		 System.out.println("Launching browser: " + browser);  // Debugging log
		launchUrl(browser);
		ob = new DraggablePage();   // Instantiate the DraggablePage object to interact with elements on the page
	}

	@Test(priority = 1, groups = {"smoke" ,"sanity"  , "regression"})
	public void clickoninteractions() {
		ob.clickOnInteractions();
	}

	@Test(priority = 2, groups = {"regression"})
	public void clickondraggableoption() {
		ob.clickOnDraggableoption();
	}

	@Test(priority = 3, groups = {"regression"} ,enabled=false)
	public void draggablecursor() {
		ob.dragCursor();
  }
	
	@Test(priority = 4, groups = {"regression"})
	public void draggablecursorandValidate() {
		System.out.println("chal raha");
		ob.dragCursorAndValidate();
	}
}
