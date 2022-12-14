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
import java.util.List;

public class LaptopsAndNoteBooksPage extends Utility {
    HomePage homePage = new HomePage();
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooks;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement verifyLaptopsAndNotebooksText;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    WebElement priceSelect;

    @CacheLookup
    @FindBy(id="input-sort")
    WebElement priceHighToLow;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement selectMacBook;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement verifyTextMacBook;
    @CacheLookup
    @FindBy(id="button-cart")
    WebElement clickOnAddToCart;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement verifySuccessFullyAddedToCart ;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement clickOnShoppingCartInToSuccessMessage ;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement verifyTextMacBookShopping ;
    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement changeQty ;
    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement clickOnUpdate ;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='checkout-cart']/div[1]")
    WebElement verifyTextUpdate ;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement verifyTotalPrice ;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement clickOnCheckOut ;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement verifyClickOnCheckout ;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement verifyNewCustomer ;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement selectGuestCheckOut ;
    @CacheLookup
    @FindBy(id = "button-account")
    WebElement clickContinueAsGuest ;

    public void selectLaptopAndNotebookPage() {
        Reporter.log("laptop and notebooks" + laptopsAndNotebooks.toString());
        CustomListeners.test.log(Status.PASS, "laptop and notebooks" + laptopsAndNotebooks);
        mouseHoverToElementAndClick(laptopsAndNotebooks);
        homePage.selectMenu("Show All Laptops & Notebooks");
    }

    public String verifyLaptopsAndNotebooksText() {
        Reporter.log("verify text" + verifyLaptopsAndNotebooksText.toString());
        CustomListeners.test.log(Status.PASS, "verify text" + verifyLaptopsAndNotebooksText);
        return getTextFromElement(verifyLaptopsAndNotebooksText);
    }

    public List<Double> beforePriceSort() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        // Collections.sort(originalProductsPrice, Collections.reverseOrder());
        return originalProductsPrice;
    }

    public List<Double> afterPriceSort() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        selectByVisibleTextFromDropDown(priceHighToLow, "Price (Low > High)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        return afterSortByPrice;
    }

    public void selectPriceSortHighToLow() {
        Reporter.log("select price high -low" + priceHighToLow.toString());
        CustomListeners.test.log(Status.PASS, "select price" + priceHighToLow);
        selectByVisibleTextFromDropDown(priceHighToLow, "Price (Low > High)");
    }

    public void clickOnMacBook() {
        Reporter.log("select mac book" + selectMacBook.toString());
        CustomListeners.test.log(Status.PASS, "mac book" + selectMacBook);
        clickOnElement(selectMacBook);
    }

    public String verifyTextMacBook() {
        Reporter.log("text mac book" + verifyTextMacBook.toString());
        CustomListeners.test.log(Status.PASS, "text" + verifyTextMacBook);
        return getTextFromElement(verifyTextMacBook);
    }

    public void clickOnAddToCart() {
        Reporter.log("click on add to cart" + clickOnAddToCart.toString());
        CustomListeners.test.log(Status.PASS, "click on add to cart" + clickOnAddToCart);
        clickOnElement(clickOnAddToCart);
    }

    public String verifySuccessFullyAddedToCart() {
        Reporter.log("verify successfully added to cart" + verifySuccessFullyAddedToCart.toString());
        CustomListeners.test.log(Status.PASS, "text" + verifySuccessFullyAddedToCart);
        return getTextFromElement(verifySuccessFullyAddedToCart);
    }

    public void clickOnShoppingCartInToSuccessMessage() {
        Reporter.log("click on shopping cart " + clickOnShoppingCartInToSuccessMessage.toString());
        CustomListeners.test.log(Status.PASS, "click on shopping cart" + clickOnShoppingCartInToSuccessMessage);
        clickOnElement(clickOnShoppingCartInToSuccessMessage);
    }

    public String verifyTextMacBookInShopping() {
        Reporter.log("verify shopping cart" + verifyTextMacBookInShopping().toString());
        CustomListeners.test.log(Status.PASS, "verify shopping cart" + verifyTextMacBookShopping);
        return getTextFromElement(verifyTextMacBookShopping);
    }

    public void changeQty() {
        changeQty.clear();
        Reporter.log("change qty" + changeQty.toString());
        CustomListeners.test.log(Status.PASS, "change qty" + changeQty);
        sendTextToElement(changeQty, "2");
        Reporter.log("click on update" + clickOnUpdate.toString());
        CustomListeners.test.log(Status.PASS, "click on update" + clickOnUpdate);
        clickOnElement(clickOnUpdate);
    }

    public String verifyUpdatedMessage() {
        Reporter.log("verify text " + verifyTextUpdate.toString());
        CustomListeners.test.log(Status.PASS, "text" + verifyTextUpdate);
        return getTextFromElement(verifyTextUpdate);
    }

    public String verifyTotalPrice() {
        Reporter.log("verify total price" + verifyTotalPrice.toString());
        CustomListeners.test.log(Status.PASS, "verify total price" + verifyTotalPrice);
        return getTextFromElement(verifyTotalPrice);
    }

    public void clickOnCheckOut() {
        Reporter.log("click on check out" + clickOnCheckOut.toString());
        CustomListeners.test.log(Status.PASS, "click on check out" + clickOnCheckOut);
        clickOnElement(clickOnCheckOut);
    }

    public String verifyTextClickOnCheckOut() {
        Reporter.log("verify text" + verifyClickOnCheckout.toString());
        CustomListeners.test.log(Status.PASS, "verify text" + verifyClickOnCheckout);
        return getTextFromElement(verifyClickOnCheckout);
    }

    public String verifyNewCustomer() {
        Reporter.log("verify text" + verifyNewCustomer.toString());
        CustomListeners.test.log(Status.PASS, "text" + verifyNewCustomer);
        return getTextFromElement(verifyNewCustomer);
    }

    public void selectGuestCheckOut() {
        Reporter.log("select check out guest" + selectGuestCheckOut.toString());
        CustomListeners.test.log(Status.PASS, "select as guest" + selectGuestCheckOut);
        clickOnElement(selectGuestCheckOut);
        Reporter.log("click as guest" + clickContinueAsGuest.toString());
        CustomListeners.test.log(Status.PASS, "click on guest" + clickContinueAsGuest);
        clickOnElement(clickContinueAsGuest);
    }
}
