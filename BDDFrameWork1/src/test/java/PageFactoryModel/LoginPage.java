package PageFactoryModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//input[@id='user-name']") WebElement Txt_Username;
	@FindBy(xpath="//input[@id='password']") WebElement Txt_Password;
	@FindBy(xpath="//input[@id='login-button']") WebElement Btn_login;
	
	@FindBy(xpath="//div[@class='app_logo']") WebElement Logo;
	
	
	public void get_username(String user_name)
	{
		Txt_Username.sendKeys(user_name);
	}
	
	public void get_password(String pass_word)
	{
		Txt_Password.sendKeys(pass_word);
	}
	
	public void click_login()
	{
		Btn_login.click();
	}
	
	public boolean verify_logo()
	{
		boolean imglogo= Logo.isDisplayed();
		return imglogo;
	}

}
