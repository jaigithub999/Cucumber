package org.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.adactin.utilities.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotenSteps   {
	public static WebDriver driver;
	
	@Given("user launch facebook application")
	public void userLaunchFacebookApplication() {
		System.out.println("Before Scenario");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}
	@When("user click the forgoten account link")
	public void userClickTheForgotenAccountLink() {
		WebElement forgotBtn = driver.findElement(By.xpath("//a[contains(text(),'Forgotten account?')]"));
		forgotBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("user enter invalid {string} and click the search button")
	public void userEnterInvalidAndClickTheSearchButton(String d) {
		WebElement enterMbileNo = driver.findElement(By.id("identify_email"));
		enterMbileNo.sendKeys(d);
		WebElement searchBtn = driver.findElement(By.id("did_submit"));
		searchBtn.click();
	}

	@Then("user see no results page")
	public void userSeeNoResultsPage() {
		
	   WebElement noResultsPage = driver.findElement(By.xpath("//div[text()='No search results']"));
	   Assert.assertTrue(noResultsPage.isDisplayed());
	}


}
