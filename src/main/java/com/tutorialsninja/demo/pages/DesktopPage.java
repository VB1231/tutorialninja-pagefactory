package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    HomePage homePage = new HomePage();
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement deskTop;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement verifyDesktopText;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement sortingList;
    @CacheLookup
    @FindBy(id="input-sort")
    WebElement sortBy;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currency;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    WebElement currencyDropDown;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement selectHP;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement verifyTextHP;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement clickOnCalender;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement getDefaultMonthYear;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextMonthYear;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    WebElement selectDay;
    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Success: You have added ')]")
    WebElement verifySuccessfullyAdded;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping Cart')]")
    WebElement clickOnShoppingCartLink;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement clickOnAddToCartLink;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement verifyTextShoppingCart;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement verifyTextHpL;

    @CacheLookup
    @FindBy(xpath = "//small[contains(text(),'Delivery Date: 2022-11-30')]")
    WebElement verifyDeliveryDate;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement verifyModel;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement verifyTotalAmount;



    public void selectDesktopPage() {
        Reporter.log("mouse hover and click on desktop"+deskTop.toString());
        CustomListeners.test.log(Status.PASS,"mouse hover and click desktop" +deskTop);
        mouseHoverToElementAndClick(deskTop);
        homePage.selectMenu("Show All Desktops");
    }

    public String verifyDesktopNavigation() {
        Reporter.log("verify desktop text"+verifyDesktopText.toString());
        CustomListeners.test.log(Status.PASS,"verify desktop text" +verifyDesktopText);
        return getTextFromElement(verifyDesktopText);
    }

    public ArrayList<String> beforeSort() {
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        return originalProductsName;
    }

    public ArrayList<String> afterSort() {
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        selectByVisibleTextFromDropDown(sortBy, "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products =driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        return afterSortByZToAProductsName;
    }

    public void currencyChange() {
        clickOnElement(currency);
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }

    public void showAllDesktops() {
        currencyChange();
        selectDesktopPage();
        Reporter.log("select sort by "+sortBy.toString());
        CustomListeners.test.log(Status.PASS,"select sort by" +sortBy);
        selectByVisibleTextFromDropDown(sortBy, "Name (A - Z)");
    }

    public String verifyTextHP() {
        Reporter.log("select HP "+selectHP.toString());
        CustomListeners.test.log(Status.PASS,"select HP" +selectHP);
        clickOnElement(selectHP);
        Reporter.log("verify text hp"+verifyTextHP.toString());
        CustomListeners.test.log(Status.PASS,"text hp" +verifyTextHP);
        return getTextFromElement(verifyTextHP);
    }

    public void setDate() {
        String year = "2022";
        String month = "November";
        String date = "30";
        Reporter.log("click on calender"+clickOnCalender.toString());
        CustomListeners.test.log(Status.PASS,"calender" +clickOnCalender);
        clickOnElement(clickOnCalender);
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextMonthYear);
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnAddToCart() {
        Reporter.log("select add to cart"+addToCart.toString());
        CustomListeners.test.log(Status.PASS,"click add to cart" +addToCart);
        clickOnElement(addToCart);
    }

    public String verifyYouSuccessfullyAdded() {
        Reporter.log("verify text"+verifySuccessfullyAdded.toString());
        CustomListeners.test.log(Status.PASS,"verify success" +verifySuccessfullyAdded);
        return getTextFromElement(verifySuccessfullyAdded);
    }

    public void clickOnShoppingCartLink() {
        Reporter.log("click on shopping cart link"+clickOnShoppingCartLink.toString());
        CustomListeners.test.log(Status.PASS,"click on shopping cart" +clickOnShoppingCartLink);
        clickOnElement(clickOnShoppingCartLink);
    }

    public void clickOnAddToCartLink() {
        Reporter.log("click on add to cart"+clickOnAddToCartLink.toString());
        CustomListeners.test.log(Status.PASS,"click on add to cart " +clickOnAddToCartLink);
        clickOnElement(clickOnAddToCartLink);
    }

    public String verifyTextShoppingCart() {
        Reporter.log("verify shopping cart text"+verifyTextShoppingCart.toString());
        CustomListeners.test.log(Status.PASS,"text" +verifyTextShoppingCart);
        return getTextFromElement(verifyTextShoppingCart);
    }

    public String verifyTextHpL() {
        Reporter.log("verify text HPL "+verifyTextHpL.toString());
        CustomListeners.test.log(Status.PASS,"text verify" +verifyTextHpL);
        return getTextFromElement(verifyTextHpL);
    }

    public String verifyDeliveryDate() {
        Reporter.log("delivery date "+verifyDeliveryDate.toString());
        CustomListeners.test.log(Status.PASS,"verify date" +verifyDeliveryDate);
        return getTextFromElement(verifyDeliveryDate);
    }

    public String verifyModel() {
        Reporter.log("verify Model"+verifyModel.toString());
        CustomListeners.test.log(Status.PASS,"text" +verifyModel);
        return getTextFromElement(verifyModel);
    }

    public String verifyTotalAmount() {
        Reporter.log("verify total amount"+verifyTotalAmount.toString());
        CustomListeners.test.log(Status.PASS,"verify total" +verifyTotalAmount);
        return getTextFromElement(verifyTotalAmount);
    }
}
