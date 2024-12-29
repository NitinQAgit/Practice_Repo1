
//Sortable page class for sorting all the list options

package pages_for_interactions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mavenLibrary.MavenLibrary;

public class SortablePage extends MavenLibrary {

    // Constructor - Initializes the page elements.
    public SortablePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-target='#interations']")
    private WebElement interactionsButton;

    @FindBy(xpath = "//a[text()='sortable']")
    private WebElement sortableOption;

    @FindBy(xpath = "//button[@onclick='sortTable()']")
    private WebElement sortButton;

    @FindBy(xpath = "//table[@id='myTable']//tr[th[text()='Name']]/following-sibling::tr/td[following-sibling::td]")
    private List<WebElement> List1;    //List of names before clicking sort button

    @FindBy(xpath = "//table[@id='myTable']//tr[td]/td[1]")
    private List<WebElement> List2;      //List of names after clicking sort button(actual names list)

    @FindBy(xpath = "//table[@id='myTable']//tr[th[text()='Country']]/following-sibling::tr/td[preceding-sibling::td]")
    private List<WebElement> List3;       //List of countries before clicking sort button

    @FindBy(xpath = "//table[@id='myTable']//tr[td]/td[last()]")
    private List<WebElement> List4;       //List of countries after clicking sort button(actual countries list)
    
    @FindBy(xpath = "//table[@id='myTable']//tr/td")
    private List<WebElement> List5;         //List which contains both names and countries

    public void clickOnInteractions() {
        waitforClick(interactionsButton);
        interactionsButton.click();
    }

    public void clickOnSortableOption() {
        waitforClick(sortableOption);
        sortableOption.click();
    }

    
    public void sortNameListUsingMap(){
    
    	 // Convert WebElement list to a list of strings containing the text of each WebElement  using MAP
	    List<String> textList = List1.stream()
                              .map(WebElement::getText)   // Map each WebElement to its text
                              .collect(Collectors.toList());  // Collect to a new List
	    
	    Collections.sort(textList);
	    
	    // Print each text value
	        textList.forEach(System.out::println);
	    //  textList.forEach(text -> System.out.println("Text of each element is: " + text));
	    }
    
    
    public void sortNameListUsingTraditionalForLoop(){


	    // Create a new list to hold the text values of the WebElements in List1
	    List<String> textList = new ArrayList<String>();

	    // Extract the text from each WebElement in List1 and add it to the textList
	    for (int i = 0; i < List1.size(); i++) {
	        String text = List1.get(i).getText();
	        textList.add(text);
	    }

	    // Print the original (unsorted) list
	    System.out.println("Original list of texts from List1:");
	    for (int i = 0; i < textList.size(); i++) {
	        System.out.println("Text of element " + (i + 1) + ": " + textList.get(i));
	    }

	    // Sort the list of texts
	    Collections.sort(textList);  //this will sort the textlist so you dont need to store it seperately

	    // Print the sorted list
	    System.out.println("\nSorted list of texts from List1:");
	    for (int i = 0; i < textList.size(); i++) {
	        System.out.println("Text of element " + (i + 1) + ": " + textList.get(i));
	    }
	}
    
    
    
    public void sortNameListUsingEnhancedForLoop(){
       
    	// Create a new list to hold the text values of the WebElements in List1
        List<String> textList = new ArrayList<String>();

        // Extract the text from each WebElement in List1 and add it to the textList
        for (WebElement element : List1) {
            textList.add(element.getText());
        }

        // Print the original (unsorted) list
        System.out.println("Original list of texts from List1:");
        for (String text : textList) {
            System.out.println("Text: " + text);
        }

        // Sort the list of texts
        Collections.sort(textList);  // This will sort the textList in ascending order

        // Print the sorted list
        System.out.println("\nSorted list of texts from List1:");
        for (String text : textList) {
            System.out.println("Text: " + text);
        }
    }

    
    
    
    public void sortNameListUsingGetText(){
    	
    	
    	// Create a new list to hold the text values of the WebElements in List1
    	List<String> textList = new ArrayList<String>();         // list to hold elements before sorting method
    	List<String> actualtextList = new ArrayList<String>();   //list to hold elements after using sort button
    	
    	// Extract the text from each WebElement in List1 and add it to the textList
    	for (int i = 0; i < List1.size(); i++) {
    		String text = List1.get(i).getText();
    		textList.add(text);
    	}
    	
    	// Print the original (unsorted) list
    	System.out.println("Text of element before sorting method is: ");
    	
    	for (int i = 0; i < textList.size(); i++) {
    		System.out.println((i + 1) + ": " + textList.get(i));
    	}
    	
    	// Sort the list of texts
    	Collections.sort(textList);               //this will sort the original textlist so you dont need to store it seperately
    	
    	
    	System.out.println("\nText of element after sorting method is: ");
    	
    	for (int i = 0; i < textList.size(); i++) {
    		System.out.println((i + 1) + ": " + textList.get(i));
    	}
    	
    	waitforClick(sortButton);
    	sortButton.click();
    	
    
    	// Extract the text from each alternative WebElement in List5 and add it to the actualtextList
    	for (int i = 0; i < List5.size(); i=i+2) {
    		String text = List5.get(i).getText();
    		actualtextList.add(text);
    	}
    	System.out.println("\nText of element after sorting button is: ");
    	
    	for (int i = 0; i < actualtextList.size(); i++) {
    		System.out.println((i + 1) + ": " + actualtextList.get(i));
    	}
    	 System.out.println("\nSize of List5 is: " + List5.size());
    	 System.out.println("Size of actualtextlist is: " + actualtextList.size());
    	
    	
	    // Compare the two lists using equals() (checks both size and order)
	    boolean areListsEqual = textList.equals(actualtextList);
	    if (areListsEqual) {
	        System.out.println("\nBoth lists are equal (same elements in the same order).");
	    } else {
	        System.out.println("\nBoth lists are NOT equal (elements or order differ).");
	    }
    }

    
    
       public void sortNameListAndValidate() {
    
	    // Create a new list to hold the text values of the WebElements in List1
	    List<String> textList = new ArrayList<String>();         // list to hold elements before sorting method
    	List<String> actualtextList = new ArrayList<String>();   //list to hold elements after using sort button
	
	    // Extract the text from each WebElement in List1 and add it to the textList
	    for (int i = 0; i < List1.size(); i++) {
	        String text = List1.get(i).getText();  // Extract text from each WebElement
	        textList.add(text);  // Store the text in the textList
	    }
	
	    // Print the original (unsorted) list
	    System.out.println("Original list of texts from List1:");
	    for (int i = 0; i < textList.size(); i++) {
	        System.out.println((i + 1) + ": " + textList.get(i));
	    }
	
	    // Create a new list to hold the sorted texts
	    List<String> sortedList = new ArrayList<>(textList);  // Create a copy of the original list
	    Collections.sort(sortedList);  // Sort the copied list
	
	    // Print the sorted list
	    System.out.println("\nSorted list of texts from List1:");
	    for (int i = 0; i < sortedList.size(); i++) {
	        System.out.println((i + 1) + ": " + sortedList.get(i));
	    }
	    
    	waitforClick(sortButton);
    	sortButton.click();
    	
    	// Extract the text from each alternative WebElement in List5 and add it to the actualtextList
    	for (int i = 0; i < List5.size(); i=i+2) {
    		String text = List5.get(i).getText();
    		actualtextList.add(text);
    	}
    	System.out.println("\nText of element after sorting button is: ");
    	
    	for (int i = 0; i < actualtextList.size(); i++) {
    		System.out.println((i + 1) + ": " + actualtextList.get(i));
    	}

	    // Compare the two lists using equals() (checks both size and order)
	    boolean areListsEqual = actualtextList.equals(sortedList);
	    if (areListsEqual) {
	        System.out.println("\nBoth lists are equal (same elements in the same order).");
	    } else {
	        System.out.println("\nBoth lists are NOT equal (elements or order differ).");
	    }

	    // Compare the two lists using containsAll() (checks if all elements are present, but not order)
	    boolean areListsContainsAll = textList.containsAll(sortedList);
	    if (areListsContainsAll) {
	        System.out.println("\nThe original list contains all the elements of the sorted list (but order may differ).");
	    } else {
	        System.out.println("\nThe original list does NOT contain all the elements of the sorted list.");
	    }
		}
		}
