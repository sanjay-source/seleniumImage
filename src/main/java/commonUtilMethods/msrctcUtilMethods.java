package commonUtilMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


import pageObject.letsKodIt;
import resources.Utilities;
//method to demonstrate autosuggestive dropdown and how to run a test case with multiple set of data provided by user from excel sheet.
//these method is used in msrctcTestCasses.java file.
public class msrctcUtilMethods
{
	
//	private static final String String = null;
	public Boolean bool = null;
	Utilities util = new Utilities();
	letsKodIt pageObject = new letsKodIt();
	public WebDriver bdriver;

	public msrctcUtilMethods(WebDriver driver) {
		this.bdriver = driver;
	}
    By element= By.cssSelector("#fromPlaceName");
	public void autoSuggestDropdown(String shortname, String fullname) {
		bdriver.findElement(element).sendKeys(shortname+Keys.DOWN);
		JavascriptExecutor js=(JavascriptExecutor)bdriver;
		String script= "return document.getElementById(\"fromPlaceName\").value;";
		String text= (String) js.executeScript(script);	
		int i=0;
		while(!text.equalsIgnoreCase(fullname)) {
			i++;
			bdriver.findElement(element).sendKeys(Keys.DOWN);
		    text= (String) js.executeScript(script);	
			System.out.println(text);
			if(i>10) {
				break;
			}
		}
		}
	    
}
