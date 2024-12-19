package StepDefinition;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import PageFactoryModel.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public class LoginSteps2 extends BaseSteps
{
	
	
//	WebDriver driver; 
//	LoginPage lp; //come form BaseSteps
	
	
	@Before
	public void setup() throws IOException
	{
		log=LogManager.getLogger(this.getClass());
//		FileReader reader=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		FileReader reader=new FileReader("./src/test/resources/config.properties");
		prop=new Properties();
		prop.load(reader);
		
		log.info("*** 1 Web Browser Opening ***");
		String br=prop.getProperty("browser");
		
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default : System.out.println("plz give valid browser name"); return;
		}
		
		/*
		if(br.toLowerCase().equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (br.toLowerCase().equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if (br.toLowerCase().equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("plz give valid browser name");
			
		}
		*/
		
		log.info("*** 2 Maximizeing Web Browser ***");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}


	
//	@Given("user navigates to the website {string}")
//	public void user_navigates_to_the_website(String url_name) {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get(url_name);
//	}
			
	@Given("user navigates to the website https:www.saucedemo.com")
	public void user_navigates_to_the_website_saucedemo_com() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.saucedemo.com/");
		log.info("*** 3 Opeing Sausedemo url ***");
		driver.get(prop.getProperty("url_saucedemo"));
//		System.out.println(prop.getProperty("url_saucedemo"));
	    
	}


	@And("user enter valid {string} and {string}")
	public void user_enter_valid_and(String username, String password) throws InterruptedException
	{
		log.info("*** 4 Entering Username ***");
		lp=new LoginPage(driver);
		lp.get_username(username);
		Thread.sleep(1000);
		log.info("*** 5 Entering Password ***");
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
		log.info("*** 6 Click on login Button ***");
		lp.click_login();
//		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	 
	}

	@Then("login must be successful.")
	public void login_must_be_successful() {
		log.info("*** 7 Verify login success ***");
		Assert.assertTrue(lp.verify_logo());
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed());
	   
	}

	@And("close browser")
	public void close_browser() {
		log.info("*** 8 Closeing Browser ***");
		driver.quit();
	    
	}

}
