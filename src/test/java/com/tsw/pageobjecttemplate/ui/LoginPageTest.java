package com.tsw.pageobjecttemplate.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.tsw.pageobjecttemplate.pages.LoginPage;
import com.tsw.pageobjecttemplate.pages.OrderPage;
import com.tsw.pageobjecttemplate.pages.StatusInformationPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginPageTest {
    LoginPage loginPage = new LoginPage();
    StatusInformationPage statusInformationPage = new StatusInformationPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://fe-delivery.tallinn-learning.ee/signin");
    }

    @Test
    public void loginTestAndCheckErrorMessage() {
        loginPage.loginFiled.setValue("qwer");
        loginPage.passwordFiled.setValue("12345678");
        loginPage.signInButton.click();
        loginPage.loginErrorMessage.shouldBe(visible);
        loginPage.popupCloseButton.shouldBe(visible);
    }

    @Test
    public void successfulLogin() {
        OrderPage orderPage = loginPage.performLoginAndReturnOrderPage();
        orderPage.orderButton.shouldBe(visible);
        orderPage.statusButton.shouldBe(visible);
    }
// Homework_18
    @Test
    public void createNewOrder() {
        OrderPage orderPage = loginPage.performLoginAndReturnOrderPage();
        orderPage.nameField.setValue("Tetiana");
        orderPage.phoneField.setValue("12345678");
        orderPage.commentField.setValue("Hello");
        orderPage.orderButton.click();
        orderPage.orderCreateMessage.shouldBe(visible);
        orderPage.popupCloseButtonOrderMessage.shouldBe(visible);
        orderPage.popupOkButton.shouldBe(visible);
        Selenide.sleep(5000);
    }

    @Test
    public void checkLogoutButton() {
        OrderPage orderPage = loginPage.performLoginAndReturnOrderPage();
        orderPage.logoutButton.click();
        loginPage.loginFiled.shouldBe(visible);
        loginPage.passwordFiled.shouldBe(visible);
        loginPage.signInButton.shouldBe(visible);
        Selenide.sleep(5000);
    }

    @Test
    public void searchNotExistOrder() {
        OrderPage orderPage = loginPage.performLoginAndReturnOrderPage();
        orderPage.statusButton.click();
        statusInformationPage.searchOrderFiled.setValue("000");
        statusInformationPage.trekkingButton.click();
        statusInformationPage.orderNotFoundErrorMessage.shouldBe(visible);
        Selenide.sleep(2000);
    }
}
