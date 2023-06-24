package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
		
	WebDriver driver;
	
	public GoogleSearchPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	By searchBox=By.xpath("//textarea[@name='q']");	
	By search_btn = By.xpath("//input[@name='btnK']//ancestor::div[@jsname='VlcLAe']");
	By Facebook_link = By.xpath("//a[@href='https://www.facebook.com/']//h3");
	
	public void searchgoogle(String searchinput) throws InterruptedException
	{
		driver.findElement(searchBox).sendKeys(searchinput);
		Thread.sleep(3000);
		driver.findElement(search_btn).click();
		Thread.sleep(5000);
	}
				
	public void ClickFacebook() throws InterruptedException
	{
		driver.findElement(Facebook_link).click();
		Thread.sleep(5000);
	}
	
}
