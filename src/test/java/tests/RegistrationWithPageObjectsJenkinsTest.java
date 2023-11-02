package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalDialogComponent;

import static io.qameta.allure.Allure.step;

@Tag("demoqa")
public class RegistrationWithPageObjectsJenkinsTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ModalDialogComponent modalDialog = new ModalDialogComponent();
    @Test
    void successfulRegistrationTest() {
        step("Open form", () -> {
        registrationPage.openPage();});

        step("Fill form", () -> {
            registrationPage.setFirstName("Yuri")
                .setLastName("Chudov")
                .setEmail("yuri@chudov.com")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("04", "August", "1987")
                .setSubject("English")
                .setHobbies("Reading")
                .uploadPicture("img.png")
                .setCurrentAddress("Some Address 1")
                .setState("NCR")
                .setCity("Delhi")
                .submit();});

        step("Verify Form", () -> {

        modalDialog.checkWindow();

        modalDialog.checkResult("Student Name", "Yuri Chudov")
                .checkResult("Student Email", "yuri@chudov.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "04 August,1987")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "img.png")
                .checkResult("Address", "Some Address 1")
                .checkResult("State and City", "NCR Delhi");});

    }

}