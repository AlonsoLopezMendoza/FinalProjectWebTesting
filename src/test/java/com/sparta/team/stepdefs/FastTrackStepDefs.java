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
    WebDriver webDriver = new ChromeDriver();
    HomePage homePage = new HomePage(webDriver);
    CheckoutPage checkoutPage = new CheckoutPage(webDriver);

    @Given("I am on on the homepage")
    public void iAmOnOnTheHomepage() {
    }

    @When("I click the first item's add to cart")
    public void iClickTheFirstItemsAddToCart() {
        homePage.hoverFirstItemAndClickAddToCart();
    }

    @And("I click go to checkout on the popup")
    public void iClickGoToCheckoutOnThePopup() {
        homePage.clickPopupCheckout();
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

    @And("I am logged in")
    public void iAmLoggedIn() {
    }

    @Then("I arrive at the address step")
    public void iArriveAtTheAddressStep() {
    }

    @Given("I am on the address step of the checkout page")
    public void iAmOnTheAddressStepOfTheCheckoutPage() {
    }

    @Then("I arrive at the shipping step")
    public void iArriveAtTheShippingStep() {
    }

    @Given("I am on the shipping step of the checkout page")
    public void iAmOnTheShippingStepOfTheCheckoutPage() {
    }

    @And("I click on the agree to terms of service checkbox")
    public void iClickOnTheAgreeToTermsOfServiceCheckbox() {
    }

    @Then("I arrive at the payment step")
    public void iArriveAtThePaymentStep() {
    }
}
