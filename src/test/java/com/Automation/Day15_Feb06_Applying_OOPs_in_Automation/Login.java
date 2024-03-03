package com.Automation.Day15_Feb06_Applying_OOPs_in_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Login extends TestBase {
	
	public Login() throws Exception {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = initalizeBrowserAndOpenApplication("Chrome");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
	}
	
	@Test(priority=1)
	public void verifyLoginWithValidCredentials()  {
		
		
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("logout")).isDisplayed());
		driver.quit();
}
	
	@Test(priority=2)
	public void verifyLoginWithInValidCredentials()  {
		
		
		driver.findElement(By.id("input-email")).sendKeys("seleniumpandahksa@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("selenium@127883");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		driver.quit();
}
	
	@Test(priority=3)
	public void verifyLoginWithValidEmailInValidPassword()  {
		
		
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("selenium@127883");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		driver.quit();
}
	
	@Test(priority=4)
	public void verifyLoginWithInValidEmailValidPassword()  {
		
		
		driver.findElement(By.id("input-email")).sendKeys("seleniumpandsdda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		driver.quit();
}
	
	
	@Test(priority=5)
	public void verifyLoginWithNoCredentials()  {
		
		
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		driver.quit();
}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}