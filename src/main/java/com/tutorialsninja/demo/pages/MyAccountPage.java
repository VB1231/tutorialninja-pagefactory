package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MyAccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    WebElement selectMenu;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement selectMyAccount;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement verifyTextRegister;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement verifyAccountTextCreated ;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement clickOnContinueAccount ;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement verifyAccountLogOut ;




    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void clickOnMyAccount(String s) {
        Reporter.log("click on my account" + selectMyAccount.toString());
        CustomListeners.test.log(Status.PASS, "text" + selectMyAccount);
        clickOnElement(selectMyAccount);
        selectMyAccountOptions(s);
    }

    public String verifyRegisterPage() {
        Reporter.log("verify text" + verifyTextRegister.toString());
        CustomListeners.test.log(Status.PASS, "text" + verifyTextRegister);
        return getTextFromElement(verifyTextRegister);
    }

    public String verifyAccountCreatedText() {
        Reporter.log("text verify" + verifyAccountTextCreated.toString());
        CustomListeners.test.log(Status.PASS, "text" + verifyAccountTextCreated);
        return getTextFromElement(verifyAccountTextCreated);
    }

    public void clickOnContinueAccount() {
        Reporter.log("click on continue account" + clickOnContinueAccount.toString());
        CustomListeners.test.log(Status.PASS, "click on continue " + clickOnContinueAccount);
        clickOnElement(clickOnContinueAccount);
    }

    public String verifyTextAccountLogOut() {
        Reporter.log("text verify" + verifyAccountLogOut.toString());
        CustomListeners.test.log(Status.PASS, "text" + verifyAccountLogOut);
        return getTextFromElement(verifyAccountLogOut);
    }
}
