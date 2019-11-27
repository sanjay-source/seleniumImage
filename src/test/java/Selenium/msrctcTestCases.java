package Selenium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonUtilMethods.msrctcUtilMethods;
import resources.Utilities;
//Testcase to demonstrate autosuggestive dropdown and how to run a test case with multiple set of data provided by user from excel sheet.
public class msrctcTestCases {
	private static Logger log=LogManager.getLogger(msrctcTestCases.class.getName());
	Utilities util = new Utilities();
	public WebDriver driver;

	msrctcTestCases() throws IOException, InterruptedException {
		this.driver = util.getBrowser();
	}

	@Test(dataProvider="driveTest")
	public void testCase11(String dname, String tname) throws IOException {
        log.info("Maximising the window to full size");
        driver.manage().window().maximize(); 
		driver.get("https://ksrtc.in/oprs-web/");
		log.fatal("Could not found the URL of the application");
		msrctcUtilMethods mutilmethods=new msrctcUtilMethods(driver);
		mutilmethods.autoSuggestDropdown(dname, tname);
		driver.quit();		
	}
	
	@DataProvider(name="driveTest")
	public Object[][] getdata() throws IOException {
		List<String> list01=util.getExcelData("testCase11", "testdata");
		List<String> list02=util.getExcelData("testCase12", "testdata");
		List<String> list03=util.getExcelData("testCase13", "testdata");
		List<List<String>> nodes= new ArrayList<List<String>>();
		nodes.add(list01);
		nodes.add(list02);
		nodes.add(list03);
		

		Object[][] data = new Object[nodes.size()][];
		for (int i = 0; i < nodes.size(); i++) {
			List<String> row = nodes.get(i);
			data[i] = row.toArray(new String[row.size()]);
		}
		return data;
	}
}
