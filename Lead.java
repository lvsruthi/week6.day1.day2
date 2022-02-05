package StepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lead extends CucumberBaseClass {
	
/*	@Given("Launch the Browser")
	public void LauchBrowser()
	{ WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
		
	}
	@Given("Load the application url {string}")
	public void LoadUrl(String url)
	{
		driver.get("http://leaftaps.com/opentaps/");	
	}
	*/
	String MergeleadID;
	String DeleteleadID;
	String leadID;

	@Given("Enter username as {string}")
	public void EnterUsername(String uname)
	{
		driver.findElement(By.id("username")).sendKeys(uname);
	}

	@Given("Enter the password as {string}")
	public void EnterPassword(String password)
	{
		driver.findElement(By.id("password")).sendKeys(password);
		
	}

	@Given("click on Login Button")
	public void clickLogin()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
		
	}
	
	@Given("Homepage should be displayed")
	public void VerifyHomePage()
	{
		String title = driver.getTitle();
		if(title.contains("TestLeaf"))
			System.out.println("Login Success!! Home Page displayed successfully");
		else
			System.out.println("Login Unsuccessful");
	}
	

@Given("Click on LinkText {string}")
public void click_on_LinkText(String LinkText) {
	
	driver.findElement(By.linkText(LinkText)).click();

	
}

@Given("Enter CompanyName as Temenos")
public void enter_company_name_as_temenos() {
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Temenos");
	
}

@Given("Enter FirstName as Sru")
public void enter_first_name_as_sru() {
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sru");
	}

@Given("Enter LastName as Pri")
public void enter_last_name_as_pri() {
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Pri");
}

@When("Submit button is clicked")
public void submit_button_is_clicked() {
	driver.findElement(By.name("submitButton")).click();
}

@Then("Verify Lead is created")
public void verify_lead_is_created() {
	String title = driver.getTitle();
	System.out.println(title);
	if(title.contains("View Lead | opentaps CRM"))
		System.out.println("Lead created successfully");
	else
		System.out.println("Lead not created");

	
}

@Given("Click on the Phone Tabs")
public void click_on_the_phoneNumber()
{
	
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
}



@Given("Enter phoneNumber as {string}")
public void enter_phone_number_as(String phoneNumber) {
	
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumber);
}

@Given("click on the FindLeads Button")
public void click_on_the_find_leads_button() {
	
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
}

@Given("click on the First Result")
public void click_on_the_first_result() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
}


@Then("Verify Lead is Duplicated")
public void verify_lead_is_duplicated() {
    String Title = driver.getTitle();
    if(Title.contains("Lead"))
    	System.out.println("Lead is duplicated");
    else
    	System.out.println("Lead is not duplicated");
}

@Given("Update the companyName as TCS")
public void update_the_company_name_as_tcs() {
	driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
	
}

@Then("Verify Lead is Edited")
public void verify_lead_is_edited() {
	 String Title = driver.getTitle();
	    if(Title.contains("Lead"))
	    	System.out.println("Lead is Edited");
	    else
	    	System.out.println("Lead is not Edited");
}

@Given("Click on the first lead")
public void click_on_the_first_lead() throws InterruptedException {
	
	
	driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	Set<String> allWindows = driver.getWindowHandles();
	List<String> allhandles = new ArrayList<String>(allWindows);
	driver.switchTo().window(allhandles.get(1));
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("sethu");
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	 leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(allhandles.get(0));
	
}

@Given("Click on the second lead")
public void click_on_the_second_lead() throws InterruptedException {
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	Set<String> allWindows2 = driver.getWindowHandles();
	List<String> allhandles2 = new ArrayList<String>(allWindows2);
	driver.switchTo().window(allhandles2.get(1));
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("sruthi");
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(allhandles2.get(0));
}

@When("Click on Merge")
public void click_on_merge() {

	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	driver.switchTo().alert().accept();
	
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
}

@Then("Verify Lead is merged")
public void verify_lead_is_merged() {
	String text = driver.findElement(By.className("x-paging-info")).getText();
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
}

@Given("store the firstLead value")
public void store_the_first_lead_value() throws InterruptedException {
	Thread.sleep(2000);
	DeleteleadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
}

@Given("update the lead with the stored value")
public void update_the_lead_with_the_stored_value() {
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(DeleteleadID);
	
	
}


@When("click on Delete")
public void click_on_delete() {
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
}

@Then("Verify Lead is Deleted")
public void verify_lead_is_deleted() {
	String text = driver.findElement(By.className("x-paging-info")).getText();
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
}

	
}
