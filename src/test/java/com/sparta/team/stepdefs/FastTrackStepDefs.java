package com.sparta.team.stepdefs;

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
}
