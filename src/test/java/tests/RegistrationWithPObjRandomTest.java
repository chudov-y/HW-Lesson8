package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalDialogComponent;
import utils.RandomUtils;


public class RegistrationWithPObjRandomTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ModalDialogComponent modalDialog = new ModalDialogComponent();
    RandomUtils random = new RandomUtils();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(random.firstName)
                .setLastName(random.lastName)
                .setEmail(random.email)
                .setGender(random.gender)
                .setUserNumber(random.phoneNumber)
                .setDateOfBirth(random.bDay, random.bMonth, random.bYear)
                .setSubject(random.subject)
                .setHobbies(random.hobby)
                .uploadPicture(random.picture)
                .setCurrentAddress(random.address)
                .setState(random.chooseState)
                .setCity(random.chooseCity)
                .submit();

        modalDialog.checkWindow();

        modalDialog.checkResult("Student Name", random.firstName + " " + random.lastName)
                .checkResult("Student Email", random.email)
                .checkResult("Gender", random.gender)
                .checkResult("Mobile", random.phoneNumber)
                .checkResult("Date of Birth", random.bDay + " " + random.bMonth+ "," + random.bYear)
                .checkResult("Subjects", random.subject)
                .checkResult("Hobbies", random.hobby)
                .checkResult("Picture", random.picture)
                .checkResult("Address", random.address)
                .checkResult("State and City", random.chooseState + " " + random.chooseCity);

    }

    @Test
    void requiredFieldsTest(){
        registrationPage.openPage()
                .setFirstName(random.firstName)
                .setLastName(random.lastName)
                .setGender(random.gender)
                .setUserNumber(random.phoneNumber)
                .submit();

        modalDialog.checkWindow();

        modalDialog.checkResult("Student Name", random.firstName + " " + random.lastName)
                .checkResult("Gender", random.gender)
                .checkResult("Mobile", random.phoneNumber);
    }

    @Test
    void emptyFieldsTest(){
        registrationPage.openPage()
                .submit();

    }

}