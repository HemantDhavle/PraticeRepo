package stepDefination;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ContextTestManager;

public class RegistrationStepDefination {
	
	
	public ContextTestManager contextTestManager;
	public RegistrationStepDefination(ContextTestManager contextTestManager)
	{
		this.contextTestManager = contextTestManager;
	}
	@Given("user is on landing page")
	public void user_is_on_landing_page() throws IOException 
	{
		
			
		String crtTitle = contextTestManager.pageManager.getRegistrationPage().validateTitle();
		Assert.assertEquals(crtTitle, "Xpath Practice Page | Shadow dom, nested shadow dom, iframe, nested iframe and more complex automation scenarios.");
	}

	@When("user enters below details")
	public void user_enters_below_details(DataTable str) throws InterruptedException 
	{
		Thread.sleep(2000);
		List<String> list = str.asList(String.class);
		//for()
		String email = list.get(0);
		System.out.println(email);
		String pass = list.get(1);
		System.out.println(pass);
		String comp = list.get(2);
		System.out.println(comp);
		String mob = list.get(3);
		System.out.println(mob);
		contextTestManager.pageManager.getRegistrationPage().fillDetails(email, pass, comp, mob);
		
	   
	}

	@When("click on submit")
	public void click_on_submit() {
	  System.out.println("clicked");
	}

	@Then("details should be submitted successfully")
	public void details_should_be_submitted_successfully() {
	   System.out.println("eb");
	}

}
