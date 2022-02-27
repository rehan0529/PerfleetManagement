package com.perfleet.pages;

import com.perfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameBox;

    @FindBy(id = "prependedInput2")
    public WebElement passwordBox;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement invalidError;

    @FindBy(xpath = "//a[@class='no-hash']")
    public WebElement logOut;

    @FindBy(xpath = "//a[@href='/user/reset-request']")
    public WebElement forgotPassword;

    @FindBy(css = "[type=text]")
    public WebElement forgotPasswordInputBox;

    @FindBy(css = "[type=submit]")
    public WebElement request;

    @FindBy(xpath = "//div[@class='alert alert-warn']")
    public WebElement unableError;

    @FindBy(xpath = "//span[@class='custom-checkbox__text']")
    public WebElement rememberMe;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement name;

    public void login(String username, String password) {
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }

    public void loginAsDriver() {
        usernameBox.sendKeys("user7");
        passwordBox.sendKeys("UserUser123");
        loginButton.click();
    }

    public void loginStoreManager() {
        usernameBox.sendKeys("storemanager87");
        passwordBox.sendKeys("UserUser123");
        loginButton.click();
    }

    public void loginAsSalesManager() {
        usernameBox.sendKeys("salesmanager107");
        passwordBox.sendKeys("UserUser123");
        loginButton.click();
    }


}
