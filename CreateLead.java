package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass{
	@BeforeClass
	void beforeClass()
	{
		FileName= "Sruthi_excel";
		
	}
	//to use retry for failed cases for particular test alone
	//@Test(dataProvider = "sendData", priority=1, enabled=true, retryAnalyzer=RetryFailedTests.class)

	@Test(dataProvider = "sendData", priority=1, enabled=true)
	public void createLead(String company, String fname, String Lname) {
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(Lname);
		driver.findElement(By.name("submitButton")).click();
		
		String Title = driver.getTitle();
		System.out.println(Title);
		//hard assert View Lead | opentaps CRM
		//Assert.assertEquals(Title, "View Lead | opentaps CRM");
		
		
		//soft Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(Title, "View| opentaps CRM");
		softAssert.assertAll();

}
	/*@DataProvider
	public String[][] sendData()
	{
		String Data[][]= new String[2][3];
		
		Data[0][0]="Temenos";
		Data[0][1]="Sruthi";
		Data[0][2]="Priya";
		
		Data[1][0]="Amazon";
		Data[1][1]="Sethu";
		Data[1][2]="Ram";
		
		return Data;
		
	}*/
	
	
}






