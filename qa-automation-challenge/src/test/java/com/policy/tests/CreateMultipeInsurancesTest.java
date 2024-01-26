package com.policy.tests;

import org.testng.annotations.Test;

import com.policy.pages.HomePage;
import com.policy.pages.ImportPage;
import com.policy.pages.LoginPage;

public class CreateMultipeInsurancesTest extends BaseTest {
	
	@Test
	public void createMultipleInsurances() {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		ImportPage importPage = new ImportPage(driver);
		driver.get("https://insurance-manager.sb-qa-candidatetask-2.sisu.sh/login");
		loginPage.selectLanguage();
		loginPage.userLogin("testsellingpartner2@simplesurance.de", "TestSellingPartner2Pass");
		homePage.clickImportButton();
		importPage.importFile();
		importPage.clickCreateInsurance();
		importPage.printErrorMessage();
		
	}

}
