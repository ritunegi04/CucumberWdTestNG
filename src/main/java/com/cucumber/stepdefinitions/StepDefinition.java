package com.cucumber.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StepDefinition {
	
	private WebDriver driver;

	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://ui.cogmento.com/");

	}

	@When("^login page title is displayed$")
	public void login_page_title_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String title=driver.getTitle();
		Assert.assertEquals("Cogmento CRM", title);
	   
	}

	@Then("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_and(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement uname=driver.findElement(By.name("email")); WebElement
		  password1=driver.findElement(By.name("password"));
		  uname.sendKeys(arg1); password1.sendKeys(arg2);
		  driver.findElement(By.xpath("//div[contains(@class,'submit')]")).click();
	   
	}

	@Then("^User is navigated to homepage$")
	public void user_is_navigated_to_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(5000);
		WebElement homeIcon=driver.findElement(By.xpath("//div[@id='main-nav']/a[1]/span"));
		String text=homeIcon.getText();
		Assert.assertEquals( "Home", text);
	 
	}

	@Then("^browser is closed$")
	public void browser_is_closed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}

	
	

}
