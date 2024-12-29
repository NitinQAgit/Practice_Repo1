
//Library_For_Alert_Windows_Frames with explicit wait 

package mavenLibrary;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import applicationUtility.ApplicationUtility;
import excelutility.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import propertyUtility.PropertyUtility;
import waitUtility.WaitUtilityNew;

public class MavenLibrary   implements ExcelUtility , PropertyUtility , ApplicationUtility, WaitUtilityNew {
	



	// OPTION 1-    THIS LAUNCH URL METHOD WAS USED IN OLDER VERSION BEFORE SELENIUM 3 VERSION
	 	
	/* 	
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
		*/

	
	// OPTION 2-    THIS IS THE APPROACH WE USED IN SELENIUM 3 VERSION
	/*

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
	
	*/
	
	
	
	
	 // OPTION 3-    THIS IS THE LATEST APPROACH WE USED FOR LAUNCH URL IN SELENIUM 4 VERSION
	
	/*
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
	    
	    driver.get("https://testingbaba.com/old/");  // Open the URL
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     //implicitly wait for web page launch
		driver.manage().window().maximize();
	    */
	    
	    
	
	    
   // OPTION 4-    THIS IS THE LATEST AND ACTUAL  APPROACH WE USED FOR LAUNCH URL IN SELENIUM 4 VERSION IN COMPANY
	
		public static WebDriver driver;
		public void launchUrl(String browser) throws InterruptedException {
			
		System.out.println("Launching browser: " + browser);                   // Debugging log   
	    
	    
		
	    ChromeOptions chromeOptions = new ChromeOptions();            // Chrome Options
	    //chromeOptions.setAcceptInsecureCerts(true);
	    //chromeOptions.addArguments("--incognito");
	    chromeOptions.addArguments("--maximize");


	    FirefoxOptions firefoxOptions = new FirefoxOptions();          // Firefox Options
	   // firefoxOptions.setAcceptInsecureCerts(true);
	    //firefoxOptions.addArguments("-private");                     // Firefox equivalent of incognito
	    firefoxOptions.addArguments("--width=1920", "--height=1080");  // For maximizing Firefox window (alternative)

	    
	    EdgeOptions edgeOptions = new EdgeOptions();                    // Edge Options
	    //edgeOptions.setAcceptInsecureCerts(true);
	    //edgeOptions.addArguments("-inprivate");                       // Edge equivalent of incognito
	    edgeOptions.addArguments("--start-maximized");                  // For maximizing Edge window

	   // WebDriver driver;

	    // Choose browser based on the condition
	    if (browser.equalsIgnoreCase("chrome")) {
	        driver = new ChromeDriver(chromeOptions);                   // Apply Chrome options
	        
	    } else if (browser.equalsIgnoreCase("firefox")) {
	        driver = new FirefoxDriver(firefoxOptions);                 // Apply Firefox options
	        
	    } else if (browser.equalsIgnoreCase("edge")) {
	        driver = new EdgeDriver(edgeOptions);                        // Apply Edge options
	        
	    } else {
	        throw new IllegalArgumentException("Unsupported browser: " + browser);  // Handle unsupported browsers
	    }

	    driver.get("https://testingbaba.com/old/");                         // Open the URL
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //implicitly wait for web page launch
		driver.manage().window().maximize();
	
	
		
		
		
		
		
		
		
		
		
		
		WebElement close=driver.findElement(By.xpath("//button[text()='×']"));
		Thread.sleep(2000);
		waitforClick(close);
		close.click();
		//if(close.isDisplayed())
		//{
			//waitforClick(close);
		//}

		driver.findElement(By.xpath("//a[text()='Practice']")).click();
	}

	@Override
	public String getReadData(int sheetNo, int colNo, int rowNo) {
		String val="";
		String path="C:\\Users\\Bhavna sharma\\eclipse-workspace\\Practice_Project1\\testdata\\testdata.xlsx";
		
	try {
		FileInputStream fis=new FileInputStream(path);    //This opens the Excel file (testdata.xlsx) for reading
		XSSFWorkbook wb=new XSSFWorkbook(fis);            // It reads the .xlsx file that was opened by the FileInputStream (fis).
		XSSFSheet sheet=wb.getSheetAt(sheetNo);           //This line gets a specific sheet from the workbook.
		val=sheet.getRow(rowNo).getCell(colNo).getStringCellValue();    // This retrieves the specific cell value from the sheet.
		
	} catch (Exception e) {
		System.out.println("Issue in get read data from excel file "+ e);
	}
	return val;                        //It  returns the value val, which holds the data from the specific cell in the Excel file.
	}

	@Override
	public String getReadData(String key) {
		String value="";
		String path="C:\\Users\\Bhavna sharma\\eclipse-workspace\\Practice_Project1\\testdata\\config.properties";
		
	try {
		FileInputStream fis=new FileInputStream(path);    //This opens the property file (config.properties) for reading
		Properties prop =new Properties();            // It reads the .properties file that was opened by the FileInputStream (fis).
    prop.load(fis);
    value=prop.getProperty(key);
		
	} catch (Exception e) {
		System.out.println("Issue in get read data from property file "+ e);
	}
	return value;
	}

