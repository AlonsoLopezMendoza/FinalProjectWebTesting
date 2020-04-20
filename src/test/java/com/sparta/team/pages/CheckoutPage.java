package com.sparta.team.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver webDriver;
    By proceedToCheckoutButton = new By.ByCssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium");
    By heading = new By.ByCssSelector("#center_column > h1");


    public CheckoutPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void clickProceedToCheckoutButton(){
        webDriver.findElement(proceedToCheckoutButton).click();
    }

    public String getHeading(){
        return webDriver.findElement(heading).getText();
    }


}
