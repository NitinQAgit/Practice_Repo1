
//Application Utility For common actions

package applicationUtility;

import org.openqa.selenium.WebElement;

public interface ApplicationUtility {
   
	public void doubleClickOnElement(WebElement ele);
	public void rightClickOnElement(WebElement ele);
	public void clickOnElement(WebElement ele);
	public void changeWindow(int tab_no);
	public void fileuploading(String Filepath);
	
	public void close();
	public void quit();
	
	public boolean isEnabled_Disabled(WebElement ele);
	
	public void selectbyText(WebElement ele, String text);
	public void selectbyIndex(WebElement ele, int index);
	public void selectbyValue(WebElement ele, String value);
	
	public void mouseHover(WebElement ele); 
	public void mouseHoverForToolTip(WebElement ele); 
	
	public int getResponseCodeForRequest(String url);
		
	
}