	@Override
	public void doubleClickOnElement(WebElement ele) {
		Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
		
	}

	@Override
	public void rightClickOnElement(WebElement ele) {
		Actions act=new Actions(driver);
		act.contextClick(ele).perform();
	}

	@Override
	public void clickOnElement(WebElement ele) {
		Actions act=new Actions(driver);
		act.click(ele).perform();	
	}

	
	
	@Override
	public void changeWindow(int tabno) {
		
	Set<String> windowhandles = driver.getWindowHandles();                 // Get a Set of window handles.
	List<String> handles = new ArrayList<String>(windowhandles);           // Convert Set to List.
	//handles.addAll(windowhandles); can use this if windowhandles is not passed as parameter in above line
	driver.switchTo().window(handles.get(tabno));                          // Switch to the window/tab based on the given index.
}

	
	@Override
	public void close() {
		driver.close();	
	}

	@Override
	public void quit() {
	driver.quit();	
	}

	@Override
	public void fileuploading(String Filepath) {
	  try {
			
		StringSelection sel=new StringSelection(Filepath);
		Clipboard  clip=Toolkit.getDefaultToolkit().getSystemClipboard();
		clip.setContents(sel, null);
		
		Robot rob=new Robot();
		rob.delay(500);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		//rob.delay(250);
		
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.delay(250);
		rob.keyRelease(KeyEvent.VK_ENTER);
		}
		
	  catch (Exception e) {
		  System.out.println("Issue in uploading file "+ e);
		}
		
	}

	@Override
	public boolean isEnabled_Disabled(WebElement ele) {
	boolean value=ele.isEnabled();
		return value;
	}

	@Override
	public void waitforClick(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		//ele.click();
	}

	@Override
		public void waitforVisibility(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
		//ele.sendKeys(val);
			
	}

	@Override     //How to handle drop down with select class or  select tag by text
	public void selectbyText(WebElement ele, String text) {
		Select sel=new Select(ele);
		sel.selectByVisibleText(text);
		
	    List<WebElement> selectvalue = sel.getOptions();   
	    
	    int numberOfOptions = selectvalue.size();                     //to get the size of the list
	    System.out.println("Number of elements in the dropdown: " + numberOfOptions);
	    
	    //if you are selecting one of from the list and want to print it too you can use these lines
		WebElement selectedOption = sel.getFirstSelectedOption();     //to print the selected option of the dropdown
		System.out.println("\nThe selected option from the dropdown is: " + selectedOption.getText());
	
	    // and if you want to print all the  options from the list then use these lines
	    System.out.println("\nAll the elements from the dropdown are:");
	    for (int i = 1; i < selectvalue.size(); i++) {   // because at zero index placeholder=Select Option is there
	    	
	        WebElement option = selectvalue.get(i);                   // Get the element at index 'i'
	        System.out.println(option.getText());                     // Print the text of the option
	    }
	 }

	

	@Override     //How to handle drop down with select class or  select tag   index
	public void selectbyIndex(WebElement ele, int index) {
		Select sel=new Select(ele);
		sel.selectByIndex(index);
		WebElement selectedOption = sel.getFirstSelectedOption();
		System.out.println("The selected option from the dropdown is: " + selectedOption.getText());
	}

	
	
	@Override     //How to handle drop down without select class or  select tag using value
	public void selectbyValue(WebElement ele, String value) {
		Select sel=new Select(ele);
		sel.selectByValue(value);
		WebElement selectedOption = sel.getFirstSelectedOption();
		System.out.println("The selected option from the dropdown is: " + selectedOption.getText());	
	}


	
	@Override
	public void mouseHover(WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();
		
		String selectedOptionText = ele.getText();
		System.out.println("You have selected: " + selectedOptionText);
		
	}
	/*// you can also use this if you want to print the selected option too
	  public void mouseHoverAndSelectOption(WebElement ele, WebElement option) {
    Actions act = new Actions(driver);
  
    act.moveToElement(ele).build().perform();     // Hover over the element
    option.click();       // Click on the option you want to select (assuming you want to select a dropdown option)
    System.out.println("Selected option: " + option.getText());    // Print the text of the selected option
}
*/

	@Override
	public void mouseHoverForToolTip(WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();
		String value=ele.getAttribute("title");
		System.out.println(value);
		
	}

	@Override
	public void waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
	}

	@Override
	public int getResponseCodeForRequest(String url) {   //if using line 295 then change to void
		try {
			  URL curl=new URL(url);
			  HttpURLConnection huc = (HttpURLConnection) curl.openConnection();
			  huc.setRequestMethod("GET");
			  huc.connect();
			  //int responsecode=huc.getResponseCode();
			  int responsecode=huc.getResponseCode();
			 // return huc.getResponseCode();  // Return the HTTP response code(can also used this in place of above line
			  return responsecode;
		}
	catch (Exception e) {
	    e.printStackTrace();  // Log the exception to understand what went wrong
	    return-1;
	}
		
	}
		
	}


	

