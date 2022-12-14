package com.tutorialsninja.demo.testuit;

import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNoteBooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopPage;
    LaptopsAndNoteBooksPage laptopsAndNotebooksPage;
    @BeforeMethod(alwaysRun = true)
    public void inIT(){
        homePage = new HomePage();
        laptopsAndNotebooksPage = new LaptopsAndNoteBooksPage();
          desktopPage = new DesktopPage();
    }
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        desktopPage.selectDesktopPage();
        Assert.assertEquals(desktopPage.verifyDesktopNavigation(),"Desktops","Not verify");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        laptopsAndNotebooksPage.selectLaptopAndNotebookPage();
        Assert.assertEquals(laptopsAndNotebooksPage.verifyLaptopsAndNotebooksText(),"Laptops & Notebooks","not verify");
    }
    @Test(groups = "regression")
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        homePage.selectComponents();
        Assert.assertEquals(homePage.verifyTextComponents(),"Components","Not verify");

    }
}
