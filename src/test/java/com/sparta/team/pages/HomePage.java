package com.sparta.team.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver webDriver;
    By firstItemBox = new By.ByCssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line");
    By firstItemAddToCartButton = new By.ByCssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default");

    By homeFeatures = new By.ById("homefeatured");
    By firstItemImage = new By.ByClassName("img");
    By firstItemName = new By.ByClassName("product-name");
    By firstItemPrice = new By.ByClassName("price product-price");

    By proceedToCheckoutPopUpBoxProduct = new By.ByClassName("layer_cart_product col-xs-12 col-md-6");
    By proceedToCheckoutPopUpBoxCart = new By.ByClassName("layer_cart_cart col-xs-12 col-md-6");
    By proceedToCheckoutButton = new By.ByCssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span");

    By popUpItemImage = new By.ByClassName("img");
    By popUpItemName = new By.ById("layer_cart_product_title");
    By popUpItemQuantity = new By.ById("layer_cart_product_quantity");
    By popUpItemPrice = new By.ById("layer_cart_product_price");
    By popUpItemAttributes = new By.ById("layer_cart_product_attributes");
    By popUpTotalPrice = new By.ByClassName("ajax_block_products_total");
    By popUpTotalShippingCost = new By.ByClassName("ajax_cart_shipping_cost");
    By popUpTotal = new By.ByClassName("ajax_block_cart_total");


    By productImagePayment = new By.ByCssSelector("#product_1_1_0_304609 > td.cart_product > a > img");
    By productNamePayment = new By.ByCssSelector("#product_1_1_0_304609 > td.cart_description > small.cart_ref");
    By productSKUPayment = new By.ByCssSelector("#product_1_1_0_304609 > td.cart_description > small:nth-child(3) > a");
    By productColorSizePayment = new By.ByCssSelector("#product_1_1_0_304609 > td.cart_description > small:nth-child(3) > a");
    By productInStockPayment = new By.ByCssSelector("#product_1_1_0_304609 > td.cart_avail > span");
    By productPricePayment = new By.ByCssSelector("#product_price_1_1_304609 > span");
    By productQuantityPayment = new By.ByCssSelector("#product_1_1_0_304609 > td.cart_quantity.text-center > span");
    By productTotalPayment = new By.ByCssSelector("#total_product_price_1_1_304609");
    By totalProductsPayment = new By.ByCssSelector("<td colspan=\"2\" class=\"price\" id=\"total_product\">$66.04</td>");
    By totalShippingPayment = new By.ByCssSelector("#total_shipping");
    By totalPayment = new By.ByCssSelector("#total_price");

    By deliveryOptionPriceShipping = new By.ByCssSelector("#form > div > div.delivery_options_address > div.delivery_options > div > div > table > tbody > tr > td.delivery_option_price > div");

    private final int TIMEOUTTIME = 5;


    public String getProductImagePayment() {
        return webDriver.findElement(productImagePayment).getAttribute("src");
    }

    public String getProductNamePayment() {
        return webDriver.findElement(productNamePayment).getText();
    }

    public String getProductSKUPayment() {
        return webDriver.findElement(productSKUPayment).getText();
    }

    public String getProductColorSizePayment() {
        return webDriver.findElement(productColorSizePayment).getText();
    }

    public String getProductInStockPayment() {
        return webDriver.findElement(productInStockPayment).getText();
    }

    public String getProductPricePayment() {
        return webDriver.findElement(productPricePayment).getText();
    }

    public String getProductQuantityPayment() {
        return webDriver.findElement(productQuantityPayment).getText();
    }

    public String getProductTotalPayment() {
        return webDriver.findElement(productTotalPayment).getText();
    }

    public String getTotalProductsPayment() {
        return webDriver.findElement(totalProductsPayment).getText();
    }

    public String getTotalShippingPayment() {
        return webDriver.findElement(totalShippingPayment).getText();
    }

    public String getTotalPayment() {
        return webDriver.findElement(totalPayment).getText();
    }

    public String getDeliveryOptionPriceShipping() {
        return webDriver.findElement(deliveryOptionPriceShipping).getText();
    }


    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriver.manage().window().maximize();
        webDriver.get("http://automationpractice.com/index.php");
    }

    private Actions hoverFirstItem() {
        Actions actions = new Actions(webDriver);
        WebElement menu = webDriver.findElement(firstItemBox);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", menu);
        actions.moveToElement(menu);
        return actions;
    }

    public void addFirstItemToCart() {
        Actions actions = hoverFirstItem();

        WebElement subMenu = webDriver.findElement(firstItemAddToCartButton);
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }

    public CheckoutPage clickPopupCheckout() {
        WebDriverWait wait = new WebDriverWait(webDriver, TIMEOUTTIME);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(proceedToCheckoutButton)));
        webDriver.findElement(proceedToCheckoutButton).click();
        return new CheckoutPage(webDriver);
    }

    public int getAmountOfFeaturedItems() {
        return webDriver.findElements(homeFeatures).size();
    }

    public String getFirstItemImage() {
        return webDriver.findElement(firstItemBox).findElement(firstItemImage).getAttribute("src");
    }

    public String getFirstItemName() {
        return webDriver.findElement(firstItemBox).findElement(firstItemName).getText();
    }

    public String getFirstItemPrice() {
        return webDriver.findElement(firstItemBox).findElement(firstItemPrice).getText();
    }

    public String getPopUpItemImage() {
        return webDriver.findElement(proceedToCheckoutPopUpBoxProduct).findElement(popUpItemImage).getAttribute("src");
    }

    public String getPopUpItemName() {
        return webDriver.findElement(proceedToCheckoutPopUpBoxProduct).findElement(popUpItemName).getText();
    }

    public String getPopUpItemQuantity() {
        return webDriver.findElement(proceedToCheckoutPopUpBoxProduct).findElement(popUpItemQuantity).getText();
    }

    public String getPopUpItemPrice() {
        return webDriver.findElement(proceedToCheckoutPopUpBoxProduct).findElement(popUpItemPrice).getText();
    }

    public String getPopUpItemAttributes() {
        return webDriver.findElement(proceedToCheckoutPopUpBoxProduct).findElement(popUpItemAttributes).getText();
    }

    public String getPopUpTotalPrice() {
        return webDriver.findElement(proceedToCheckoutPopUpBoxCart).findElement(popUpTotalPrice).getText();
    }

    public String getPopUpTotalShippingCost() {
        return webDriver.findElement(proceedToCheckoutPopUpBoxCart).findElement(popUpTotalShippingCost).getText();
    }

    public String getPopUpTotal() {
        return webDriver.findElement(proceedToCheckoutPopUpBoxCart).findElement(popUpTotal).getText();
    }
}
