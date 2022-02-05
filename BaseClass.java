package week5.day1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
  public RemoteWebDriver driver;
  
  public String FileName;
  
  @Parameters({"tBrowser", "url", "uname","pass"})
  @BeforeMethod
   public void beforeMethod(String tBrowser, String turl, String tuname, String tpass) {
	  if(tBrowser.equalsIgnoreCase("CHROME"))
	  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	  }
	  else if(tBrowser.equalsIgnoreCase("EDGE"))
	  {
		  WebDriverManager.edgedriver().setup();
		  driver = new EdgeDriver();
	  }
		driver.manage().window().maximize();
		driver.get(turl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(tuname);
		driver.findElement(By.id("password")).sendKeys(tpass);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
	  
  }
  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  
  }

  @DataProvider
	public String[][] sendData() throws IOException
	{
	  return ReadExcel.readExcel(FileName);
		
	}
}
