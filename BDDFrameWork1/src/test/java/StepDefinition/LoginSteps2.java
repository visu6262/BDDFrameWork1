package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageFactoryModel.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public class LoginSteps2 
{
	
	static WebDriver driver;
	
	LoginPage lp;
			
	@Given("user navigates to the website saucedemo.com")
	public void user_navigates_to_the_website_saucedemo_com() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
	    
	}


	@And("user enter valid {string} and {string}")
	public void user_enter_valid_and(String username, String password) throws InterruptedException
	{
		lp=new LoginPage(driver);
		lp.get_username(username);
		Thread.sleep(1000);
		lp.get_password(password);
		Thread.sleep(1000);
		
		/*
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		Thread.sleep(1000);
		*/
	}

	@And("user click on login Button")
	public void user_click_on_login_button() {
		lp.click_login();
//		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	 
	}

	@Then("login must be successful.")
	public void login_must_be_successful() {
		Assert.assertTrue(lp.verify_logo());
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed());
	   
	}

	@And("close browser")
	public void close_browser() {
		driver.quit();
	    
	}

}
