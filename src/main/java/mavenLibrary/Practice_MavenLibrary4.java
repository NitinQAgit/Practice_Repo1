
// OPTION 4-    THIS IS THE APPROACH WE USED IN AND AFTER SELENIUM 3 VERSION
package mavenLibrary;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice_MavenLibrary4 {
	
// OPTION 4-    THIS IS THE APPROACH WE USED IN SELENIUM 3 VERSION


 public static WebDriver driver;
 public void launchUrl(String browser) throws InterruptedException {
	
		System.out.println("Launching browser: " + browser);  // Debugging log
	
	if (browser.equalsIgnoreCase("chrome")) {
	    WebDriverManager.chromedriver().setup();          // Automatically handles Chrome driver setup
	    driver = new ChromeDriver();                      // ChromeDriver initialization
	    
	} else if (browser.equalsIgnoreCase("firefox")) {
	    WebDriverManager.firefoxdriver().setup();         // Automatically handles Firefox driver setup
	    driver = new FirefoxDriver();                     // FirefoxDriver initialization
	    
	} else if (browser.equalsIgnoreCase("edge")) {
	    WebDriverManager.edgedriver().setup();             // Automatically handles Edge driver setup
	    driver = new EdgeDriver();                         // EdgeDriver initialization
	}
		driver.get("https://testingbaba.com/old/");        // Open the URL
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //implicitly wait for web page launch
		driver.manage().window().maximize();

}}