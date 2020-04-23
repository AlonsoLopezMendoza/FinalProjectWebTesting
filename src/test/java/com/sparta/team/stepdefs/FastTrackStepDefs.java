package com.sparta.team.stepdefs;

import com.sparta.team.driverfactory.DriverFactory;
import com.sparta.team.pages.CheckoutPage;
import com.sparta.team.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FastTrackStepDefs {
    private static WebDriver webDriver;
    private static HomePage homePage;
    private static CheckoutPage checkoutPage;
    private String browserType = "";

    public void importProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/browserType.properties"));
            browserType = properties.getProperty("browser").toUpperCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Given("I am on on the homepage")
    public void iAmOnOnTheHomepage() {
        importProperties();
        webDriver = DriverFactory.getWebDriver(browserType);
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


    @Given("I have added an item to my basket and proceeded to checkout")
    public void iHaveAddedAnItemToMyBasketAndProceededToCheckout() {
        iAmOnOnTheHomepage();
        iClickTheFirstItemsAddToCart();
        iClickGoToCheckoutOnThePopup();
    }


    @And("I have gone through the summary page")
    public void iHaveGoneThroughTheSummaryPage() {
        iHaveAddedAnItemToMyBasketAndProceededToCheckout();
        iClickOnTheProceedToSignInButton();
    }

    @And("I have signed in during checkout")
    public void iHaveSignedInDuringCheckout() {
        iHaveGoneThroughTheSummaryPage();
        iEnterMyAccountDetails();
    }

    @And("I have confirmed my address")
    public void iHaveConfirmedMyAddress() {
        iHaveSignedInDuringCheckout();
        iClickOnTheProceedToShippingButton();
    }

    @Given("I have gone through the shipping page")
    public void iHaveGoneThroughTheShippingPage() {
        iHaveConfirmedMyAddress();
        iClickOnTheAgreeToTermsOfServiceCheckbox();
        iClickOnTheProceedToPurchaseButton();
    }

    @Given("I am on the payment step of the checkout page")
    public void iAmOnThePaymentStepOfTheCheckoutPage() {
        Assertions.assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", checkoutPage.getHeading());
    }


}
