package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.TextBoxRegistrationPage;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxRegistrationPage textBoxRegistrationPage = new TextBoxRegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}
