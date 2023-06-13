package org.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	
	public WebDriver driver;
	
	@Given("user launch the facebook application")
	public void userLaunchTheFacebookApplication() {
	    WebDriverManager.chromedriver().setup();
	     driver=new ChromeDriver();
	     driver.get("https://www.facebook.com/");
	     driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("user enter invalid username and invalid password")
	public void userEnterInvalidUsernameAndInvalidPassword(io.cucumber.datatable.DataTable d) {
		WebElement email = driver.findElement(By.id("email"));
		List<Map<String, String>> a = d.asMaps();
		String s = a.get(1).get("username");
//		enterText(email, a.get(1).get("username"));
		email.sendKeys(s);
		WebElement pass = driver.findElement(By.name("pass"));
		pass.sendKeys(a.get(2).get("password"));
	}

	@When("user click login button")
	public void userClickLoginButton() {
		WebElement loginBTn = driver.findElement(By.name("login"));
		loginBTn.click();
	}

	@Then("user see the results based on the credential")
	public void userSeeTheResultsBasedOnTheCredential() {
		WebElement errorMsg = driver.findElement(By.xpath("//div[contains(text(),'The email address')]"));
		Assert.assertTrue(errorMsg.isDisplayed());
	}

	@When("user click login button without username and password")
	public void userClickLoginButtonWithoutUsernameAndPassword() {
	    WebElement loginBtn = driver.findElement(By.name("login"));
	    loginBtn.click();
	}

	@Then("user should see error message")
	public void userShouldSeeErrorMessage() {
		WebElement errorMsg = driver.findElement(By.xpath("//div[contains(text(),'The email')]"));
	    Assert.assertTrue(errorMsg.isDisplayed());
	}


}