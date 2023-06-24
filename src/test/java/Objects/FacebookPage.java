package Objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookPage {
	
	WebDriver driver;
  
	public FacebookPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	By Useremail=By.xpath("//input[@id='email']");
	By fbPassword=By.xpath("//input[@id='pass']");
	By Login_btn=By.xpath("//button[@name='login']");

	public void EnterUserName(String Username)
	{
		driver.findElement(Useremail).clear();
		driver.findElement(Useremail).sendKeys(Username);
	}
	

	public void EnterUserPassword(String Pass)
	{
		driver.findElement(fbPassword).clear();
		driver.findElement(fbPassword).sendKeys(Pass);
	}
	
	public void VerifyLogin()
	{
		driver.findElement(Login_btn).click();
	
		String title= driver.getTitle();
		assertEquals(title, "Facebook");
	}
	
}
