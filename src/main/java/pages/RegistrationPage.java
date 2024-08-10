package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.GenericMethod;

public class RegistrationPage {

	public WebDriver driver;
	public GenericMethod genM;
	public By email = By.xpath("//*[@id='pass']//preceding-sibling::input");
	public By pass = By.xpath("//*[@id='pass']");
	public By comp = By.xpath("(//*[@id='pass']//following-sibling::div[1]//input)[1]");
	public By mob = By.xpath("(//*[@id='pass']//following-sibling::div[1]//input)[2]");
	public By submit = By.xpath("//*[@id='pass']//following-sibling::button");
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		genM = new GenericMethod(driver);
	}
	
	public String validateTitle()
	{
		
		return genM.getTitle();
	}
	
	public void fillDetails(String email, String pass, String comp, String mob)
	{
		genM.enterTest(this.email, email);
		genM.enterTest(this.pass, pass);
		genM.enterTest(this.comp, comp);
		genM.enterTest(this.mob, mob);
		genM.doClick(submit);
	}
	
}
