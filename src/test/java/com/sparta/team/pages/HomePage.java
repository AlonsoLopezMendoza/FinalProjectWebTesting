package com.sparta.team.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver webDriver;
    By firstItemBox = new By.ByCssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line");
    By firstItemAddToCartButton = new By.ByCssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default");
    By homeFeatures = new By.ById("homefeatured");
    By proceedToCheckoutButton = new By.ByCssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span");
    By proceedToCheckoutPopUpBox = new By.ByClassName("layer_cart_product col-xs-12 col-md-6");

    private final int TIMEOUTTIME = 5;

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

    public CheckoutPage clickPopupCheckout(){
        WebDriverWait wait = new WebDriverWait(webDriver, TIMEOUTTIME);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(proceedToCheckoutButton)));
        webDriver.findElement(proceedToCheckoutButton).click();
        return new CheckoutPage(webDriver);
    }

    public int getAmountOfFeaturedItems(){
       return webDriver.findElements(homeFeatures).size();
    }

    public String getFirstItemImage(){
        return webDriver.findElement(firstItemBox).findElement(By.className("img")).getAttribute("src");
    }
    public String getFirstItemName(){
        return webDriver.findElement(firstItemBox).findElement(By.className("product-name")).getText();
    }
    public Float getFirstItemPrice(){
        return Float.parseFloat(webDriver.findElement(firstItemBox).findElement(By.className("price product-price")).getText());
    }

    public String getPopupItemImage(){
        return webDriver.findElement(proceedToCheckoutPopUpBox).findElement(By.className("img")).getAttribute("src");
    }
    public String getPopupItemName(){
        return webDriver.findElement(proceedToCheckoutPopUpBox).findElement(By.id("layer_cart_product_title")).getText();
    }
    public String getPopupItemQuantity(){
        return webDriver.findElement(proceedToCheckoutPopUpBox).findElement(By.id("layer_cart_product_quantity")).getText();
    }
    public Float getPopupItemPrice(){
        return Float.parseFloat(webDriver.findElement(proceedToCheckoutPopUpBox).findElement(By.id("layer_cart_product_price")).getText());
    }
}
