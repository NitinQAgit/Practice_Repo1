
// LAUNCH BROWSER APPROACH 1  - THIS IS THE BEST APPROACH TO RUN AND OPEN BROWSER IN COMPANIES
package mavenLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Practice_MavenLibrary1 {

	public static WebDriver driver;
	
	
	// THIS IS THE BEST APPROACH TO RUN AND OPEN BROWSER IN COMPANIES
	
	public void launchUrl(String browser) throws InterruptedException {
		
		System.out.println("Launching browser: " + browser);  // Debugging log
		

	    ChromeOptions chromeOptions = new ChromeOptions();                 // Chrome Options
	    chromeOptions.setAcceptInsecureCerts(true);
	    chromeOptions.addArguments("--incognito");
	    chromeOptions.addArguments("--maximize");


	    FirefoxOptions firefoxOptions = new FirefoxOptions();               // Firefox Options
	    firefoxOptions.setAcceptInsecureCerts(true);
	    firefoxOptions.addArguments("-private");                            // Firefox equivalent of incognito
	    firefoxOptions.addArguments("--width=1920", "--height=1080");       // For maximizing Firefox window (alternative)


	    EdgeOptions edgeOptions = new EdgeOptions();                   	    // Edge Options
	    edgeOptions.setAcceptInsecureCerts(true);
	    edgeOptions.addArguments("-inprivate");                             // Edge equivalent of incognito
	    edgeOptions.addArguments("--start-maximized");                      // For maximizing Edge window

	    WebDriver driver;                                                //if this code isn't working,try by removing this

	    // Choose browser based on the condition
	    if (browser.equalsIgnoreCase("chrome")) {
	        driver = new ChromeDriver(chromeOptions);   }                    // Apply Chrome options
	   
	       else if (browser.equalsIgnoreCase("firefox")) {
	        driver = new FirefoxDriver(firefoxOptions);    }                 // Apply Firefox options
	    
	       else if (browser.equalsIgnoreCase("edge")) {
	        driver = new EdgeDriver(edgeOptions); }                          // Apply Edge options
	   
	       else {
	        throw new IllegalArgumentException("Unsupported browser: " + browser);  // Handle unsupported browsers
	                  }

	    driver.get("http://flipkart.com");                                           // Open the URL
	}
}
