package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	private WebDriver driver;
	public MainPage(WebDriver driver) {
		this.driver=driver;
		
	}
	public boolean isAppLogoDisplayed() {
        WebElement appLogoElement = driver.findElement(By.className("app_logo"));
        return appLogoElement.isDisplayed();
    }

    public boolean isInventoryContainerDisplayed() {
        WebElement inventoryContainerElement = driver.findElement(By.id("inventory_container"));
        return inventoryContainerElement.isDisplayed();
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
    }
}