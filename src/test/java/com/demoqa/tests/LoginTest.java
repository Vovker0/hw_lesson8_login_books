package com.demoqa.tests;

import com.demoqa.pages.LoginPage;
import com.demoqa.pages.ProfilePage;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestBase {

    String userNameCorrect = "Testuser999";
    String userNameWrong = "Vasya";
    String passwordCorrect = "TestPassword1!";
    String passwordWrong = "adfad";

    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    @Test
    void successfulLoginTest() {

        loginPage.openPage()
                .setUserName(userNameCorrect)
                .setPassword(passwordCorrect)
                .logIn();

        profilePage.checkLoggedInByUser(userNameCorrect);
    }

    @Test
    void negativeLoginTestWrongUsername() {

        loginPage.openPage()
                .setUserName(userNameWrong)
                .setPassword(passwordCorrect)
                .logIn();

        loginPage.checkLoginNotSuccessful();
    }

    @Test
    void negativeLoginTestWrongPassword() {

        loginPage.openPage()
                .setUserName(userNameCorrect)
                .setPassword(passwordWrong)
                .logIn();

        loginPage.checkLoginNotSuccessful();
    }

    @Test
    void negativeLoginTestNoUsername() {

        loginPage.openPage()
                .setPassword(passwordCorrect)
                .logIn();

        loginPage.checkIsOpened();
    }

    @Test
    void negativeLoginTestNoPassword() {

        loginPage.openPage()
                .setUserName(userNameCorrect)
                .logIn();

        loginPage.checkIsOpened();
    }

    @Test
    void negativeLoginNothingEntered() {

        loginPage.openPage()
                .logIn();

        loginPage.checkIsOpened();
    }

}
