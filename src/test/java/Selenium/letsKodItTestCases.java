package Selenium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonUtilMethods.UtilMethods;
import pageObject.letsKodIt;
import resources.Utilities;
import resources.suiteListeners;


public class letsKodItTestCases {
	private static Logger log=LogManager.getLogger(letsKodItTestCases.class.getName());
	Utilities util = new Utilities();
	letsKodIt pageObject = new letsKodIt();
	public WebDriver driver;

	letsKodItTestCases() throws IOException, InterruptedException {
		this.driver = util.getBrowser();
	}

	@Parameters({"URL"})
	@BeforeClass(enabled=true)
	public void testCase(String urlname) {
        log.info("Maximising the window to full size");
        driver.manage().window().maximize(); 
		driver.get(urlname);
		log.fatal("Could not found the URL of the application");
	}

	@Test
	// Testcase to select a checkbox
	public void testCase01() throws InterruptedException, IOException {
		UtilMethods utilemethods = new UtilMethods(driver);
		List<String> list=util.getExcelData("testCase01", "testdata");
		Boolean value = utilemethods.selectCheckbox(list.get(1));
		log.debug("Data Loaded, operation successful");
		Assert.assertTrue(value, "true");
		log.info("Value matched! Test case passed");

	}

	@Test
	// Testcase to select a radiobutton
	public void testCase02() throws InterruptedException, IOException {
		UtilMethods utilemethods = new UtilMethods(driver);
		List<String> list=util.getExcelData("testCase02", "testdata");
		log.debug("Entering data from the excel datasheet and performing testCase operation subsequently");
		Boolean value = utilemethods.selectRadioButton(list.get(1));
		Assert.assertTrue(value, "true");
		log.info("Value matched! Test case passed");
	}

	@Test
	// Testcase to select value from a static drop down
	public void testCase03() throws InterruptedException, IOException {
		UtilMethods utilemethods = new UtilMethods(driver);
		List<String> list=util.getExcelData("testCase03", "testdata");
		Boolean value = utilemethods.selectStaticDropdowns(list.get(1));
		Assert.assertTrue(value, "true");
		log.info("Value matched! Test case passed");
	}

	@Test(timeOut=2000)
	// Testcase to select multiple values from a static drop down
	public void testCase04() throws InterruptedException, IOException {
		UtilMethods utilemethods = new UtilMethods(driver);
		List<String> list=util.getExcelData("testCase04", "testdata");
		List<String> mSelect = new ArrayList<String>();
		mSelect.addAll(Arrays.asList(list.get(1), list.get(2)));
		Boolean value = utilemethods.multiselectStaticDropdowns(mSelect);
		Assert.assertTrue(value, "true");
		log.info("Value matched! Test case passed");
	}

	@Test(dependsOnMethods = { "testCase06" })
	// Testcase to handle windows or tabs
	public void testCase05() throws InterruptedException, IOException {
		UtilMethods utilemethods = new UtilMethods(driver);
		List<String> list=util.getExcelData("testCase05", "testdata");
		String childWindow = list.get(1);
		String value = utilemethods.multiWindowHandle(childWindow);
		Assert.assertEquals(value, childWindow);
		log.info("Value matched! Test case passed");
	}

	@Test
	// Testcase to handle alert on webpage
	public void testCase06() throws InterruptedException, IOException {
		UtilMethods utilemethods = new UtilMethods(driver);
		List<String> list=util.getExcelData("testCase06", "testdata");
		String childWindow = list.get(1);
		String value = utilemethods.alertHandle(list.get(2));
		Assert.assertEquals(value, childWindow);
		log.info("Value matched! Test case passed");
	}

	@Test
	// Testcase to check textbox is enabled or disabled
	public void testCase07() throws InterruptedException, IOException {
		UtilMethods utilemethods = new UtilMethods(driver);
		List<String> list=util.getExcelData("testCase07", "testdata");
		log.debug("Checking checkbox selection");
		Boolean value = utilemethods.checkEnabledDisabled(list.get(1));
		Assert.assertFalse(value, "false");
		log.info("Value matched! Test case passed");
	}

	@Test
	// Testcase to handle iframe on webpage
	public void testCase08() throws InterruptedException, IOException {
		UtilMethods utilemethods = new UtilMethods(driver);
		List<String> list=util.getExcelData("testCase08", "testdata");
		Boolean value = utilemethods.iframeHandle(list.get(1));
		Assert.assertTrue(value, "true");
		log.info("Value matched! Test case passed");
	}

	@Test
	// Testcase to demonstrate action class
	public void testCase09() throws InterruptedException, IOException {
		UtilMethods utilemethods = new UtilMethods(driver);
		utilemethods.hoverAction();
		log.info("Value matched! Test case passed");
	}

	@Test
	// Testcase to handle web tables
	public void testCase10() throws InterruptedException, IOException {
		UtilMethods utilemethods = new UtilMethods(driver);
		List<String> list=util.getExcelData("testCase10", "testdata");
		String index = list.get(10);                                    //intentional failing test case here
		String value = utilemethods.handleWebTable(index);
		Assert.assertEquals(value, index);
		log.info("Value matched! Test case passed");
	}

	@AfterTest(alwaysRun=true)
	public void testCaseClose() throws InterruptedException, IOException {	
		driver.quit();
		Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		log.error("Could not close the driver Object and session");
	}

}
