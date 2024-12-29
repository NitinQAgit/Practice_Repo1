

//DraggablePage class for checking the drag feature

package pages_for_interactions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mavenLibrary.MavenLibrary;

public class DraggablePage extends MavenLibrary {

//Constructor - Initializes the page elements.
	public DraggablePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-target='#interations']")
	private WebElement interactionsButton;

	@FindBy(xpath = "//a[text()='draggable']")
	private WebElement draggableOption;

	@FindBy(xpath = "//div[@id='draggable']")
	private WebElement draggableElement;
	
	@FindBy(xpath = "//iframe[@src='dragable.html']")
	private WebElement dragFrame;



	public void clickOnInteractions() {
		waitforClick(interactionsButton);
		interactionsButton.click();
	}

	public void clickOnDraggableoption() {
		waitforClick(draggableOption);
		draggableOption.click();
	}

	public void dragCursor() {

		try {
			
        driver.switchTo().frame(dragFrame);
            Actions act = new Actions(driver);       // Use Actions class to perform drag and drop

            act.dragAndDropBy(draggableElement, 300, 100).perform(); // Drag the element by an offset (e.g., 300 pixels in the X direction, 0 in Y direction)
            driver.switchTo().defaultContent();

        } 
		
		catch (Exception e)
		
		{
        	System.err.println("Error: The thread was interrupted during the sleep or wait time.");
            e.printStackTrace();
        } 	
	}
	
	public void dragCursorAndValidate() {
		
	    try {
	        driver.switchTo().frame(dragFrame);
	        Actions act = new Actions(driver); // Use Actions class to perform drag and drop

	        // Get the initial location of the element
	        int initialX = draggableElement.getLocation().getX();
	        int initialY = draggableElement.getLocation().getY();

	        System.out.println("Initial Length  "+ initialX);
	        System.out.println("Initial Height is   "+ initialY);
	        
	        // Perform drag and drop by an offset (e.g., 300 pixels in the X direction, 100 in Y direction)
	        act.dragAndDropBy(draggableElement, 120, 300).perform();

	        // Get the new location of the element
	        int newX = draggableElement.getLocation().getX();
	        int newY = draggableElement.getLocation().getY();
	        
	        System.out.println("Final Length  "+ newX);
	        System.out.println("Final Height is   "+ newY);

	        // Validate whether the element's position has changed
	     if (newX != initialX && newY != initialY) {
	            System.out.println("Drag operation was successful.");
	        } 
	     
	     else {
	            System.out.println("Drag operation failed.");
	        }

	        driver.switchTo().defaultContent();
	    } 
	    
	    catch (Exception e) {
	        System.err.println("Error: The thread was interrupted during the sleep or wait time.");
	        e.printStackTrace();
	    }
	}
}

