package com.sparta.team.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver webDriver;
    By proceedToSignIn = new By.ByCssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium");
    By proceedToShipping = new By.ByCssSelector("#center_column > form > p > button");
    By proceedToPayment = new By.ByCssSelector("#form > p > button");
    By proceedToPaymentMethodConfirmation = new By.ByCssSelector("#cart_navigation > button");

    By signInButton = new By.ByCssSelector("#SubmitLogin");
    By emailAddressTextBox = new By.ByCssSelector("#email");
    By passwordTextBox = new By.ByCssSelector("#passwd");

    By heading = new By.ByClassName("page-heading");
    By subheading = new By.ByClassName("page-subheading");
    By darkText = new By.ByCssSelector("#center_column > div > p > strong");
    By greenConfirmationText = new By.ByCssSelector("#center_column > p.alert.alert-success");

    By termsOfServiceCheckBox = new By.ByCssSelector("#cgv");
    By payByBankWireButton = new By.ByCssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a");
    By payByCheckButton = new By.ByCssSelector("#HOOK_PAYMENT > div:nth-child(2) > div > p > a");

    private String orderConfirmedText = "Your order on My Store is complete.";


    public CheckoutPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickProceedToSignInButton() {
        webDriver.findElement(proceedToSignIn).click();
    }

    public void clickProceedToShippingButton() {
        webDriver.findElement(proceedToShipping).click();
    }

    public void clickProceedToPurchaseButton() {
        webDriver.findElement(proceedToPayment).click();
    }


    public void clickSignInButton() {
        webDriver.findElement(signInButton).click();
    }

    public void clickTermsOfServiceCheckBox() {
        webDriver.findElement(termsOfServiceCheckBox).click();
    }

    public void clickPayByWireButton() {
        webDriver.findElement(payByBankWireButton).click();
    }

    public void clickPayByCheckButton() {
        webDriver.findElement(payByCheckButton).click();
    }

    public String getHeading() {
        return webDriver.findElement(heading).getText();
    }

    public String getSubHeading() {
        return webDriver.findElement(subheading).getText();
    }


    public boolean getOrderConfirmed() {
        boolean answer;

        try {
            answer = webDriver.findElement(darkText).getText().equals(orderConfirmedText);
        } catch (NoSuchElementException e) {
            answer = webDriver.findElement(greenConfirmationText).getText().equals(orderConfirmedText);

        }
        return answer;
    }

    public void enterIntoEmailAddressTextBox(String s) {
        webDriver.findElement(emailAddressTextBox).sendKeys(s);
    }

    public void enterIntoPasswordTextBox(String s) {
        webDriver.findElement(passwordTextBox).sendKeys(s);
    }

    public void clickProceedToPaymentMethodConfirmation() {
        webDriver.findElement(proceedToPaymentMethodConfirmation).click();
    }


}