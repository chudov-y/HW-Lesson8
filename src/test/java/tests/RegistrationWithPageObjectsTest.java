package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalDialogComponent;


public class RegistrationWithPageObjectsTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ModalDialogComponent modalDialog = new ModalDialogComponent();
    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Yuri")
                .setLastName("Chudov")
                .setEmail("yuri@chudov.com")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("04", "August", "1987")
                .setSubject("English")
                .setHobbies("Reading")
                .uploadPicture("1.png")
                .setCurrentAddress("Some Address 1")
                .setState("NCR")
                .setCity("Delhi")
                .submit();

        modalDialog.checkWindow();

        modalDialog.checkResult("Student Name", "Yuri Chudov")
                .checkResult("Student Email", "yuri@chudov.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "04 August,1987")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "1.png")
                .checkResult("Address", "Some Address 1")
                .checkResult("State and City", "NCR Delhi");

    }

    @Test
    void requiredFieldsTest(){
        registrationPage.openPage()
                .setFirstName("Yuri")
                .setLastName("Chudov")
                .setGender("Male")
                .setUserNumber("1234567890")
                .submit();

        modalDialog.checkWindow();

        modalDialog.checkResult("Student Name", "Yuri Chudov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890");
    }

    @Test
    void emptyFieldsTest(){
        registrationPage.openPage()
                .submit();

    }

}