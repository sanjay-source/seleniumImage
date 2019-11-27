package resources;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.io.FileUtils;



public class Utilities {
	public ArrayList<String> list;
	public static WebDriver driver;

	public ArrayList<String> getExcelData(String testcaseName, String sheetName) throws IOException {
		list = new ArrayList<String>();
 
		FileInputStream fis = new FileInputStream("src\\main\\java\\resources\\dataSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				int rowCount = sheet.getPhysicalNumberOfRows();
				Iterator<Row> rows = sheet.iterator();
				while (rows.hasNext()) {
					Row row = rows.next();
					int colCount = row.getLastCellNum();
					if (row.getCell(0).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						Iterator<Cell> cv = row.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							if (c.getCellType() == CellType.STRING)
								list.add(c.getStringCellValue());
							else
								list.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
					}
				}
			}
		}

		return list;
	}

	@SuppressWarnings("null")
	public WebDriver getBrowser() throws IOException, InterruptedException {
		String browserEnv = "chrome";
		getExcelData("browser", "testdata");
		if (browserEnv.equals(list.get(1))) {
			@SuppressWarnings("static-access")
			DesiredCapabilities ch = new DesiredCapabilities().chrome();
			ch.acceptInsecureCerts();
			ch.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			ChromeOptions c = new ChromeOptions();
			c.merge(ch);
			System.setProperty("webdriver.chrome.driver", "src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver(c);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else
			System.out.println("Given browser is not supported");
		return driver;
	}

	public void getScreenshots(String name) throws IOException, InterruptedException {
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("logs\\"+"TestCaseFailed-"+name+".png"));
	} 
}
