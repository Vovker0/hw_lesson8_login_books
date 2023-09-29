package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    SelenideElement profileHeader = $(".main-header");
    SelenideElement userName = $("#userName-value");

    public ProfilePage checkPageName() {
        profileHeader.shouldHave(exactText("Profile"));
        return this;
    }

    public ProfilePage checkUserName(String name) {
        userName.shouldBe(exactText(name));
        return this;
    }

    public ProfilePage checkLoggedInByUser(String user) {
        checkPageName().checkUserName(user);
        return this;
    }
}
