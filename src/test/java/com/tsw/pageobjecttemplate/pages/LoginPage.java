package com.tsw.pageobjecttemplate.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.jetbrains.com/
public class LoginPage {
    public SelenideElement loginFiled = $(By.id("username"));
    public SelenideElement passwordFiled = $(By.id("password"));
    public SelenideElement signInButton = $x("//*[@data-name='signIn-button']");
    public SelenideElement loginErrorMessage = $x("//*[@data-name='authorizationError-popup']");
    public SelenideElement popupCloseButton = $x("//*[@data-name='authorizationError-popup']");

    public OrderPage performLoginAndReturnOrderPage(){
        loginFiled.setValue("t-kharuzheva");
        passwordFiled.setValue("pgd3VbfT2nt");
        signInButton.click();
        return  new OrderPage();
    }

}
