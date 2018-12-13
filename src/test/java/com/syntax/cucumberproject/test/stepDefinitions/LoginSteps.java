package com.syntax.cucumberproject.test.stepDefinitions;


import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

	WebDriver driver;

	@Given("^I open browser$")
	public void i_open_browser() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\MKHAN\\eclipse-workspace\\CucumberProject\\src\\test\\resources\\drivers\\chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.manage().window().maximize();
	     
	}

	 @Given("^I navigate to the FreeCrm$")
	    public void i_navigate_to_the_FreeCrm() throws Throwable {
	        driver.get("https://www.freecrm.com/index.html");
	    }

	 @When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
	 public void i_enter_valid_and(String uName, String pwd) throws Throwable {
	     driver.findElement(By.name("username")).sendKeys(uName);
	     driver.findElement(By.name("password")).sendKeys(pwd);
	     throw new PendingException();
	 }

	    @When("^I click login button$")
	    public void i_click_login_button() throws Throwable {
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//input[@value='Login']")).click();
	    }

	    @Then("^I successfully logged in$")
	    public void i_successfully_logged_in() throws Throwable {
	        driver.switchTo().frame(1);
	        Thread.sleep(1000);
	        boolean homeElement = driver
	                .findElement(By.xpath("//a[@href='https://www.freecrm.com/system/index.cfm?action=home']"))
	                .isDisplayed();
	        Assert.assertTrue(homeElement);
	        System.out.println(homeElement + " home is displayed");
	    }

	    @When("^I enter invalid username and password$")
	    public void i_enter_invalid_username_and_password() throws Throwable {
	        driver.findElement(By.name("username")).sendKeys("Messi");
	        driver.findElement(By.name("password")).sendKeys("Madrid");
	    }
	    
	    @When("^I enter valid username and invalid password$")
	    public void i_enter_valid_username_and_invalid_password() throws Throwable {
	        driver.findElement(By.name("username")).sendKeys("SyntaxTechnologies");
	        driver.findElement(By.name("password")).sendKeys("Madrid");
	    }
	    
	    @Then("^I still see sign up link$")
	    public void i_still_see_sign_up_link() throws Throwable {
	        boolean signUp= driver.findElement(By.linkText("Sign Up")).isDisplayed();
	         Assert.assertTrue(signUp);
	    }
	    
	    @Then("^I close browser$")
	    public void i_close_browser() throws Throwable {
	        driver.quit();
	    }
	
	


}
