//package StepDefinition;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//
//
//
//public class LoginSteps 
//{
//	static WebDriver driver;
//	@Given("user navigates to the website saucedemo.com")
//	public void user_navigates_to_the_website_saucedemo_com() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.saucedemo.com/");
//	    
//	}
//
//	@And("there user logs in through Login Window by using Userid as USER and Password as PASSWORD")
//	public void there_user_logs_in_through_login_window_by_using_userid_as_user_and_password_as_password() throws InterruptedException {
//		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
//		Thread.sleep(1000);
//	}
//
//	@And("user click on login Button")
//	public void user_click_on_login_button() {
//		driver.findElement(By.xpath("//input[@id='login-button']")).click();
//	 
//	}
//
//	@Then("login must be successful.")
//	public void login_must_be_successful() {
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed());
//	   
//	}
//
//	@And("close browser")
//	public void close_browser() {
//		driver.quit();
//	    
//	}
//
//}
