package com.tsw.pageobjecttemplate.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.jetbrains.com/
public class OrderPage {
    public SelenideElement statusButton = $x("//*[@data-name='openStatusPopup-button']");
    public SelenideElement orderButton = $x("//*[@data-name='createOrder-button']");
    public SelenideElement nameField =$x("//*[@data-name='username-input']");
    public SelenideElement phoneField =$x("//*[@data-name='phone-input']");
    public SelenideElement commentField =$x("//*[@data-name='comment-input']");
    public SelenideElement orderCreateMessage =$x("//*[@data-name='orderSuccessfullyCreated-popup']");
    public SelenideElement popupCloseButtonOrderMessage = $x("//*[@data-name='orderSuccessfullyCreated-popup-close-button']");
    public SelenideElement popupOkButton = $x("//*[@data-name='orderSuccessfullyCreated-popup-ok-button']");
    public SelenideElement logoutButton = $x("//*[@data-name='logout-button']");


}
