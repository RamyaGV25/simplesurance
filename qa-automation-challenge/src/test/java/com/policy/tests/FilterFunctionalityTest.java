package com.policy.tests;

import java.time.Duration;

import org.testng.annotations.Test;

import com.policy.pages.HomePage;
import com.policy.pages.LoginPage;

public class FilterFunctionalityTest  extends BaseTest{

	@Test
	public void filterFunctionality() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		driver.get("https://insurance-manager.sb-qa-candidatetask-2.sisu.sh/login");
		loginPage.selectLanguage();
		loginPage.userLogin("testsellingpartner2@simplesurance.de", "TestSellingPartner2Pass");
		homePage.verifyFilterFunctionality();
	}
}
