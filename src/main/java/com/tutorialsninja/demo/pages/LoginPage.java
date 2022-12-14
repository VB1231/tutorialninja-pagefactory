package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement clickLogin;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    WebElement verifyTextFromMyAccountLogin;


    public void enterEmailAndPassword() {
        Reporter.log("enter email" + emailField.toString());
        CustomListeners.test.log(Status.PASS, "email" +emailField);
        sendTextToElement(emailField, "viral@gmail.com");
        Reporter.log("enter password" + passwordField.toString());
        CustomListeners.test.log(Status.PASS, "password" +passwordField);
        sendTextToElement(passwordField, "Welcome123");
        Reporter.log("click on login" + clickLogin.toString());
        CustomListeners.test.log(Status.PASS, "click login" +clickLogin);
        clickOnElement(clickLogin);
    }

    public String verifyTextMyAccountLogin() {
        Reporter.log("verify text" + verifyTextFromMyAccountLogin.toString());
        CustomListeners.test.log(Status.PASS, "text" +verifyTextFromMyAccountLogin);
        return getTextFromElement(verifyTextFromMyAccountLogin);
    }
}
