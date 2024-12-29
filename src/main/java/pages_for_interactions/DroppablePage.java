

//DroppablePage class for checking the draag and drop feature

package pages_for_interactions;
import org.openqa.selenium.Rectangle; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mavenLibrary.MavenLibrary;

public class DroppablePage extends MavenLibrary {

//Constructor - Initializes the page elements.
	public DroppablePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-target='#interations']")
	private WebElement interactionsButton;

	@FindBy(xpath = "//a[text()='droppable']")
	private WebElement droppableOption;
	
	@FindBy(xpath = "//iframe[@src='drop.html']")
	private WebElement dropFrame;
	
	@FindBy(xpath = "//img[@id='drag1']")
	private WebElement dragElement;
	
	@FindBy(xpath = "//div[@id='div1']")
	private WebElement dropTarget;
	

	
	public void clickOnInteractions() {
		waitforClick(interactionsButton);
		interactionsButton.click();
	}
	
	public void clickOnDroppableOption() {
		waitforClick(droppableOption);
		droppableOption.click();
	}
	
	public void dropElement() {

		try {
            driver.switchTo().frame(dropFrame);
            
            Actions act = new Actions(driver);                                // Initialize Actions class
            waitforClick(dragElement);
            act.dragAndDrop(dragElement, dropTarget).build().perform();       // Perform drag-and-drop action
            
	        driver.switchTo().defaultContent();              }
		
		catch (Exception e)  {	
		
            System.err.println("Error:Drag and drop feature is unsuccessful.");
            e.printStackTrace();
              } 		
	}

	
	public void dropElementAndValidate() {
	    try {
	        driver.switchTo().frame(dropFrame);                                // Switch to iframe

	        // Get the initial bounding rectangle of the drop target
	        Rectangle dropTargetBounds = dropTarget.getRect();
	        
	        // Get X, Y, width, and height of drop target
	        int dropTargetX = dropTargetBounds.getX();
	        int dropTargetY = dropTargetBounds.getY();
	        int dropTargetWidth = dropTargetBounds.getWidth();
	        int dropTargetHeight = dropTargetBounds.getHeight();
	        
	        // Print the drop target dimensions
	        System.out.println("Drop Target X is: " + dropTargetX);
	        System.out.println("Drop Target Y is: " + dropTargetY);
	        System.out.println("Drop Target Width is: " + dropTargetWidth);
	        System.out.println("Drop Target Height is: " + dropTargetHeight);

	        Actions act = new Actions(driver);                                   // Perform drag-and-drop action
	        waitforClick(dragElement);
	        act.dragAndDrop(dragElement, dropTarget).build().perform();

	        // Get the final position of the drag element after drop
	        Rectangle dragElementBounds = dragElement.getRect();
	        
	        // Get X, Y, width, and height of drag element
	        int dragElementX = dragElementBounds.getX();
	        int dragElementY = dragElementBounds.getY();
	        int dragElementWidth = dragElementBounds.getWidth();
	        int dragElementHeight = dragElementBounds.getHeight();
	        
	        // Print the drag element dimensions
	        System.out.println("Drag Element X is: " + dragElementX);
	        System.out.println("Drag Element Y is: " + dragElementY);
	        System.out.println("Drag Element Width is: " + dragElementWidth);
	        System.out.println("Drag Element Height is: " + dragElementHeight);

	        // Check if the drag element is inside the drop target's bounding box
	        if (dragElementX >= dropTargetX && dragElementX <= dropTargetX + dropTargetWidth &&
	            dragElementY >= dropTargetY && dragElementY <= dropTargetY + dropTargetHeight) 
	        {
	            System.out.println("The drag element is correctly dropped within the drop target.");
	        }
	        else {
	            System.out.println("The drag element is outside the drop target.");
	        }

	        driver.switchTo().defaultContent(); 

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
