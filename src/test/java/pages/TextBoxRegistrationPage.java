package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxRegistrationPage {

    SelenideElement  titleLabel = $(".main-header"),
                     userNameInput = $("#userName"),
                     userEmailInput = $("#userEmail"),
                     currentAddressInput = $("#currentAddress"),
                     permanentAddressInput = $("#permanentAddress");



    public TextBoxRegistrationPage openPage() {
        open("/text-box");
        titleLabel.shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxRegistrationPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxRegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxRegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxRegistrationPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public void submit(){
        $("#submit").click();

    }
}
