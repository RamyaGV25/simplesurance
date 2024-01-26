package com.policy.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'New')]/parent::button")
	public static WebElement newButton;

	@FindBy(xpath = "//span[contains(text(),'Import')]/parent::button")
	public static WebElement importButton;

	@FindBy(xpath = "//th[@data-sort='POLICY_NUMBER']/*[name()='svg']")
	public static WebElement sortPolicyNumber;

	@FindBy(xpath = "//a[contains(@href,'/policy/details')]/button")
	public static List<WebElement> policyNumberList;

	@FindBy(xpath = "//a[contains(@href,'/policy/details')]/button")
	public static WebElement policyNumber;

	@FindBy(xpath = "//th[@data-sort='ACTIVATED_AT']/*[name()='svg']/../../../..//th[@scope='row']/span[contains(text(),'2024')]")
	public static List<WebElement> activationDateList;
	
	@FindBy(xpath = "//th[contains(text(),'mail')]")
	public static WebElement emailText;


	@FindBy(xpath = "//label[text()='Search for...']")
	public static WebElement searchForDropdown;

	@FindBy(xpath = "(//div[@role='combobox'])[1]")
	public static WebElement searchForDropdown2;

	@FindBy(xpath = "//ul[@role='listbox']/li[@role='option']/span[contains(text(),'E-Mail')]")
	public static WebElement searchForOptions;

	
	public void clickNewButton() {
		waitForWebElementToAppear(newButton);
		newButton.click();
	}

	public void clickImportButton() {
		waitForWebElementToAppear(importButton);
		importButton.click();
	}

	public void verifySortFunctionality(String column) throws InterruptedException {
		waitForWebElementToAppear(newButton);
		waitForWebElementToAppear(driver.findElement(By.xpath("//th[@data-sort='" + column + "']/*[name()='svg']")));
		driver.findElement(By.xpath("//th[@data-sort='" + column + "']/*[name()='svg']")).click();
		Thread.sleep(5000);
		if (column == "POLICY_NUMBER") {
			List<String> policies = new ArrayList<String>();
			for (WebElement policy : policyNumberList) {
				policies.add(policy.getText());
			}
			List<String> sortedWebElementTexts = new ArrayList<String>(policies);
			Collections.sort(sortedWebElementTexts);
			if (policies.equals(sortedWebElementTexts)) {
				System.out.println("policy numbers are sorted.");
			} else {
				System.out.println("policy numbers are not sorted.");
			}
		} else {
			List<String> activationDates = new ArrayList<String>();
			for (WebElement activationDate : activationDateList) {
				activationDates.add(activationDate.getText());
			}
			List<String> sortedWebElementTexts = new ArrayList<String>(activationDates);
			Collections.sort(sortedWebElementTexts);
			if (activationDates.equals(sortedWebElementTexts)) {
				System.out.println("Activation dates are sorted.");
			} else {
				System.out.println("Activation dates are not sorted.");
			}
		}

	}

	public void verifyFilterFunctionality() throws InterruptedException {
		String emailIdToSearch = "Ramya@gmail.com";
		Thread.sleep(5000);
		waitForWebElementToAppear(searchForDropdown);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", searchForDropdown);

		Actions actions = new Actions(driver);

		actions.moveToElement(searchForDropdown).click().sendKeys(Keys.DOWN).perform();

		Thread.sleep(2000);

		waitForWebElementToAppear(searchForOptions);

		executor.executeScript("arguments[0].click();", searchForOptions);
		Thread.sleep(2000);
		WebElement searchBox = driver
				.findElement(By.xpath("//label[text()='Search for E-Mail']/parent::div/div/input"));
		actions.sendKeys(emailIdToSearch, Keys.ENTER).build().perform();

		Thread.sleep(2000);
		String emailIDSearchResult = emailText.getText();
		Assert.assertEquals(emailIdToSearch, emailIDSearchResult);

	}
}
