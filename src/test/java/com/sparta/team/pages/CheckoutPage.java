package com.sparta.team.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    WebDriver webDriver;
    By proceedToCheckoutButton = new By.ByCssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium");
    By proceedToCheckoutButton2 = new By.ByCssSelector("#center_column > form > p > button");
    By signInButton = new By.ByCssSelector("#SubmitLogin");
    By emailAddressTextBox = new By.ByCssSelector("#email");
    By passwordTextBox = new By.ByCssSelector("#passwd");
    By heading = new By.ByCssSelector("#center_column > h1");
    By termsOfServiceCheckBox = new By.ByCssSelector("#cgv");
    By payByBankWireButton = new By.ByCssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a");
    By payByCheckButton = new By.ByCssSelector("#HOOK_PAYMENT > div:nth-child(2) > div > p > a");


    public CheckoutPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void clickProceedToCheckoutButton(){
        try {
            webDriver.findElement(proceedToCheckoutButton).click();
        }
        catch(NoSuchElementException e){
            webDriver.findElement(proceedToCheckoutButton2).click();
        }
    }

    public void clickSignInButton(){
        webDriver.findElement(signInButton).click();
    }

    public void clickTermsOfServiceCheckBox(){
        webDriver.findElement(termsOfServiceCheckBox).click();
    }

    public void clickPayByWireButton(){
        webDriver.findElement(payByBankWireButton).click();
    }

    public void clickPayByCheckButton(){
        webDriver.findElement(payByCheckButton).click();
    }

    public String getHeading(){
        return webDriver.findElement(heading).getText();
    }

    public void enterIntoEmailAddressTextBox(String s){
        webDriver.findElement(emailAddressTextBox).sendKeys(s);
    }

    public void enterIntoPasswordTextBox(String s){
        webDriver.findElement(passwordTextBox).sendKeys(s);
    }


}
