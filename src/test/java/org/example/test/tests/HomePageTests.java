package org.example.test.tests;

import org.example.test.base.BaseTest;
import org.example.test.pages.CareersPage;
import org.example.test.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void testCareerPageApplication() {
        driver.get("https://useinsider.com/");

        String expectedUrl = "https://useinsider.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The opened URL is incorrect!");

        HomePage homePage = new HomePage(driver);
        homePage.rejectCookies();
        homePage.clickCareersSubMenu();

        CareersPage careersPage = new CareersPage(driver);
        Assert.assertTrue(careersPage.checkCareersPageLoaded());
        driver.get("https://useinsider.com/careers/quality-assurance/");
        careersPage.clickSeeAllQaJobs();
        careersPage.waitForDepartmentFilter();
        Assert.assertTrue(careersPage.checkDepartmentSelected());
        careersPage.selectIstanbulLocation();
        Assert.assertTrue(careersPage.verifyPositionsText("Quality Assurance"));
        Assert.assertTrue(careersPage.verifyLocationsText("Istanbul, Turkiye"));
        careersPage.clickFirstViewRole();
        careersPage.switchWindow();

        String expected = "https://jobs.lever.co/useinsider/";
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expected), "The opened URL is incorrect!");

        Assert.assertTrue(careersPage.checkJobApplicationPageIsOpened());
    }
}
