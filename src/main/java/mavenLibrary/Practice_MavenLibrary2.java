  
// SAME LIKE FIRST APPROACH BUT ONLY FOR CHROME-THIS IS THE BEST APPROACH TO RUN AND OPEN BROWSER

package mavenLibrary;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;

	public class Practice_MavenLibrary2 {
		
   // THIS IS THE BEST APPROACH TO RUN AND OPEN BROWSER
	  public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();          // Create ChromeOptions object
        options.addArguments("--headless");                   // Add headless argument to run without GUI      
        options.addArguments("--disable-gpu");                // Optionally, you can disable GPU hardware acceleration if needed
        options.addArguments("window-size=1920x1080");    	  // Optional: Set window size (headless mode might default to a small resolution)
        

        WebDriver driver1 = new ChromeDriver(options);    	   // Create a WebDriver instance with ChromeOptions
        driver1.get("https://testingbaba.com/old/");    	   // Navigate to the URL
        
        // Your test operations here
        
        driver1.quit();                                          // Close the browser after operations
    }
	}

