package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class letsKodIt {

	By staticdropDown = By.cssSelector("#carselect");
	By radioButton = By.cssSelector("input[type='radio']");
	By checkBoxes = By.cssSelector("input[type='checkbox']");
	By staticMultiSelectDropDown = By.cssSelector("#multiple-select-example");
	By multipleWindowHandle = By.cssSelector("#opentab");
	By alertTextBox = By.cssSelector("#name");
	By alertButton = By.cssSelector("#confirmbtn");
	By visibleTextBox = By.cssSelector("#displayed-text");
	By isDisableCheck = By.cssSelector("#hide-textbox");
	By isEnabledCheck = By.cssSelector("#show-textbox");
	By webTable = By.xpath("//table[@id='product']/tbody");
	By iFrame = By.cssSelector("iframe#courses-iframe");
	By iFrameTextBox = By.cssSelector("#search-courses");
	By mouseHover = By.cssSelector("#mousehover");

	public By staticdropDown() {
		return staticdropDown;
	}

	public By radioButton() {
		return radioButton;
	}

	public By checkBoxes() {
		return checkBoxes;
	}

	public By staticMultiSelectDropDown() {
		return staticMultiSelectDropDown;
	}

	public By multipleWindowHandle() {
		return multipleWindowHandle;
	}

	public By alertTextBox() {
		return alertTextBox;
	}

	public By alertButton() {
		return alertButton;
	}

	public By visibleTextBox() {
		return visibleTextBox;
	}

	public By isEnabledCheck() {
		return isEnabledCheck;
	}

	public By isDisableCheck() {
		return isDisableCheck;
	}

	public By webTable() {
		return webTable;
	}

	public By iFrame() {
		return iFrame;
	}

	public By iFrameTextBox() {
		return iFrameTextBox;
	}

	public By mouseHover() {
		return mouseHover;
	}

}
