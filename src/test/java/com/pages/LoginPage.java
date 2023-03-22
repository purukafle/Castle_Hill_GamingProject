package com.pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public void enteruserName(String username) throws InterruptedException {
		WebElement userelem = driver.findElement(By.id("user-name"));
		userelem.sendKeys(username);
		
		
	}

	public void enterPassword(String password) throws InterruptedException {
		
		WebElement passelem = driver.findElement(By.id("password"));
		passelem.sendKeys(password);
		

	}

	public void clickLoginBtn() {
		WebElement loginBtnElem = driver.findElement(By.id("login-button"));
		loginBtnElem.click();
	}

	public void verifyErrorMessage(String expectedErrorMessage) {
		WebElement errorMessage = driver.findElement(By.className("error-button"));
		String actualErrorMessage = errorMessage.getText();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

	}

	public boolean isLogoDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement appLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("app_logo")));
		return appLogo.isDisplayed();
		

	}
}
