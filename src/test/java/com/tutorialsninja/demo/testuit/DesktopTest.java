package com.tutorialsninja.demo.testuit;

import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DesktopTest extends BaseTest {
    DesktopPage desktopPage ;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        desktopPage = new DesktopPage();
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
        desktopPage.selectDesktopPage();
        Assert.assertEquals(desktopPage.beforeSort(),desktopPage.afterSort(),"not verify");
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){
        desktopPage.showAllDesktops();
        Assert.assertEquals(desktopPage.verifyTextHP(),"HP LP3065","Not verify");
        desktopPage.setDate();
        desktopPage.clickOnAddToCart();
        Assert.assertEquals(desktopPage.verifyYouSuccessfullyAdded(),"Success: You have added HP LP3065 to your shopping cart!\n" +
                "×","Not Verify");
        desktopPage.clickOnAddToCartLink();
        Assert.assertEquals(desktopPage.verifyTextShoppingCart(),"Shopping Cart  (1.00kg)","Not verify");
        Assert.assertEquals(desktopPage.verifyTextHpL(),"HP LP3065","Not verify");
        Assert.assertEquals(desktopPage.verifyDeliveryDate(),"Delivery Date: 2022-11-30","Not verify");
        Assert.assertEquals(desktopPage.verifyModel(),"Product 21","Not verify");
        Assert.assertEquals(desktopPage.verifyTotalAmount(),"£74.73","Not verify");

    }
}
