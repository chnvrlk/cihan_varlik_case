package org.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {

    private By findYourDreamJobButton = By.xpath("(//a[text()='Find your dream job'])[1]");
    private By ourLocationsText = By.xpath("//h3[contains(text(),'Our Locations')]");
    private By allTeams = By.xpath("//div[@class='col-12 d-flex flex-wrap p-0 career-load-more']");
    private By seeAllQaJobsButton = By.xpath("//a[text()='See all QA jobs']");
    private By istanbulTurkiye = By.xpath("//li[text()='Istanbul, Turkiye']");
    private By qualityAssuranceDepartmentText = By.xpath("//span[@title='Quality Assurance']");
    private By selectLocation = By.xpath("//span[@id='select2-filter-by-location-container']");
    private By positionsText = By.xpath("//span[@class='position-department text-large font-weight-600 text-primary']");
    private By firstPosition = By.xpath("(//div[@class='position-list-item-wrapper bg-light'])[1]");
    private By firstViewRoleButton = By.xpath("(//a[text()='View Role'])[1]");
    private By locationsText = By.xpath("//div[@class='position-location text-large']");
    private By applyForThisJobText = By.xpath("(//a[text()='Apply for this job'])[1]");

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkCareersPageLoaded() {
        return isElementPresent(findYourDreamJobButton) && isElementPresent(allTeams) && isElementPresent(ourLocationsText);
    }

    public void clickSeeAllQaJobs() {
        clickElement(seeAllQaJobsButton);
    }

    public void selectIstanbulLocation() {
        clickElement(selectLocation);
        clickElement(istanbulTurkiye);
    }

    public void waitForDepartmentFilter() {
        waitElement(qualityAssuranceDepartmentText);
    }

    public boolean checkDepartmentSelected() {
        return isElementPresent(qualityAssuranceDepartmentText);
    }

    public boolean verifyPositionsText(String expectedValue) {
        waitForElementText(positionsText,expectedValue);
        return checkAllElementsTextByText(positionsText, expectedValue);
    }

    public boolean verifyLocationsText(String expectedValue) {
        waitForElementText(locationsText,expectedValue);
        return checkAllElementsTextByText(locationsText, expectedValue);
    }

    public void clickFirstViewRole() {
        scrollWithPixels(500);
        hoverElement(firstPosition);
        clickElement(firstViewRoleButton);
    }

    public void switchWindow() {
        switchToWindow();
    }

    public boolean checkJobApplicationPageIsOpened() {
        return isElementPresent(applyForThisJobText);
    }


}
