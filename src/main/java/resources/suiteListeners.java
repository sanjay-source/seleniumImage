package resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class suiteListeners implements ITestListener {
	Utilities util=new Utilities();

	public void onTestFailure(ITestResult result) {
		try {
			util.getScreenshots(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
       

	

}
