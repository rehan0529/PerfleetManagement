package com.perfleet.pages;

import com.perfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    public LogoutPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a[@class='no-hash']")
    public WebElement logoutButton;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement QuickLaunchpad;

    @FindBy(xpath = "//*[@id=\"organization-switcher\"]//div//h1//a")
    public WebElement FleetManagement;

}
