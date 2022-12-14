package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephoneNumber;
    @CacheLookup
    @FindBy(id = "input-payment-company")
    WebElement company;
    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement addressField;
    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement cityField;
    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement  postCode;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement  countryField;
    @CacheLookup
    @FindBy(xpath = "//select[@name='zone_id']")
    WebElement zone;
    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement acceptTerms;
    @CacheLookup
    @FindBy(id = "button-register")
    WebElement  clickContinue;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement  registerFirstName;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement  registerLastName;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement  registerEmailField;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement  registerTelephone;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement  registerPassword;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement  registerConfirmPassword;
    @CacheLookup
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement registerAcceptTerms;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement registerClickContinue;



    public void mandatoryField() {
        firstName.clear();
        Reporter.log("enter first name" + firstName.toString());
        CustomListeners.test.log(Status.PASS, "first name" + firstName);
        sendTextToElement(firstName, "Prime");
        Reporter.log("enter last name" + lastName.toString());
        CustomListeners.test.log(Status.PASS, "last name" + lastName);
        sendTextToElement(lastName, "Testing");
        emailField.clear();
        Reporter.log("enter email " + emailField.toString());
        CustomListeners.test.log(Status.PASS, "enter email" + emailField);
        sendTextToElement(emailField, randomEmail());
        Reporter.log("enter telephone number" + telephoneNumber.toString());
        CustomListeners.test.log(Status.PASS, "enter telephone number" + telephoneNumber);
        sendTextToElement(telephoneNumber, "01923 630 555");
        Reporter.log("enter company " + company.toString());
        CustomListeners.test.log(Status.PASS, "enter company" + company);
        sendTextToElement(company, "adsf");
        Reporter.log("enter address" + addressField.toString());
        CustomListeners.test.log(Status.PASS, "enter address" + addressField);
        sendTextToElement(addressField, "14 The Avenue");
        Reporter.log("enter postcode" + postCode.toString());
        CustomListeners.test.log(Status.PASS, "enter postcode" + postCode);
        sendTextToElement(postCode, "WD23 7AB");
        Reporter.log("enter country field " + countryField.toString());
        CustomListeners.test.log(Status.PASS, "enter country" + countryField);
        selectByVisibleTextFromDropDown(countryField, "United Kingdom");
        Reporter.log("enter zone " + zone.toString());
        CustomListeners.test.log(Status.PASS, "enter zone" + zone);
        selectByVisibleTextFromDropDown(zone, "Aberdeen");
        Reporter.log("accept terms" + acceptTerms.toString());
        CustomListeners.test.log(Status.PASS, "accept terms" + acceptTerms);
        clickOnElement(acceptTerms);
        Reporter.log("click on continue" + clickContinue.toString());
        CustomListeners.test.log(Status.PASS, "click on continue" + clickContinue);
        clickOnElement(clickContinue);
    }

    public void registerField() {
        registerFirstName.clear();
        Reporter.log("enter first name" + registerFirstName.toString());
        CustomListeners.test.log(Status.PASS, "enter name" + registerFirstName);
        sendTextToElement(registerFirstName, "Prime");
        registerLastName.clear();
        Reporter.log("enter last name" + registerLastName.toString());
        CustomListeners.test.log(Status.PASS, "enter name" + registerLastName);
        sendTextToElement(registerLastName, "Testing");
        registerEmailField.clear();
        Reporter.log("enter email" + registerEmailField.toString());
        CustomListeners.test.log(Status.PASS, "enter email" + registerEmailField);
        sendTextToElement(registerEmailField, randomEmail());
        Reporter.log("enter telephone" + registerTelephone.toString());
        CustomListeners.test.log(Status.PASS, "enter telephone" + registerTelephone);
        sendTextToElement(registerTelephone, "01923 630 555");
        Reporter.log("enter password" + registerPassword.toString());
        CustomListeners.test.log(Status.PASS, "enter password" + registerPassword);
        sendTextToElement(registerPassword, "Welcome123");
        Reporter.log("enter confirm password" + registerConfirmPassword.toString());
        CustomListeners.test.log(Status.PASS, "enter confirm password" + registerConfirmPassword);
        sendTextToElement(registerConfirmPassword, "Welcome123");
        Reporter.log("Accept terms" + registerAcceptTerms.toString());
        CustomListeners.test.log(Status.PASS, "accept terms " + registerAcceptTerms);
        clickOnElement(registerAcceptTerms);
        Reporter.log("click on continue" + registerClickContinue.toString());
        CustomListeners.test.log(Status.PASS, "click on continue" + registerClickContinue);
        clickOnElement(registerClickContinue);

    }
}
