package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    SelenideElement loginForm = $("#userForm");
    SelenideElement loginHeader = $(".main-header");
    SelenideElement userNameInput = $("#userName");
    SelenideElement passwordInput = $("#password");
    SelenideElement loginButton = $("#login");
    SelenideElement outputMessage = $("#output");

    public LoginPage openPage() {
        open("/login");
        loginForm.shouldHave(text("Welcome, Login in Book Store"));
        return this;
    }

    public LoginPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public LoginPage setPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    public void logIn() {
        loginButton.click();
    }

    public LoginPage checkLoginNotSuccessful() {
        outputMessage.shouldHave(text("Invalid username or password!"));
        return this;
    }

    public LoginPage checkIsOpened() {
        loginHeader.shouldHave(exactText("Login"));
        return this;
    }
}
