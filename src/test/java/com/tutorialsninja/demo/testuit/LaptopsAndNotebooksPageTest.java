package com.tutorialsninja.demo.testuit;

import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.LaptopsAndNoteBooksPage;
import com.tutorialsninja.demo.pages.RegisterPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksPageTest extends BaseTest {
    LaptopsAndNoteBooksPage  laptopsAndNotebooksPage;
    RegisterPage registerPage;
    DesktopPage desktopPage ;
    @BeforeMethod(alwaysRun = true)
    public void inIT(){
        laptopsAndNotebooksPage = new LaptopsAndNoteBooksPage();
        registerPage = new RegisterPage();
        desktopPage = new DesktopPage();
    }
    @Test(groups = {"sanity","regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        laptopsAndNotebooksPage.selectLaptopAndNotebookPage();
        Assert.assertEquals(laptopsAndNotebooksPage.afterPriceSort(),laptopsAndNotebooksPage.beforePriceSort(),"Not verify");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatUserPlaceOrderSuccessfully()throws InterruptedException{
        desktopPage.currencyChange();
        laptopsAndNotebooksPage.selectLaptopAndNotebookPage();
        laptopsAndNotebooksPage.selectPriceSortHighToLow();
        laptopsAndNotebooksPage.clickOnMacBook();
        Assert.assertEquals(laptopsAndNotebooksPage.verifyTextMacBook(),"MacBook","Not verify");
        laptopsAndNotebooksPage.clickOnAddToCart();
        Assert.assertEquals(laptopsAndNotebooksPage.verifySuccessFullyAddedToCart(),"Success: You have added MacBook to your shopping cart!\n" +
                "×","Not verify");
        laptopsAndNotebooksPage.clickOnShoppingCartInToSuccessMessage();
        Assert.assertEquals(laptopsAndNotebooksPage.verifyTextMacBookInShopping(),"MacBook","Not verify");
        laptopsAndNotebooksPage.changeQty();
        Assert.assertEquals(laptopsAndNotebooksPage.verifyUpdatedMessage(),"Success: You have modified your shopping cart!\n" +
                "×","Not verify");
        Assert.assertEquals(laptopsAndNotebooksPage.verifyTotalPrice(),"£737.45","Not verify");
        laptopsAndNotebooksPage.clickOnCheckOut();
        Assert.assertEquals(laptopsAndNotebooksPage.verifyTextClickOnCheckOut(),"Checkout","Not verify");
        Thread.sleep(200);
        Assert.assertEquals(laptopsAndNotebooksPage.verifyNewCustomer(),"New Customer","Not verify");
        laptopsAndNotebooksPage.selectGuestCheckOut();
        registerPage.mandatoryField();
    }
}
