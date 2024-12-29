
// OPTION 5-    THIS IS THE LATEST APPROACH WE USED FOR LAUNCH URL IN SELENIUM 4 VERSION
package mavenLibrary;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Practice_MavenLibrary5 {
	

// OPTION 5-    THIS IS THE LATEST APPROACH WE USED FOR LAUNCH URL IN SELENIUM 4 VERSION
	

	public static WebDriver driver;
	public void launchUrl(String browser) throws InterruptedException {
		
	System.out.println("Launching browser: " + browser);           // Debugging log
    
	if (browser.equalsIgnoreCase("chrome")) {
        driver = new ChromeDriver();                               // Open Chrome browser
        
    } else if (browser.equalsIgnoreCase("firefox")) {
        driver = new FirefoxDriver();                              // Open Firefox browser
        
    } else if (browser.equalsIgnoreCase("edge")) {
        driver = new EdgeDriver();                                  // Open Edge browser
        
    } else {
        throw new IllegalArgumentException("Unsupported browser: " + browser);  // Handle unsupported browsers
    }
    
    driver.get("https://testingbaba.com/old/");                      // Open the URL
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     //implicitly wait for web page launch
	driver.manage().window().maximize();
	}}




