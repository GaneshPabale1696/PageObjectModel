package Objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Page {
	
	WebDriver driver;
	  
	public Search_Page(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement Useremail;
	
	@FindBy(xpath="//input[@id='pass']")
	public WebElement fbPassword;
	
	@FindBy(xpath="//button[@name='login']")
	public WebElement Login_btn;
	
	//By Useremail=By.xpath("//input[@id='email']");
	//By fbPassword=By.xpath("//input[@id='pass']");
	//By Login_btn=By.xpath("//button[@name='login']");

	public void EnterUserName(String Username)
	{
		Useremail.clear();
		Useremail.sendKeys(Username);
	}
	

	public void EnterUserPassword(String Pass)
	{
		fbPassword.clear();
		fbPassword.sendKeys(Pass);
	}
	
	public void VerifyLogin()
	{
		Login_btn.click();
	
		String title= driver.getTitle();
		assertEquals(title, "Facebook");
	}
	

}
