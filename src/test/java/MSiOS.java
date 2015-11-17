package test.java;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;




public class MSiOS extends basicTest{

	@Test  (dataProvider="PerfectoParams") 
	public void checkUserBloodGroup(PerfectoTestParams params) {
		Assert.assertTrue(false, "checkUserBloodGroup");
	
	}

	@Test (dataProvider="PerfectoParams") 
	public void checkUserHealthInsurence(PerfectoTestParams params) {
		Assert.assertTrue(true, "checkUser Health Insurence");
	
	}
	@Test (dataProvider="PerfectoParams") 
	public void checkAppointment(PerfectoTestParams params) {
		boolean b = Math.random() < 0.3;
		Assert.assertTrue(b, "check Appointmentd");

	 
	} 

 

	@Test (dataProvider="PerfectoParams") 
	public void LogIn(PerfectoTestParams params) {
		System.out.println("Test1 in Test"+params._platform);
		System.out.println("Test1 in Test"+params._repKey);
		String devID = params._device._id;
		RemoteWebDriver d = util.getAppiumDriver(params._device,params._activityBandle,params._platform,params._cloud,params._user,params._password,params._repKey);
		try {
			System.out.println("Start test on device"+devID);

			this.execTest(d);
		} catch (Exception e) {
			// TODO: handle exception
		}finally
		{
			System.out.println("end test on"+devID);

			this.endTest(d);

		}



	}

	@Override
	public void execTest(RemoteWebDriver driver) throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("(//*[@label='Home'])[2]")).click();
		util.sleep(1000);
		driver.findElement(By.xpath("(//*[@label='User'])[2]")).click();
		util.sleep(1000);
		driver.findElement(By.xpath("(//*[@label='Treatment'])[2]")).click();
		util.sleep(1000);
		driver.findElement(By.xpath("(//*[@label='Dinner'])[2]"));
		WebElement dinner = 	driver.findElement(By.xpath("(//*[@label='Dinner'])[2]//following-sibling::*[1]"));

		System.out.println("need to take "+dinner.getText()+" after dinner");


	}

	@Override
	public void beforeTest() throws Exception {



	}




	@Override
	public void endTest(RemoteWebDriver driver) {



		String devId = (String) driver.getCapabilities().getCapability("deviceName");

		//close the test  
		try{

			driver.close();	
			System.out.println("driver closed");

			util.downloadReport(driver, "pdf","MS_VSO"+devId);	
		} catch (IOException e) {

			e.printStackTrace();

		}finally
		{

			try{
				driver.quit();

			}catch(Exception e)
			{
				e.printStackTrace();
			}


		} 


	}


}
