package com.sparta.team.stepdefs;

import com.sparta.team.pages.CheckoutPage;
import com.sparta.team.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FastTrackStepDefs {
    private static WebDriver webDriver;
    private static HomePage homePage;
    private static CheckoutPage checkoutPage;



    @Given("I am on on the homepage")
    public void iAmOnOnTheHomepage() {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
    }

    @When("I click the first item's add to cart")
    public void iClickTheFirstItemsAddToCart() {
        homePage.hoverFirstItemAndClickAddToCart();
    }

    @And("I click go to checkout on the popup")
    public void iClickGoToCheckoutOnThePopup() {
        checkoutPage = homePage.clickPopupCheckout();
        System.out.println(checkoutPage);
    }

    @Then("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order", webDriver.getCurrentUrl());
    }




    @Given("I am on the summary step of the checkout page")
    public void iAmOnTheSummaryStepOfTheCheckoutPage() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order", webDriver.getCurrentUrl());
    }

    @When("I click on the proceed to checkout button")
    public void iClickOnTheProceedToCheckoutButton() {
        checkoutPage.clickProceedToCheckoutButton();
    }

    @Then("I arrive at the sign in step")
    public void iArriveAtTheSignInStep() {
        Assertions.assertEquals("AUTHENTICATION", checkoutPage.getHeading());
    }



    @Given("I am on the sign in step of the checkout page")
    public void iAmOnTheSignInStepOfTheCheckoutPage() {
        Assertions.assertEquals("AUTHENTICATION", checkoutPage.getHeading());
    }

    @When("I enter my account details")
    public void iEnterMyAccountDetails() {
        checkoutPage.enterIntoEmailAddressTextBox("PNoble@SpartaGlobal.com");
        checkoutPage.enterIntoPasswordTextBox("FinalProject");
        checkoutPage.clickSignInButton();
    }

    @Then("I arrive at the address step")
    public void iArriveAtTheAddressStep() {
        Assertions.assertEquals("ADDRESSES", checkoutPage.getHeading());
    }




    @Given("I am on the address step of the checkout page")
    public void iAmOnTheAddressStepOfTheCheckoutPage() {
        Assertions.assertEquals("ADDRESSES", checkoutPage.getHeading());
    }


    @Then("I arrive at the shipping step")
    public void iArriveAtTheShippingStep() {
        Assertions.assertEquals("SHIPPING", checkoutPage.getHeading());
    }

    @Given("I am on the shipping step of the checkout page")
    public void iAmOnTheShippingStepOfTheCheckoutPage() {
        Assertions.assertEquals("SHIPPING", checkoutPage.getHeading());
    }

    @And("I click on the agree to terms of service checkbox")
    public void iClickOnTheAgreeToTermsOfServiceCheckbox() {
        checkoutPage.clickTermsOfServiceCheckBox();
    }

    @Then("I arrive at the payment step")
    public void iArriveAtThePaymentStep() {
        Assertions.assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", checkoutPage.getHeading());
    }
}
