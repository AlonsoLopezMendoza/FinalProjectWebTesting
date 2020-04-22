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
    }

    @Then("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order", webDriver.getCurrentUrl());
    }




    @Given("I am on the summary step of the checkout page")
    public void iAmOnTheSummaryStepOfTheCheckoutPage() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order", webDriver.getCurrentUrl());
    }


    @When("I click on the proceed to sign in button")
    public void iClickOnTheProceedToSignInButton() {
        checkoutPage.clickProceedToSignInButton();
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

    @When("I click on the proceed to shipping button")
    public void iClickOnTheProceedToShippingButton() {
        checkoutPage.clickProceedToShippingButton();
    }

    @Then("I arrive at the shipping step")
    public void iArriveAtTheShippingStep() {
        Assertions.assertEquals("SHIPPING", checkoutPage.getHeading());
    }



    @Given("I am on the shipping step of the checkout page")
    public void iAmOnTheShippingStepOfTheCheckoutPage() {
        Assertions.assertEquals("SHIPPING", checkoutPage.getHeading());
    }

    @When("I click on the proceed to purchase button")
    public void iClickOnTheProceedToPurchaseButton() {
        checkoutPage.clickProceedToPurchaseButton();
    }

    @And("I click on the agree to terms of service checkbox")
    public void iClickOnTheAgreeToTermsOfServiceCheckbox() {
        checkoutPage.clickTermsOfServiceCheckBox();
    }

    @Then("I arrive at the payment step")
    public void iArriveAtThePaymentStep() {
        Assertions.assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", checkoutPage.getHeading());
    }


    @Given("I am satisfied with what is in my cart")
    public void iAmSatisfiedWithWhatIsInMyCart() {
        //TODO
    }

    @When("I click pay by wire transfer")
    public void iClickPayByWireTransfer() {
        checkoutPage.clickPayByWireButton();
    }

    @And("I confirm my wire transfer payment option")
    public void iConfirmMyWireTransferPaymentOption() {
        Assertions.assertEquals("BANK-WIRE PAYMENT.", checkoutPage.getSubHeading());
        checkoutPage.clickProceedToPaymentMethodConfirmation();
    }


    @When("I click pay by check")
    public void iClickPayByCheck() {
        checkoutPage.clickPayByCheckButton();
    }

    @And("I confirm my check payment option")
    public void iConfirmMyCheckPaymentOption() {
        Assertions.assertEquals("CHECK PAYMENT", checkoutPage.getSubHeading());
        checkoutPage.clickProceedToPaymentMethodConfirmation();
    }

    @Then("I will see the order has been confirmed")
    public void iWillSeeTheOrderHasBeenConfirmed() {
        Assertions.assertEquals(true, checkoutPage.getOrderConfirmed());
    }
}
