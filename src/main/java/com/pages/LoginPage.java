package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.ElementUtility;

public class LoginPage {

	private WebDriver driver;
	private ElementUtility eleUtil;

	// ===== Locators =====
	private By usernameInput = By.name("username");
	private By passwordInput = By.name("password");
	private By loginButton = By.cssSelector("button[type='submit']");
	private By errorMessage = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
	private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
	private By requiredFieldErrors = By.xpath("//span[text()='Required']");
	private By forgotPasswordLink = By.xpath("//p[text()='Forgot your password?']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtil = new ElementUtility(driver);
	}

	// ===== Actions =====
	public void launchApplication(String url) {
		eleUtil.navigateToUrl(url);
	}

	public void enterUsername(String username) {
		eleUtil.sendText(usernameInput, username);
	}

	public void enterPassword(String password) {
		eleUtil.sendText(passwordInput, password);
	}

	public void clickLoginButton() {
		eleUtil.click(loginButton);
	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}

	public void clickForgotPassword() {
		eleUtil.click(forgotPasswordLink);
	}

	// ===== Validations / Getters =====
	public boolean isErrorMessageDisplayed() {
		return eleUtil.isElementDisplayed(errorMessage);
	}

	public String getErrorMessageText() {
		return eleUtil.getText(errorMessage);
	}

	public boolean isDashboardDisplayed() {
		return eleUtil.isElementDisplayed(dashboardHeader);
	}

	public boolean areRequiredFieldErrorsDisplayed() {
		return eleUtil.isElementDisplayed(requiredFieldErrors);
	}

	public String getCurrentPageUrl() {
		return eleUtil.getCurrentUrl();
	}
}
