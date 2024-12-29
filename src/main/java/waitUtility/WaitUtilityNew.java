package waitUtility;

import org.openqa.selenium.WebElement;

public interface WaitUtilityNew {
	public void waitforClick(WebElement ele);    //this wait method is used only for click action
	//public void waitforVisibility(WebElement ele,String val);    //this will wait for visibilty and also do send keys fucntionality  
	public void waitforVisibility(WebElement ele);    //this wait method is used only to wait till visibility   
   public void waitForAlert();
}
