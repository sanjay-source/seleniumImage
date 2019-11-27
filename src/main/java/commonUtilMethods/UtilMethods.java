package commonUtilMethods;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.letsKodIt;
import resources.Utilities;

public class UtilMethods {
	private static final String String = null;
	public Boolean bool = null;
	Utilities util = new Utilities();
	letsKodIt pageObject = new letsKodIt();
	public WebDriver adriver;

	public UtilMethods(WebDriver driver) {
		this.adriver = driver;
	}

	public Boolean selectCheckbox(String checkbox) throws IOException, InterruptedException {

		int count = adriver.findElements(pageObject.checkBoxes()).size();
		for (int i = 0; i <= count - 1; i++) {
			String text = adriver.findElements(pageObject.checkBoxes()).get(i).getAttribute("value");
			if (text.equalsIgnoreCase(checkbox)) {
				adriver.findElements(pageObject.checkBoxes()).get(i).click();
				bool = adriver.findElements(pageObject.checkBoxes()).get(i).isSelected();
			}

		}
		return bool;
	}

	public Boolean selectRadioButton(String radioButton) {
		int count = adriver.findElements(pageObject.radioButton()).size();
		for (int i = 0; i <= count - 1; i++) {
			String text = adriver.findElements(pageObject.radioButton()).get(i).getAttribute("value");
			if (text.equalsIgnoreCase(radioButton)) {
				adriver.findElements(pageObject.radioButton()).get(i).click();
				bool = adriver.findElements(pageObject.radioButton()).get(i).isSelected();
			}
		}
		return bool;
	}

	public Boolean selectStaticDropdowns(String Selection) {
		Select sclass = new Select(adriver.findElement(pageObject.staticdropDown()));
		Iterator<WebElement> it = sclass.getOptions().iterator();
		while (it.hasNext()) {
			WebElement element = it.next();
			if (element.getAttribute("value").equalsIgnoreCase(Selection)) {
				element.click();
				bool = true;
			}
		}
		return bool;
	}

	public Boolean multiselectStaticDropdowns(List<String> multiSelect) {
		Select msclass = new Select(adriver.findElement(pageObject.staticMultiSelectDropDown()));
		Iterator<WebElement> it = msclass.getOptions().iterator();
		while (it.hasNext()) {
			WebElement element = it.next();
			for (String mSelection : multiSelect) {
				if (element.getAttribute("value").equalsIgnoreCase(mSelection)) {
					element.click();
					bool = true;
				}
			}
		}
		return bool;
	}

	public String multiWindowHandle(String childWindowTitle) {
		String childwindowTitle = "";
		adriver.findElement(pageObject.multipleWindowHandle()).click();
		Iterator<String> it = adriver.getWindowHandles().iterator();
		while (it.hasNext()) {
			String child = it.next();
			adriver.switchTo().window(child);
			childwindowTitle = adriver.getTitle();
			adriver.switchTo().defaultContent();
		}
		return childwindowTitle;
	}
	
	public String alertHandle(String alertText) {
		String message = "";
		adriver.findElement(pageObject.alertTextBox()).sendKeys(alertText);
		adriver.findElement(pageObject.alertButton()).click();
		WebDriverWait wait = new WebDriverWait(adriver, 2);
		wait.until(ExpectedConditions.alertIsPresent());
		message = adriver.switchTo().alert().getText();
		adriver.switchTo().alert().accept();
		return message;
	}
	
	public Boolean checkEnabledDisabled(String Text) {
		adriver.findElement(pageObject.visibleTextBox()).sendKeys(Text);
		adriver.findElement(pageObject.isDisableCheck()).click();
		bool=adriver.findElement(pageObject.visibleTextBox()).isDisplayed();
		return bool;
	}
   
	public Boolean iframeHandle(String Text) {
		adriver.switchTo().frame(adriver.findElement(pageObject.iFrame()));
		adriver.findElement(pageObject.iFrameTextBox()).sendKeys(Text);
		bool=adriver.findElement(pageObject.iFrameTextBox()).isEnabled();
		adriver.switchTo().defaultContent();
		return bool;
	}
	
	public void hoverAction() {
		Actions action=new Actions(adriver);
		action.moveToElement(adriver.findElement(pageObject.mouseHover())).build().perform();			
	}
	
	public String handleWebTable(String text) {
		String var="";
		WebElement table=adriver.findElement(pageObject.webTable());
		Iterator<WebElement> rows=  table.findElements(By.tagName("tr")).iterator();
		while(rows.hasNext()) {
			WebElement row=rows.next();
			Iterator<WebElement>columns=row.findElements(By.tagName("td")).iterator();
			while(columns.hasNext()) {
				WebElement column=columns.next();
				if(column.getText().equalsIgnoreCase(text)) {
					var=column.getText();
				}
				
			}
			
		}
		return var;
	}
	
}
