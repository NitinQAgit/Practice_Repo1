
// OPTION 3- TRADITIONAL APPROACH USED BELOW SELENIUM V3   THIS LAUNCH URL METHOD WAS USED IN OLDER VERSION BEFORE SELENIUM 3 VERSION

package mavenLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practice_MavenLibrary3 {
	

	// OPTION 3-    THIS LAUNCH URL METHOD WAS USED IN OLDER VERSION BEFORE SELENIUM 3 VERSION
	 	
		
	 public static WebDriver driver;
	 public void launchUrl(String browser) throws InterruptedException {
		
		System.out.println("Launching browser: " + browser);  // Debugging log
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			String path = "C:\\Users\\Bhavna sharma\\eclipse-workspace\\Practice_Project1\\my_webdriver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);              //To Know Selenium, where the ChromeDriver is located
			driver = new ChromeDriver();    }                                  //created object to open the chrome driver window
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			String path = "C:\\Users\\Bhavna sharma\\eclipse-workspace\\Practice_Project1\\my_webdriver\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path);              //To Know Selenium, where the firefoxDriver is located
			driver = new FirefoxDriver();    }                                  //created object to open the firefox driver window
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			String path = "C:\\Users\\Bhavna sharma\\eclipse-workspace\\Practice_Project1\\my_webdriver\\msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", path);              //To Know Selenium, where the edgeDriver is located
			driver = new EdgeDriver();    }                                  //created object to open the edge driver window
		
	    driver.get("https://testingbaba.com/old/");  // Open the URL
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //implicitly wait for web page launch
		driver.manage().window().maximize();
	 }
}
