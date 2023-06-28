 package stepdefination;


 import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.nopCommerce.pageObject.AddCustomerPage;
import com.nopCommerce.pageObject.AdminPage;

 import io.cucumber.java.en.Given;
 import io.cucumber.java.en.Then;
 import io.cucumber.java.en.When;



public class Stepdefination extends Base {
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() throws Exception {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		System.setProperty("webdriver.chrome.driver", "D:\\test\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver(chromeOptions);
		 Thread.sleep(2000);
		//ad = new AdminPage(driver);
	   
	}

	@When("User open url{string}")
	public void user_open_url(String url) throws Exception {
		driver.get(url);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		ad = new AdminPage(driver);
	}

	@When("User Enter Email as {string} and passward as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws Exception {
		ad.setUsername(email);
		ad.setPassword(password);
		Thread.sleep(2000);
	}

	@When("Click on login")
	public void click_on_login() throws Exception {
		ad.clickLogin();
		Thread.sleep(2000);
	
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) throws Exception {
		Assert.assertEquals(title, driver.getTitle());
		Thread.sleep(2000);
	   
	}

	
	


//Add customer 

@Then("User can view Dashborad")
public void user_can_view_dashborad() throws Exception {
	 addCust=new AddCustomerPage(driver);
	   Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
	    Thread.sleep(2000);
	    }

@When("user click on customers menu")
public void user_click_on_customers_menu() throws Exception {
	addCust.clickOnCustomesMenu();
    Thread.sleep(2000);
    }

@When("user click on customers menu item")
public void user_click_on_customers_menu_item() throws Exception {
	addCust.clickOnCustomesMenuItem();
    Thread.sleep(2000);
    
}

@When("user click on new add button")
public void user_click_on_new_add_button() throws Exception {
	addCust.clickOnAddNew();
    Thread.sleep(2000);;
}

@Then("user can view add new customer page")
public void user_can_view_add_new_customer_page() throws Exception {
	 Thread.sleep(2000);
     Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
   
}

@When("user enter customer info as {string} and {string} and {string} and {string} and {string} and {string} and {string}")
public void user_enter_customer_info_as_and_and_and_and_and_and(String newEmail, String NewPassword, String firstName, String lastName, String gender, String compName, String adminComment) throws Exception {
	addCust.SetEmail(newEmail);
	  addCust.SetPassword(NewPassword);
	  addCust.SetFirstName(firstName);
	  addCust.SetLastName(lastName);
	  addCust.SetGender(gender);
	  addCust.SetCompanyName(compName);
	  addCust.SetAdminContent(adminComment);
	    Thread.sleep(2000); 
}

@When("click on save button")
public void click_on_save_button() {
	addCust.clickOnSave();
}

@Then("user can view confirmation msg {string}")
public void user_can_view_confirmation_msg(String string) throws Exception {
	Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	Thread.sleep(2000); 
}
@Then("close browser")
public void close_browser() {
	driver.close(); 
}
}





