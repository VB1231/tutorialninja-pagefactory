package com.tutorialsninja.demo.testuit;

import com.tutorialsninja.demo.pages.LoginPage;
import com.tutorialsninja.demo.pages.MyAccountPage;
import com.tutorialsninja.demo.pages.RegisterPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {
    MyAccountPage myAccountPage ;
    RegisterPage registerPage ;
    LoginPage loginPage ;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        myAccountPage = new MyAccountPage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
    }
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        myAccountPage.clickOnMyAccount("Register");
        Assert.assertEquals(myAccountPage.verifyRegisterPage(),"Returning Customer","Not verify");
    }
    @Test(groups = {"smoke","regression"})
    public void  verifyThatUserRegisterAccountSuccessfully(){
        myAccountPage.clickOnMyAccount("Register");
        registerPage.registerField();
        Assert.assertEquals(myAccountPage.verifyAccountCreatedText(),"Your Account Has Been Created!","Not verify");
        myAccountPage.clickOnContinueAccount();
        myAccountPage.clickOnMyAccount("Logout");
        Assert.assertEquals(myAccountPage.verifyTextAccountLogOut(),"Account Logout","Not verify");
        myAccountPage.clickOnContinueAccount();
    }
    @Test(groups = "regression")
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        myAccountPage.clickOnMyAccount("Login");
        loginPage.enterEmailAndPassword();
        Assert.assertEquals(loginPage.verifyTextMyAccountLogin(),"My Account","Not verify");
        myAccountPage.clickOnMyAccount("Logout");
        Assert.assertEquals(myAccountPage.verifyTextAccountLogOut(),"Account Logout","Not verify");
        myAccountPage.clickOnContinueAccount();


    }
}
