package com.perfleet.step_definitions;

import com.perfleet.pages.LoginPage;
import com.perfleet.utilities.BrowserUtils;
import com.perfleet.utilities.ConfigurationReader;
import com.perfleet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("the user enter {string} and {string}")
    public void the_user_enter_and(String validUsername, String validPassword) {
        loginPage.login(validUsername, validPassword);
    }

    @Then("{string} should land on the {string} page after login successfully")
    public void should_land_on_the_page_after_login_successfully(String driver, String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        if (driver.equals("user7")) {
            Assert.assertTrue(actualTitle.contains(expectedTitle));
        }
    }

    @Then("{string} or {string} should land on the {string} page after login successfully")
    public void or_should_land_on_the_page_after_login_successfully(String salesmanager, String storemanager, String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        if (salesmanager.equals("salesmanager107") || storemanager.equals("storemanager87")) {
            Assert.assertTrue(actualTitle.contains(expectedTitle));
        }
    }

    @Given("copy the url after log in then log out paste the same url to browser and try to skip authentication step")
    public void copy_the_url_after_log_in_then_log_out_paste_the_same_url_to_browser_and_try_to_skip_authentication_step() {
        loginPage.loginAsDriver();
        String actualUrl = Driver.get().getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);
        BrowserUtils.clickWithJS(loginPage.logOut);
        BrowserUtils.waitFor(3);
        Driver.get().get(actualUrl);
        Assert.assertFalse(Driver.get().getTitle().contains("Quick Launchpad"));
    }

    @Then("the user enters invalid credentials {string} and {string} and after {string} message should be displayed for invalid credentials")
    public void the_user_enters_invalid_credentials_and_and_after_message_should_be_displayed_for_invalid_credentials(String invalidUsername, String invalidPassword, String error) {
        loginPage.login(invalidUsername, invalidPassword);
        String actual = loginPage.invalidError.getText();
        System.out.println("actual = " + actual);
        String expected = "Invalid user name or password.";
        Assert.assertEquals("verify that messages are same", expected, actual);
    }

    @Then("the user enters blank credentials {string} and {string} and  {string} message should be displayed for any empty field")
    public void the_user_enters_blank_credentials_and_and_message_should_be_displayed_for_any_empty_field(String blankUsername, String blankPassword, String blankMessage) {
        loginPage.login(blankUsername, blankPassword);
        blankMessage = loginPage.passwordBox.getAttribute("validationMessage");
        String blankExpected = "Please fill in this field.";
        Assert.assertEquals("verify that messages are same", blankExpected, blankMessage);
    }

    @Given("Users should see their password in bullet signs while typing")
    public void users_should_see_their_password_in_bullet_signs_while_typing() {
        Assert.assertTrue(loginPage.passwordBox.getAttribute("placeholder").equals("Password"));
    }

    @Then("User lands on the ‘Forgot Password’ page after clicking on the {string} link")
    public void user_lands_on_the_Forgot_Password_page_after_clicking_on_the_link(String str) {
        loginPage.forgotPassword.click();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(Driver.get().getTitle().contains("Forgot Password"));
        Driver.get().get("https://qa.perfleet.com/user/login");

    }

    @Then("Users can change their password with the username after clicking on {string} link")
    public void users_can_change_their_password_with_the_username_after_clicking_on_link(String str) {
        loginPage.forgotPassword.click();
        BrowserUtils.waitFor(3);
        loginPage.forgotPasswordInputBox.sendKeys("user7");
        BrowserUtils.waitFor(3);
        loginPage.request.click();
        BrowserUtils.waitFor(3);
        Assert.assertFalse(loginPage.unableError.isDisplayed());
    }

    @Given("User can see {string} link on the login page and it should be clickable")
    public void user_can_see_link_on_the_login_page_and_it_should_be_clickable(String str) {
        Assert.assertTrue(loginPage.rememberMe.isDisplayed());
        BrowserUtils.waitFor(3);
        Assert.assertTrue(loginPage.rememberMe.isEnabled());
    }

    @Given("User can use {string} key from their keyboard on the login page after entering username and password")
    public void user_can_use_key_from_their_keyboard_on_the_login_page_after_entering_username_and_password(String str) {
        Actions actions = new Actions(Driver.get());
        loginPage.usernameBox.sendKeys("user7");
        loginPage.passwordBox.sendKeys("UserUser123");
        actions.sendKeys(Keys.ENTER);
    }

    @Given("drivers can see own username in profile menu, after login successfully")
    public void drivers_can_see_own_username_in_profile_menu_after_login_successfully() {
        loginPage.loginAsDriver();
        String actualName = loginPage.name.getText();
        System.out.println("actualName = " + actualName);
        String expectedName = "user5";
        Assert.assertEquals("verify that names are same",expectedName,actualName);
    }

    @Given("sales manager can see own username in profile menu, after login successfully")
    public void sales_manager_can_see_own_username_in_profile_menu_after_login_successfully() {
        loginPage.loginAsSalesManager();
        String actualName = loginPage.name.getText();
        System.out.println("actualName = " + actualName);
        String expectedName = "salesmanager107";
        Assert.assertEquals("verify that names are same",expectedName,actualName);
    }

    @Given("store manager can see own username in profile menu, after login successfully")
    public void store_manager_can_see_own_username_in_profile_menu_after_login_successfully() {
        loginPage.loginStoreManager();
        String actualName = loginPage.name.getText();
        System.out.println("actualName = " + actualName);
        String expectedName = "storemanager87";
        Assert.assertEquals("verify that names are same",expectedName,actualName);
    }

}
