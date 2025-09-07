package org.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {


    private By companyMenu = By.xpath("//*[@id='navbarDropdownMenuLink'  and contains(text(),'Company')]");

    private By whyInsiderText = By.xpath("//*[@id='navbarDropdownMenuLink' and contains(text(),'Why Insider')]");

    private By customersText = By.xpath("//*[@class='nav-link nav-no-dropdown' and contains(text(),'Customers')]");

    private By careersLink = By.xpath("//*[@class='dropdown-sub' and text()='Careers']");
    private By rejectCookiesButton = By.xpath("//a[@id='wt-cli-reject-btn']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CareersPage clickCareersSubMenu() {
        hoverAndClickElement(companyMenu, careersLink);
        return new CareersPage(driver);
    }

    public void rejectCookies() {
        clickElement(rejectCookiesButton);
    }

}