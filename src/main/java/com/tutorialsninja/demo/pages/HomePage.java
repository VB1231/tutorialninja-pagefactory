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

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    WebElement selectMenu;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement selectComponents;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement verifyTextComponent;


    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }

    public void selectComponents() {
        Reporter.log("select component" + selectComponents.toString());
        CustomListeners.test.log(Status.PASS, "select component" + selectComponents);
        mouseHoverToElementAndClick(selectComponents);
        selectMenu("Show All Components");
    }

    public String verifyTextComponents() {
        Reporter.log("text component " + verifyTextComponent.toString());
        CustomListeners.test.log(Status.PASS, "verify component" + verifyTextComponent);
        return getTextFromElement(verifyTextComponent);
    }


}
