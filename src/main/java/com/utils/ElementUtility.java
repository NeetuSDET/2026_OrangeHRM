package com.utils;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtility {

	private WebDriver driver;

	public ElementUtility(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitForElementVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMEOUT));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void sendText(By locator, String text) {
		WebElement element = waitForElementVisible(locator);
		element.clear();
		element.sendKeys(text);
	}

	public void click(By locator) {
		waitForElementVisible(locator).click();
	}

	public String getText(By locator) {
		return waitForElementVisible(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return waitForElementVisible(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void navigateToUrl(String url) {
		driver.get(url);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
