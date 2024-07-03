package com.tsw.pageobjecttemplate.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.jetbrains.com/
public class StatusInformationPage {

    public SelenideElement searchOrderFiled = $x("//*[@data-name='searchOrder-input']");
    public SelenideElement trekkingButton = $x("//*[@data-name='searchOrder-submitButton']");
    public SelenideElement popupSearchCloseButton = $x("//*[@data-name='searchOrder-popup-close-button']");
    public SelenideElement orderNotFoundErrorMessage = $x("//*[@data-name='orderNotFound-container']");
}
